package Ejercicio1;

import java.util.Random;
import java.util.Scanner;

public class Menu1 {
    public static void menu() throws Exception{
        Scanner teclado = new Scanner(System.in);
        boolean seguir =true;
        Random r = new Random();
        long valor;
        try{
            int aux=0;
            while(seguir) {

                valor = r.nextInt(9999999-2)+1;

                if (valor > Integer.MAX_VALUE || valor < Integer.MIN_VALUE) {
                    throw new DesbordamientoException("El valor introducido supera los limites de digitos");
                }else{
                    seguir=false;
                }
                aux= Integer.parseInt(valor+"");
            }
            System.out.println("El numero PI es "+Matematicas.generarNumeroPi(aux));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }


    }

}
