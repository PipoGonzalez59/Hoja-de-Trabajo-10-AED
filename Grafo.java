import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Grafo {

    String[] ciudades;
    int[][] matriz;
    int cantidad;

    public Grafo() {
        ciudades = new String[50];
        matriz = new int[50][50];
        cantidad = 0;

        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {

                if (i == j) {
                    matriz[i][j] = 0;
                } else {
                    matriz[i][j] = 99999;
                }

            }
        }
    }

    public void agregarCiudad(String ciudad) {

        boolean existe = false;

        for (int i = 0; i < cantidad; i++) {

            if (ciudades[i].equals(ciudad)) {
                existe = true;
            }

        }

        if (!existe) {
            ciudades[cantidad] = ciudad;
            cantidad++;
        }

    }

    public int buscarCiudad(String ciudad) {

        for (int i = 0; i < cantidad; i++) {

            if (ciudades[i].equals(ciudad)) {
                return i;
            }

        }

        return -1;
    }

    public void agregarConexion(String origen, String destino, int distancia) {

        agregarCiudad(origen);
        agregarCiudad(destino);

        int i = buscarCiudad(origen);
        int j = buscarCiudad(destino);

        matriz[i][j] = distancia;
    }

    public void eliminarConexion(String origen, String destino) {

        int i = buscarCiudad(origen);
        int j = buscarCiudad(destino);

        matriz[i][j] = 99999;
    }

    public void leerArchivo(String nombreArchivo) {

        try {

            File archivo = new File(nombreArchivo);
            Scanner scanner = new Scanner(archivo);

            while (scanner.hasNext()) {

                String origen = scanner.next();
                String destino = scanner.next();
                int distancia = scanner.nextInt();

                agregarConexion(origen, destino, distancia);

            }

            scanner.close();

        } catch (FileNotFoundException e) {

            System.out.println("Archivo no encontrado");

        }

    }

    public void mostrarMatriz() {

        System.out.println("Matriz de Adyacencia");

        for (int i = 0; i < cantidad; i++) {

            for (int j = 0; j < cantidad; j++) {

                if (matriz[i][j] == 99999) {
                    System.out.print("INF ");
                } else {
                    System.out.print(matriz[i][j] + " ");
                }

            }

            System.out.println();

        }

    }

}