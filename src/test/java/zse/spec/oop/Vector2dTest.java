package zse.spec.oop;

import org.junit.jupiter.api.Test;
import zse.spec.oop.model.Vector2d;

import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {

    @Test
    public void testEquals() {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(1, 2);
        assertEquals(v1, v2);
    }

    @Test
    public void testToString() {
        Vector2d v = new Vector2d(1, 2);
        assertEquals("(1,2)", v.toString());
    }

    @Test
    public void testPrecedes() {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(2, 3);
        assertTrue(v1.precedes(v2));
    }

    @Test
    public void testFollows() {
        Vector2d v1 = new Vector2d(2, 3);
        Vector2d v2 = new Vector2d(1, 2);
        assertTrue(v1.follows(v2));
    }

    @Test
    public void testUpperRight() {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(2, 1);
        assertEquals(new Vector2d(2, 2), v1.upperRight(v2));
    }

    @Test
    public void testLowerLeft() {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(2, 1);
        assertEquals(new Vector2d(1, 1), v1.lowerLeft(v2));
    }

    @Test
    public void testAdd() {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(-2, 1);
        assertEquals(new Vector2d(-1, 3), v1.add(v2));
    }

    @Test
    public void testSubtract() {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(-2, 1);
        assertEquals(new Vector2d(3, 1), v1.subtract(v2));
    }

    @Test
    public void testOpposite() {
        Vector2d v = new Vector2d(1, 2);
        assertEquals(new Vector2d(-1, -2), v.opposite());
    }
}