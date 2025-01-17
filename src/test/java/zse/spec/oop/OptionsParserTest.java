package zse.spec.oop;

import org.junit.jupiter.api.Test;
import zse.spec.oop.model.MoveDirection;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OptionsParserTest {

    @Test
    public void testParse() {
        String[] args = {"f", "b", "r", "l", "x"};
        List<MoveDirection> directions = OptionsParser.parse(args);
        assertEquals(List.of(MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.LEFT), directions);
    }
}