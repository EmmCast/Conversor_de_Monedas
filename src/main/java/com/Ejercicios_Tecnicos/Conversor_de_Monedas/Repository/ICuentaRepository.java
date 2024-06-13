package com.Ejercicios_Tecnicos.Conversor_de_Monedas.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Ejercicios_Tecnicos.Conversor_de_Monedas.Model.Divisa;

@Repository
public interface IDivisaRepository extends JpaRepository<Divisa, Long>{
	
    Optional<Divisa> findByCodigo(String codigo);

}
