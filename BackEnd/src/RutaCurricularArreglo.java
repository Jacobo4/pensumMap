import EstructurasDeDatos.Colas.ColaArreglo;

public class RutaCurricularArreglo<T> {
    private ColaArreglo<T> ACola;

    public RutaCurricularArreglo() {
        ACola = new ColaArreglo<>();
    }

    public void insertarDato(T dato) {
        ACola.put(dato);
    }

    public T eliminarDato() {
        return ACola.atender();
    }

    public boolean vacio() {
        return ACola.vacio();
    }

    public T obtenerCabeza() {
        return ACola.obtenerCabeza();
    }

    public T obtenerCola() {
        return ACola.obtenerCola();
    }

    public void put(T dato) {
        ACola.put(dato);
    }

    public T atender() {
        return ACola.atender();
    }

}
