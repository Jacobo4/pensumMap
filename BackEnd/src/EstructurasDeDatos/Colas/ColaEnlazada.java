package EstructurasDeDatos.Colas;

public class ColaEnlazada <T> implements Colas <T>{
    private Nodo <T> cabeza;
    private Nodo <T> cola;

    public ColaEnlazada(){
        cabeza = cola = null;
    }

    @Override
    public boolean vacio() {
        // TODO Auto-generated method stub
        if (cabeza == null)
        return true;
        else 
        return false;
    }

    @Override
    public T obtenerCabeza() {
        // TODO Auto-generated method stub
        if (vacio())
            return null;
        else
            return cabeza.getDato();
    }

    @Override
    public T obtenerCola() {
        // TODO Auto-generated method stub
        if (vacio())
            return null;
        else
            return cola.getDato();
    }

    @Override
    public void put(T dato) {
        // TODO Auto-generated method stub
        Nodo nuevo = new Nodo<T>(dato);
        if (cabeza == null)
            cabeza = nuevo;
        else
            cola.setSig(nuevo);
        cola = nuevo;
    }

    @Override
    public T atender() {
        // TODO Auto-generated method stub
        if (cabeza == null)
            return null;
        Nodo <T> aux = cabeza;
        cabeza = cabeza.getSig();
        if(vacio())
            cola = null;
        return aux.getDato();
    }
}
