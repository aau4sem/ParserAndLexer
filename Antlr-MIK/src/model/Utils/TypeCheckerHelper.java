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
}
