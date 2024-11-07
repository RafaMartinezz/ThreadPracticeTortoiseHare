public class App {
    public static void main(String[] args) {

        // Creates the race table, the turtle, and the hare.
        Tabla tabla = new Tabla();
        Thread tartaruga = new Tartaruga(tabla, "Tartaruga"); // Creates the turtle thread.
        Thread lebre = new Lebre(tabla, "Lebre"); // Creates the hare thread.

        // Signals the start of the race.
        tabla.InicioCarreira();

        // Starts both threads, initiating the race.
        tartaruga.start();
        lebre.start();

        try {
            // Ensures that both threads complete before proceeding.
            lebre.join();
            tartaruga.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Signals the end of the race.
        tabla.FinCarreira();

        // Declares the winner.
        tabla.Gañador();

    }
}
