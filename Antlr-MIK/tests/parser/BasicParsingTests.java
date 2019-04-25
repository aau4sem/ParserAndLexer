
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Assert;
import org.junit.Test;

public class BasicParsingTests {

    @Test
    public void testTest(){

        //CharStream input = new ANTLRFileStream("FILENAME");

        ANTLRInputStream input = new ANTLRInputStream("int i = 5;");
        TacticLexer lexer = new TacticLexer(input);
        Tactic parser = new Tactic(new CommonTokenStream(lexer));
        //parser.addParseListener(); //Not needed for syntax checking
        parser.start();

        Assert.assertEquals(0, parser.getNumberOfSyntaxErrors()); //Better solution exists: https://stackoverflow.com/questions/21661899/get-all-antlr-parsing-errors-as-list-of-string

        //Hint: if you want to re-use the parser+lexer instances, call their 'reset()' methods after setting their input streams.
        //https://stackoverflow.com/questions/18110180/processing-a-string-with-antlr4
    }
}
