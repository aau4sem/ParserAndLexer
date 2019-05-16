package model.utils;

import customListeners.VariableCollectorListener;
import model.dataTypes.Array;
import model.dataTypes.GamePiece;
import model.dataTypes.Vector;
import model.dataTypes.Number;

import java.util.ArrayList;

public class TypeCheckerHelper {

    /** @return true if the given string is "true" and
     * false if the given string is "false". Else returns null. */
    public static Boolean parseBool(String val){

        Boolean returnVal = null;

        if(val.compareTo("true") == 0)
            returnVal = true;
        else if(val.compareTo("false") == 0)
            returnVal = false;

        return returnVal;
    }

    /** @return a Number if the given string is an integer, else null. */
    public static Number parseNumber(String val){

        Integer intVal = parseInt(val);
        Float floatVal = parseFloat(val);

        if(intVal != null)
            return new Number(intVal);
        else if(floatVal != null)
            return new Number(floatVal);
        else
            return null;
    }

    /** @return an Integer if the given string is an integer, else null. */
    public static Integer parseInt(String val){

        try {
            return Integer.parseInt(val);
        }catch (NumberFormatException e){
            return null;
        }
    }

    /** @return an Integer if the given string is an integer, else null. */
    public static int trimFloatToInt(String val){
        try {
            Float floatVal = Float.parseFloat(val);
            return floatVal.intValue();


        } catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }

    /** @return a Float if the given string is a float, else null. */
    public static Float parseFloat(String val){
        try {
            return Float.parseFloat(val);
        }catch (NumberFormatException e){
            return null;
        }
    }

    /** Returns a GamePiece if the given string is an string, else null. */
    public static GamePiece parseGamePiece(String val){

        //TODO IdentifierName????
        GamePiece gp = new GamePiece();

        //Format of string should be:
        //"name:VAL,position:VAL,size:VAL,color:VAL,label:VAL,opacity:VAL,shape:VAL,"
        //"name:test,position:(2,3,4),size:3.2,color:RED,label:test,opacity:0.2,shape:circle,"
        //"name:STRING,position:VECTOR,size:FLOAT,color:STRING,label:STRING,opacity:FLOAT[0:1],shape:STRING,"
        //"name:,position:,size:,color:,label:STRING,opacity:,shape:STRING,"

        boolean readingProperty = true;
        boolean readingValue = false;
        boolean readingVector = false;

        String collectorProperty = "";
        String collectorValue = "";

        for(char c : val.toCharArray()){

            //This is done to avoid the commas in a vector messing up the reading of the string
            if(c == '(')
                readingVector = true;
            else if(c == ')')
                readingVector = false;


            if(c == ':'){
                readingProperty = false;
                readingValue = true;
            }else if(c == ',' && !readingVector){
                readingProperty = true;
                readingValue = false;

                //Save/collect value for the property
                GamePiece.GamePiecePropertyType currentType = parseGamePiecePropertyType(collectorProperty);
                gp.changeProperty(currentType, collectorValue);

                //Reset collectors
                collectorProperty = "";
                collectorValue = "";
            }else if(readingProperty){
                collectorProperty += c;
            }else if(readingValue){
                collectorValue += c;
            }
        }

        return gp;
    }



    /** Returns a Vector if the given string is an vector, else null.
     * //TODO Current only parses vectors whose values are of the type int.
     * //TODO Do we support float vectors? */
    public static Vector parseVector(String val){
        try {
            StringBuilder xString = new StringBuilder();
            StringBuilder yString = new StringBuilder();
            StringBuilder zString = new StringBuilder();

            int commaCounter = 0;
            int parenthesesCounter = 0;
            for (char c : val.toCharArray()){

                if(c == '(' || c == ')')
                    parenthesesCounter++;
                else if(c == ',')
                    commaCounter++;
                else if(commaCounter == 0)
                    xString.append(c);
                else if(commaCounter == 1)
                    yString.append(c);
                else if(commaCounter == 2){
                    zString.append(c);
                }
            }

            if(parenthesesCounter != 2)
                return null;
            if(commaCounter == 2)
                return new Vector(Integer.parseInt(xString.toString()), Integer.parseInt(yString.toString()), Integer.parseInt(zString.toString()));
            if(commaCounter == 1)
                return new Vector(Integer.parseInt(xString.toString()), Integer.parseInt(yString.toString()));
            if(commaCounter == 0)
                return null;
        }catch (NumberFormatException e){
            return null;
        }

        return null;
    }

