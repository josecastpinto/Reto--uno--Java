import java.util.Scanner;

public class App {

    static Scanner scanner = new Scanner(System.in);

    // Función para seleccionar un planeta
    public static int seleccionarPlaneta() {
        System.out.println("Selecciona un planeta:");
        System.out.println("1. Mercurio (78 millones de km)");
        System.out.println("2. Venus (41 millones de km)");
        System.out.println("3. Tierra (0 km)");
        System.out.println("4. Marte (62 millones de km)");
        System.out.println("5. Júpiter (628 millones de km)");
        System.out.println("6. Saturno (1275 millones de km)");
        System.out.println("7. Urano (2870 millones de km)");
        System.out.println("8. Neptuno (4300 millones de km)");

        int opcionPlaneta = scanner.nextInt();
        return opcionPlaneta; // Retorna la opción seleccionada
    }

    // Función para seleccionar una nave
    public static int seleccionarNave() {
        System.out.println("Selecciona un tipo de nave:");
        System.out.println("1. Exploradora (20000 km/h)");
        System.out.println("2. Carga pesada (15000 km/h)");
        System.out.println("3. Velocidad máxima (30000 km/h)");

        int opcionNave = scanner.nextInt();
        return opcionNave; // Retorna la opción seleccionada
    }

    // Función para calcular el tiempo de vuelo
    public static double calcularTiempoDeVuelo(double distancia, double velocidad) {
        return distancia / velocidad;
    }

    // Función principal que une todo
    public static void main(String[] args) {
        // Definir las distancias entre la Tierra y otros planetas (en millones de km)
        double[] distancias = {78.0, 41.0, 62.0, 628.0, 1275.0, 2870.0, 4300.0}; // distancias en millones de km

        // Definir las velocidades de las naves en km/h
        double[] velocidades = {20000.0, 15000.0, 30000.0}; // velocidades de las naves en km/h

        // Selección del planeta
        int opcionPlaneta = seleccionarPlaneta();
        if (opcionPlaneta < 1 || opcionPlaneta > 8) {
            System.out.println("Opción inválida para el planeta.");
            return; // Salir si se elige una opción inválida
        }
        
        // Lista de planetas y sus nombres
        String[] planetas = {"Mercurio", "Venus", "Tierra", "Marte", "Júpiter", "Saturno", "Urano", "Neptuno"};
        String planetaSeleccionado = planetas[opcionPlaneta - 1]; // Elige el nombre del planeta

        double distancia = distancias[opcionPlaneta - 1] * 1000000; // Distancia correspondiente al planeta (convertido a km)

        // Selección de la nave
        int opcionNave = seleccionarNave();
        if (opcionNave < 1 || opcionNave > 3) {
            System.out.println("Opción inválida para la nave.");
            return; // Salir si se elige una opción inválida
        }

        // Lista de naves y sus nombres
        String[] naves = {"Exploradora", "Carga pesada", "Velocidad máxima"};
        String naveSeleccionada = naves[opcionNave - 1]; // Elige el nombre de la nave

        double velocidad = velocidades[opcionNave - 1]; // Velocidad correspondiente a la nave

        // Calcular el tiempo de vuelo
        double tiempoVuelo = calcularTiempoDeVuelo(distancia, velocidad);
        
        // Convertir el tiempo de vuelo a días (aproximadamente)
        double tiempoEnDias = tiempoVuelo / 24.0;

        // Mostrar el resultado
        System.out.println("La nave seleccionada es: " + naveSeleccionada);
        System.out.println("El tiempo de vuelo desde la Tierra hasta " + planetaSeleccionado + " es de: " 
                           + tiempoVuelo + " horas, o aproximadamente " + tiempoEnDias + " días.");
    }
}