package EstructurasDeDatos.TablasHash.TablaHashCerrada;

public class TablaHashDirCerrado <T>implements TablaHash <T>{
    private int tamano;
    private ListaEnlazada<T> [] tabla;
    private int elementos = 0;

    public TablaHashDirCerrado(){
        this.tamano = 37;
        this.tabla = new ListaEnlazada [tamano];
    }
    private float calcularFactorDeCarga(){
        return elementos/tamano;
    }

    @Override
    public void insertar(String llave, T dato) {
        // TODO Auto-generated method stub
        elementos++;
        int indice = funcionHash(llave);
        if (tabla[indice] != null){
            tabla[indice].add(dato, 0);
        }else{
            tabla[indice] = new ListaEnlazada<>();
            tabla[indice].add(dato, 0);
        }
        rehashing();  
    }
    private void rehashing (){
        if (calcularFactorDeCarga()>0.9){
            ListaEnlazada <T>[] aux = new ListaEnlazada [tamano];
            for ( int i = 0 ; i < tamano ; i ++)
                aux[i] = tabla[i];
            tamano *=2;
            tabla = new ListaEnlazada [tamano];
            elementos = 0;
            for ( int i = 0 ; i < aux.length ; i ++){
                if (aux[i] != null){
                    for (int j = 0 ; j < aux[i].size() ; j ++){
                        insertar((String)(((aux[i].get(j)))), aux[i].get(j));
                    }
                }
                
            }
                
        }
    }
    @Override
    public T eliminar(String llave , T dato) {
        // TODO Auto-generated method stub
        int indice = funcionHash(llave);
        if (tabla[indice]!= null){
            int aux = tabla[indice].indexOf((T)llave);
            if (aux == -1){
                return null;
            }
            T datoEliminado = tabla[indice].remove(aux);
            if (tabla[indice].size() == 0)
                tabla[indice] = null;
            return datoEliminado;
        }
        return null;
    }

    @Override
    public boolean buscar(String llave) {
        // TODO Auto-generated method stub
        int indice = funcionHash(llave);
        if (tabla[indice].indexOf((T)llave) == -1)
            return false;
        return true;
    }
    private int funcionHash(String llave){
        int indice = 0;
        for (int i = 0 ; i < llave.length() ; i ++){
            indice = 37*indice+llave.charAt(i);
        }
        indice %= tamano;
        if (indice < 0){
            indice += tamano;
        }
        return indice;
    }
    public void imprimir (){
        for (int i  = 0 ; i < tabla.length ; i ++){
            if (tabla[i]!= null)
                System.out.println(tabla[i]);
        }
    }
}
