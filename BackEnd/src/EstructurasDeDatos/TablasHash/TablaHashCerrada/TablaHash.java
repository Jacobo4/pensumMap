package EstructurasDeDatos.TablasHash.TablaHashCerrada;

import javax.swing.text.StyledEditorKit.BoldAction;

public interface TablaHash <T> {
    void insertar(String llave,T dato);
    T eliminar(String llave, T dato);
    boolean buscar(String llave);
}
