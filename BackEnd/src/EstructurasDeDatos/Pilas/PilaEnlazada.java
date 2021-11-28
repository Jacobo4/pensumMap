package EstructurasDeDatos.Pilas;

import EstructurasDeDatos.Listas.RCurricularLEnlazada;

public class PilaEnlazada <T> extends RCurricularLEnlazada <T> implements Pilas <T> {

    public PilaEnlazada(){
        super();
    }

    @Override
    public T peek() {
        // TODO Auto-generated method stub
        if (vacio())
            return null;
        return obtener(0);
    }

    @Override
    public void push(T dato) {
        // TODO Auto-generated method stub
        insertar(dato,0);
    }

    @Override
    public T pop() {
        // TODO Auto-generated method stub
        if (vacio())
            return null;
        return elinimar(0);
    }

}