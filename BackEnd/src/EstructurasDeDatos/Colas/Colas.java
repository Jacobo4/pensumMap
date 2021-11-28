package EstructurasDeDatos.Colas;

public interface Colas <T>{
    boolean vacio();
    T obtenerCabeza();
    T obtenerCola();
    void put( T dato);
    T atender(); 
}
