import java.util.Random;
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

        return scanner.nextInt();
    }

    // Función para seleccionar una nave
    public static int seleccionarNave() {
        System.out.println("Selecciona un tipo de nave:");
        System.out.println("1. Exploradora (20000 km/h)");
        System.out.println("2. Carga pesada (15000 km/h)");
        System.out.println("3. Velocidad máxima (30000 km/h)");

        return scanner.nextInt();
    }

    // Función para calcular el tiempo de vuelo
    public static double calcularTiempoDeVuelo(double distancia, double velocidad) {
        return distancia / velocidad;
    }

    // Función para calcular el combustible necesario
    public static double calcularCombustible(double distancia) {
        return distancia / 10_000; // Ejemplo: se requiere 1 unidad de combustible por cada 10,000 km
    }

    // Función para simular eventos aleatorios
    public static boolean eventoAleatorio(double progreso) {
        Random random = new Random();
        int probabilidad = random.nextInt(100);

        // Eventos aleatorios con probabilidad basada en el progreso
        if (probabilidad < 10) {
            System.out.println("¡Evento aleatorio! Asteroides detectados, esquivando...");
            return false; // Evento menor, no termina el viaje
        } else if (probabilidad < 15) {
            System.out.println("¡Falla en el sistema! Reparando...");
            return false; // Evento mayor, pero se resuelve
        }
        return true; // No hay evento
    }

    // Monitorear el progreso del viaje
    public static void monitorearViaje(double distancia, double velocidad, double combustible, double oxigeno) {
        double tiempoTotal = distancia / velocidad; // Tiempo total en horas
        double tiempoEnDias = tiempoTotal / 24.0;
        double progreso = 0.0; // Porcentaje de progreso
        double recursosTotales = combustible; // Simplificado: sólo combustible

        System.out.println("\n¡Inicio del viaje!");

        for (int hora = 1; hora <= tiempoTotal; hora++) {
            // Calcular progreso
            progreso = (hora / tiempoTotal) * 100;

            // Reducir recursos
            combustible -= 1; // Consumo por hora
            oxigeno -= 0.5; // Oxígeno por hora

            // Mostrar estado actual
            System.out.printf("Progreso: %.2f%%, Combustible restante: %.2f, Oxígeno restante: %.2f, Horas restantes: %.2f\n",
                              progreso, combustible, oxigeno, tiempoTotal - hora);

            // Comprobar recursos
            if (combustible <= 0 || oxigeno <= 0) {
                System.out.println("¡Recursos agotados! El viaje no puede continuar.");
                return;
            }

            // Evento aleatorio
            if (!eventoAleatorio(progreso)) {
                continue; // Resolver evento y continuar
            }

            // Simular el paso del tiempo (puedes añadir un delay real si lo deseas)
        }

        System.out.println("¡Has llegado a tu destino con éxito!");
    }

    public static void main(String[] args) {
        // Datos de planetas y naves
        double[] distancias = {78.0, 41.0, 62.0, 628.0, 1275.0, 2870.0, 4300.0}; // en millones de km
        double[] velocidades = {20000.0, 15000.0, 30000.0}; // en km/h
        String[] planetas = {"Mercurio", "Venus", "Tierra", "Marte", "Júpiter", "Saturno", "Urano", "Neptuno"};
        String[] naves = {"Exploradora", "Carga pesada", "Velocidad máxima"};

        // Selección de planeta
        int opcionPlaneta = seleccionarPlaneta();
        if (opcionPlaneta < 1 || opcionPlaneta > 8) {
            System.out.println("Opción inválida para el planeta.");
            return;
        }

        String planetaSeleccionado = planetas[opcionPlaneta - 1];
        double distancia = distancias[opcionPlaneta - 1] * 1_000_000; // Convertir a km

        // Selección de nave
        int opcionNave = seleccionarNave();
        if (opcionNave < 1 || opcionNave > 3) {
            System.out.println("Opción inválida para la nave.");
            return;
        }

        String naveSeleccionada = naves[opcionNave - 1];
        double velocidad = velocidades[opcionNave - 1];

        // Calcular combustible necesario
        double combustible = calcularCombustible(distancia);
        double oxigeno = distancia / 50_000; // Ejemplo: 1 unidad de oxígeno por 50,000 km

        System.out.println("Nave seleccionada: " + naveSeleccionada);
        System.out.printf("Combustible necesario: %.2f unidades, Oxígeno necesario: %.2f unidades.\n", combustible, oxigeno);

        // Monitorear el estado del viaje
        monitorearViaje(distancia, velocidad, combustible, oxigeno);
    }
}
