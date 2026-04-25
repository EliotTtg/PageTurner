import java.util.Date;

public class Reserva {
    private int id;
    private Date fecha;
    private boolean activa;
    private Cliente cliente;
    private Libro libro;

    public Reserva(int _id, Date _fecha, Cliente _cliente, Libro _libro) {
        this.id = _id;
        this.fecha = _fecha;
        this.cliente = _cliente;
        this.libro = _libro;
        this.activa = true;
    }

    public void confirmarReserva() {
        System.out.println("Reserva registrada correctamente para el libro: " + libro.getTitulo());
        activa = true;
    }

    public void cancelarReserva() {
        activa = false;
    }

    public boolean isActiva() {
        return activa;
    }

    public int getId() {
        return id; 
    }

    public Date getFecha() {
        return fecha; 
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha; 
    }

    public Cliente getCliente() {
        return cliente; 
    }

    public Libro getLibro() {
        return libro; 
    }

}