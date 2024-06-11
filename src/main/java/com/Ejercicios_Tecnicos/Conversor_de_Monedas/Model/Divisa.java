package com.Ejercicios_Tecnicos.Conversor_de_Monedas.Model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Divisas")
@Data
public class Divisa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	 @Id
	 private Long id_divisa;
	 private String codigo;
	 private String pais;
	 private String nombre;
	 private double valor;

}
