package com.bedu.tienda;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TiendaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiendaApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ProductoRepository productoRepo, CategoriaRepository categoriaRepo,
			MarcaRepository marcaRepo) {
		return (args) -> {
			Categoria tecnologia = new Categoria("Tecnología");
			categoriaRepo.save(tecnologia);

			Marca marca1 = new Marca("Apple");
			Marca marca2 = new Marca("Samsung");
			marcaRepo.save(marca1);
			marcaRepo.save(marca2);

			productoRepo.save(new Producto("iPhone 15", "iOS 12", 90000.00, tecnologia, marca1));
			productoRepo.save(new Producto("iPad Pro", "Pantalla 10 pulgadas", 140000.00, tecnologia, marca1));
			productoRepo.save(new Producto("Galaxy S23", "Android 14", 7800.00, tecnologia, marca2));
			productoRepo.save(new Producto("Smart TV", "Android 11", 7800.00, tecnologia, marca2));

			// System.out.println("📂 Productos registrados:");
			// productoRepo.findAll()
			// .forEach(p -> System.out.println(p.getNombre() + " - " +
			// p.getCategoria().getNombre()));

			System.out.println("📚 Productos por marca:");
			marcaRepo.findAll().forEach(marca -> {
				System.out.println("🏷️ " + marca.getNombre() + ":");
				productoRepo.findAll().stream()
						.filter(p -> p.getMarca().getId().equals(marca.getId()))
						.forEach(p -> System.out.println("   - " + p.getNombre()));
			});
		};
	}

}
