package Ejercicio1;

import java.util.Random;
import java.util.Scanner;

public class MontecarloPi {
    public static void calcularAproximacion() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Dime la cantidad de puntos a generar:");
        int puntosTotales = teclado.nextInt();
        int aciertos = 0;
        double radio = 1.0;
        Random rnd = new Random();

        for (int i = 0; i < puntosTotales; i++) {
            double x = rnd.nextDouble() * 2 - 1;
            double y = rnd.nextDouble() * 2 - 1;
            if (Math.sqrt(x * x + y * y) <= radio) {
                aciertos++;
            }
        }

        double aproximacionPi = 4.0 * aciertos / puntosTotales;
        System.out.println("Aproximación a pi: " + aproximacionPi);
    }
}