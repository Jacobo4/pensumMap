package EstructurasDeDatos.TablasHash.TablaHashCerrada;

public interface Listas<T> {
    int size();

    boolean isEmpty();

    void add(T dato,int index);

    T remove(int index);

    int indexOf(T dato);

    T get(int index);
}
