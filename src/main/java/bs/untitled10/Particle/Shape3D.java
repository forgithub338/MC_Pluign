package bs.untitled10.Particle;

public class Shape3D extends Shape2D {
    private final double y;
    protected Shape3D(double x, double z, double y) {
        super(x, z);
        this.y = y;
    }

    public double getY() {
        return y;
    }
}
