import java.util.Date;

public class Venta {

    public enum EstadoVenta {
        PENDIENTE,
        PROCESADA,
        CANCELADA
    }

    private int id;
    private Date fecha;
    private int cantidad;
    private Cliente cliente;
    private Libro libro;
    private EstadoVenta estado;

    public Venta(int _id, Date _fecha, int _cantidad, Cliente _cliente, Libro _libro) {

        if (cantidad <= 0) {
            throw new IllegalArgumentException("Cantidad inválida");
        }

        if (cliente == null || libro == null) {
            throw new IllegalArgumentException("Cliente y libro no pueden ser nulos");
        }

        this.id = _id;
        this.fecha = _fecha;
        this.cantidad = _cantidad;
        this.cliente = _cliente;
        this.libro = _libro;
        this.estado = EstadoVenta.PENDIENTE;
    }

    public boolean procesarVenta() {
        if (estado != EstadoVenta.PENDIENTE) {
            System.out.println("La venta no se puede procesar");
            return false;
        }

        if (libro.hayStock(cantidad)) {
            libro.reducirStock(cantidad);
            estado = EstadoVenta.PROCESADA;
            return true;
        } else {
            System.out.println("Stock insuficiente");
            return false;
        }
    }

    public void cancelarVenta() {
        if (estado == EstadoVenta.CANCELADA) {
            System.out.println("La venta ya está cancelada");
            return;
        }

        if (estado == EstadoVenta.PROCESADA) {
            libro.aumentarStock(cantidad);
            libro.reducirVentas(cantidad);
        }

        estado = EstadoVenta.CANCELADA;
        System.out.println("Venta cancelada correctamente");
    }

    public double calcularTotal() {
        return cantidad * libro.getPrecio();
    }

    public void mostrarDetalle() {
        System.out.println("----- DETALLE DE VENTA -----");
        System.out.println("ID: " + id);
        System.out.println("Fecha: " + fecha);
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Libro: " + libro.getTitulo());
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Estado: " + estado);
        System.out.println("Total: S/ " + calcularTotal());
        System.out.println("----------------------------");
    }

    public int getId() { 
        return id; 
    }

    public Date getFecha() { 
        return fecha; 
    }

    public int getCantidad() { 
        return cantidad; 
    }

    public Cliente getCliente() { 
        return cliente; 
    }

    public Libro getLibro() { 
        return libro; 
    }

    public EstadoVenta getEstado() { 
        return estado; 
    }
}