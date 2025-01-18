package zse.spec.oop;

import org.junit.jupiter.api.Test;
import zse.spec.oop.model.Vector2d;
import zse.spec.oop.model.MoveDirection;
import zse.spec.oop.model.RectangularMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SimulationTest {

    @Test
    public void testSimulation() {
        List<MoveDirection> directions = List.of(MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.LEFT);
        List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(1, 2));
        Simulation simulation = new Simulation(directions, positions, new RectangularMap(5, 5));
        simulation.run();

    }
}