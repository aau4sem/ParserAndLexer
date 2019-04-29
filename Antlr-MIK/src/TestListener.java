public class TestListener extends TacticBaseListener {

    @Override
    public void exitFloatDcl(Tactic.FloatDclContext ctx) {
        System.out.println("FLOAT DCL");
    }
}
