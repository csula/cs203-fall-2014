package hw2solution;

public abstract class GeometricObject {
    protected int level = 0;

    public abstract double getArea();

    public int getLevel() {
        return level;
    }
}
