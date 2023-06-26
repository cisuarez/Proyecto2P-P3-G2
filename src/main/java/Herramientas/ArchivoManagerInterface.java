public interface ArchivoManager {
    ArrayList<String> LeeFichero(String nombrearchivo);
    void EscribirArchivo(String nombreArchivo, String linea);
    ArrayList<String[]> generarArreglo(String nombreArchivo, String separador);
}
