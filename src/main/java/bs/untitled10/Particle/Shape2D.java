package bs.untitled10.Particle;

public class Shape2D {
    private final double x;
    private final double z;

    protected Shape2D(double x, double z) {
        this.x = x;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getZ() {
        return z;
    }
}
