package procesos;

import modelos.Cliente;
import modelos.Cesta;
import utilidades.BaseDatos;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Supermercado {
    private List<Cliente> clientes;
    private BaseDatos baseDatos;

    public Supermercado(BaseDatos baseDatos) {
        this.baseDatos = baseDatos;
        this.clientes = new ArrayList<>();
    }

    // Método para inicializar los clientes con una nueva lista cada vez
    public void inicializarClientes(int numeroClientes) {
        clientes.clear(); // Limpiamos la lista de clientes anteriores
        Random random = new Random();

        for (int i = 0; i < numeroClientes; i++) {
            // Crear una cesta con una cantidad aleatoria de artículos
            Cesta cesta = new Cesta(random.nextInt(5) + 1);  // Aquí se genera la cesta con un número de artículos
            clientes.add(new Cliente("Cliente_" + (i + 1), cesta)); // Pasamos la cesta al cliente
        }
    }

    // Método para iniciar la simulación creando nuevos cajeros/hilos
    public void iniciarSimulacion() {
        // Inicializa los cajeros como nuevos hilos en cada ejecución
        List<Cajero> cajeros = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            cajeros.add(new Cajero("Cajero_" + i, baseDatos, clientes));
        }

        // Inicia los hilos de los cajeros
        for (Cajero cajero : cajeros) {
            cajero.start(); // Iniciar cada hilo cajero
            try {
                cajero.join(); // Asegura que el hilo termine antes de iniciar el siguiente
            } catch (InterruptedException e) {
                System.out.println("Error en la simulación del cajero: " + e.getMessage());
            }
        }
    }
}
