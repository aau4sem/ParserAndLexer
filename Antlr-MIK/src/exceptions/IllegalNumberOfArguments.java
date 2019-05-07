package exceptions;

public class IllegalNumberOfArguments extends RuntimeException {

    public IllegalNumberOfArguments(int requiredNumberOfArgument, String functionName, int givenNumberOfArgument) {
        super("The function, " + functionName + ", was called with " + givenNumberOfArgument + " arguments but requires " + requiredNumberOfArgument + ".");
    }
}
