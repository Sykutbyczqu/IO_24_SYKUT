package zse.spec.oop;

import java.util.Arrays;
import java.util.Objects;

public class World {
    public static void main(String[] args) {
        System.out.println("START");


        Direction[] directions = Arrays.stream(args)
                .map(Direction::fromString)
                .filter(Objects::nonNull)
                .toArray(Direction[]::new);


        run(directions);

        System.out.println("STOP");
    }

    public static void run(Direction[] directions) {
        System.out.println("Zwierzak idzie do przodu");


        for (Direction direction : directions) {
            switch (direction) {
                case FORWARD -> System.out.println("Zwierzak idzie do przodu");
                case BACKWARD -> System.out.println("Zwierzak idzie do tylu");
                case RIGHT -> System.out.println("Zwierzak skreca w prawo");
                case LEFT -> System.out.println("Zwierzak skreca w lewo");
            }
        }
    }
}
