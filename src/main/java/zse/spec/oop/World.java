package zse.spec.oop;

import zse.spec.oop.model.*;

import java.util.List;

public class World {
    public static void main(String[] args) {
        List<MoveDirection> directions = OptionsParser.parse(args);
        List<Vector2d> positions = List.of(new Vector2d(1, 2));
        GrassField map = new GrassField(5);
        Simulation simulation = new Simulation(directions, positions, map);
        simulation.run();
    }
}