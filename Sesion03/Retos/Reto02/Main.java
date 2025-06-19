package Sesion03.Retos.Reto02;

import java.util.AbstractMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Sucursal> sucursales = List.of(
                new Sucursal("Centro", List.of(
                        new Encuesta("Juan", "El tiempo de espera fue largo", 1),
                        new Encuesta("María", null, 3))),
                new Sucursal("Norte", List.of(
                        new Encuesta("Maria", "La atención fue buena, pero la limpieza puede mejorar", 1),
                        new Encuesta("Esteban", "Buen Servico", 5))),
                new Sucursal("Sur", List.of(
                        new Encuesta("Esteban", "Área de espera en malas condiciones", 2),
                        new Encuesta("Diana", "Atención a tiempo", 4))),
                new Sucursal("Este", List.of(
                        new Encuesta("Andrés", "Buena condición del área de atención al cliente", 5),
                        new Encuesta("Sofía", null, 1)))
        );

        sucursales
                .stream()
                .flatMap(s -> s.getEncuestas().stream().map(encuesta -> new AbstractMap.SimpleEntry<>(s.getNombre(), encuesta)))
                .filter(e -> e.getValue().getCalificacion() <= 3)
                .flatMap(e -> e.getValue().getComentario()
                    .map(comentario -> new AbstractMap.SimpleEntry<>(e.getKey(), comentario))
                    .stream())
                .map(e -> "Sucursal " + e.getKey() + ": Seguimiento a paciente con comentario: \"" + e.getValue() + "\"")
                .forEach(System.out::println);
    }
}