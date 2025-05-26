package Sesion01.Retos.Reto01;

public class OrdenPersonalizada extends OrdenProduccion {
    String cliente;

    public OrdenPersonalizada (String codigo, int cantidad, String cliente){
        super(codigo, cantidad);
        this.cliente = cliente;
    }

    public String getCliente (){
        return cliente;
    }

    @Override
    public void mostrarResumen() {
        System.out.println("OrdenPersonalizada - Código: " + codigo + " - Cantidad: " + cantidad + " - Cliente: " + cliente);
    }

    public void costoAdicional(int costoA){
        System.out.println("Orden " + codigo + " ajustada con costo adicional de $" + costoA);
    }
}
