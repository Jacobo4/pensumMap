package EstructurasDeDatos.Colas;

public class ColaArreglo <T> implements Colas<T> {
    int ICabeza;
    int ICola;
    T[] datos;

    public ColaArreglo(int n){
        if (n > 1)
            datos = (T [])new Object [n];
        else
            datos = (T [])new Object [10];
        ICabeza = 0;
        ICola = -1;
    }

    public ColaArreglo(){
        this(10);
    }

    @Override
    public boolean vacio() {
        // TODO Auto-generated method stub
        if (ICabeza > ICola)
        return true;
        else 
        return false;
    }

    @Override
    public T obtenerCabeza() {
        // TODO Auto-generated method stub
        if (vacio())
            return null;
        else
            return datos[ICabeza];
    }

    @Override
    public T obtenerCola() {
        // TODO Auto-generated method stub
        if (vacio())
            return null;
        else
            return datos[ICola];
    }

    @Override
    public void put(T dato) {
        // TODO Auto-generated method stub
        if (ICola+1 >= datos.length){
            T [] aux = datos;
            datos = (T[]) new Object[2*datos.length];
            System.arraycopy(aux, 0, datos, 0, ICola);
        }
        if (vacio()){
            datos[ICabeza] = dato;
            ICola++;
        }else{
            datos[ICola+1] = dato;
            ICola++;
        }
        
    }

    @Override
    public T atender() {
        // TODO Auto-generated method stub
        if (vacio())
            return null;
        T aux = datos[ICabeza];
        for (int i = 0; i < ICola;i++)
            datos[i] = datos[i+1];
        
        ICola--;
        return aux;
    }
    
}
