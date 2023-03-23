import Ejercicio1.Matematicas;
import Ejercicio1.Menu1;

public class Main {
    public static void main(String[] args) {
        try {
            Menu1.menu();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
