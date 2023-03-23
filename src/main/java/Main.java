import Ejercicio1.Matematicas;
import Ejercicio1.Menu1;
import Ejercicio2.Tablero;

public class Main {
    public static void main(String[] args) {
       // try {
        //    Menu1.menu();
        //} catch (Exception e) {
         //   System.out.println(e.getMessage());
        //}


        Tablero tablero = new Tablero();
        System.out.println("SIMULACIÓN CON TABLERO LEÍDO");
        tablero.leerEstadoActual();
        System.out.println(tablero);
        for (int i = 0; i <= 5; i++) {
            tablero.transitarAlEstadoSiguiente();
            System.out.println(tablero);
        }
        System.out.println("SIMULACIÓN CON TABLERO GENERADO MEDIANTE MONTECARLO");
        tablero.generarEstadoActualPorMontecarlo();
        System.out.println(tablero);
        for (int i = 0; i <= 15; i++) {
            tablero.transitarAlEstadoSiguiente();
            System.out.println(tablero);
        }

    }
}
