package com.Ejercicios_Tecnicos.Conversor_de_Monedas.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Ejercicios_Tecnicos.Conversor_de_Monedas.Model.Cuenta;

@Repository
public interface ICuentaRepository extends JpaRepository<Cuenta, Long>{
	

}
