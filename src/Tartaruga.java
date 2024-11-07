/**
 * Represents the tortoise in the race. This class defines the movement logic
 * and race behavior.
 * It uses random probabilities to determine the movement speed and potential
 * slips.
 */
public class Tartaruga extends Thread {

    private Tabla tabla; // Reference to the race table

    /**
     * Constructor to initialize the tortoise with a reference to the race table and
     * a name.
     *
     * @param tabla The race table that tracks positions and race status.
     * @param name  The name of this thread, representing the tortoise.
     */
    public Tartaruga(Tabla tabla, String name) {
        this.tabla = tabla;
        super.setName(name); // Sets the thread name to the given name
    }

    /**
     * The main behavior of the tortoise in the race. It runs until the race ends.
     * Moves based on random probabilities and checks if the tortoise reaches the
     * finish line.
     */
    @Override
    public void run() {
        try {
            // Loop until the race is over
            while (!this.tabla.isFinCarreira()) {
                Thread.sleep(100); // Pauses for a moment before calculating the next move
                Probabilidad(); // Determines the movement type based on probabilities
                tabla.ImprimirTablaTartaruga(); // Prints the tortoise's position

                // Checks if the tortoise reached the finish line (position 70)
                if (this.tabla.getTartaruga() == 70) {
                    tabla.setFinCarreira(true); // Ends the race
                    if (tabla.getLebre() == 70) {
                        tabla.empate(); // Declares a tie if both reached the finish line
                    } else {
                        tabla.setGañador(this); // Sets the tortoise as the winner
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Represents a fast advance for the tortoise, moving it forward by 3 positions.
     */
    private void AvanceRapido() {
        SumaResta(3);
    }

    /**
     * Represents a slip for the tortoise, moving it back by 6 positions.
     */
    private void Esvarar() {
        SumaResta(-6);
    }

    /**
     * Represents a slow advance for the tortoise, moving it forward by 1 position.
     */
    private void AvanceLento() {
        SumaResta(1);
    }

    /**
     * Adjusts the tortoise's position based on the given number.
     * Ensures that the position stays within the race boundaries (1 to 70).
     *
     * @param numero The number of positions to move; can be positive or negative.
     */
    private void SumaResta(int numero) {
        int resultado = this.tabla.getTartaruga() + numero;
        if (resultado > 70) {
            this.tabla.setTartaruga(70); // Caps position at 70
        } else if (resultado < 1) {
            this.tabla.setTartaruga(1); // Sets position to 1 if it goes below 1
        } else {
            this.tabla.setTartaruga(resultado); // Updates position normally
        }
    }

    /**
     * Determines the tortoise's movement type based on a random number.
     * Each movement type has a specific probability:
     * - 20% chance to slip
     * - 30% chance for a slow advance
     * - 50% chance for a fast advance
     */
    private void Probabilidad() {
        int numAleatorio = (int) (Math.random() * 100);

        if (numAleatorio <= 20) {
            Esvarar(); // 20% probability to slip
        } else if (numAleatorio > 20 && numAleatorio <= 50) {
            AvanceLento(); // 30% probability to advance slowly
        } else {
            AvanceRapido(); // 50% probability to advance quickly
        }
    }
}
