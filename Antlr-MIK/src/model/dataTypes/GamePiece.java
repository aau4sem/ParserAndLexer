package model.dataTypes;

import customListeners.VariableCollectorListener;
import exceptions.GrammarHasChangedException;
import model.utils.TypeCheckerHelper;
import model.variables.VariableContainer;

public class GamePiece {

    /** This enum is used by the action-call Change. */
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

    private static Vector defaultPosition = new Vector(0,0,0);
    private static String defaultIdentifier = "";
    private static Float defaultSize = 1f;
    private static String defaultColor = "red";
    private static String defaultLabel = "";
    private static Float defaultOpacity = 1f;
    private static String defaultShape = "circle";

    //TODO Do checks for boundaries of values.
    private String name = defaultIdentifier; //A unique value used in parsing. This is the identifier for this object given in declaration.
    private Vector position = defaultPosition;
    private Float size = defaultSize; //Must be positive
    private String color = defaultColor; //Could also be of format: RBG
    private String label = defaultLabel;
    private Float opacity = defaultOpacity; //Must be [0:1]
    private String shape =  defaultShape; //Type check for shapes

    /** Changes the field matching the given PropertyType to the given value.
     * @param type the type of the property to change.
     * @param value the value the property should be changed to. */
    public void changeProperty(GamePiecePropertyType type, String value){

        if(value.compareTo("") == 0)
            return;

        switch (type){
            case NAME:      setName(value); break;
            case POSITION:  setPosition(TypeCheckerHelper.parseVector(value)); break;
            case SIZE:      setSize(TypeCheckerHelper.parseFloat(value)); break;
            case COLOR:     setColor(value); break;
            case LABEL:     setLabel(value); break;
            case OPACITY:   setOpacity(TypeCheckerHelper.parseFloat(value)); break;
            case SHAPE:     setShape(value); break;
        }
    }

    /** @return true if the given VariableContainers type is the one required by the given PropertyType. */
    public static boolean doesValueMatchPropertyType(GamePiecePropertyType type, VariableContainer varCon){
        switch (type){
            case NAME:      return (varCon.getType() == VariableCollectorListener.VariableType.STRING);
            case POSITION:  return (varCon.getType() == VariableCollectorListener.VariableType.VEC);
            case SIZE:      return (varCon.getType() == VariableCollectorListener.VariableType.FLOAT);
            case COLOR:     return (varCon.getType() == VariableCollectorListener.VariableType.STRING);
            case LABEL:     return (varCon.getType() == VariableCollectorListener.VariableType.STRING);
            case OPACITY:   return (varCon.getType() == VariableCollectorListener.VariableType.FLOAT);
            case SHAPE:     return (varCon.getType() == VariableCollectorListener.VariableType.STRING);
        }

        throw new GrammarHasChangedException(); //Should never happen!
    }

    /** @return a string representing this GamePiece and all its values. */
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
        if(identifierName == null)
            throw new IllegalArgumentException();
        this.name = identifierName;
    }

    public void setPosition(Vector position) {
        if(position == null)
            throw new IllegalArgumentException();
        this.position = position;
    }

    public void setSize(Float size) {
        if(size == null)
            throw new IllegalArgumentException();
        this.size = size;
    }

    public void setColor(String color) {
        if(color == null)
            throw new IllegalArgumentException();
        this.color = color;
    }

    public void setLabel(String label) {
        if(label == null)
            throw new IllegalArgumentException();
        this.label = label;
    }

    public void setOpacity(Float opacity) {
        if(opacity == null)
            throw new IllegalArgumentException();
        this.opacity = opacity;
    }

    public void setShape(String shape) {
        if(shape == null)
            throw new IllegalArgumentException();
        this.shape = shape;
    }

    public String getName() {
        return name;
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
