// GrassField.java
package zse.spec.oop.model;

import java.util.*;
import zse.spec.oop.util.MapVisualizer;


public class GrassField extends AbstractWorldMap {
    private final Map<Vector2d, Grass> grasses = new HashMap<>();

    public GrassField(int numberOfGrasses) {
        Random random = new Random();
        int range = (int) Math.sqrt(numberOfGrasses * 10);
        while (grasses.size() < numberOfGrasses) {
            Vector2d position = new Vector2d(random.nextInt(range), random.nextInt(range));
            if (!grasses.containsKey(position)) {
                grasses.put(position, new Grass(position));
            }
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return super.isOccupied(position) || grasses.containsKey(position);
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        if (super.isOccupied(position)) {
            return super.objectAt(position);
        }
        if (grasses.containsKey(position)) {
            return grasses.get(position);
        }
        return null;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return true;
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        Vector2d oldPosition = animal.getPosition();
        animal.move(direction, this);
        Vector2d newPosition = animal.getPosition();
        if (!oldPosition.equals(newPosition)) {
            animals.remove(oldPosition);
            animals.put(newPosition, animal);
            System.out.println("Animal moved from " + oldPosition + " to " + newPosition);
        } else {
            System.out.println("Animal did not move from " + oldPosition);
        }
    }

    @Override
    public String toString() {
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(getLowerLeft(), getUpperRight());
    }

    private Vector2d getLowerLeft() {
        return new Vector2d(0, 0);
    }

    private Vector2d getUpperRight() {
        int maxX = 0;
        int maxY = 0;
        for (Vector2d position : grasses.keySet()) {
            if (position.x() > maxX) maxX = position.x();
            if (position.y() > maxY) maxY = position.y();
        }
        if (animals != null) {
            for (Vector2d position : animals.keySet()) {
                if (position.x() > maxX) maxX = position.x();
                if (position.y() > maxY) maxY = position.y();
            }
        }
        return new Vector2d(maxX, maxY);
    }
}