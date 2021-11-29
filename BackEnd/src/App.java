import EstructurasDeDatos.Colas.ColaArreglo;
import EstructurasDeDatos.Colas.ColaEnlazada;
import EstructurasDeDatos.Listas.ListaArreglo;
import EstructurasDeDatos.Listas.ListaEnlazada;
import EstructurasDeDatos.Pilas.PilaArreglo;
import EstructurasDeDatos.Pilas.PilaEnlazada;

public class App {
    public static void main(String[] args) throws Exception {

        //Crea dos rutas curriculares de tipo cola implementadas con arreglo y enlazada
        RutaCurricularArreglo<Materia> ruta1 = new RutaCurricularArreglo<>();
        RutaCurricularEnlazada<Materia> ruta2 = new RutaCurricularEnlazada<>();

        guardarMateriasRuta(ruta1, ruta2);

        //Crea dos listas implementadas con arreglo y enlazada
        ListaArreglo<RutaCurricularArreglo> listaA = new ListaArreglo<>();
        ListaEnlazada<RutaCurricularArreglo> listaE = new ListaEnlazada<>();

        guardarRutas(listaA, listaE);

        //Crea dos pilas implementadas con arreglo y enlazada
        PilaArreglo<Materia> pilaA = new PilaArreglo<Materia>();
        PilaEnlazada<Materia> pilaE = new PilaEnlazada<Materia>();

        insertarDatosBackUp(pilaA, pilaE);
    }

    //Guarda las materias en una ruta curricular. La ruta curricular es de tipo cola
    public static void guardarMateriasRuta(RutaCurricularArreglo<Materia> ruta1,RutaCurricularEnlazada<Materia> ruta2) {
        for (int i = 10000; i < 10000000; i = i *5) {
            insertarColaArreglo(ruta1, i);
        }
        System.out.println();
        for (int i = 10000; i < 10000000; i = i *5) {
            insertarColaEnlazada(ruta2, i);
        }
        System.out.println();
    }
    //Ingresa las materias en una Cola implementada con arreglos
    private static void insertarColaArreglo(RutaCurricularArreglo<Materia> colaA, int i) {
        long inicio = System.currentTimeMillis();
        for (int j = 0; j < i; j++) {
            colaA.put(new Materia(5, "Materia" + String.valueOf(i + 1), 1, 'a'));
        }
        long fin = System.currentTimeMillis();
        double tiempo = (double) (fin - inicio) / 1000;
        System.out.println("Para " + i + " materias la cola implementada con arreglos gasta: " + tiempo);
        //System.out.println(i+ " " + tiempo);
        colaA = new RutaCurricularArreglo<>();

    }
    //Ingresa las materias en una Cola enlazada
    private static void insertarColaEnlazada(RutaCurricularEnlazada<Materia> colaE, int i) {
        long inicio = System.currentTimeMillis();
        for (int j = 0; j < i; j++) {
            colaE.put(new Materia(5, "Materia" + String.valueOf(i + 1), 1, 'a'));
        }
        long fin = System.currentTimeMillis();
        double tiempo = (double) (fin - inicio) / 1000;
        System.out.println("Para " + i + " materias la cola enlazada gasta: " + tiempo);
        //System.out.println(i+ " " + tiempo);
        colaE = new RutaCurricularEnlazada<>();

    }

    //Guarda rutas curriculares en una lista
    public static void guardarRutas(ListaArreglo<RutaCurricularArreglo> listaA,ListaEnlazada<RutaCurricularArreglo> listaE) {
        int index = 0;
        for (int i = 10000; i < 100000000; i = i *10) {
            insertarListaArreglo(listaA, i, index);
        }
        System.out.println();
        for (int i = 10000; i < 100000000; i = i * 5) {
            insertarListaEnlazada(listaE, i, index);
        }
    }
    //Ingresa las rutas curriculares en una Lista implementada con arreglos
    public static void insertarListaArreglo(ListaArreglo<RutaCurricularArreglo> listaA, int i, int index) {
        long inicio = System.currentTimeMillis();
        for (int j = 0; j < i; j++) {
            listaA.insertar(new RutaCurricularArreglo(), index);
        }
        long fin = System.currentTimeMillis();
        double tiempo = (double) (fin - inicio) / 1000;
        System.out.println("Para " + i + " datos la lista implementada con arreglos gasta: " + tiempo);
        //System.out.println(i+ " " + tiempo);
        listaA = new ListaArreglo<>();

    }
    //Ingresa las rutas curriculares en una Lista enlazada
    public static void insertarListaEnlazada(ListaEnlazada<RutaCurricularArreglo> listaE, int i, int index) {
        long inicio = System.currentTimeMillis();
        for (int j = 0; j < i; j++) {
            listaE.insertar(new RutaCurricularArreglo(), index);
        }
        long fin = System.currentTimeMillis();
        double tiempo = (double) (fin - inicio) / 1000;
        System.out.println("Para " + i + " datos la lista enlazada gasta: " + tiempo);
        //System.out.println(i+ " " + tiempo);
        listaE = new ListaEnlazada<>();
    }

    //Hace la accion de deshacer la operacion de ingresar una materia en una ruta curricular (ctrl z)
    public static void insertarDatosBackUp(PilaArreglo<Materia> pilaA, PilaEnlazada<Materia> pilaE) {
        for (int i = 10000; i < 10000000; i = i * 5) {
            insertarPilaArreglo(pilaA, i);
        }
        System.out.println();
        for (int i = 10000; i < 10000000; i = i * 5) {
            insertarPilaEnlazada(pilaE, i);
        }
    }
    //Ingresa las materias en una Pila implementada con arreglos
    private static void insertarPilaArreglo(PilaArreglo<Materia> pilaA, int i) {
        long inicio = System.currentTimeMillis();
        for (int j = 0; j < i; j++) {
            pilaA.push(new Materia(5, "Materia" + String.valueOf(i + 1), 1, 'a'));
        }
        long fin = System.currentTimeMillis();
        double tiempo = (double) (fin - inicio) / 1000;
        System.out.println("Para " + i + " datos la pila implementada con arreglos gasta: " + tiempo);
        //System.out.println(i+ " " + tiempo);
        pilaA = new PilaArreglo<>();
    }
    //Ingresa las materias en una Pila enlazada
    private static void insertarPilaEnlazada(PilaEnlazada<Materia> pilaE, int i) {
        long inicio = System.currentTimeMillis();
        for (int j = 0; j < i; j++) {
            pilaE.push(new Materia(5, "Materia" + String.valueOf(i + 1), 1, 'a'));
        }
        long fin = System.currentTimeMillis();
        double tiempo = (double) (fin - inicio) / 1000;
        System.out.println("Para " + i + " datos la pila enlazada gasta: " + tiempo);
        //System.out.println(i+ " " + tiempo);
        pilaE = new PilaEnlazada<>();
    }
}
