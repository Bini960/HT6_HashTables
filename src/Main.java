public class Main {
    public static void main(String[] args) {

        HashMap mapa = new HashMap();

        mapa.put("Orion", "Betelgeuse");
        mapa.put("Canis Mayor", "Sirius");
        mapa.put("Lyra", "Vega");
        mapa.put("Orion", "Rigel"); // Actualiza valor

        mapa.mostrar();

        System.out.println("Buscar Orion: " + mapa.get("Orion"));

        mapa.remove("Lyra");

        System.out.println("\nDespués de eliminar Lyra:");
        mapa.mostrar();
    }
}