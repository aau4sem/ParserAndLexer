package model.dataTypes;

/** This class models a 3D-vector where the coordinates is of the type Integer.*/
public class Vector {

    private int x;
    private int y;
    private int z;

    public Vector(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector(int x, int y) {
        this(x, y, 0);
    }

    /** Performs vector addition with the given vector. */
    public void addVector(Vector secondVector){
        this.x = this.x + secondVector.x;
        this.y = this.y + secondVector.y;
        this.z = this.z + secondVector.z;
    }

    /** Performs vector subtraction with the given vector. */
    public void subVector(Vector secondVector){
        this.x = this.x - secondVector.x;
        this.y = this.y - secondVector.y;
        this.z = this.z - secondVector.z;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + "," + z + ')';
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }
}
