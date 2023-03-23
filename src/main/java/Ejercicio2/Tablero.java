package Ejercicio2;

public class Tablero {

    int[][] posiciones = new int[30][30];
    public Tablero(){
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j <30 ; j++) {
                if(Math.random()*11>3){
                    this.posiciones[i][j]=1;
                }else{
                    this.posiciones[i][j]=0;
                }
            }
        }
    }


    @Override
    public String toString() {
        String res ="";
        for (int i = 0; i <30; i++) {
            res+="\n";
            for (int j = 0; j <30 ; j++) {
                res+=this.posiciones[i][j]+" ";
            }
        }
        return res;
    }

    public static Tablero generarNuevoestado(Tablero tablero){
        Tablero res = tablero;
        int contador =0;

        for (int i = 0; i <30 ; i++) {
            for (int j = 0; j <30 ; j++) {

                for (int k = -1; k <=1 ; k++) {
                    for (int l = -1; l <=1 ; l++) {
                        if(i+k>0 && i+k<30 && j+l>0 && j+l<30){
                            if(tablero.posiciones[i+k][j+l]==1){
                                contador++;
                            }
                        }
                    }
                }

                if(tablero.posiciones[i][j]==0){
                    if(contador==3){
                        res.posiciones[i][j]=1;
                    }else{
                        res.posiciones[i][j]=0;
                    }
                }else{
                    if(contador ==2 || contador==3){
                        res.posiciones[i][j]=1;
                    }else{
                        res.posiciones[i][j]=0;
                    }
                }

                contador =0;

            }
        }


        return res;
    }
}