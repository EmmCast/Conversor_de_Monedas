package com.Ejercicios_Tecnicos.Conversor_de_Monedas.Dto;

import lombok.Data;

@Data
public class Request {

	private String deMoneda;
    private String aMoneda;
    private Float cambio;

}
