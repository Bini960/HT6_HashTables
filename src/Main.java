public class Main {
    public static void main(String[] args) {
        // Arreglo de tamaño 17 (número primo)
        HashMap mapa = new HashMap();

        System.out.println("Constelaciones y sus estrellas más brillantes:");

        mapa.put("Orion", "Betelgeuse");
        mapa.put("Canis Mayor", "Sirius");
        mapa.put("Lyra", "Vega");
        mapa.put("Orion", "Rigel"); // Actualiza valor
        mapa.put("Osa Menor", "Polaris");
        mapa.put("Centauro", "Alfa Centauri");
        mapa.put("Cisne", "Deneb");
        mapa.put("Aguila", "Altair");
        mapa.put("Escorpio", "Antares");
        mapa.put("Leo", "Regulo");
        mapa.put("Tauro", "Aldebaran");
        mapa.put("Crux", "Acrux");
        mapa.put("Auriga", "Capella");
        mapa.put("Geminis", "Pollux");
        mapa.put("Virgo", "Espiga");
        mapa.put("Boyero", "Arturo");

        mapa.mostrar();

        System.out.println("Buscar Orion: " + mapa.get("Orion"));
        System.out.println("Buscar Leo: " + mapa.get("Leo"));

        mapa.remove("Lyra");

        System.out.println("\nDespués de eliminar Lyra:");
        mapa.mostrar();
    }
}