package Sesion03.Retos.Reto01;

import java.util.Optional;

public class Pedido {
    private String cliente;
    private String tipoEntrega;
    private Optional<String> telefono;

    public Pedido(String cliente, String tipoEntrega, Optional<String> telefono){
        this.cliente = cliente;
        this.tipoEntrega = tipoEntrega;
        this.telefono = telefono;
    }

    public Optional<String> getTelefono(){ return telefono; }

    public String getCliente(){ return cliente; }

    public String getTipoEntrega(){ return tipoEntrega; }


}
