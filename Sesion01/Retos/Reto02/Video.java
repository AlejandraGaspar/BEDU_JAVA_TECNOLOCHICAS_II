package Sesion01.Retos.Reto02;

public class Video extends MaterialCurso {
    int duracion;

    public Video(String titulo, String autor, int duracion){
        super(titulo, autor);
        this.duracion = duracion;
    }
    
    public int getDuracion () { return duracion; }

    @Override
    public void mostrarDetalle() {
        System.out.println("Video: " + titulo + " - Autor: " + autor + " - Duración: " + duracion + " min");
    }

    public void duracionMinutos(){
        duracion += duracion;
        System.out.println("Duración total de videos: " + duracion);
    }
}
