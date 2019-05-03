package model.dataTypes;

import model.utils.TypeCheckerHelper;

public class GamePiece {

    public enum GamePiecePropertyType { NAME("name"), POSITION("position"), SIZE("size"),
        COLOR("color"), OPACITY("opacity"), LABEL("label"), SHAPE("shape");

        String string;

        GamePiecePropertyType(String string) {
            this.string = string;
        }

        public String getString() {
            return string;
        }
    }

    private static String defaultName = "";
    private static Vector defaultPosition = null; //TODO Default?
    private static Float defaultSize = 1f; //TODO Default?
    private static String defaultColor = null;
    private static String defaultLabel = "";
    private static Float defaultOpacity = 1f;
    private static String defaultShape = "circle";

    //Does this equal makes so that if we change the below changed the above
    private String name = defaultName;
    private Vector position = defaultPosition;
    private Float size = defaultSize; //Must be positive
    private String color = defaultColor; //Could also be of format: RBG
    private String label = defaultLabel;
    private Float opacity = defaultOpacity; //Must be [0:1]
    private String shape =  defaultShape; //Type check for shapes

    /** @param type the type of the property to change.
     * @param value the value the property should be changed to. */
    public void changeProperty(GamePiecePropertyType type, String value){

        //TODO Make sure that the end value is corrent - that the parsed value is not null

        if(value.compareTo("") == 0)
            return;

        switch (type){
            case NAME:      name = value;
                            break;
            case POSITION:  position = TypeCheckerHelper.parseVector(value);
                            break;
            case SIZE:      size = TypeCheckerHelper.parseFloat(value);
                            break;
            case COLOR:     color = value;
                            break;
            case LABEL:     label = value;
                            break;
            case OPACITY:   opacity = TypeCheckerHelper.parseFloat(value);
                            break;
            case SHAPE:     shape = value;
                            break;
        }
    }

    public String getGamePieceString(){

        StringBuilder sb = new StringBuilder();
        sb.append(GamePiecePropertyType.NAME.getString()).append(":").append(this.getName()).append(",");
        String positionVal = (position == null) ? "" : position.toString();
        sb.append(GamePiece.GamePiecePropertyType.POSITION.getString()).append(":").append(positionVal).append(",");
        sb.append(GamePiece.GamePiecePropertyType.SIZE.getString()).append(":").append(this.getSize()).append(",");
        String colorVal = (color == null) ? "" : color;
        sb.append(GamePiece.GamePiecePropertyType.COLOR.getString()).append(":").append(colorVal).append(",");
        sb.append(GamePiece.GamePiecePropertyType.LABEL.getString()).append(":").append(this.getLabel()).append(",");
        sb.append(GamePiece.GamePiecePropertyType.OPACITY.getString()).append(":").append(this.getOpacity()).append(",");
        sb.append(GamePiece.GamePiecePropertyType.SHAPE.getString()).append(":").append(this.getShape()).append(",");
        return sb.toString();
    }

    public void setName(String identifierName) {
        this.name = identifierName;
    }

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

    public void setOpacity(Float opacity) {
        this.opacity = opacity;
    }

    public String getName() {
        return name;
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

    public Float getOpacity() {
        return opacity;
    }

    public String getShape() {
        return shape;
    }
}
