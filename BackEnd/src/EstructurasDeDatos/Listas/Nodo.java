package EstructurasDeDatos.Listas;
public class Nodo <T>{
    private T dato;
    private Nodo <T> sig;

    Nodo(T dato , Nodo <T> sig){
        this.setDato(dato);
        this.setSig(sig);
    }
    Nodo(T dato){
        this.setDato(dato);
        setSig(null);
    }


    public Nodo <T> getSig() {
        return sig;
    }

    public void setSig(Nodo <T> sig) {
        this.sig = sig;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }
    
}
