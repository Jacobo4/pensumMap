import EstructurasDeDatos.Colas.ColaArreglo;
import EstructurasDeDatos.Colas.ColaEnlazada;
import EstructurasDeDatos.Listas.RCurricularLArreglo;
import EstructurasDeDatos.Listas.RCurricularLEnlazada;
import EstructurasDeDatos.Pilas.PilaArreglo;
import EstructurasDeDatos.Pilas.PilaEnlazada;

public class App {
    public static void main(String[] args) throws Exception {
        RCurricularLArreglo <Materia> listaA = new  RCurricularLArreglo <Materia> ();
        RCurricularLEnlazada <Materia> listaE = new RCurricularLEnlazada<Materia>();

        ColaArreglo <Materia> colaA = new ColaArreglo <Materia>();
        ColaEnlazada <Materia> colaE = new ColaEnlazada <Materia>();

        PilaArreglo <Materia> pilaA = new PilaArreglo <Materia>();
        PilaEnlazada <Materia> pilaE = new PilaEnlazada <Materia>();

        //insertarDatosColas(colaA, colaE);
        //insertarDatosListas(listaA, listaE);
        insertarDatosPilas(pilaA, pilaE);
    }

    public static void insertarDatosPilas(PilaArreglo <Materia> pilaA , PilaEnlazada <Materia> pilaE ){
        for (int i = 10000 ; i < 100000000 ; i= i*10){
            insertarPilaArreglo(pilaA, i);
            insertarPilaEnlazada(pilaE, i);
        }
    }

    private static void insertarPilaArreglo(PilaArreglo <Materia> pilaA,int i){
        long inicio  = System.currentTimeMillis();
        for (int j = 0 ; j < i ; j ++){
            pilaA.push(new Materia(5, "Materia"+String.valueOf(i+1),1 , 'a'));
        }
        long fin  = System.currentTimeMillis();
        double tiempo = (double) (fin-inicio)/1000;
        System.out.println("Para "+i+" datos la pila implementada con arreglos gasta: "+tiempo);
    }
    private static void insertarPilaEnlazada(PilaEnlazada <Materia> pilaE , int i){
        long inicio  = System.currentTimeMillis();
        for (int j = 0 ; j < i ; j ++){
            pilaE.push(new Materia(5, "Materia"+String.valueOf(i+1),1 , 'a'));
        }
        long fin  = System.currentTimeMillis();
        double tiempo = (double) (fin-inicio)/1000;
        System.out.println("Para "+i+" datos la pila enlazada gasta: "+tiempo);
        
    }

    public static void insertarDatosColas(ColaArreglo <Materia> colaA , ColaEnlazada <Materia> colaE ){
        for (int i = 10000 ; i < 10000000 ; i= i*10){
            insertarColaArreglo(colaA, i);
            insertarColaEnlazada(colaE, i);
        }
    }

    public static void insertarColaArreglo(ColaArreglo <Materia> colaA , int i){
        long inicio  = System.currentTimeMillis();
        for (int j = 0 ; j < i ; j ++){
            colaA.put(new Materia(5, "Materia"+String.valueOf(i+1),1 , 'a'));
        }
        long fin  = System.currentTimeMillis();
        double tiempo = (double) (fin-inicio)/1000;
        System.out.println("Para "+i+" datos la cola implementada con arreglos gasta: "+tiempo);

    }

    public static void insertarColaEnlazada(ColaEnlazada <Materia> colaE, int i){
        long inicio  = System.currentTimeMillis();
        for (int j = 0 ; j < i ; j ++){
            colaE.put(new Materia(5, "Materia"+String.valueOf(i+1),1 , 'a'));
        }
        long fin  = System.currentTimeMillis();
        double tiempo = (double) (fin-inicio)/1000;
        System.out.println("Para "+i+" datos la cola enlazada gasta: "+tiempo);

    }

    public static void insertarDatosListas(RCurricularLArreglo<Materia> listaA , RCurricularLEnlazada<Materia> listaE){
        int index = 0;
        for (int i = 10000 ; i < 100000000 ; i= i*10){
            insertarListaArreglo(listaA, i, index);
            insertarListaEnlazada(listaE, i, index);
        }
    }

    public static void insertarListaArreglo(RCurricularLArreglo<Materia> listaA , int i ,int index){
        long inicio  = System.currentTimeMillis();
        for (int j = 0 ; j < i ; j ++){
            listaA.insertar(new Materia(5, "Materia"+String.valueOf(i+1),1 , 'a'),index);
        }
        long fin  = System.currentTimeMillis();
        double tiempo = (double) (fin-inicio)/1000;
        System.out.println("Para "+i+" datos la lista implementada con arreglos gasta: "+tiempo);

    }
    public static void insertarListaEnlazada(RCurricularLEnlazada<Materia> listaE, int i , int index){
        long inicio  = System.currentTimeMillis();
        for (int j = 0 ; j < i ; j ++){
            listaE.insertar(new Materia(5, "Materia"+String.valueOf(i+1),1 , 'a'),index);
        }
        long fin  = System.currentTimeMillis();
        double tiempo = (double) (fin-inicio)/1000;
        System.out.println("Para "+i+" datos la lista enlazada gasta: "+tiempo);
    }


    public static Materia [] crearArreglo(int n){
        Materia [] materias = new  Materia [n];
        //char [] componentes = {'a','b','c','d'};
        
        for (int i = 0 ; i < n ; i++){
         //   int creditos = (int) (Math.random()*5+1);
          //  int index = (int) (Math.random()*4);
         //   long codigo = (long) (Math.random()*10000000);
            materias[i] = new Materia(5, "Materia"+String.valueOf(i+1),1 , 'a');
        }
        
        return materias;
    }
}
