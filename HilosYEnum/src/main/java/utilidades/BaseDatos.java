package utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDatos {
    private Connection conexion;

    public BaseDatos() {
        try {
            String url = "jdbc:mysql://localhost:3306/supermercado";
            String usuario = "root";
            String contrasena = ""; 

            conexion = DriverManager.getConnection(url, usuario, contrasena);
            System.out.println("Conexión establecida con la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        }
    }

    public void guardarVenta(String nombreCajero, int clientesAtendidos, double totalVentas) {
        if (conexion == null) {
            System.out.println("Conexión no establecida. No se puede guardar la venta.");
            return;
        }

        String sql = "INSERT INTO ventas (nombre_cajero, clientes_atendidos, total_ventas, fecha_venta) VALUES (?, ?, ?, NOW())";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, nombreCajero);
            stmt.setInt(2, clientesAtendidos);
            stmt.setDouble(3, totalVentas);
            stmt.executeUpdate();
            System.out.println("Venta guardada correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al guardar la venta: " + e.getMessage());
        }
    }

    public void mostrarResultados() {
        if (conexion == null) {
            System.out.println("Conexión no establecida. No se pueden mostrar los resultados.");
            return;
        }

        String sql = "SELECT * FROM ventas";

        try (PreparedStatement stmt = conexion.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                System.out.println("Cajero: " + rs.getString("nombre_cajero") +
                        ", Clientes Atendidos: " + rs.getInt("clientes_atendidos") +
                        ", Total Ventas: $" + rs.getDouble("total_ventas") +
                        ", Fecha de Venta: " + rs.getTimestamp("fecha_venta"));
            }
        } catch (SQLException e) {
            System.out.println("Error al mostrar resultados: " + e.getMessage());
        }
    }

    public void borrarDatos() {
        if (conexion == null) {
            System.out.println("Conexión no establecida. No se pueden borrar los datos.");
            return;
        }

        String sql = "DELETE FROM ventas";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.executeUpdate();
            System.out.println("Datos borrados correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al borrar datos: " + e.getMessage());
        }
    }
}
