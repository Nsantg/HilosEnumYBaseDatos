package modelos;

public class Articulo {
    private TipoArticulo tipo;

    public Articulo(TipoArticulo tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return tipo.getNombre();
    }

    public double getPrecio() {
        return tipo.getPrecio();
    }
}
