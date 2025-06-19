import java.util.Arrays;
import java.util.List;

public class Ejemplo {
    
    public static void main(String[] args) {
        //creando una lista de numeros
        List<Integer> numeritos = Arrays.asList(8,9,34,56,67,89);

        //Imperativa
        //decir lo que se quiere y como se quiere obtener
        for (int i = 0; i < numeritos.size(); i++){
            System.out.println("Imperativo: " + numeritos.get(i));
        }

        //Declarativa
        //Decir lo que quiero sin preocuparme del como
        //Lenguajes funcionales: Haskell, Elixir. Lenguajes medio fubncionales: JavaScript, Python, Java
        
        numeritos
        .forEach(numero -> System.out.println("Declarativo: " + numero));
        
        // Función: Es una caja negra que dada una entrada, regresa una salida
        // Lambda: Una función anónima que recibe paramétros y hace algo
    }
}
