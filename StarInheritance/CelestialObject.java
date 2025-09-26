import java.util.Objects;

public class CelestialObject {
    public double x = 0.0;
    public double y = 0.0;
    public double z = 0.0;
    public String name = "Soleil";

    public CelestialObject() {
    }

    public CelestialObject(String name, double x, double y, double z) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getZ() {
        return this.z;
    }

    public String getName() {
        return this.name;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static double getDistanceBetween(CelestialObject a, CelestialObject b) {
        double dx = a.x - b.x;
        double dy = a.y - b.y;
        double dz = a.z - b.z;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    public static double getDistanceBetweenInKm(CelestialObject a, CelestialObject b) {
        return getDistanceBetween(a, b) * KM_IN_ONE_AU;
    }

    public static double KM_IN_ONE_AU = 150000000;

    public String toString() {
        return String.format("%s is positioned at (%.3f, %.3f, %.3f)", name, x, y, z);
    }

    public boolean equals(CelestialObject other) {
        if (other == null) {
            return false;
        }
        return this.name.equals(other.name) && this.x == other.x && this.y == other.y && this.z == other.z;
    }

    public int hashCode() {
        return Objects.hash(name, x, y, z);
    }
}