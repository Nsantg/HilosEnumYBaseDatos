package procesos;

import modelos.Cliente;
import modelos.Cesta;
import utilidades.BaseDatos;

import java.util.List;

public class Cajero extends Thread {
    private String nombre;
    private int clientesAtendidos;
    private double totalVentas;
    private BaseDatos baseDatos;
    private List<Cliente> clientes;

    public Cajero(String nombre, BaseDatos baseDatos, List<Cliente> clientes) {
        this.nombre = nombre;
        this.clientesAtendidos = 0;
        this.totalVentas = 0.0;
        this.baseDatos = baseDatos;
        this.clientes = clientes;
    }

    @Override
    public void run() {
        for (Cliente cliente : clientes) {
            atenderCliente(cliente);
        }
        baseDatos.guardarVenta(nombre, clientesAtendidos, totalVentas);
    }

    public synchronized void atenderCliente(Cliente cliente) {
        Cesta cesta = cliente.getCesta();
        double totalCliente = cesta.calcularTotal();
        this.totalVentas += totalCliente;
        this.clientesAtendidos++;
        System.out.println("Cajero " + nombre + " atendió a " + cliente.getNombre() + ", total de compra: $" + totalCliente);
    }

    public int getClientesAtendidos() {
        return clientesAtendidos;
    }

    public double getTotalVentas() {
        return totalVentas;
    }

    public String getNombre() {
        return nombre;
    }
}
