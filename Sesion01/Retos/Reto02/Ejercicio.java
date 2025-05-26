package Sesion01.Retos.Reto02;

public class Ejercicio extends MaterialCurso {
    boolean revisado;

    public Ejercicio(String titulo, String autor, boolean revisado){
        super(titulo, autor);
        this.revisado = revisado;
    }

    public boolean getRevisado() {
        return revisado;
    }

    public void setRevisado(boolean revisado) {
        this.revisado = revisado;
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("Ejercicio: " + titulo + " - Autor: " + autor + " - Revisado: " + revisado);
    }

    public void mRevisado(){
        if(revisado == false){
            revisado = true;
            System.out.println("Estado de revision: " + revisado);
            System.out.println("Ejercicio '" + titulo + "' marcado como revisado.");
        } else{
            System.out.println("Ejercicio '" + titulo + "' marcado como revisado.");
        }
    }
}
