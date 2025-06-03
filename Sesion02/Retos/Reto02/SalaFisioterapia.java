package Sesion02.Retos.Reto02;

public class SalaFisioterapia implements Runnable {
    public String nombreMedico;
    public RecursoMedico recurso;

    public SalaFisioterapia(String nombreM, RecursoMedico recurso){
        this.nombreMedico = nombreM;
        this.recurso = recurso;
    }

    @Override
    public void run() {
        recurso.usar(nombreMedico);
    }
}
