import java.util.Random;
import java.util.Scanner;

public class App {
    static Scanner entrada = new Scanner(System.in);
    static Random random = new Random();

    static String[] planetas = {"1. MERCURIO", "2. VENUS", "3. MARTE", "4. JUPITER", "5. SATURNO", "6. URANO", "7. NEPTUNO"};
    static double[] distancias = {91.7, 42.4, 78.3, 628.9, 1284.4, 2721.4, 4345.4};

    static String[] naves = {"1. EXPLORER", "2. CARGUERO", "3. SPEEDER"};
    static double[] velocidad = {45000.0, 55000.0, 80000.0};

    static final double FACTOR_CONSUMO = 0.5;
    public static double distanciaPlane;
    public static double tiempoTranscurrido;

    public static void main(String[] args) {
        int option;
        do {
            mostrarMenu();
            option = entrada.nextInt();

            switch (option) {
                case 1:
                    iniciarSimulacion();
                    break;
                case 2:
                    System.out.println("¡HASTA LUEGO!");
                    break;
                default:
                    System.out.println("Ingrese una opción válida.");
                    break;
            }
        } while (option != 2); // El bucle se repite hasta que el usuario elija la opción 2 (Salir)
    }

    // Mostrar menú
    public static void mostrarMenu() {
        System.out.println("\n //////////////////////////////////////////////////////////");
        System.out.println("======BIENVENIDO A LA SIMULACION DE VIAJE INTERPLANETARIO=====");
        System.out.println("//////////////////////////////////////////////////////////");
        System.out.println("1. INICIAR SIMULACION");
        System.out.println("2. SALIR");
        System.out.print("POR FAVOR, ELIGE UNA OPCION: ");
    }

    // Iniciar simulación
    public static void iniciarSimulacion() {
        mostrarProgresoViaje();
    }

    // Seleccionar destino y distancia
    public static double selecionarDestino() {
        var option = 0;
        do {
            
        
        System.out.println("SELECCIONA TU DESTINO: ");
        for (int i = 0; i < planetas.length; i++) {
            System.out.println(planetas[i]);
        }
        System.out.print("Ingresa el número del planeta: ");
        option = entrada.nextInt();
        if (option >= 1 && option <= planetas.length) {
            distanciaPlane = distancias[option - 1];
            System.out.println("¡Excelente elección! Te diriges hacia: " + planetas[option - 1] + " a una distancia de: " + distanciaPlane + " millones de km.");
        } else {
            System.out.println("Opción no válida.");
        }
        } while (option < 1 || option > planetas.length);
        return distanciaPlane;
    }

    // Seleccionar nave y velocidad
    public static double navesVelocidad() {
        var option = 0;
        double velocidadNave = 0;
        do {
            
        
        for (int i = 0; i < naves.length; i++) {
            System.out.println(naves[i]);
        }
        System.out.print("Ingresa el numero que correspanda a tu nave: ");
         option = entrada.nextInt();
        if (option >= 1 && option <= naves.length) {
            velocidadNave = velocidad[option - 1];
            System.out.println("Tu nave seleccionada es: " + naves[option - 1] + " a una velocidad de: " + velocidadNave + " km/h.");
        } else {
            System.out.println("Opción no válida.");
        }
        }while (option < 1 || option > naves.length); // Repetir hasta que el usuario elija una opción válida
        return velocidadNave;
    
    }

