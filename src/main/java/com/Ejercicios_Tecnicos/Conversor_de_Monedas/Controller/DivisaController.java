package com.Ejercicios_Tecnicos.Conversor_de_Monedas.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Ejercicios_Tecnicos.Conversor_de_Monedas.Dto.Request;
import com.Ejercicios_Tecnicos.Conversor_de_Monedas.Model.Divisa;
import com.Ejercicios_Tecnicos.Conversor_de_Monedas.Service.IDivisaService;

@RestController
@RequestMapping("/divisas")
public class DivisaController {

	@Autowired
	IDivisaService divisaService;
	
	   @PostMapping("/convert")
	    public double convert(@RequestBody Request request) {
	        System.out.println("DeMoneda: " + request.getDeMoneda());
	        System.out.println("AMoneda: " + request.getAMoneda());
	        System.out.println("Cambio: " + request.getCambio());
	        
	        if (request.getDeMoneda() == null) {
	            System.out.println("DeMoneda is null");
	        }
	        if (request.getAMoneda() == null) {
	            System.out.println("AMoneda is null");
	        }
	        
	        return divisaService.convercion(request);
	    }
	   
	   @GetMapping("/findAll")
	   List<Divisa> findAll(){
		   return divisaService.listartodo();
	   }
}
