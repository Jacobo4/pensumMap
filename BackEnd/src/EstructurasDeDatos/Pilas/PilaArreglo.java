package EstructurasDeDatos.Pilas;

import java.util.EmptyStackException;

import EstructurasDeDatos.Colas.Colas;
import EstructurasDeDatos.Listas.RCurricularLArreglo;

public class PilaArreglo <T> extends RCurricularLArreglo <T> implements Pilas <T>{
    public PilaArreglo(int n){
        super(n);
    }
    public PilaArreglo(){
        super(10);
    }

    @Override
    public T peek() {
        // TODO Auto-generated method stub
        if(vacio())
        return null;
        return obtener(tanano()-1);
    }
    @Override
    public void push(T dato) {
        // TODO Auto-generated method stub
        insertar(dato, tanano());
    }
    @Override
    public T pop() {
        // TODO Auto-generated method stub
        if(vacio())
        return null;
        return elinimar(tanano()-1);
    }
    
}
