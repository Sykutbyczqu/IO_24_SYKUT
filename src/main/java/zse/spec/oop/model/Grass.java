package zse.spec.oop.model;

public class Grass implements WorldElement {

    public Grass(Vector2d position) {
    }

    @Override
    public String toString() {
        return "*";
    }

    @Override
    public Vector2d getPosition() {
        return null;
    }
}