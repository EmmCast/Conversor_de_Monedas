package com.Ejercicios_Tecnicos.Conversor_de_Monedas.Service;

import java.util.List;

import com.Ejercicios_Tecnicos.Conversor_de_Monedas.Dto.Request;
import com.Ejercicios_Tecnicos.Conversor_de_Monedas.Model.Divisa;

public interface IDivisaService {

	
	public double convercion(Request request);
	
	List<Divisa> listartodo();
	
}
