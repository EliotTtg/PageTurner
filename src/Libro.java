public class Libro {
    private int id;
    private String titulo;
    private String autor;
    private String isbn;
    private double precio;
    private int stock;
    private int totalVentas;

    public Libro(int _id, String _titulo, String _autor, String _isbn, double _precio, int _stock) {
        this.id = _id;
        this.titulo = _titulo;
        this.autor = _autor;
        this.isbn = _isbn;
        this.totalVentas = 0;
        setStock(_stock);
        setPrecio(_precio);
    }

    public boolean hayStock(int cantidad) {
        return stock >= cantidad;
    }

    public void reducirStock(int cantidad) {
        if (hayStock(cantidad)) {
            stock -= cantidad;
            totalVentas += cantidad;
        } else {
            throw new IllegalArgumentException("Stock insuficiente");
        }
    }
    
    public void reducirVentas(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("Cantidad inválida");
        }

        if (totalVentas < cantidad) {
            throw new IllegalArgumentException("No se puede reducir más de lo vendido");
        }

        totalVentas -= cantidad;
    }

    public void setPrecio(double precio) {
        if (precio <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor a 0");
        }
        this.precio = precio;
    }

    public void setStock(int stock) {
        if (stock < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo");
        }
        this.stock = stock;
    }

    public void aumentarStock(int cantidad) {
        stock += cantidad;
    }

    public double calcularIngresos() {
        return totalVentas * precio;
    }

    public int getId() {
        return id; 
    }

    public double getPrecio() { 
        return precio; 
    }

    public int getStock() { 
        return stock; 
    }
    
    public String getTitulo() { 
        return titulo; 
    }

    public void setTitulo(String Titulo) { 
        this.titulo = Titulo; 
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}