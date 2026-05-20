import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Grafo grafo = new Grafo();

        grafo.leerArchivo("guategrafo.txt");

        Floyd floyd = new Floyd(grafo);

        floyd.calcularFloyd();

        Scanner scanner = new Scanner(System.in);

        int opcion = 0;

        while (opcion != 4) {

            System.out.println("MENU");
            System.out.println("1. Ruta mas corta");
            System.out.println("2. Centro del grafo");
            System.out.println("3. Modificar grafo");
            System.out.println("4. Salir");

            opcion = scanner.nextInt();

            if (opcion == 1) {

                scanner.nextLine();

                System.out.println("Ciudad origen:");
                String origen = scanner.nextLine();

                System.out.println("Ciudad destino:");
                String destino = scanner.nextLine();

                floyd.rutaMasCorta(origen, destino);

            }

            else if (opcion == 2) {

                floyd.centroGrafo();

            }

            else if (opcion == 3) {

                scanner.nextLine();

                System.out.println("1. Eliminar conexion");
                System.out.println("2. Agregar conexion");

                int op = scanner.nextInt();
                scanner.nextLine();

                if (op == 1) {

                    System.out.println("Origen:");
                    String origen = scanner.nextLine();

                    System.out.println("Destino:");
                    String destino = scanner.nextLine();

                    grafo.eliminarConexion(origen, destino);

                }

                else if (op == 2) {

                    System.out.println("Origen:");
                    String origen = scanner.nextLine();

                    System.out.println("Destino:");
                    String destino = scanner.nextLine();

                    System.out.println("Distancia:");
                    int distancia = scanner.nextInt();

                    grafo.agregarConexion(origen, destino, distancia);

                }

                floyd = new Floyd(grafo);
                floyd.calcularFloyd();

            }

        }

        scanner.close();

    }

}