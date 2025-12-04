import java.time.LocalDate;

public class Prestamo {

    private Usuario usuario;
    private Libro libro;
    private LocalDate fechaInicio;
    private LocalDate fechaFinEstimada;
    private boolean devuelto;

    public Prestamo(Usuario usuario, Libro libro, LocalDate fechaInicio, LocalDate fechaFinEstimada) {
        this.usuario = usuario;
        this.libro = libro;
        this.fechaInicio = fechaInicio;
        this.fechaFinEstimada = fechaFinEstimada;
        this.devuelto = false;
    }


    public Usuario getUsuario() {
        return usuario;
    }

    public Libro getLibro() {
        return libro;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFinEstimada() {
        return fechaFinEstimada;
    }

    public boolean getDevuelto() {
        return devuelto;
    }

    public void marcarDevuelto() {
        devuelto = true;
        libro.prestarEjemplar();
    }

    public int calcularRetrasoEnDias(LocalDate hoy) {
        if (hoy == null) {
            return -1;
        }

        if (!hoy.isAfter(fechaFinEstimada)) {
            return 0;
        }
        return (int) java.time.temporal.ChronoUnit.DAYS.between(fechaFinEstimada, hoy);
    }
}