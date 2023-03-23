package Ejercicio2;

import java.util.Random;

public class Tablero {
    private static final int DIMENSION =30;
    private int[][] estadoActual;
    private int[][] estadoSiguiente;
    public Tablero(){
        this.estadoSiguiente =new int[30][30];
        this.estadoActual = new int[30][30];
    }

    public void leerEstadoActual(){
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j <30 ; j++) {
                if(Math.random()<1){
                    this.estadoActual[i][j]=1;
                }else{
                    this.estadoActual[i][j]=0;
                }
            }
        }
    }

    public void generarEstadoActualPorMontecarlo() {
        Random random = new Random();
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                int r = random.nextInt(2);
                estadoActual[i][j] = r;
                int vecinosVivos = contarVecinosVivos(i, j);
                if (r == 1 && (vecinosVivos < 2 || vecinosVivos > 3)) {
                    estadoSiguiente[i][j] = 0;
                } else if (r == 0 && vecinosVivos == 3) {
                    estadoSiguiente[i][j] = 1;
                } else {
                    estadoSiguiente[i][j] = r;
                }
            }
        }
        this.estadoActual = this.estadoSiguiente;
    }
    public int contarVecinosVivos(int fila, int columna) {
        int contador = 0;
        for (int i = fila - 1; i <= fila + 1; i++) {
            for (int j = columna - 1; j <= columna + 1; j++) {
                if (i >= 0 && i < 30 && j >= 0 && j < 30 && !(i == fila && j == columna)) {
                    contador += estadoActual[i][j];
                }
            }
        }
        return contador;
    }

    @Override
    public String toString() {
        String res ="";
        for (int i = 0; i <DIMENSION; i++) {
            res+="\n";
            for (int j = 0; j <DIMENSION ; j++) {
                res+=this.estadoActual[i][j]+" ";
            }
        }
        return res;
    }

    public void transitarAlEstadoSiguiente() {
        int[][] temp = this.estadoActual;
        this.estadoActual = this.estadoSiguiente;
        estadoSiguiente = temp;

        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                int vecinosVivos = contarVecinosVivos(i, j);
                if (estadoActual[i][j] == 1 && (vecinosVivos == 2 || vecinosVivos == 3)) {
                    estadoSiguiente[i][j] = 1;
                } else if (estadoActual[i][j] == 0 && vecinosVivos == 3) {
                    estadoSiguiente[i][j] = 1;
                } else {
                    estadoSiguiente[i][j] = 0;
                }
            }
        }
    }
}