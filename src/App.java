import java.util.Date;

public class App {
    public static void main(String[] args) {

        SistemaLibreria sistema = new SistemaLibreria();

        // ==============================
        // REGISTRO INICIAL (BASE DEL SISTEMA)
        // ==============================
        Cliente cliente1 = new Cliente(1, "Jose Torrez", "12345678", "juan@gmail.com");
        Cliente cliente2 = new Cliente(2, "Leydi Quispe", "87654321", "maria@gmail.com");

        Libro libro1 = new Libro(1, "POO en Java", "Autor X", "123-ABC", 50.0, 1);

        sistema.registrarCliente(cliente1);
        sistema.registrarCliente(cliente2);
        sistema.agregarLibro(libro1);

        // =====================================================
        // HISTORIA 1: CLIENTE (Buscar / comprar / reservar libro)
        // =====================================================
        System.out.println("\n---- HISTORIA 1: Cliente ----");

        System.out.println("Libros disponibles:");
        sistema.mostrarLibrosDisponibles();

        Venta venta1 = new Venta(1, new Date(), 1, cliente1, libro1);
        sistema.registrarVenta(venta1);
        venta1.mostrarDetalle();

        // Intento de compra sin stock
        System.out.println("\nIntento de compra sin stock:");
        Venta venta2 = new Venta(2, new Date(), 1, cliente2, libro1);
        sistema.registrarVenta(venta2);

        // Reserva cuando no hay stock
        System.out.println("\nCreando reserva de libro:");
        Reserva reserva1 = new Reserva(1, new Date(), cliente2, libro1);
        sistema.registrarReserva(reserva1);

        // =====================================================
        // HISTORIA 2: DUEÑA (Carmen - control de ventas)
        // =====================================================
        System.out.println("\n---- HISTORIA 2: Dueña ----");

        System.out.println("Total de ingresos:");
        System.out.println(sistema.calcularIngresosTotales());

        System.out.println("Reporte de ventas:");
        sistema.mostrarVentas();

        // =====================================================
        // HISTORIA 3: ASISTENTE (stock y reservas)
        // =====================================================
        System.out.println("\n---- HISTORIA 3: Asistente ----");

        System.out.println("Reponiendo stock...");
        libro1.aumentarStock(5);
        System.out.println("Stock actualizado: " + libro1.getStock());

        System.out.println("Confirmando reserva...");
        reserva1.confirmarReserva();
        System.out.println("Estado de reserva activa: " + reserva1.isActiva());

        // =====================================================
        // VERIFICACIÓN FINAL DEL SISTEMA
        // =====================================================
        System.out.println("\n---- ESTADO FINAL ----");

        System.out.println("Stock final: " + libro1.getStock());
        System.out.println("Ingresos por libro: " + libro1.calcularIngresos());
    }
}