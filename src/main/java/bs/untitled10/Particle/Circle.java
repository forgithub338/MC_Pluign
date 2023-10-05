package bs.untitled10.Particle;

public class Circle extends Shape2D {
    protected Circle(double x, double z) {
        super(x, z);
    }

    public Circle[] getCircleCoordinates(int r, int num) {
        double   angle      = (double) 360 / num;
        Circle[] circleCoordinates = new Circle[num];

        double theta = 0;
        for (int i = 0; i < num; i++) {
            theta += angle;
            circleCoordinates[i] = new Circle(this.getX() + r * Math.cos(theta), this.getZ() + r * Math.sin(theta));
        }

        return circleCoordinates;
    }
}
