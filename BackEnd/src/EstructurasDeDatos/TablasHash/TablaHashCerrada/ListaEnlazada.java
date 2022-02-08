package EstructurasDeDatos.TablasHash.TablaHashCerrada;

import javax.print.DocFlavor.STRING;

public class ListaEnlazada<T> implements Listas<T> {
    private NodoLista<T> cabeza;
    private int size;
    public String nombre;

    public ListaEnlazada() {
        cabeza = null;
        size = 0;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return size;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        if (size == 0)
            return true;
        else
            return false;
    }

    private void validarIndice(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("El indice " + index + " no valido, el tanano de la lista es " + size);
    }

    @Override
    public T get(int index) {
        // TODO Auto-generated method stub
        validarIndice(index);
        NodoLista<T> aux = cabeza;
        int i = 0;
        while (i < index) {
            aux = aux.getSig();
            i++;
        }
        return aux.getDato();
    }

    @Override
    public int indexOf(T dato) {
        // TODO Auto-generated method stub
        NodoLista<T> aux = cabeza;
        int i = 0;
        while (aux != null && comparar(aux.getDato(), (String)dato) == -1) {
            aux = aux.getSig();
            i++;
        }
        if (aux == null)
            return -1;
        else
            return i;
    }
    private int comparar(T dato1 , String dato2){
        if (dato1.equals(dato2) ){
            return 1;
        }else{
            return -1;
        }
    }
    @Override
    public void add(T dato, int index) {
        // TODO Auto-generated method stub
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("El indice " + index + " no valido, el tanano de la lista es " + size);

        if (index == 0)
            cabeza = new NodoLista<T>(dato, cabeza);
        else {
            NodoLista<T> aux = cabeza;
            int i = 0;
            while (i < index - 1) {
                aux = aux.getSig();
                i++;
            }
            aux.setSig(new NodoLista(dato, aux.getSig()));
        }
        size++;
    }

    @Override
    public T remove (int index) {
        // TODO Auto-generated method stub
        validarIndice(index);
        NodoLista<T> eliminado;
        if (index == 0) {
            eliminado = cabeza;
            cabeza = cabeza.getSig();
        } else {
            NodoLista<T> aux = cabeza;
            int i = 0;
            while (i < index - 1) {
                aux = aux.getSig();
                i++;
            }
            eliminado = aux.getSig();
            aux.setSig(eliminado.getSig());
        }
        size--;
        return eliminado.getDato();
    }


}
