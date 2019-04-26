
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.*;

public class BasicParsingTests {

    private static TacticLexer lexer;
    private static Tactic parser;

    @After
    public void afterEveryTest(){
        parser = new Tactic(new CommonTokenStream(lexer));
        parser.start();
        Assert.assertEquals(0, parser.getNumberOfSyntaxErrors());
    }

    @Test
    public void testTest(){

        //CharStream input = new ANTLRFileStream("FILENAME");

        //ANTLRInputStream input = new ANTLRInputStream("int i = 5;");
        //TacticLexer lexer = new TacticLexer(input);
        TacticLexer lexer = new TacticLexer(new ANTLRInputStream("int i = 5;"));
        Tactic parser = new Tactic(new CommonTokenStream(lexer));
        //parser.addParseListener(); //Not needed for syntax checking
        parser.start();

        Assert.assertEquals(0, parser.getNumberOfSyntaxErrors()); //Better solution exists: https://stackoverflow.com/questions/21661899/get-all-antlr-parsing-errors-as-list-of-string

        //Hint: if you want to re-use the parser+lexer instances, call their 'reset()' methods after setting their input streams.
        //https://stackoverflow.com/questions/18110180/processing-a-string-with-antlr4
    }

    @Test
    public void testTest2(){
        lexer = new TacticLexer(new ANTLRInputStream("int i = 5;"));
    }

    @Test
    public void backgroundImage01() {
        lexer = new TacticLexer(new ANTLRInputStream("levels[0] = " + "\"" + "\\some\\path\\pictures1.jpg" + "\"" + ";"));
    }

    @Test
    public void declaration01() {
        lexer = new TacticLexer(new ANTLRInputStream("int tempInt;"));
    }

    @Test
    public void declaration02() {
        lexer = new TacticLexer(new ANTLRInputStream("float tempFloat;"));
    }

    @Test
    public void declaration03() {
        lexer = new TacticLexer(new ANTLRInputStream("bool tempBool;"));
    }
    @Test
    public void declaration04() {
        lexer = new TacticLexer(new ANTLRInputStream("stringTemp;"));
    }

    @Test
    public void declaration05() {
        lexer = new TacticLexer(new ANTLRInputStream("vector tempVector;"));
    }
    @Test
    public void declaration06() {
        lexer = new TacticLexer(new ANTLRInputStream("GamePiece tempGamePiece;"));
    }


}
