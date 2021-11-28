package EstructurasDeDatos.Listas;
public class RCurricularLEnlazada <T> implements Listas <T>{
    private Nodo <T> cabeza;
    private int size;

    public RCurricularLEnlazada(){
        cabeza = null;
        size = 0;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

    @Override
    public int tanano() {
        // TODO Auto-generated method stub
        return size;
    }

    @Override
    public boolean vacio() {
        // TODO Auto-generated method stub
        if (size == 0)
        return true;
        else 
        return false;
    }
    private void validarIndice(int index){
        if (index < 0  || index >= size)
        throw new IndexOutOfBoundsException("El indice "+index+" no valido, el tanano de la lista es "+size);
    }

    @Override
    public T obtener(int index) {
        // TODO Auto-generated method stub
        validarIndice(index);
        Nodo <T> aux = cabeza;
        int i = 0;
        while (i < index){
            aux = aux.getSig();
            i++;
            
        }
        return aux.getDato();
    }

    @Override
    public int buscarIndice(T dato) {
        // TODO Auto-generated method stub
        Nodo <T> aux = cabeza;
        int i = 0 ;
        while(aux != null && !aux.getDato().equals(dato)){
            aux = aux.getSig();
            i++;
        }
        if (aux == null)
            return -1;
        else
            return i;
    }

    @Override
    public void insertar(T dato, int index) {
        // TODO Auto-generated method stub
        if (index < 0 ||  index > size)
            throw new IndexOutOfBoundsException("El indice "+index+" no valido, el tanano de la lista es "+size);
        
        if (index == 0 )
            cabeza = new Nodo <T>(dato,cabeza);
        else{
            Nodo <T> aux = cabeza;
            int i = 0;
            while( i < index-1){
                System.out.println(aux);
                aux = aux.getSig();
                i++;
            }
            aux.setSig(new Nodo(dato, aux.getSig()));
        }
        size++;
    }
    
    @Override
    public T elinimar(int index) {
        // TODO Auto-generated method stub
        validarIndice(index);
        Nodo <T> eliminado;
        if (index == 0){
            eliminado = cabeza;
            cabeza = cabeza.getSig();
        }else{
            Nodo<T> aux = cabeza;
            int i = 0 ;
            while (i < index-1){
                aux = aux.getSig();
                i++;
            }
            eliminado = aux.getSig();
            aux.setSig(eliminado.getSig());
        }
        size--;
        return eliminado.getDato();
    }

}
