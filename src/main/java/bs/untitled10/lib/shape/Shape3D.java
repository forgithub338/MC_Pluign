package bs.untitled10.lib.shape;

public abstract class Shape3D extends Shape2D {
    private double y;
    public Shape3D(double x, double z, double y) {
        super(x, z);
        this.y = y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getY() {
        return y;
    }
}
