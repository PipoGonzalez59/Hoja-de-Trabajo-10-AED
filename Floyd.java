public class Floyd {

    int[][] distancias;
    String[][] caminos;
    Grafo grafo;

    public Floyd(Grafo grafo) {

        this.grafo = grafo;

        distancias = new int[50][50];
        caminos = new String[50][50];

        for (int i = 0; i < grafo.cantidad; i++) {

            for (int j = 0; j < grafo.cantidad; j++) {

                distancias[i][j] = grafo.matriz[i][j];
                caminos[i][j] = "";

            }

        }

    }

    public void calcularFloyd() {

        int n = grafo.cantidad;

        for (int k = 0; k < n; k++) {

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < n; j++) {

                    int nuevo = distancias[i][k] + distancias[k][j];

                    if (nuevo < distancias[i][j]) {

                        distancias[i][j] = nuevo;
                        caminos[i][j] = grafo.ciudades[k];

                    }

                }

            }

        }

    }

    public void rutaMasCorta(String origen, String destino) {

        int i = grafo.buscarCiudad(origen);
        int j = grafo.buscarCiudad(destino);

        System.out.println("Ruta mas corta:");

        System.out.print(origen + " ");

        if (!caminos[i][j].equals("")) {
            System.out.print(caminos[i][j] + " ");
        }

        System.out.println(destino);

        System.out.println("Distancia: " + distancias[i][j]);

    }

    public void centroGrafo() {

        int n = grafo.cantidad;

        int menor = 99999;
        int posicion = 0;

        for (int i = 0; i < n; i++) {

            int mayor = 0;

            for (int j = 0; j < n; j++) {

                if (distancias[i][j] > mayor) {
                    mayor = distancias[i][j];
                }

            }

            if (mayor < menor) {

                menor = mayor;
                posicion = i;

            }

        }

        System.out.println("Centro del grafo:");
        System.out.println(grafo.ciudades[posicion]);

    }

}