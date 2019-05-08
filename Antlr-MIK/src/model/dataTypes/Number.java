package model.dataTypes;

public class Number {

    private Integer intValue = null;
    private Float floatValue = null;

    public Number(Integer intValue) {
        this.intValue = intValue;
    }

    public Number(Float floatValue) {
        this.floatValue = floatValue;
    }

    public Integer getIntValue() {
        return intValue;
    }

    public Float getFloatValue() {
        return floatValue;
    }
}
