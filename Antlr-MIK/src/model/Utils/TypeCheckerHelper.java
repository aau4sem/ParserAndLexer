package model.utils;

import model.dataTypes.GamePiece;
import model.dataTypes.Vector;
import model.dataTypes.Number;

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

        //TODO, Handle GP. The value in VariableContainer should reflect a GP.

        return new GamePiece();
    }

    /** Returns a Vector if the given string is an vector, else null. */
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
}