public class ValueContainer {

    private Integer intVal;
    private Float floatVal;

    public ValueContainer(int intVal) {
        this.intVal = intVal;
        this.floatVal = null;
    }

    public ValueContainer(float floatVal) {
        this.floatVal = floatVal;
        this.intVal = null;
    }

    public Integer getIntVal() {
        return intVal;
    }

    public Float getFloatVal() {
        return floatVal;
    }

    public String getValue(){
        if(intVal != null)
            return intVal.toString();
        else
            return floatVal.toString();
    }
}
