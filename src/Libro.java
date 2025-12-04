public class Libro {
    private String isbn;
    private String titulo;
    private String autor;
    private int anioPublicacion;
    private int ejemplaresTotales;
    private int ejemplaresDisponibles;

    public Libro(String isbn, String titulo, String autor, int anioPublicacion, int ejemplaresTotales) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.ejemplaresTotales = ejemplaresTotales;
        this.ejemplaresDisponibles = ejemplaresTotales;
    }


    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public int getEjemplaresTotales() {
        return ejemplaresTotales;
    }

    public int getEjemplaresDisponibles() {
        return ejemplaresDisponibles;
    }

    public boolean estaDisponible() {
        return ejemplaresDisponibles > 0;
    }

    public void prestarEjemplar() {
        if (estaDisponible()) {
            System.out.println("Ejemplar prestado existosamente, quedan" + ejemplaresDisponibles);
            ejemplaresDisponibles--;
        }
    }

    public void devolver() {
        if (ejemplaresDisponibles < ejemplaresTotales) {
            ejemplaresDisponibles++;
        }
    }

    @Override
    public String toString() {
        return "Libro{" +
                "isbn='" + isbn + '\'' +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", anioPublicacion=" + anioPublicacion +
                ", ejemplaresTotales=" + ejemplaresTotales +
                ", ejemplaresDisponibles=" + ejemplaresDisponibles +
                '}';
    }
}   