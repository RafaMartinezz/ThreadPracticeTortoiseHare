/**
 * The Tabla class manages the display and logic for the race.
 * It keeps track of the positions of the tortoise and hare and determines the
 * race winner.
 */
public class Tabla {

    private int tartaruga; // Position of the tortoise
    private int lebre; // Position of the hare
    private boolean finCarreira; // Indicates if the race has finished
    private Thread gañador; // Holds the winner thread for printing

    /**
     * Initializes the race table, setting both tortoise and hare to position 0,
     * and the race status to not finished.
     */
    public Tabla() {
        this.tartaruga = 0;
        this.lebre = 0;
        this.finCarreira = false;
    }

    /**
     * Prints the start message for the race.
     */
    public void InicioCarreira() {
        System.out.println("Inicio da carreira!");
        System.out.println("------------------");
    }

    /**
     * Prints the end message for the race.
     */
    public void FinCarreira() {
        System.out.println("Fin da carreira!");
        System.out.println("------------------");
        System.out.println("");
    }

    /**
     * Prints the hare's position on the race track.
     * Ensures thread safety for concurrent access.
     */
    public synchronized void ImprimirTablaLebre() {
        for (int i = 1; i < 71; i++) {
            if (i == this.lebre) {
                System.out.print("L " + this.lebre); // Prints 'L' at the hare's position
            } else {
                System.out.print(" ");
            }
        }
        System.out.println("");
    }

    /**
     * Prints the tortoise's position on the race track.
     * Ensures thread safety for concurrent access.
     */
    public synchronized void ImprimirTablaTartaruga() {
        for (int i = 1; i < 71; i++) {
            if (i == this.tartaruga) {
                System.out.print("T " + this.tartaruga); // Prints 'T' at the tortoise's position
            } else {
                System.out.print(" ");
            }
        }
        System.out.println("");
    }

    /**
     * Prints a message indicating a tie between the tortoise and hare.
     */
    public void empate() {
        System.out.println("Empataron!!!");
    }

    /**
     * Returns whether the race has finished.
     *
     * @return true if the race has finished, false otherwise.
     */
    public boolean isFinCarreira() {
        return finCarreira;
    }

    /**
     * Sets the race status as finished or not.
     *
     * @param finCarreira true if the race has finished, false otherwise.
     */
    public void setFinCarreira(boolean finCarreira) {
        this.finCarreira = finCarreira;
    }

    /**
     * Prints the winner's name once the race is over.
     */
    public void Gañador() {
        System.out.println("O gañador é: " + gañador.getName());
    }

    /**
     * Sets the winner of the race.
     *
     * @param gañador The thread representing the winning racer (tortoise or hare).
     */
    public void setGañador(Thread gañador) {
        this.gañador = gañador;
    }

    /**
     * Gets the tortoise's current position.
     *
     * @return the position of the tortoise.
     */
    public int getTartaruga() {
        return tartaruga;
    }

    /**
     * Sets the tortoise's position.
     *
     * @param tartaruga the new position of the tortoise.
     */
    public void setTartaruga(int tartaruga) {
        this.tartaruga = tartaruga;
    }

    /**
     * Gets the hare's current position.
     *
     * @return the position of the hare.
     */
    public int getLebre() {
        return lebre;
    }

    /**
     * Sets the hare's position.
     *
     * @param lebre the new position of the hare.
     */
    public void setLebre(int lebre) {
        this.lebre = lebre;
    }
}