    /** @return the property type matches the given string. Can be null.*/
    public static GamePiece.GamePiecePropertyType parseGamePiecePropertyType(String val){
        for(GamePiece.GamePiecePropertyType type : GamePiece.GamePiecePropertyType.values()){
            if(val.compareTo(type.getString()) == 0)
                return type;
        }

        return null;
    }

    /** @return the same string but with removed start and end parentheses. "test" -> test*/
    public static String parseString(String val){

        if(val.length() == 0)
            return "";

        String output = val; //Does this even copy the content?

        if(output.charAt(0) == '"')
            output = output.substring(1);

        if(output.charAt(output.length() - 1) == '"')
            output = output.substring(0, output.length() - 1);


        return output;
    }

    /** @return the VariableType matching the given input. */
    public static VariableCollectorListener.VariableType parseVariableType(String val){

        //todo HANDLE ARRAYS

        switch (val){
            case "int": return VariableCollectorListener.VariableType.INT;
            case "float" : return VariableCollectorListener.VariableType.FLOAT;
            case "GamePiece" : return VariableCollectorListener.VariableType.GAMEPIECE;
            case "vector" : return VariableCollectorListener.VariableType.VEC;
            case "string" : return VariableCollectorListener.VariableType.STRING;
            case "bool" : return VariableCollectorListener.VariableType.BOOL;
        }

        return null;
    }

    public static int[] parseIntegerArray(String val){
        ArrayList<String> elements = getArrayElements(val);

        int[] result = new int[elements.size()];

        for(int i = 0; i < elements.size(); i++)
            result[i] = parseInt(elements.get(i));

        return result;
    }

    public static float[] parseFloatArray(String val){
        ArrayList<String> elements = getArrayElements(val);

        float[] result = new float[elements.size()];

        for(int i = 0; i < elements.size(); i++)
            result[i] = parseFloat(elements.get(i));

        return result;
    }

    public static Vector[] parseVectorArray(String val){
        ArrayList<String> elements = getArrayElements(val);

        Vector[] result = new Vector[elements.size()];

        for(int i = 0; i < elements.size(); i++)
            result[i] = parseVector(elements.get(i));

        return result;
    }

    public static boolean[] parseBooleanArray(String val){
        ArrayList<String> elements = getArrayElements(val);

        boolean[] result = new boolean[elements.size()];

        for(int i = 0; i < elements.size(); i++)
            result[i] = parseBool(elements.get(i));

        return result;
    }

    public static String[] parseStringArray(String val){
        ArrayList<String> elements = getArrayElements(val);

        String[] result = new String[elements.size()];

        for(int i = 0; i < elements.size(); i++)
            result[i] = parseString(elements.get(i));

        return result;
    }

    public static GamePiece[] parseGamePieceArray(String val){
        ArrayList<String> elements = getArrayElements(val);

        GamePiece[] result = new GamePiece[elements.size()];

        for(int i = 0; i < elements.size(); i++)
            result[i] = parseGamePiece(elements.get(i));

        return result;
    }

    /** @param val takes an array string in the given format: {x,x,x,x,x,x,...}
     * @return a list of the individual elements. (All the x's in the above format example.)*/
    private static ArrayList<String> getArrayElements(String val){

        ArrayList<String> result = new ArrayList<>();

        if(val.length() < 3)
            return result;

        StringBuilder value = new StringBuilder();
        boolean isInParentheses = false;

        for(int i = 1; i < val.length() -1; i++){

            if(val.charAt(i) == '(')
                isInParentheses = true;
            else if(val.charAt(i) == ')')
                isInParentheses = false;


            if(val.charAt(i) == ',' && !isInParentheses){
                result.add(value.toString());
                value = new StringBuilder();
            }else
                value.append(val.charAt(i));
        }

        result.add(value.toString());

        return result;
    }
}
