import java.util.ArrayList;
import java.util.List;

public class Usuario {


    private String id;
    private String nombre;
    private int maximoPrestamosSimultaneos;
    private ArrayList<Prestamo> prestamosActivos;

    public Usuario(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.maximoPrestamosSimultaneos = 3;
        this.prestamosActivos = null;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getMaximoPrestamosSimultaneos() {
        return maximoPrestamosSimultaneos;
    }

    public void setMaximoPrestamosSimultaneos(int maximoPrestamosSimultaneos) {
        if (maximoPrestamosSimultaneos < 0) {
            this.maximoPrestamosSimultaneos = 0;
        }

    }

    public List<Prestamo> getPrestamosActivos() {
        return prestamosActivos;
    }


    public boolean tieneHuecoParaOtroPrestamo() {
        if (maximoPrestamosSimultaneos <= 0) {
            return false;
        }
        return prestamosActivos.size() < maximoPrestamosSimultaneos;
    }
}
