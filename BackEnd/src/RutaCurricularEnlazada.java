import EstructurasDeDatos.Colas.ColaEnlazada;

public class RutaCurricularEnlazada<T> {
    private ColaEnlazada<T> ECola;

    public RutaCurricularEnlazada() {
        ECola = new ColaEnlazada<>();
    }

    public void insertarDato(T dato) {
        ECola.put(dato);
    }

    public T eliminarDato() {
        return ECola.atender();
    }

    public boolean vacio() {
        return ECola.vacio();
    }

    public T obtenerCabeza() {
        return ECola.obtenerCabeza();
    }

    public T obtenerCola() {
        return ECola.obtenerCola();
    }

    public void put(T dato) {
        ECola.put(dato);
    }

    public T atender() {
        return ECola.atender();
    }
}
