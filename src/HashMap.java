public class HashMap {
    // Arreglo de Nodos
    private Nodo[] arreglo;
    
    // Usamos el número 17 porque es un numero primo, lo que ayuda a distribuir mejor los datos en el arreglo,
    // reduciendo las probabilidades de colisión entre constelaciones.
    private int tamaño = 17;

    // Constructor: Aquí construimos el arreglo vacío cuando arranca el programa
    public HashMap() {
        arreglo = new Nodo[tamaño];
    }

    // Función Hash (Método de la Potencia)
    // Transforma el nombre de la constelación (String) en un número de casilla (0 al 16)
    public int generarHash(String llave) {
        int hash = 0;
        
        // Recorremos la palabra letra por letra 
        for (int i = 0; i < llave.length(); i++) {
            char letra = llave.charAt(i);
            
            // Multiplicamos el acumulado por 31 (el número primo estándar en Java).
            // Al procesarlo en orden, esto evita la colision de palabras que son anagramas.
            hash = (hash * 31) + letra; 
        }
        
        // Math.abs() evita un error del sistema si el Hash se vuelve un número negativo grande
        // El módulo (% tamaño) recorta el Hash gigante para que el residuo
        // encaje exactamente en una de nuestras 17 casillas (del 0 al 16).
        return Math.abs(hash) % tamaño;
    }

    // =====================================================================
//Continuacion
}