    // Método para mostrar el progreso del viaje
    public static double mostrarProgresoViaje() {
        distanciaPlane = selecionarDestino();
        double velocidadNave = navesVelocidad();
        
        // Calcular el tiempo total de viaje en horas y luego en días
        double tiempoViajeTotal = distanciaPlane * 1000000 / velocidadNave; // Convertimos a km y calculamos el tiempo en horas
        double tiempoViajeTotalEnDias = tiempoViajeTotal / 24; // Convertimos horas a días

        System.out.println("=====Comienza tu viaje. ====");
        System.out.println("Distancia al destino: " + distanciaPlane + " millones de km");
        System.out.println("Tiempo total de viaje: " + tiempoViajeTotalEnDias + " días");

        //////////////////////////////////////////
        /// 
        double totalOxigeno = 0;
        double editCombustible = 0;

        do {
            
        System.out.println("INGRESA 1 PARA INGRESAR CANTIDAD DE COMBUSTIBLE, 2 PARA USAR EL RECOMENDADO");
         editCombustible = entrada.nextInt();

        if (editCombustible == 1) {
            System.out.println("Ingresa el combustible a utilizar (en litros):");
            double totalcombustible = entrada.nextDouble(); 
            System.out.println("Ingresa el número de personas a bordo:");
            double oxigeno = entrada.nextInt();
            totalOxigeno = oxigeno * tiempoViajeTotalEnDias; // Calculamos el oxígeno necesario

            System.out.println("Combustible ingresado: " + totalcombustible + " litros. Total Oxígeno necesario: " + totalOxigeno + " litros.");

        } else if (editCombustible == 2) {
            System.out.println("Ingresa el número de personas a bordo:");
            double oxigeno = entrada.nextInt();
            totalOxigeno = oxigeno * tiempoViajeTotalEnDias; // Calculamos el oxígeno necesario

            System.out.println("\n =======INICIO DE VIAJE =======");
            
            // Convertir la distancia del planeta de millones de km a kilómetros
            double distanciaTotalkmh = distanciaPlane * 1.60934; // Convertimos la distancia de millones de km a km
            
            // Calcular el combustible necesario
            double consumoTotal = FACTOR_CONSUMO * distanciaTotalkmh; 
            System.out.println("Combustible necesario para el viaje: " + consumoTotal + " litros de gas. Total Oxígeno necesario: " + totalOxigeno + " litros.");

            // Mostrar el inicio del viaje
            System.out.println("Comienza tu viaje hacia el planeta con una distancia de: " + distanciaTotalkmh + " km.");
            System.out.println("Tiempo total de viaje estimado: " + tiempoViajeTotalEnDias + " días.");
            
        } else {
            System.out.println("Opción inválida, ingresa una opción entre 1 y 2.");
        }} while (editCombustible < 1 || editCombustible > 2);


        ///////////////////////

        tiempoTranscurrido = 0;

        // Simulación del progreso del viaje
        while (tiempoTranscurrido < tiempoViajeTotalEnDias) {
            try {
                Thread.sleep(1000); // Simula 1 día en 1 segundo
                tiempoTranscurrido++;

                // Calculamos el porcentaje de progreso
                double progreso = (tiempoTranscurrido / tiempoViajeTotalEnDias) * 100;
                System.out.printf("Progreso: %.2f%%\n", progreso);

                // Mostrar eventos aleatorios durante el viaje
                if (tiempoTranscurrido % 5 == 0) { // Evento aleatorio cada 5 días
                    eventosAleatorios();
                }

                // Si ya hemos llegado a nuestro destino, mostramos un mensaje de éxito
                if (progreso >= 100) {
                    System.out.println("¡Has llegado a tu destino!");
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }return tiempoTranscurrido;
    }

    // Mostrar eventos aleatorios
    public static void eventosAleatorios() {
        int tipoEvento = random.nextInt(6) + 1; // Genera un número entre 1 y 6
        

        switch (tipoEvento) {
            
            case 1:
                System.out.println("¡Una tormenta espacial ha ocurrido! Se necesita ajustar la trayectoria.");
         
                break;
            case 2:
                System.out.println("¡Has encontrado una nave alienígena! ¿Amistosa o hostil?");
                break;
            case 3:
                System.out.println("¡El sistema de comunicación se ha averiado temporalmente!");
                break;
            case 4:
                System.out.println("Revisa el combustible.");
                break;
            case 5:
                System.out.println("Revisa las provisiones.");
                break;
            case 6:
                System.out.println("¡Un evento inesperado ha ocurrido!");
                break;
            default:
                break;
        }
    }

    
    
    
}
    