package exceptions;

import model.utils.Argument;

public class IllegalArgumentType extends RuntimeException {
    public IllegalArgumentType(int argumentNumber, String functionName, Argument.ArgumentType... allowedType) {
        super(printErrorMessage(argumentNumber, functionName, allowedType));
    }

    public IllegalArgumentType(int argumentNumber, String functionName, String allowedType) {
        super(printErrorMessage(argumentNumber, functionName, allowedType));
    }

    /** @return an error message used when an argument of a function call is of the wrong type.
     * @param argumentNumber which number the argument is, in the function call. (Counting from 1)
     * @param functionName the name of the function which argument is being checked.
     * @param allowedType a given amount of ArgumentTypes which the given Argument has to be ONE of. */
    private static String printErrorMessage(int argumentNumber, String functionName, Argument.ArgumentType... allowedType){
        StringBuilder sb = new StringBuilder();
        sb.append("The ").append(argumentNumber).append(" argument of the ")
                .append(functionName).append("-action call is not of the type ");

        if(allowedType.length == 1)
            sb.append(allowedType[0].toString()).append(".");
        else{
            for(int i = 0; i < allowedType.length -1; i++)
                sb.append(allowedType[i].toString()).append(" or ");

            sb.append(allowedType[allowedType.length-1]).append(".");
        }

        return sb.toString();
    }

    /** @param allowedType a string containing the allowed types. Format: GamePiece or Integer or Float. */
    private static String printErrorMessage(int argumentNumber, String functionName, String allowedType){
        StringBuilder sb = new StringBuilder();
        sb.append("The ").append(argumentNumber).append(" argument of the ")
                .append(functionName).append("-action call is not of the type ");

        sb.append(allowedType).append(".");

        return sb.toString();
    }
}
