package model.dataTypes;

public class GamePiece {

    public enum GamePieceProppertyTypes { POSITION, SIZE, COLOR, OPACITY, LABEL, SHAPE}

    private Vector position = null; //TODO Default?
    private Float size = null; //Must be positive //TODO Default?
    private String color = null; //Could also be of format: RBG
    private String label = "";
    private float opacity = 1; //Must be [0:1]
    private String shape =  "circle"; //Type check for shapes

    public void setPosition(Vector position) {
        this.position = position;
    }

    public void setSize(Float size) {
        this.size = size;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setOpacity(float opacity) {
        this.opacity = opacity;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public Vector getPosition() {
        return position;
    }

    public Float getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public String getLabel() {
        return label;
    }

    public float getOpacity() {
        return opacity;
    }

    public String getShape() {
        return shape;
    }
}
