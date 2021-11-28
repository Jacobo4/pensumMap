package EstructurasDeDatos.Pilas;

public interface Pilas <T> {
    boolean vacio();
    T peek();
    void push( T dato);
    T pop(); 
    
}
