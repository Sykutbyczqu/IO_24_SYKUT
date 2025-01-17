package zse.spec.oop;

import zse.spec.oop.model.Animal;
import zse.spec.oop.model.MoveDirection;
import zse.spec.oop.model.Vector2d;
import zse.spec.oop.model.WorldMap;
import zse.spec.oop.model.RectangularMap;

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
            }
        }
    }

    public Simulation(List<MoveDirection> directions, List<Vector2d> positions) {
        this(directions, positions, new RectangularMap(4, 4));

    }

    public void run() {
        int animalIndex = 0;
        for (MoveDirection direction : directions) {
            Animal animal = animals.get(animalIndex);
            map.move(animal, direction);
            System.out.println(map);
            animalIndex = (animalIndex + 1) % animals.size();
        }
    }
}