package zse.spec.oop;


import zse.spec.oop.model.MoveDirection;
import zse.spec.oop.model.Vector2d;

import java.util.List;

public class World {
    public static void main(String[] args) {
        List<MoveDirection> directions = OptionsParser.parse(args);
        List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(3, 4));
        Simulation simulation = new Simulation(directions, positions);
        simulation.run();
    }
}