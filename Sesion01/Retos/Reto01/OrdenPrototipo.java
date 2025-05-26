package Sesion01.Retos.Reto01;

public class OrdenPrototipo extends OrdenProduccion {
    String faseDesarrollo;

    public OrdenPrototipo(String codigo, int cantidad, String faseD){
        super(codigo, cantidad);
        this.faseDesarrollo = faseD;
    }

    public String getFaseDesarrollo(){
        return faseDesarrollo;
    }

    @Override
    public void mostrarResumen() {
        System.out.println("OrdenPrototipo - Código: " + codigo + " - Cantidad: " + cantidad + " - Fase: " + faseDesarrollo);
    }
}
