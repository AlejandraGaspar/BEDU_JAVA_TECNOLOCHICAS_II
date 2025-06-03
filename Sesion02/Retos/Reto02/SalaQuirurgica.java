package Sesion02.Retos.Reto02;

public class SalaQuirurgica implements Runnable{
    private String nombreMedico;
    private RecursoMedico recurso;

    public SalaQuirurgica(String nombreM, RecursoMedico recurso){
        this.nombreMedico = nombreM;
        this.recurso = recurso;
    }

    @Override
    public void run() {
        recurso.usar(nombreMedico);
    }
}
