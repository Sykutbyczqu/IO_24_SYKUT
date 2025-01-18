// Animal.java
package zse.spec.oop.model;

public class Animal implements WorldElement {
    private MapDirection orientation;
    private Vector2d position;

    public Animal() {
        this.position = new Vector2d(1, 2);
        this.orientation = MapDirection.NORTH;
    }

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
                break;
            case LEFT:
                this.orientation = this.orientation.previous();
                break;
            case FORWARD:
                newPosition = this.position.add(this.orientation.toUnitVector());
                if (validator.canMoveTo(newPosition)) {
                    this.position = newPosition;
                    System.out.println("Moved to: " + newPosition);
                } else {
                    System.out.println("Cannot move to: " + newPosition);
                }
                break;
            case BACKWARD:
                newPosition = this.position.subtract(this.orientation.toUnitVector());
                if (validator.canMoveTo(newPosition)) {
                    this.position = newPosition;
                    System.out.println("Moved to: " + newPosition);
                } else {
                    System.out.println("Cannot move to: " + newPosition);
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