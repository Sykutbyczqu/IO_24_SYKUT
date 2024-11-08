package zse.spec.oop;

public enum Direction {
    FORWARD, BACKWARD, RIGHT, LEFT;

    public static Direction fromString(String str) {
        return switch (str) {
            case "f" -> FORWARD;
            case "b" -> BACKWARD;
            case "r" -> RIGHT;
            case "l" -> LEFT;
            default -> null;
        };
    }
}