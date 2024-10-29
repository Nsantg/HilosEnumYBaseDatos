package main;

import procesos.Supermercado;
import utilidades.BaseDatos;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BaseDatos baseDatos = new BaseDatos();
        Supermercado supermercado = new Supermercado(baseDatos);
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("1. Iniciar Simulación");
            System.out.println("2. Mostrar Resultados");
            System.out.println("3. Borrar Datos");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    supermercado.inicializarClientes(5); // Genera 5 clientes aleatorios para la simulación
                    supermercado.iniciarSimulacion();
                    break;
                case 2:
                    baseDatos.mostrarResultados();
                    break;
                case 3:
                    baseDatos.borrarDatos();
                    System.out.println("Datos borrados correctamente.");
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 4);

        scanner.close();
    }
}
