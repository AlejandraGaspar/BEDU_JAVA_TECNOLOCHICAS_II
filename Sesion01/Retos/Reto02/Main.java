package Sesion01.Retos.Reto02;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){
        List<Video> videos = new ArrayList<>();
        videos.add(new Video("Introducción a Java", "Mario", 15));
        videos.add(new Video("POO en Java", "Carlos", 20));
       
        List<Articulo> articulos = new ArrayList<>();
        articulos.add(new Articulo("Historia de Java", "Ana", 1200));
        articulos.add(new Articulo("Tipos de datos", "Luis", 800));

        List<Ejercicio> ejercicios = new ArrayList<>();
        ejercicios.add(new Ejercicio("Variables y tipos", "Luis", false));
        ejercicios.add(new Ejercicio("Condicionales", "Mario", false));

        List<MaterialCurso> materiales = new ArrayList<>();
        materiales.addAll(videos);
        materiales.addAll(articulos);
        materiales.addAll(ejercicios);

        //System.out.println("Materiales del curso:");
        // mostrarMateriales(videos);
        // mostrarMateriales(articulos);
        // mostrarMateriales(ejercicios);
        mostrarMateriales(materiales);
        System.out.println();
        contarDuracionVideos(videos);
        System.out.println();
        marcarEjerciciosRevisados(ejercicios);
        System.out.println();
        filtrarPorAutor(materiales);

    }

    public static void mostrarMateriales(List<? extends MaterialCurso> lista) {
        System.out.println("Materiales del curso:");
        if(lista.isEmpty()){
            System.out.println("No hay registros de materiales: ");
        } 
        for (MaterialCurso material : lista){
            material.mostrarDetalle();
        }
    }

    public static void contarDuracionVideos(List<? extends Video> lista){
        int DuracionTotal = 0;
        for (Video video : lista){
            DuracionTotal += video.getDuracion();
        }
        System.out.println("Duración total de videos: " + DuracionTotal + " minutos");
    }

    public static void marcarEjerciciosRevisados(List<? super Ejercicio> lista){
        boolean encontrado = false;
        for (Object obj : lista) {
            if (obj instanceof Ejercicio) {
                Ejercicio ejercicio = (Ejercicio) obj;
                if (!ejercicio.getRevisado()) {
                    ejercicio.setRevisado(true);
                    System.out.println("Ejercicio \"" + ejercicio.getTitulo() + "\" marcado como revisado.");
                    encontrado = true;
                }
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron ejercicios pendientes de revisión en la lista o la lista no contiene ejercicios.");
        }
    }

    public static void filtrarPorAutor (List<? extends MaterialCurso> lista){
        String buscarAutor = "Mario";
        System.out.println("Filtrando materiales por autor:");
        for (MaterialCurso materialCurso : lista){
            if (materialCurso.getAutor().equals(buscarAutor)){
                materialCurso.mostrarDetalle();
            }
        }
    }
}
