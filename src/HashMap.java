public class HashMap {
    //Arreglo de nodos para manejar colisiones
    private Nodo[] arreglo;
    // Tamaño del arreglo (número primo para mejor distribución)
    private int tamaño = 17;
    // Constructor del arreglo al momento de iniciar el programa
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
            // Multiplicamos el acumulado por 31 (el número primo estándar en Java), esto evita la colision de palabras que son anagramas.
            hash = (hash * 31) + letra;
        }

        // Evita un error del sistema si el Hash se vuelve un número negativo grande
        // El módulo recorta el Hash para que el residuoencaje exactamente en una de nuestras 17 casillas (del 0 al 16).
        return Math.abs(hash) % tamaño;
    }

    // INSERTAR (PUT)
    public void put(String llave, String valor) {
        int indice = generarHash(llave);

        Nodo nuevo = new Nodo(llave, valor);

        // Si la posición está vacía
        if (arreglo[indice] == null) {
            arreglo[indice] = nuevo;
        } else {
            Nodo actual = arreglo[indice];

            // Revisar si la llave ya existe (actualizar valor)
            while (actual != null) {
                if (actual.llave.equals(llave)) {
                    actual.valor = valor;
                    return;
                }
                if (actual.siguiente == null) break;
                actual = actual.siguiente;
            }

            // Insertar al final de la lista
            actual.siguiente = nuevo;
        }
    }


    // OBTENER (GET)
    public String get(String llave) {
        int indice = generarHash(llave);

        Nodo actual = arreglo[indice];

        while (actual != null) {
            if (actual.llave.equals(llave)) {
                return actual.valor;
            }
            actual = actual.siguiente;
        }

        return null; // No encontrado
    }

    // ELIMINAR (REMOVE)
    public void remove(String llave) {
        int indice = generarHash(llave);

        Nodo actual = arreglo[indice];
        Nodo anterior = null;

        while (actual != null) {
            if (actual.llave.equals(llave)) {
                // Si es el primero
                if (anterior == null) {
                    arreglo[indice] = actual.siguiente;
                } else {
                    anterior.siguiente = actual.siguiente;
                }
                return;
            }
            anterior = actual;
            actual = actual.siguiente;
        }
    }

    // MOSTRAR CONTENIDO
    public void mostrar() {
        for (int i = 0; i < tamaño; i++) {
            Nodo actual = arreglo[i];
            System.out.print("Índice " + i + ": ");

            while (actual != null) {
                System.out.print("[" + actual.llave + " -> " + actual.valor + "] ");
                actual = actual.siguiente;
            }

            System.out.println();
        }
    }
}