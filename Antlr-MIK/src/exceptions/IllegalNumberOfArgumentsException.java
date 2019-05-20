package exceptions;

public class IllegalNumberOfArgumentsException extends RuntimeException {

    public IllegalNumberOfArgumentsException(int requiredNumberOfArgument, String functionName, int givenNumberOfArgument) {
        super("The function, " + functionName + ", was called with " + givenNumberOfArgument + " arguments but requires " + requiredNumberOfArgument + ".");
    }
}
