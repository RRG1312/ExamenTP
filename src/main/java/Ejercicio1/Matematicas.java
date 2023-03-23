package Ejercicio1;

import java.util.Random;
import java.util.Scanner;

public class Matematicas {
    public static double generarNumeroPi(long pasos) {
        long puntosTotales = pasos;
        int aciertos = 0;
        double radio = 1.0;
        Random rnd = new Random();

        for (long i = 0; i < puntosTotales; i++) {
            double x = rnd.nextDouble() * 2 - 1;
            double y = rnd.nextDouble() * 2 - 1;
            if (Math.sqrt(x * x + y * y) <= radio) {
                aciertos++;
            }
        }

        double aproximacionPi = 4.0 * aciertos / puntosTotales;
        return aproximacionPi;
    }
}