

package dominio;

/**
 * 
 * @author HectorLopez
 */
public class Usuario {
    
    private int idUser;
    private String email;
    private String password;
    private String nombre;
    private String apellido;

    public Usuario(int idUser, String email, String password, String nombre, String apellido) {
        this.idUser = idUser;
        this.email = email;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Usuario() {
    }
    
    public Usuario(int idUser) {
        this.idUser = idUser;
    }

    public Usuario(String email, String password, String nombre, String apellido) {
        this.email = email;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    

}
