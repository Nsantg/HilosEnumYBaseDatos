package modelos;

public class Cliente {
    private String nombre;
    private Cesta cesta;

    public Cliente(String nombre, Cesta cesta) {
        this.nombre = nombre;
        this.cesta = cesta;
    }

    public String getNombre() {
        return nombre;
    }

    public Cesta getCesta() {
        return cesta;
    }
}
