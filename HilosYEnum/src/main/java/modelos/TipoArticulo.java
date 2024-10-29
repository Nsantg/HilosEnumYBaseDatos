package modelos;

public enum TipoArticulo {
    FRUTAS("Frutas", 3.00),
    VERDURAS("Verduras", 2.50),
    LACTEOS("Lácteos", 4.00),
    PANADERIA("Panadería", 1.50),
    CARNES("Carnes", 5.00);

    private final String nombre;
    private final double precio;

    TipoArticulo(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
}
