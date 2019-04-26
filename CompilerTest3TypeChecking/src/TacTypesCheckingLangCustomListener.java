import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.HashMap;

public class TacTypesCheckingLangCustomListener extends TacTypesCheckingBaseListener {

    HashMap<String, ValueContainer> variableMap = new HashMap<>();

    @Override
    public void exitIntDcl(TacTypesCheckingParser.IntDclContext ctx) {
        this.variableMap.put(ctx.LETTER().getText(), new ValueContainer(Integer.parseInt(ctx.DIGIT().getText())));
    }

    @Override
    public void exitFloatDcl(TacTypesCheckingParser.FloatDclContext ctx) {
        this.variableMap.put(ctx.LETTER().getText(), new ValueContainer(Float.parseFloat(ctx.DIGIT().getText())));
    }

    // This gets called when the tree walked exits the print-node
    @Override
    public void exitPrint(TacTypesCheckingParser.PrintContext ctx) {

        if(ctx.PRINT() != null){
            if(this.variableMap.get(ctx.LETTER().getText()) != null){
                System.out.println(this.variableMap.get(ctx.LETTER().getText()).getValue()); //Get the value matches the variable
            }else{
                System.out.println("COMPILER ERROR! The variable does not have a matches id: variableMap does not contain the value matches the string.");
            }
        }
    }

    // An example of type checking on the IntPlus statement. The code is: x + y; This is a valid statement, but is both values of the type int?
    @Override
    public void exitIntPlus(TacTypesCheckingParser.IntPlusContext ctx) {
        if(this.variableMap.get(ctx.LETTER(0).getText()) != null && this.variableMap.get(ctx.LETTER(1).getText()) != null){ //Is both the first and second variable in the variable map?

            //TYPE CHECKING: Is the two variables of the type int?
            if(this.variableMap.get(ctx.LETTER(0).getText()).getIntVal() == null || this.variableMap.get(ctx.LETTER(1).getText()).getIntVal() == null)
                throw new IllegalArgumentException(); //Both variables are not INT! ..todo create custom exceptions.
        }else{
            System.out.println("COMPILER ERROR! The variable does not have a matches id: variableMap does not contain the value matches the string.");
        }


    }
}
