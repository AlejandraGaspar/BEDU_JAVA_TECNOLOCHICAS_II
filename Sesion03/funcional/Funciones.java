import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Funciones {

    public static void main(String[] args) {
        List<Integer> numeritos = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        // Stream API
        // Permite poder utiklizar programacion funcional sobre las listas

        //Objetivo: Tomar cada numero y multiplicarlo por 10

        //Imperativa
        for (int i = 0; i < numeritos.size(); i++){
            int miNumero = numeritos.get(i);  // Obteniendo el i-esimo numero
            int nuevoNumero = miNumero * 10;

            numeritos.set(i, nuevoNumero);
        }

        for (int i = 0; i < numeritos.size(); i++){
            System.out.println(numeritos.get(i));
        }


        // Funcional
        // High Order Functions: Las funciones pueden recibir como parametros funciones
        // o regresar funciones

        // map: Convierte la lista dependiendo un criterio

        // El primer parametro es el tipo de la entrada
        // El segundo parametro es el tipo del retorno

        // Matematicas f(x) = x * 10

        // En la programacion funcional se inrtenta quie no hayan estados o que las
        // funciones sean FUNCIONES PURAS

        Function<Integer, Integer> multiplicarPor10 = x -> x * 10;

        numeritos
        .stream() // ACTIVANDO EL MODO FUNCIONAL
        .map(multiplicarPor10);

        numeritos
        .stream()
        .forEach((n) -> System.out.println(n));

        // Es lo mismo que...

        numeritos
        .stream()
        .forEach(System.out::println);
    }
}