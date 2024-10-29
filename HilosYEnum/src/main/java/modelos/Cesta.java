package modelos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cesta {
    private List<Articulo> articulos;

    public Cesta(int i) {
        this.articulos = new ArrayList<>();
        agregarArticulosAleatorios();
    }

    private void agregarArticulosAleatorios() {
        Random random = new Random();
        TipoArticulo[] tipos = TipoArticulo.values();

        for (int i = 0; i < 5; i++) {
            TipoArticulo tipoAleatorio = tipos[random.nextInt(tipos.length)];
            articulos.add(new Articulo(tipoAleatorio));
        }
    }

    public List<Articulo> getArticulos() {
        return articulos;
    }

    public double calcularTotal() {
        return articulos.stream().mapToDouble(Articulo::getPrecio).sum();
    }
}
