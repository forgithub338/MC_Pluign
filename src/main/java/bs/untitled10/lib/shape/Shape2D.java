package bs.untitled10.lib.shape;

public abstract class Shape2D {
    private double x;
    private double z;

    public Shape2D(double x, double z) {
        this.x = x;
        this.z = z;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getZ() {
        return z;
    }
}
