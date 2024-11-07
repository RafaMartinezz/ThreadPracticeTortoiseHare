# Tortoise and hare race simulation

This project simulates a race between a tortoise and a hare, each represented by a separate thread. The race involves random movement types and speeds, where the tortoise and hare advance based on different probabilities. The project demonstrates basic multithreading concepts, synchronization, and random event-driven logic in Java.

## Features

- **Multithreading**: Each participant (tortoise and hare) runs as an independent thread, simulating simultaneous actions.
- **Randomized Movement**: Movement types and speeds are determined randomly based on specified probabilities.
- **Synchronized Output**: Position updates are printed in real-time using synchronized methods, ensuring accurate race tracking.
- **Race Outcome**: The race automatically concludes when either participant reaches the finish line, determining the winner or announcing a tie.

## Project Structure

- `App`: Main class that starts the race, initializes the participants (tortoise and hare), and waits for the threads to complete.
- `Tabla`: Manages race conditions, tracking the participants' positions, printing their progress, and announcing the winner.
- `Tartaruga`: Defines the behavior and movement types for the tortoise with probabilistic movement logic.
- `Lebre`: Defines the behavior and movement types for the hare, also governed by random probabilities.

## Classes Overview

1. **App**: Sets up the race, initializes the tortoise and hare, and starts the race. Waits for both threads to finish and then displays the race results.
2. **Tabla**: Synchronizes the race data, controlling and displaying the current positions of the tortoise and hare. Contains methods to print race progress, check for race completion, and display the winner.
3. **Tartaruga**: The tortoise’s thread class, which determines its movement based on probability:
   - **20%** chance to slip backward.
   - **30%** chance to advance slowly.
   - **50%** chance to advance quickly.
4. **Lebre**: The hare’s thread class, defining its unique movement patterns:
   - **20%** chance to sleep (no movement).
   - **20%** chance to make a big jump.
   - **10%** chance to make a big slip.
   - **30%** chance to make a small jump.
   - **20%** chance to make a small slip.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 17 or later.

### Running the Project

1. Compile all classes:
   ```bash
   javac App.java
   ```
2. Run the main class:
   ```bash
   java App
   ```

### Expected Output

The console output will show the position of each participant at every stage of the race. The race continues until either participant reaches the finish line (position 70), with a final message indicating the winner or a tie.

## Customization

- **Race Length**: You can modify the finish line by changing the position checks in the `Tartaruga` and `Lebre` classes.
- **Probability Adjustment**: Update probability values in the `Probabilidad()` methods within `Tartaruga` and `Lebre` to modify the participants' behavior.

## Learning Points

- Introduction to basic multithreading and concurrency in Java.
- Synchronization techniques using synchronized methods to avoid race conditions.
- Implementation of random event-based logic to simulate real-world scenarios.