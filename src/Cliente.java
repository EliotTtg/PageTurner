public class Cliente {
    private int id;
    private String nombre;
    private String dni;
    private String correo;

    public Cliente(int _id, String _nombre, String _dni, String _correo) {
        this.id = _id;
        this.nombre = _nombre;
        setDni(_dni);
        setCorreo(_correo);
    }

    public int getId() {
        return id; 
    }

    public String getNombre() {
        return nombre; 
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni; 
    }

    public void setDni(String dni) {
        if (dni != null && dni.matches("\\d{8}")) {
            this.dni = dni;
        } else {
            throw new IllegalArgumentException("El DNI debe tener exactamente 8 dígitos numéricos");
        }
    }

    public String getCorreo() {
        return correo; 
    }

    public void setCorreo(String correo) {
        if (correo != null && correo.contains("@")) {
            this.correo = correo;
        } else {
            throw new IllegalArgumentException("Correo inválido");
        }
    }
}