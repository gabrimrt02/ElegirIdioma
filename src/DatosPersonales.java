/*Almacena todos los datos de las propiedades que se encuentran en el formulario */

public class DatosPersonales {
    private String nombre, profesion, telefono, direccion, email;

    public DatosPersonales(String nombre, String profesion, String telefono, String direccion, String email) {
        this.nombre = nombre;
        this.profesion = profesion;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
    }

    public String toString() {
        String s = "\n--------------------";
        s += String.format("\nNombre: %s \nProfeción: %s \nTelefono: %s \nDirección: %s\nEmail: %s",
        this.nombre, this.profesion, this.telefono, this.direccion, this.email);
        s += "\n--------------------";
        return s;
    }
}
