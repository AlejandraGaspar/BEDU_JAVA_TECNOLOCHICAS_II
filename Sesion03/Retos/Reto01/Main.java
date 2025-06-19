package Sesion03.Retos.Reto01;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Pedido> pedidos = Lector.leerArchivo();

        Predicate<Pedido> TipoPedidos = (p) -> "domicilio".equals(p.getTipoEntrega());

        List<Pedido> pedidoDomicilio = pedidos
        .stream()
        .filter(TipoPedidos)
        .collect(Collectors.toList());

        pedidoDomicilio
            .forEach(pedido -> {
                pedido.getTelefono().ifPresent(telefono -> {
                    System.out.println("Confirmación enviada al número: " + telefono);
                });
            });
    }
}