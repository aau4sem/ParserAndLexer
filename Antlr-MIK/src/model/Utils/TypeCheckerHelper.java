package model.Utils;

import model.dataTypes.GamePiece;
import model.dataTypes.Vector;

public class TypeCheckerHelper {

    /** Returns an Integer if the given string is an integer, else null. */
    public static Integer parseInt(String val){

        try {
            return Integer.parseInt(val);
        }catch (NumberFormatException e){
            return null;
        }
    }

    /** Returns a GamePiece if the given string is an string, else null. */
    public static GamePiece parseGamePiece(String val){

        //TODO

        return null;
    }

    /** Returns a Vector if the given string is an vector, else null. */
    public static Vector parseVector(String val){
        try {
            StringBuilder xString = new StringBuilder();
            StringBuilder yString = new StringBuilder();
            StringBuilder zString = new StringBuilder();

            int commaCounter = 0;
            for (char c : val.toCharArray()){

                if(c == '(' || c == ')')
                    continue;
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

            if(commaCounter == 2)
                return new Vector(Integer.parseInt(xString.toString()), Integer.parseInt(yString.toString()), Integer.parseInt(zString.toString()));
            if(commaCounter == 1)
                return new Vector(Integer.parseInt(xString.toString()), Integer.parseInt(yString.toString()));
            if(commaCounter == 0)
                throw new IllegalArgumentException(); //TODO Handle: a vector can not be parsed with only an x value. //Can this even happen?
        }catch (NumberFormatException e){
            return null;
        }

        return null;
    }
}
