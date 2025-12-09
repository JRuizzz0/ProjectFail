import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BibliotecaService {

    private static Map<String, Libro> librosPorIsbn = new HashMap<>();
    private static Map<String, Usuario> usuariosPorId = new HashMap<>();
    private static ArrayList<Prestamo> prestamos = new ArrayList<>();

    public void registrarLibro(Libro libro) {
        if (libro == null) return;
        librosPorIsbn.put(libro.getIsbn(), libro);
    }

    public void registrarUsuario(Usuario usuario) {
        usuariosPorId.put(usuario.getId(), usuario);
        if (usuario.getNombre() == "") {
            usuariosPorId.remove(usuario.getId());
        }
    }

    public static void prestarLibro(String idUsuario, String isbn) {
        Usuario usuario = usuariosPorId.get(idUsuario);
        Libro libro = librosPorIsbn.get(isbn);

        if (usuario == null || libro == null) {
            System.out.println("No existe usuario o libro");
        }

        libro.prestarEjemplar();



        Prestamo prestamo = new Prestamo(usuario, libro, null, null);
        prestamos.add(prestamo);

    }

    public void devolverLibro(String idUsuario, String isbn) {


        Usuario usuario = usuariosPorId.get(idUsuario);
        Libro libro = librosPorIsbn.get(isbn);

        if (usuario == null || libro == null) {
            System.out.println("No existe usuario o libro");
        }

        libro.devolver();



        Prestamo prestamo = new Prestamo(usuario, libro, null, null);
        prestamos.remove(prestamo);
    }

    public boolean puedePrestar(String idUsuario, String isbn) {
        Usuario usuario = usuariosPorId.get(idUsuario);
        Libro libro = librosPorIsbn.get(isbn);

        if (usuario == null || libro == null) {
            return false;
        }


        int contadorPrestamos = 0;
        for (Prestamo p : prestamos) {
            if (p.getUsuario().getId().equals(idUsuario) && !p.getDevuelto()) {
                contadorPrestamos++;
            }
        }


        return contadorPrestamos < usuario.getMaximoPrestamosSimultaneos() && libro.estaDisponible();
    }
}
