package assignments05_code_breakdown;

public class Vector {

    private double _x;
    private double _y;
    private double _z;

    public Vector(double x, double y, double z) {
        _x = x;
        _y = y;
        _z = z;
    }

    public double getX() {
        return _x;
    }

    public double getY() {
        return _y;
    }

    public double getZ() {
        return _z;
    }
    
    @Override
    public String toString() {
        return String.format("(%s, %s, %s)", _x, _y, _z);
    }
}
