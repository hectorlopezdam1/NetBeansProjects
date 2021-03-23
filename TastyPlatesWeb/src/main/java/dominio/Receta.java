

package dominio;

/**
 * 
 * @author HectorLopez
 */
public class Receta {
    
    private int idReceta;
    private String nombre;
    private String ingredientes;
    private String pasos;
    private float puntuacion;
    private boolean vegano;
    private String imagen;
    private String descripcion;

    public Receta(int idReceta, String nombre, String ingredientes, String pasos, float puntuacion, boolean vegano, String imagen, String descripcion) {
        this.idReceta = idReceta;
        this.nombre = nombre;
        this.ingredientes = ingredientes;
        this.pasos = pasos;
        this.puntuacion = puntuacion;
        this.vegano = vegano;
        this.imagen = imagen;
        this.descripcion = descripcion;
    }

    public Receta(String nombre, String ingredientes, String pasos, float puntuacion, boolean vegano, String imagen, String descripcion) {
        this.nombre = nombre;
        this.ingredientes = ingredientes;
        this.pasos = pasos;
        this.puntuacion = puntuacion;
        this.vegano = vegano;
        this.imagen = imagen;
        this.descripcion = descripcion;
    }
    
    public Receta(int idReceta){
        this.idReceta = idReceta;
    }
    
    public Receta() {
    }

    public int getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(int idReceta) {
        this.idReceta = idReceta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getPasos() {
        return pasos;
    }

    public void setPasos(String pasos) {
        this.pasos = pasos;
    }

    public float getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(float puntuacion) {
        this.puntuacion = puntuacion;
    }

    public boolean isVegano() {
        return vegano;
    }

    public void setVegano(boolean vegano) {
        this.vegano = vegano;
    }
    
    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    

}
