public class Lebre extends Thread {

    private Tabla tabla; // Shared reference to the race status table

    public Lebre(Tabla tabla, String name) {
        this.tabla = tabla;
        super.setName(name); // Sets the name of the thread to the specified name
    }

    @Override
    public void run() {
        try {
            // Keeps running until the race is marked as finished
            while (!this.tabla.isFinCarreira()) {
                // Pauses for 100 milliseconds between probability calculations
                Thread.sleep(100);

                // Determines movement based on probability
                Probabilidad();

                // Updates the race status table to reflect the hare's new position
                tabla.ImprimirTablaLebre();

                // Checks if the hare has reached the finish line at position 70
                if (this.tabla.getLebre() == 70) {
                    tabla.setFinCarreira(true); // Marks the race as finished
                    if (this.tabla.getTartaruga() == 70) {
                        tabla.empate(); // If both reach at the same time, declares a tie
                    } else {
                        tabla.setGañador(this); // Sets the hare as the winner
                    }
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Represents the hare "sleeping," which means no movement.
     */
    private void Durmir() {
        SumaResta(0);
    }

    /**
     * Represents a large jump forward for the hare.
     */
    private void GranSalto() {
        SumaResta(9);
    }

    /**
     * Represents a large slip backward for the hare.
     */
    private void EsvaronGrande() {
        SumaResta(-12);
    }

    /**
     * Represents a small step forward for the hare.
     */
    private void PequenoSalto() {
        SumaResta(1);
    }

    /**
     * Represents a small slip backward for the hare.
     */
    private void EsvaronPequeno() {
        SumaResta(-2);
    }

    /**
     * Adjusts the hare's position by the specified amount.
     * Ensures the position stays between 1 and 70.
     * 
     * @param numero the amount to add or subtract from the hare's position
     */
    private void SumaResta(int numero) {
        int resultado = this.tabla.getLebre() + numero;
        if (resultado > 70) {
            this.tabla.setLebre(70); // Sets maximum position if overshoot
        } else if (resultado < 1) {
            this.tabla.setLebre(1); // Sets minimum position if undershoot
        } else {
            this.tabla.setLebre(resultado); // Updates position to calculated result
        }
    }

    /**
     * Determines the hare's movement based on randomly generated probabilities.
     * Each movement type has a specific probability range.
     */
    private void Probabilidad() {
        int numAleatorio = (int) (Math.random() * 100); // Generates a random number between 0 and 99

        if (numAleatorio <= 20) {
            Durmir(); // 20% chance to stay still
        } else if (numAleatorio > 20 && numAleatorio <= 40) {
            GranSalto(); // 20% chance for a large jump
        } else if (numAleatorio > 40 && numAleatorio <= 50) {
            EsvaronGrande(); // 10% chance for a large slip
        } else if (numAleatorio > 50 && numAleatorio <= 80) {
            PequenoSalto(); // 30% chance for a small jump
        } else {
            EsvaronPequeno(); // 20% chance for a small slip
        }
    }
}
