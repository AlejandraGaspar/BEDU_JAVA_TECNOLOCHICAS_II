package Sesion01.Retos.Reto01;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<OrdenMasa> omasa = new ArrayList<>();
        omasa.add(new OrdenMasa("A123", 500));
        omasa.add(new OrdenMasa("A124", 750));

        List<OrdenPersonalizada> oPersonalizadas = new ArrayList<>();
        oPersonalizadas.add(new OrdenPersonalizada("P456", 100 , "ClienteX"));
        oPersonalizadas.add(new OrdenPersonalizada("P789", 150 , "ClienteY"));

        List<OrdenPrototipo> oPrototipos = new ArrayList<>();
        oPrototipos.add(new OrdenPrototipo("T789", 10, "Diseño"));
        oPrototipos.add(new OrdenPrototipo("T790", 5, "Pruebas"));

        mostrarOrdenes(omasa);
        System.out.println();
        mostrarOrdenes(oPersonalizadas);
        System.out.println();
        mostrarOrdenes(oPrototipos);
        System.out.println();
        procesarPersonalizadas(oPersonalizadas, 200);
        System.out.println();
        System.out.println("Resumen total de órdenes:");
        System.out.println("Producción en masa: " + omasa.size());
        System.out.println("Personalizadas: " + oPersonalizadas.size());
        System.out.println("Prototipos: " + oPrototipos.size());
    }

    public static void mostrarOrdenes(List<? extends OrdenProduccion> lista) {
        System.out.println("Órdenes registradas:");
        for (OrdenProduccion oProduccion : lista) {
            oProduccion.mostrarResumen();
        }
    }

    public static void procesarPersonalizadas(List<? super OrdenPersonalizada> lista, int costoAdicional){
        System.out.println("Procesando órdenes personalizadas...");
        for(Object obj : lista) {
            if(obj instanceof OrdenPersonalizada) {
                OrdenPersonalizada orden = (OrdenPersonalizada) obj;
                orden.costoAdicional(costoAdicional);
            }
        }
    }
}
