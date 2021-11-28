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

        /*

        Materia a = new Materia(5, "Materia "+String.valueOf(1),1 , 'a');
        Materia b = new Materia(5, "Materia "+String.valueOf(2),1 , 'b');
        Materia c = new Materia(2, "Materia "+String.valueOf(3), 1, 'a');
        Materia d = new Materia(5, "Materia "+String.valueOf(4),1 , 'a');
        Materia e = new Materia(5, "Materia "+String.valueOf(5),1 , 'a');

        System.out.println(pilaE.vacio());
        System.out.println(pilaE.peek());
        pilaE.push(a);
        pilaE.push(b);
        pilaE.push(c);
        System.out.println(pilaE.pop().getNombre());
        pilaE.push(d);
        pilaE.push(e);
        System.out.println("El primer elemento de la pila es: "+pilaE.peek().getNombre());
        for (int i = 0 ; i < 5; i ++){
            if (pilaE.vacio())
                System.out.println("La pila esta vacia");
            else
                System.out.println(pilaE.pop().getNombre());
        }

        */

        /*
        System.out.println("La cola esta vacia: "+colaE.vacio());
        colaE.put(a);
        colaE.put(b);
        colaE.put(new Materia(2, "Materia "+String.valueOf(3), 1, 'a'));
        colaE.put(new Materia(5, "Materia "+String.valueOf(4),1 , 'a'));
        colaE.put(new Materia(5, "Materia "+String.valueOf(5),1 , 'a'));
        System.out.println("La cola esta vacia: "+colaE.vacio());
        System.out.println("La cabeza es: "+colaE.obtenerCabeza().getNombre());
        System.out.println("La cola es: "+colaE.obtenerCola().getNombre());

        for (int i = 0 ; i < 6 ; i ++){
            if (colaE.vacio()){
                System.out.println("La cola esta vacia");
            }else{
                System.out.println("La cabeza es: "+colaE.obtenerCabeza().getNombre());
                System.out.println("La cola es: "+colaE.obtenerCola().getNombre());
                System.out.println("Elemento eliminado: "+colaE.atender().getNombre());
            }
        }
            
        //insertarDatos(listaA, listaE);
        */
        /*

        

        System.out.println("La lista esta vacia: "+listaE.vacio());

        listaE.insertar(a,0);

        System.out.println("El tamano de la lista es: "+listaE.tanano());

        listaE.insertar(new Materia(5, "Materia"+String.valueOf(2),1 , 'a'),1);
        listaE.insertar(new Materia(5, "Materia"+String.valueOf(3),1 , 'a'),2);
        
        
        System.out.println("La lista esta vacia: "+listaE.vacio());
        System.out.println("El tamano de la lista es: "+listaE.tanano());
        
        System.out.println("La materia del indice 2 "+listaE.obtener(0).getNombre());
        System.out.println(listaE.buscarIndice(a));
        
        System.out.println("Se elimino la materia: "+listaE.elinimar(2).getNombre());

        
        for (int i = 0 ; i < listaE.tanano() ; i++)
            System.out.println(listaE.obtener(i).getNombre());
            
        //listaE.insertar(new Materia(5, "Materia"+String.valueOf(21),1 , 'a'),2);
        
        */
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
