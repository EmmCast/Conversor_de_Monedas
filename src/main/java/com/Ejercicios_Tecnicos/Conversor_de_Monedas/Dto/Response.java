package com.Ejercicios_Tecnicos.Conversor_de_Monedas.Dto;

import lombok.Data;

@Data
public class Response {

	private String DeMoneda;
    private String aMoneda;
    private Float cambio;

}
