import EstructurasDeDatos.Colas.ColaArreglo;
import EstructurasDeDatos.Colas.ColaEnlazada;
import EstructurasDeDatos.Listas.ListaArreglo;
import EstructurasDeDatos.Listas.ListaEnlazada;
import EstructurasDeDatos.Pilas.PilaArreglo;
import EstructurasDeDatos.Pilas.PilaEnlazada;

public class App {
    public static void main(String[] args) throws Exception {

        RutaCurricularArreglo<Materia> ruta1 = new RutaCurricularArreglo<>();
        RutaCurricularEnlazada<Materia> ruta2 = new RutaCurricularEnlazada<>();

        // guardarMateriasRuta(ruta1, ruta2);

        ListaArreglo<RutaCurricularArreglo> listaA = new ListaArreglo<>();
        ListaEnlazada<RutaCurricularArreglo> listaE = new ListaEnlazada<>();

        // guardarRutas(listaA, listaE);

        PilaArreglo<Materia> pilaA = new PilaArreglo<Materia>();
        PilaEnlazada<Materia> pilaE = new PilaEnlazada<Materia>();

        insertarDatosBackUp(pilaA, pilaE);
    }

    public static void guardarMateriasRuta(RutaCurricularArreglo<Materia> ruta1,
            RutaCurricularEnlazada<Materia> ruta2) {
        for (int i = 10000; i < 10000000; i = i * 10) {
            insertarColaArreglo(ruta1, i);
        }
        System.out.println();
        for (int i = 10000; i <= 10000000; i = i * 10) {
            insertarColaEnlazada(ruta2, i);
        }
        System.out.println();
    }

    public static void insertarColaArreglo(RutaCurricularArreglo<Materia> colaA, int i) {
        long inicio = System.currentTimeMillis();
        for (int j = 0; j < i; j++) {
            colaA.put(new Materia(5, "Materia" + String.valueOf(i + 1), 1, 'a'));
        }
        long fin = System.currentTimeMillis();
        double tiempo = (double) (fin - inicio) / 1000;
        System.out.println("Para " + i + " materias la cola implementada con arreglos gasta: " + tiempo);
        colaA = new RutaCurricularArreglo<>();

    }

    public static void insertarColaEnlazada(RutaCurricularEnlazada<Materia> colaE, int i) {
        long inicio = System.currentTimeMillis();
        for (int j = 0; j < i; j++) {
            colaE.put(new Materia(5, "Materia" + String.valueOf(i + 1), 1, 'a'));
        }
        long fin = System.currentTimeMillis();
        double tiempo = (double) (fin - inicio) / 1000;
        System.out.println("Para " + i + " materias la cola enlazada gasta: " + tiempo);
        colaE = new RutaCurricularEnlazada<>();

    }

    public static void guardarRutas(ListaArreglo<RutaCurricularArreglo> listaA,
            ListaEnlazada<RutaCurricularArreglo> listaE) {
        int index = 0;
        for (int i = 10000; i < 100000000; i = i * 10) {
            insertarListaArreglo(listaA, i, index);
        }
        for (int i = 10000; i < 100000000; i = i * 10) {
            insertarListaEnlazada(listaE, i, index);
        }
    }

    public static void insertarListaArreglo(ListaArreglo<RutaCurricularArreglo> listaA, int i, int index) {
        long inicio = System.currentTimeMillis();
        for (int j = 0; j < i; j++) {
            listaA.insertar(new RutaCurricularArreglo(), index);
        }
        long fin = System.currentTimeMillis();
        double tiempo = (double) (fin - inicio) / 1000;
        System.out.println("Para " + i + " datos la lista implementada con arreglos gasta: " + tiempo);
        listaA = new ListaArreglo<>();

    }

    public static void insertarListaEnlazada(ListaEnlazada<RutaCurricularArreglo> listaE, int i, int index) {
        long inicio = System.currentTimeMillis();
        for (int j = 0; j < i; j++) {
            listaE.insertar(new RutaCurricularArreglo(), index);
        }
        long fin = System.currentTimeMillis();
        double tiempo = (double) (fin - inicio) / 1000;
        System.out.println("Para " + i + " datos la lista enlazada gasta: " + tiempo);
        listaE = new ListaEnlazada<>();
    }

    public static void insertarDatosBackUp(PilaArreglo<Materia> pilaA, PilaEnlazada<Materia> pilaE) {
        for (int i = 10000; i < 100000000; i = i * 10) {
            insertarPilaArreglo(pilaA, i);
        }
        for (int i = 10000; i < 100000000; i = i * 10) {
            insertarPilaEnlazada(pilaE, i);
        }
    }

    private static void insertarPilaArreglo(PilaArreglo<Materia> pilaA, int i) {
        long inicio = System.currentTimeMillis();
        for (int j = 0; j < i; j++) {
            pilaA.push(new Materia(5, "Materia" + String.valueOf(i + 1), 1, 'a'));
        }
        long fin = System.currentTimeMillis();
        double tiempo = (double) (fin - inicio) / 1000;
        System.out.println("Para " + i + " datos la pila implementada con arreglos gasta: " + tiempo);
        pilaA = new PilaArreglo<>();
    }

    private static void insertarPilaEnlazada(PilaEnlazada<Materia> pilaE, int i) {
        long inicio = System.currentTimeMillis();
        for (int j = 0; j < i; j++) {
            pilaE.push(new Materia(5, "Materia" + String.valueOf(i + 1), 1, 'a'));
        }
        long fin = System.currentTimeMillis();
        double tiempo = (double) (fin - inicio) / 1000;
        System.out.println("Para " + i + " datos la pila enlazada gasta: " + tiempo);
        pilaE = new PilaEnlazada<>();
    }

}
