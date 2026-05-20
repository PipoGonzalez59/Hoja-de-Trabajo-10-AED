import static org.junit.Assert.*;
import org.junit.Test;

public class GrafoTest {

    @Test
    public void testAgregarCiudad() {

        Grafo g = new Grafo();

        g.agregarCiudad("Guatemala");

        assertEquals(1, g.cantidad);

    }

    @Test
    public void testAgregarConexion() {

        Grafo g = new Grafo();

        g.agregarConexion("A", "B", 20);

        int i = g.buscarCiudad("A");
        int j = g.buscarCiudad("B");

        assertEquals(20, g.matriz[i][j]);

    }

}