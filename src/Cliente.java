public class Cliente {
    private int id;
    private String nombre;
    private String dni;
    private String correo;

    public Cliente(int id, String nombre, String dni, String correo) {
        this.id = id;
        this.nombre = nombre;
        setDni(dni);
        setCorreo(correo);
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