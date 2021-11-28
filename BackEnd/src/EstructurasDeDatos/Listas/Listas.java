package EstructurasDeDatos.Listas;
public interface Listas <T> {
    boolean vacio();
    int tanano();
    T obtener(int index);
    int buscarIndice(T dato);
    T elinimar(int index);
    void insertar( T dato, int index );
    String toString();
}
