public class HashMap {
    private Nodo[] arreglo;
    private int tamaño = 17;

    public HashMap() {
        arreglo = new Nodo[tamaño];
    }

    // Función Hash
    public int generarHash(String llave) {
        int hash = 0;

        for (int i = 0; i < llave.length(); i++) {
            char letra = llave.charAt(i);
            hash = (hash * 31) + letra;
        }

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