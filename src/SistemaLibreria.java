import java.util.ArrayList;
import java.util.List;

public class SistemaLibreria {
    private List<Libro> libros = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();
    private List<Venta> ventas = new ArrayList<>();
    private List<Reserva> reservas = new ArrayList<>();

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public void registrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void registrarVenta(Venta venta) {
        if (venta.procesarVenta()) {
            ventas.add(venta);
            System.out.println("Venta registrada correctamente");
        } else {
            System.out.println("No se pudo realizar la venta (stock insuficiente)");
        }
    }

    public void registrarReserva(Reserva reserva) {
        reservas.add(reserva);
        System.out.println("Reserva registrada");
    }

    public double calcularIngresosTotales() {
        double total = 0;
        for (Venta v : ventas) {
            total += v.calcularTotal();
        }
        return total;
    }

    public void mostrarLibrosDisponibles() {
        boolean hayLibros = false;

        for (Libro libro : libros) {
            if (libro.getStock() > 0) {
                System.out.println(
                    "ID: " + libro.getId() +
                    " | Título: " + libro.getTitulo() +
                    " | Autor: " + libro.getAutor() +
                    " | Precio: " + libro.getPrecio() +
                    " | Stock: " + libro.getStock()
                );
                hayLibros = true;
            }
        }

        if (!hayLibros) {
            System.out.println("No hay libros disponibles");
        }
    }

    public void mostrarVentas() {
        if (ventas.isEmpty()) {
            System.out.println("No hay ventas registradas");
            return;
        }

        for (Venta v : ventas) {
            System.out.println(
                "ID Venta: " + v.getId() +
                " | Cliente: " + v.getCliente().getNombre() +
                " | Libro: " + v.getLibro().getTitulo() +
                " | Cantidad: " + v.getCantidad() +
                " | Total: " + v.calcularTotal() +
                " | Fecha: " + v.getFecha()
            );
        }
    }
}