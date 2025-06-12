package Sesion02.candado;

import java.util.concurrent.Callable;

public class Incrementador implements Callable<Void> {
    
    @Override
    public Void call() {

        for (int i = 0; i < 10000; i++) {
            //Bloquear el recurso para cualquier otro hilo
            MemoriaCompartida.candado.lock();

            try {
                //Dentro va todo lo que es protegido
                MemoriaCompartida.valor++;
            } finally {
                //Liberar el recurso
                MemoriaCompartida.candado.unlock();
            }
        }

        return null;
    }
}