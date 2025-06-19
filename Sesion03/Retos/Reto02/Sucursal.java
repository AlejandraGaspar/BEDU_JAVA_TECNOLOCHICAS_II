package Sesion03.Retos.Reto02;

import java.util.ArrayList;
import java.util.List;

public class Sucursal {
    private String nombre;
    private List<Encuesta> encuestas;

    public Sucursal(String nombre, List<Encuesta> encuestas){
        this.nombre = nombre;
        this.encuestas = new ArrayList<>(encuestas);
    }

    public String getNombre(){ return nombre; }

    public List<Encuesta> getEncuestas(){ return encuestas; }
}
