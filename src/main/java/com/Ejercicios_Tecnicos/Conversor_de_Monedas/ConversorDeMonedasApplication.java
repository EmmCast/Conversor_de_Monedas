package com.Ejercicios_Tecnicos.Conversor_de_Monedas;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.Ejercicios_Tecnicos.Conversor_de_Monedas.Model.Cuenta;
import com.Ejercicios_Tecnicos.Conversor_de_Monedas.Repository.ICuentaRepository;
import com.Ejercicios_Tecnicos.Conversor_de_Monedas.ServiceImpl.CuentaService;

@SpringBootApplication
public class ConversorDeMonedasApplication implements CommandLineRunner {

    @Autowired
    private CuentaService cuentaService;

    @Autowired
    private ICuentaRepository cuentaRepository;
    
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        SpringApplication.run(ConversorDeMonedasApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        while (true) {
            Cuenta cuenta = seleccionarCuenta();


            if (cuenta == null) {
                System.out.println("Saliendo...");
                return;
            }

            while (true) {
                mostrarMenu();
                int opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        consultarSaldo(cuenta.getId());
                        break;
                    case 2:
                        retirar(cuenta.getId());
                        break;
                    case 3:
                        depositar(cuenta.getId());
                        break;
                    case 9:
                        System.out.print("¿Desea consultar otro cliente? (S/N): ");
                        String respuesta = scanner.next();
                        if (respuesta.equalsIgnoreCase("S")) {
                            break;
                        } else {
                            System.out.println("Saliendo...");
                            return;
                        }
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            }
        }
    }

    private Cuenta seleccionarCuenta() {
        List<Cuenta> cuentas = cuentaService.obtenerTodasLasCuentas();
        if (cuentas.isEmpty()) {
            System.out.println("No hay cuentas disponibles.");
            return null;
        }

        System.out.println("Seleccione una cuenta:");
        for (int i = 0; i < cuentas.size(); i++) {
            Cuenta cuenta = cuentas.get(i);
            System.out.println((i + 1) + " - " + cuenta.getNombreCliente() + " (" + cuenta.getTipoCuenta() + ")");
        }
        int seleccion = scanner.nextInt();
        while (seleccion < 1 || seleccion > cuentas.size()) {
            System.out.println("Selección inválida. Intente de nuevo:");
            seleccion = scanner.nextInt();
        }
        return cuentas.get(seleccion - 1);
    }

    private void mostrarMenu() {
        System.out.println("***************************************");
        System.out.println("** Escriba el número de la opción deseada **");
        System.out.println("1 - Consultar saldo");
        System.out.println("2 - Retirar");
        System.out.println("3 - Depositar");
        System.out.println("9 - Salir");
    }

    private void consultarSaldo(Long id) {
        Cuenta cuenta = cuentaService.consultarSaldo(id);
        System.out.println("Saldo disponible: " + cuenta.getSaldoDisponible() + "$");
    }

    private void retirar(Long id) {
        System.out.print("Ingrese el monto a retirar: ");
        double monto = scanner.nextDouble();
        try {
            cuentaService.retirar(id, monto);
            System.out.println("Retiro exitoso. Saldo actualizado.");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private void depositar(Long id) {
        System.out.print("Ingrese el monto a depositar: ");
        double monto = scanner.nextDouble();
        cuentaService.depositar(id, monto);
        System.out.println("Depósito exitoso. Saldo actualizado.");
    }
}