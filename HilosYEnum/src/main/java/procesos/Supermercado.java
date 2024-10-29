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

    public void inicializarClientes(int numeroClientes) {
        clientes.clear();
        Random random = new Random();

        for (int i = 0; i < numeroClientes; i++) {
            Cesta cesta = new Cesta(random.nextInt(5) + 1); 
            clientes.add(new Cliente("Cliente_" + (i + 1), cesta)); 
        }
    }

    public void iniciarSimulacion() {
        List<Cajero> cajeros = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            cajeros.add(new Cajero("Cajero_" + i, baseDatos, clientes));
        }

        for (Cajero cajero : cajeros) {
            cajero.start(); 
            try {
                cajero.join();
            } catch (InterruptedException e) {
                System.out.println("Error en la simulación del cajero: " + e.getMessage());
            }
        }
    }
}
