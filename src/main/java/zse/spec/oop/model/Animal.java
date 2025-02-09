// Animal.java
package zse.spec.oop.model;

public class Animal implements WorldElement {
    private MapDirection orientation;
    private Vector2d position;

    public Animal(Vector2d initialPosition) {
        this.position = initialPosition;
        this.orientation = MapDirection.NORTH;
    }

    @Override
    public Vector2d getPosition() {
        return position;
    }

    public void move(MoveDirection direction, MoveValidator validator) {
        Vector2d newPosition;
        switch (direction) {
            case RIGHT:
                this.orientation = this.orientation.next();
                System.out.println("Turned right, new orientation: " + this.orientation);
                break;
            case LEFT:
                this.orientation = this.orientation.previous();
                System.out.println("Turned left, new orientation: " + this.orientation);
                break;
            case FORWARD:
                newPosition = this.position.add(this.orientation.toUnitVector());
                if (validator.canMoveTo(newPosition)) {
                    this.position = newPosition;
                    System.out.println("Moved forward to: " + newPosition);
                } else {
                    System.out.println("Cannot move forward to: " + newPosition);
                }
                break;
            case BACKWARD:
                newPosition = this.position.subtract(this.orientation.toUnitVector());
                if (validator.canMoveTo(newPosition)) {
                    this.position = newPosition;
                    System.out.println("Moved backward to: " + newPosition);
                } else {
                    System.out.println("Cannot move backward to: " + newPosition);
                }
                break;
        }
    }

    @Override
    public String toString() {
        switch (this.orientation) {
            case NORTH:
                return "N";
            case SOUTH:
                return "S";
            case WEST:
                return "W";
            case EAST:
                return "E";
            default:
                return "?";
        }
    }
}