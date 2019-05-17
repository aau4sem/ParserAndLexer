package testUtilities;

import customListeners.ActionCollectorListener;
import customListeners.BoardListener;
import customListeners.VariableCollectorListener;
import gen.Tactic;
import gen.TacticLexer;
import model.dataTypes.GamePiece;
import model.dataTypes.Vector;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Assert;

public class TestUtils {

    public static VariableCollectorListener vcl;
    public static ActionCollectorListener acl;
    public static BoardListener bl;

    /** Parses the given input and the results can be found in the field. */
    public static void parse(String input){
        TacticLexer lexer = new TacticLexer(new ANTLRInputStream(input));
        Tactic parser = new Tactic(new CommonTokenStream(lexer));
        vcl = new VariableCollectorListener();
        acl = new ActionCollectorListener(vcl);
        bl = new BoardListener(vcl);
        parser.addParseListener(vcl);
        parser.addParseListener(acl);
        parser.addParseListener(bl);
        parser.prog();
        Assert.assertEquals(0, parser.getNumberOfSyntaxErrors());
    }

    public static boolean isGamePiecesValuesEqual(GamePiece one, GamePiece two){

        boolean result = true;

        if(one.getName().compareTo(two.getName()) != 0)
            result = false;
        else if(!isVectorsValuesEqual(one.getPosition(), two.getPosition()))
            result = false;
        else if(one.getSize() != two.getSize())
            result = false;
        else if(one.getColor().compareTo(two.getColor()) != 0)
            result = false;
        else if(one.getLabel().compareTo(two.getLabel()) != 0)
            result = false;
        else if(one.getOpacity() != two.getOpacity())
            result = false;

        return result;
    }

    public static boolean isVectorsValuesEqual(Vector one, Vector two){

        boolean result = true;

        if(one.getX() != two.getX())
            result = false;

        if(one.getY() != two.getY())
            result = false;

        if(one.getZ() != two.getZ())
            result = false;

        return result;
    }
}
