package com.Ejercicios_Tecnicos.Conversor_de_Monedas.ServiceImpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ejercicios_Tecnicos.Conversor_de_Monedas.Dto.Request;
import com.Ejercicios_Tecnicos.Conversor_de_Monedas.Model.Divisa;
import com.Ejercicios_Tecnicos.Conversor_de_Monedas.Repository.IDivisaRepository;
import com.Ejercicios_Tecnicos.Conversor_de_Monedas.Service.IDivisaService;

@Service
public class DivisaServicesImpl implements IDivisaService{
	
	@Autowired
	private IDivisaRepository divisaRepository;
	
    @Override
    public double convercion(Request request) {
        Divisa deMoneda = divisaRepository.findByCodigo(request.getDeMoneda())
                .orElseThrow(() -> new RuntimeException("Divisa no encontrada: " + request.getDeMoneda()));
        Divisa aMoneda = divisaRepository.findByCodigo(request.getAMoneda())
                .orElseThrow(() -> new RuntimeException("Divisa no encontrada: " + request.getAMoneda()));

        return request.getCambio() * (deMoneda.getValor() / aMoneda.getValor());
    }
    
    @Override
    public List<Divisa> listartodo(){
    	return divisaRepository.findAll();
    }
	
	
	

}
