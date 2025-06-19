package com.bedu.tienda;

import org.springframework.data.jpa.repository.JpaRepository;

// Esta interfaz extiende JpaRepository para gestionar operaciones CRUD sobre la entidad Producto
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}