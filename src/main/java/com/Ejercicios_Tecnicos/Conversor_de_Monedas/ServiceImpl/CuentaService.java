package com.Ejercicios_Tecnicos.Conversor_de_Monedas.ServiceImpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ejercicios_Tecnicos.Conversor_de_Monedas.Model.Cuenta;
import com.Ejercicios_Tecnicos.Conversor_de_Monedas.Repository.ICuentaRepository;


@Service
public class CuentaService {

    @Autowired
    private ICuentaRepository cuentaRepository;

    public Cuenta consultarSaldo(Long id) {
        return cuentaRepository.findById(id).orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));
    }

    public Cuenta retirar(Long id, double monto) {
        Cuenta cuenta = cuentaRepository.findById(id).orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));
        if (cuenta.getSaldoDisponible() < monto) {
            throw new RuntimeException("Saldo insuficiente");
        }
        cuenta.setSaldoDisponible(cuenta.getSaldoDisponible() - monto);
        return cuentaRepository.save(cuenta);
    }

    public Cuenta depositar(Long id, double monto) {
        Cuenta cuenta = cuentaRepository.findById(id).orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));
        cuenta.setSaldoDisponible(cuenta.getSaldoDisponible() + monto);
        return cuentaRepository.save(cuenta);
    }

    public Cuenta guardarCuenta(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }
    
    public List<Cuenta> obtenerTodasLasCuentas() {
        return cuentaRepository.findAll();
    }
}