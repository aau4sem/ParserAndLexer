package exceptions;

public class GrammarHasChangedException extends RuntimeException {
    public GrammarHasChangedException() {
        super("The grammar has been changed and the current implementation does not match!");
    }

    public GrammarHasChangedException(String ruleForIncident) {
        super("The grammar has been changed and the current implementation does not match! The exception was thrown then parsing the " + ruleForIncident + "rule.");
    }
}

