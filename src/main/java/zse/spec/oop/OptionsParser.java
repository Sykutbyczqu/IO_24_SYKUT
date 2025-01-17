package zse.spec.oop;

import zse.spec.oop.model.MoveDirection;

import java.util.ArrayList;
import java.util.List;

public class OptionsParser {
    public static List<MoveDirection> parse(String[] directions) {
        List<MoveDirection> result = new ArrayList<>();
        for (String direction : directions) {
            switch (direction) {
                case "f":
                    result.add(MoveDirection.FORWARD);
                    break;
                case "b":
                    result.add(MoveDirection.BACKWARD);
                    break;
                case "r":
                    result.add(MoveDirection.RIGHT);
                    break;
                case "l":
                    result.add(MoveDirection.LEFT);
                    break;
            }
        }
        return result;
    }
}