package EstructurasDeDatos.TablasHash.TablaHashCerrada;

public class NodoLista<T> {
    private T dato;
    private NodoLista<T> sig;

    NodoLista(T dato, NodoLista<T> sig) {
        this.setDato(dato);
        this.setSig(sig);
    }

    NodoLista(T dato) {
        this.setDato(dato);
        setSig(null);
    }

    public NodoLista<T> getSig() {
        return sig;
    }

    public void setSig(NodoLista<T> sig) {
        this.sig = sig;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

}