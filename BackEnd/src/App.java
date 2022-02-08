import EstructurasDeDatos.TablasHash.TablaHashAbierta.TablaHashAbierta;
import EstructurasDeDatos.TablasHash.TablaHashCerrada.TablaHashDirCerrado;

public class App {
    public static void main(String[] args) throws Exception {
        TablaHashDirCerrado <String>tabla = new TablaHashDirCerrado<>();
        TablaHashAbierta <String>tabla1 = new TablaHashAbierta<>();
        
        for (int k = 10 ; k <= 10000000 ; k= k*10){
            String materias [] = new String[k];
            materias = crearMaterias(k);
            System.out.println(k);
            long inicio = System.currentTimeMillis();
            for (int i  = 0 ;  i < k ; i ++){
                tabla.insertar(materias[i], materias[i]);
            }
            long fin = System.currentTimeMillis();
            double tiempo1 = (double) (fin - inicio) / 1000;


            inicio = System.currentTimeMillis();
            for (int i  = 0 ;  i < k ; i ++){
                tabla1.insertar(materias[i], materias[i]);
            }
            fin = System.currentTimeMillis();
            double tiempo2 = (double) (fin - inicio) / 1000;
            
            System.out.println(tiempo1+" "+tiempo2);

            inicio = System.currentTimeMillis();
            for (int i  = 0 ;  i < k ; i ++){
                tabla.buscar(materias[i]);
            }
            fin = System.currentTimeMillis();
            tiempo1 = (double) (fin - inicio) / 1000;

            inicio = System.currentTimeMillis();
            for (int i  = 0 ;  i < k ; i ++){
                tabla1.buscar(materias[i]);
            }

            fin = System.currentTimeMillis();
            tiempo2 = (double) (fin - inicio) / 1000;

            System.out.println(tiempo1+" "+tiempo2);

            inicio = System.currentTimeMillis();
            for (int i  = 0 ;  i < k ; i ++){
                tabla.eliminar(materias[i], materias[i]);
            }
            fin = System.currentTimeMillis();
            tiempo1 = (double) (fin - inicio) / 1000;

            inicio = System.currentTimeMillis();
            for (int i  = 0 ;  i < k ; i ++){
                tabla1.eliminar(materias[i], materias[i]);
            }
            fin = System.currentTimeMillis();
            tiempo2 = (double) (fin - inicio) / 1000;

            System.out.println(tiempo1+" "+tiempo2);
        }
    }
    public static String[] crearMaterias(int tamano){
        String  materias [] = new String [tamano];
        for (int i  = 0 ;  i < tamano ; i ++){
            String m ="ayer"+i;
            materias[i] = m;
        }
        return materias;

    }
}
