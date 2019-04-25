import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.HashMap;

public class TacTypesLangCustomListener extends TacTypesBaseListener {

    HashMap<String, ValueContainer> variableMap = new HashMap<>();

    @Override
    public void exitIntDcl(TacTypesParser.IntDclContext ctx) {
        this.variableMap.put(ctx.LETTER().getText(), new ValueContainer(Integer.parseInt(ctx.DIGIT().getText())));
    }

    @Override
    public void exitFloatDcl(TacTypesParser.FloatDclContext ctx) {
        this.variableMap.put(ctx.LETTER().getText(), new ValueContainer(Float.parseFloat(ctx.DIGIT().getText())));
    }

    // This gets called when the tree walked exits the print-node
    @Override
    public void exitPrint(TacTypesParser.PrintContext ctx) {

        if(ctx.PRINT() != null){
            if(this.variableMap.get(ctx.LETTER().getText()) != null){
                System.out.println(this.variableMap.get(ctx.LETTER().getText()).getValue()); //Get the value matches the variable
            }else{
                System.out.println("COMPILER ERROR! The variable does not have a matches id: variableMap does not contain the value matches the string.");
            }


        }

    }


}
