package Sesion03.Retos.Reto01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Lector {
    public static List<Pedido> leerArchivo() {
        List<Pedido> pedidos = new LinkedList<>();

        try {
            File archivo = new File("./Sesion03/Retos/Reto01/clientes.txt");
            FileReader lector = new FileReader(archivo);
            BufferedReader buffer = new BufferedReader(lector);

            String linea;

            while((linea = buffer.readLine()) != null) {
                String[] entradas = linea.split("\\|");

                String clienteArchivo = entradas[0];
                String tipoEntregaArchivo = entradas[1];
                
                Optional<String> telefono = Optional.empty(); // Por defecto, no hay teléfono
                if (entradas.length > 2) { // Si hay un tercer elemento (el teléfono)
                    String telefonoStr = entradas[2];
                    if (!telefonoStr.isEmpty()) { // Y si no es una cadena vacía
                        telefono = Optional.of(telefonoStr); // Entonces, el Optional contiene el teléfono
                    }
                }

                pedidos.add(new Pedido(clienteArchivo, tipoEntregaArchivo, telefono));
            }

            buffer.close();

            return pedidos;
        } catch (IOException ex) {
            ex.printStackTrace();
            return new LinkedList<>();
        }
    }
}
