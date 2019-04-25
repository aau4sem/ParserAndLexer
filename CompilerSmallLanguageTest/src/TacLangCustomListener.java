import gen.TacBaseListener;
import gen.TacParser;

import java.util.HashMap;

public class TacLangCustomListener extends TacBaseListener {

    HashMap<String, Integer> variableMap = new HashMap<>();

    @Override
    public void exitShow(TacParser.ShowContext ctx) {
        if(ctx.INT() != null){
            System.out.println(ctx.INT().getText());
        }
        else if(ctx.VAR() != null){
            System.out.println(this.variableMap.get(ctx.VAR().getText()));
        }
    }

    @Override
    public void exitLet(TacParser.LetContext ctx) {
        this.variableMap.put(ctx.VAR().getText(),
                Integer.parseInt(ctx.INT().getText()));
    }
}
