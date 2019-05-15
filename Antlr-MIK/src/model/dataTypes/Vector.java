package model.dataTypes;

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
        this(x, y, -1);
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

    /** Performs simple vector addition with the given vector. */
    public void addVector(Vector secondVector){
        this.x = this.x + secondVector.x;
        this.y = this.y + secondVector.y;
        this.z = this.z + secondVector.z;
    }

    /** Performs simple vector subtraction with the given vector. */
    public void subVector(Vector secondVector){
        this.x = this.x - secondVector.x;
        this.y = this.y - secondVector.y;
        this.z = this.z - secondVector.z;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + "," + z + ')';
    }
}
