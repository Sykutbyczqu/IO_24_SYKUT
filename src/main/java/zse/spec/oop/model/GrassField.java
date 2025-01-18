package zse.spec.oop.model;

import java.util.*;
import zse.spec.oop.model.Vector2d;
import zse.spec.oop.model.util.MapVisualizer;

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
        return grasses.get(position);
    }

    @Override
    public Collection<WorldElement> getElements() {
        Set<WorldElement> elements = new HashSet<>(super.getElements());
        elements.addAll(grasses.values());
        return elements;
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
            if (position.getX() > maxX) maxX = position.getX();
            if (position.getY() > maxY) maxY = position.getY();
        }
        for (Vector2d position : animals.keySet()) {
            if (position.getX() > maxX) maxX = position.getX();
            if (position.getY() > maxY) maxY = position.getY();
        }
        return new Vector2d(maxX, maxY);
    }
}