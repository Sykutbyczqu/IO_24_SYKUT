// Simulation.java
package zse.spec.oop;

import zse.spec.oop.model.*;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private final List<Animal> animals;
    private final WorldMap map;
    private final List<MoveDirection> directions;

    public Simulation(List<MoveDirection> directions, List<Vector2d> positions, WorldMap map) {
        this.directions = directions;
        this.map = map;
        this.animals = new ArrayList<>();
        for (Vector2d position : positions) {
            Animal animal = new Animal(position);
            if (map.place(animal)) {
                this.animals.add(animal);
                System.out.println("Placed animal at: " + position);
            } else {
                System.out.println("Failed to place animal at: " + position);
            }
        }
    }

    public void run() {
        int animalIndex = 0;
        for (MoveDirection direction : directions) {
            Animal animal = animals.get(animalIndex);
            System.out.println("Moving animal at: " + animal.getPosition() + " in direction: " + direction);
            map.move(animal, direction);
            System.out.println(map);
            animalIndex = (animalIndex + 1) % animals.size();
        }
    }
}