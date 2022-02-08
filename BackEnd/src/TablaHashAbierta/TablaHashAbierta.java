package TablaHashAbierta;

public class TablaHashAbierta<T> implements TablaHash <T>{
    private int tamano;
    private String [] tabla;
    private int elementos;
    private int colision =0;

    public TablaHashAbierta (){
        this.tamano = 37;
        this.tabla = new String [tamano];  
        this.elementos = 0;
    }
    private float calcularFactorDeCarga(){
        return (float)elementos/tamano;
    }
    private void rehashing (){
        String [] aux = new String [tamano];
        for ( int i = 0 ; i < tamano ; i ++)
            aux[i] = tabla[i];
        tamano *=2;
        tabla = new String [tamano];
        elementos = 0;
        for ( int i = 0 ; i < aux.length ; i ++){
            if (aux[i] != null){
                insertar(aux[i],(T)aux[i]);
            }  
        }
    }
    @Override
    public void insertar(String llave, T dato) {
        // TODO Auto-generated method stub
        if (calcularFactorDeCarga()>0.6){
            rehashing();
        }
        elementos++;
        int indice = funcionHash1(llave);
        if (tabla[indice] == null){

            tabla[indice] = (String)dato;
        }else{
            boolean bandera = true;
            while (bandera ){
                indice = funcionHash2(indice);
                if (tabla [indice] == null){   
                    tabla[indice] = (String) dato;
                    bandera = false;
                }
            }
        }
    }

    @Override
    public T eliminar(String llave, Object dato) {
        // TODO Auto-generated method stub

        int indice = funcionHash1(llave);
        
        if (tabla[indice] == null){
            return null;
        }else{
            if (tabla[indice].equals(llave)){
                T aux =(T)tabla[indice];
                tabla[indice] = null; 
                return aux;
            }else{
                while (true ){
                    indice = funcionHash2(indice);
                        
                    if (tabla [indice] == null){
                        return null;
                    }else if (tabla [indice].equals(llave)){ 
                        T aux =(T)tabla[indice];
                        tabla[indice] = null; 
                        return aux;
                    }
                }

            } 
        }
    }

    @Override
    public boolean buscar(String llave) {
        // TODO Auto-generated method stub

        int indice = funcionHash1(llave);
        
        if (tabla[indice] == null){
            return false;
        }else{
            if (tabla[indice].equals(llave)){
                return true;
            }else{
                while (true ){
                    indice = funcionHash2(indice);
                        
                    if (tabla [indice] == null){
                        return false;
                    }else if (tabla [indice].equals(llave)){   
                        return true;
                    }
                }

            } 
        }
    }
    private int funcionHash1(String llave){
        int indice = 0;
        for (int i = 0 ; i < llave.length() ; i ++){
            indice = 37*indice+llave.charAt(i);
        }
        indice %= tamano;
        if (indice < 0){
            indice += tamano;
        }
        if (indice <0)
            return -indice;
        return indice;
    }

    private int funcionHash2(int hash1){
        colision++;
        int indice = (hash1+(colision*colision))%tamano;
        if (indice <0)
            return -indice;
        return indice;
    }
    public void imprimir (){
        for (int i  = 0 ; i < tabla.length ; i ++){
            // if (tabla[i]!= null)
            System.out.println(tabla[i]);
        }
    }
    private void contar(){
        int cuenta = 0;
        for (int i  = 0 ; i < tabla.length ; i ++){
            if (tabla[i]!= null)
                cuenta++;
        }
    }
}
