package zse.spec.oop;

import org.junit.jupiter.api.Test;
import zse.spec.oop.model.*;

import static org.junit.jupiter.api.Assertions.*;

public class RectangularMapTest {

    @Test
    public void testPlace() {
        RectangularMap map = new RectangularMap(4, 4);
        Animal animal = new Animal(new Vector2d(2, 2));
        assertTrue(map.place(animal));
        assertFalse(map.place(new Animal(new Vector2d(2, 2))));
    }

    @Test
    public void testMove() {
        RectangularMap map = new RectangularMap(4, 4);
        Animal animal = new Animal(new Vector2d(2, 2));
        map.place(animal);
        map.move(animal, MoveDirection.FORWARD);
        assertEquals(new Vector2d(2, 3), animal.getPosition());
    }
}