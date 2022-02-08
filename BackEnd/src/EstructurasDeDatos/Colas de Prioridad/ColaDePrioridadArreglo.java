package EstructurasDeDatos.ColasDePrioridad;

public class ColaDePrioridadArreglo<T> {
    public int ICola;
    T[] datos;

    public ColaDePrioridadArreglo(int n) {
        if (n > 1)
            datos = (T[]) new Object[n];
        else
            datos = (T[]) new Object[10];
        ICola = -1;
    }

    public ColaDePrioridadArreglo() {
        this(10);
    }

    public boolean vacio() {
        // TODO Auto-generated method stub
        if (0 > ICola)
            return true;
        else
            return false;
    }

    public T obtenerCabeza() {
        // TODO Auto-generated method stub
        if (vacio())
            return null;
        else
            return datos[0];
    }

    public T obtenerCola() {
        // TODO Auto-generated method stub
        if (vacio())
            return null;
        else
            return datos[ICola];
    }

    public void insertar(T dato) {
        // TODO Auto-generated method stub
        if (ICola + 1 >= datos.length) {
            T[] aux = datos;
            datos = (T[]) new Object[2 * datos.length];
            System.arraycopy(aux, 0, datos, 0, ICola);
        }
        if (vacio()) {
            datos[0] = dato;
            ICola++;
        } else {
            datos[ICola + 1] = dato;
            ICola++;
        }

    }

//    public T extraerMax() {
//        // TODO Auto-generated method stub
//        if (vacio())
//            return null;
//        T aux = datos[ICola];
//        datos[0] = null;
//        return aux;
//    }

      public T extraerMax() {
        // TODO Auto-generated method stub
        if (vacio())
            return null;
        T aux = datos[0];
        if (ICola >= 0) System.arraycopy(datos, 1, datos, 0, ICola);

        ICola--;
        return aux;
    }

}
