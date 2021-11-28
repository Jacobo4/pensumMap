package EstructurasDeDatos.Listas;
public class RCurricularLArreglo<T> implements Listas <T> {
    private T [] datos;
    private int size;

    public RCurricularLArreglo(int n){
        if (n > 1)
            datos = (T [])new Object [n];
        else
            datos = (T [])new Object [10];
        this.size = 0;
    }
    public RCurricularLArreglo(){
        this(10);
    }

    @Override
    public String toString() {
        return "ListaAreglo []";
    }
    @Override
    public boolean vacio() {
        // TODO Auto-generated method stub
        if (size == 0)
        return true;
        else 
        return false;
    }
    @Override
    public int tanano() {
        // TODO Auto-generated method stub
        return size;
    }
    private void validarIndice(int index){
        if (index < 0  || index >= size)
        throw new IndexOutOfBoundsException("El indice "+index+" no valido, el tanano de la lista es "+size);
    }
    @Override
    public T obtener(int index) {
        // TODO Auto-generated method stub
        validarIndice(index);
        return datos[index];
    }
    @Override
    public int buscarIndice(T dato) {
        // TODO Auto-generated method stub
        for (int i = 0 ; i < size ; i ++){
            if (obtener(i).equals(dato)){
                return i;
            }
        }
        return -1;
    }
    @Override
    public T elinimar(int index) {

        // TODO Auto-generated method stub
        validarIndice(index);
        T datoEliminado = obtener(index);
        for (int i = index+1 ; i < size; i++ )
            datos[i-1] = obtener(i);
        
        datos[size-1] = null;
        size--;
        return datoEliminado;
    }
    @Override
    public void insertar(T dato, int index) {
        // TODO Auto-generated method stub
        if (index <0 || index > size)
            throw new IndexOutOfBoundsException("El indice "+index+" no valido, el tanano de la lista es "+size);

        if (size == datos.length){
            T [] aux = datos;
            datos = (T[]) new Object[2*size];
            System.arraycopy(aux, 0, datos, 0, size);
        }

        for (int i = size-1 ; i >=index ; i-- )
            datos[i+1] = obtener(i);
        
        datos[index] = dato;
        size++;
        
    }
}
