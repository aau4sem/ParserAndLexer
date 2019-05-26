package model.dataTypes;

import customListeners.VariableCollectorListener;

/** This generic class is used to model and store an array of a given type. */
public class Array<T> {

    private T[] array;
    private VariableCollectorListener.VariableType type;

    public Array(T[] array, VariableCollectorListener.VariableType type) {
        this.array = array;
        this.type = type;
    }

    public Object[] getArray() {
        return array;
    }

    public VariableCollectorListener.VariableType getType() {
        return type;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("{");
        for(T element : array)
            sb.append(element).append(",");

        //Replace last comma with a '}'
        sb.replace(sb.length() -1, sb.length(), "}");

        return sb.toString();
    }
}
