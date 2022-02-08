package EstructurasDeDatos.ColasDePrioridad;

public class ColaDePrioridadMonticulos<T extends Comparable<T>> {

    private int tamano;
    private T[] array;

    public ColaDePrioridadMonticulos(int n) {
        this.tamano = -1;
        this.array = (T[]) new Comparable[n];
    }

    public ColaDePrioridadMonticulos() {
        this.tamano = -1;
        this.array = (T[]) new Comparable[5];
    }

    private T get(int index) {
        return array[index];
    }

    public int tamano() {
        return tamano;
    }

    public boolean vacio() {
        return this.tamano == -1;
    }


    // Function to insert a
// new element in
// the Binary Heap
    public void insertar(T element) {

        if (tamano + 1 >= array.length) {
            T[] aux = array;
            array = (T[]) new Comparable[2 * array.length];
            System.arraycopy(aux, 0, array, 0, tamano + 1);
        }

        tamano++;
        array[tamano] = element;
        // Shift Up to maintain
        // heap property
        shiftUp(tamano);
    }

    // Function to extract
// the element with
// maximum priority
    public T extraerMax() {
        T result = array[0];

        // Replace the value
        // at the root with
        // the last leaf
        array[0] = array[tamano];
//        array[size] = null;
        tamano = tamano - 1;

        // Shift down the replaced
        // element to maintain the
        // heap property
        shiftDown(0);
        return result;
    }

    // Function to change the priority
// of an element
    public void cambiarPrioridad(int index, T element) {
        T oldp = array[index];
        array[index] = element;

        if (element.compareTo(oldp) > 0) {
            shiftUp(index);
        } else {
            shiftDown(index);
        }
    }

    // Function to get value of
// the current maximum element
    public T obtenerCabeza() {
        return array[0];
    }

    // Function to get value of
// the current maximum element
    public T obtenerCola() {
        return array[array.length -1];
    }

    public void imprimir() {
        int i = 0;
        while (i < array.length){
            if(array[i] == null) break;
            System.out.println(array[i]);
            i++;
        }

    }

    // Function to return the index of the
// parent node of a given node
    private int padre(int index) {
        return (index - 1) / 2;
    }

    // Function to return the index of the
// left child of the given node
    private int hijoIzquierdo(int index) {
        return ((2 * index) + 1);
    }

    // Function to return the index of the
// right child of the given node
    private int hijoDerecho(int index) {
        return ((2 * index) + 2);
    }

    // Function to shift up the
// node in order to maintain
// the heap property
    private void shiftUp(int index) {
        T item1 = array[padre(index)];
        T item2 = array[index];
        while (index > 0 &&
                array[padre(index)].compareTo(array[index]) < 0) {
            // Swap parent and current node
            intercambiar(padre(index), index);

            // Update i to parent of i
            index = padre(index);
        }
    }

    // Function to shift down the node in
// order to maintain the heap property
    private void shiftDown(int index) {
        int maxIndex = index;

        // Left Child
        int l = hijoIzquierdo(index);

        if (l <= tamano &&
                array[l].compareTo(array[maxIndex]) > 0) {
            maxIndex = l;
        }

        // Right Child
        int r = hijoDerecho(index);

        if (r <= tamano &&
                array[r].compareTo(array[maxIndex]) > 0) {
            maxIndex = r;
        }

        // If i not same as maxIndex
        if (index != maxIndex) {
            intercambiar(index, maxIndex);
            shiftDown(maxIndex);
        }
    }

    private void intercambiar(int indexToSwap, int index) {
        T temp = array[indexToSwap];
        array[indexToSwap] = array[index];
        array[index] = temp;
    }

}