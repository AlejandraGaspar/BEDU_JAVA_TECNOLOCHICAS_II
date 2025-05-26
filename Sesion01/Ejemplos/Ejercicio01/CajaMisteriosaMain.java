
public class CajaMisteriosaMain {

    public static void main(String ... args) {

        CajaMisteriosa<String> cajita = new CajaMisteriosa<>();

        cajita.guardar("Hola Mundo");

        String valor = cajita.sacar(); // <--- ERROR

        System.out.println("El valor de la caja es => " + valor);

        CajaMisteriosa<Integer> cajitaNumeros = new CajaMisteriosa<>();

        cajitaNumeros.guardar(1);
    }
}

/*
    Herencia -> Especialización
    Polimorfismo -> Generalización

    Animal -> Mamifero -> Canino -> Perros
                                 -> Lobo

                       -> Felinos
                                 -> Gato


    Animal a = new Gato();

    Gato g = new Animal();


    Object -> String

    Object o = new String(); Polimorfismo
    String s = new Object(); ❌ Quien sabe que es
*/