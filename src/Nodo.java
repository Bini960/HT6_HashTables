public class Nodo {
    String llave;       // Aquí se guarda la constelación 
    String valor;       // Aquí se guarda la estrella
    Nodo siguiente;     // Atributo para la lista enlazada si hay colisión

    // Constructor: Empaquetado de los datos
    public Nodo(String llave, String valor) {
        this.llave = llave;
        this.valor = valor;
        this.siguiente = null; // Al crearse la caja no apunta a nada
    }
}