package com.bedu.tienda;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nombre;

    protected Marca(){}

    public Marca(String nombre){
        this.nombre = nombre;
    }

    public Long getId(){ return id; }
    public String getNombre(){ return nombre; }
}
