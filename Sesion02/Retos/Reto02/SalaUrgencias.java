package Sesion02.Retos.Reto02;

public class SalaUrgencias implements Runnable {
    public String nombreMedico;
    public RecursoMedico recurso;

    public SalaUrgencias(String nombreM, RecursoMedico recurso){
        this.nombreMedico = nombreM;
        this.recurso = recurso;
    }

    @Override
    public void run() {
        recurso.usar(nombreMedico);
    }
}
