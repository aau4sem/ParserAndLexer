
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.*;

public class BasicParsingTests {

    private static TacticLexer lexer;
    private static Tactic parser;

    @BeforeClass
    public static void beforeAllTests(){
        //lexer = new TacticLexer(new ANTLRInputStream("int i = 5;")); //The string should properly be an empty string? Why is that now allowed?
        lexer = new TacticLexer(new ANTLRInputStream("int i = 5;")); //The string should properly be an empty string? Why is that now allowed?
        parser = new Tactic(new CommonTokenStream(lexer));
        //parser.addParseListener(); //Not needed for syntax checking
    }

    @Before
    public void beforeEveryTest(){
        parser.reset();
    }

    @After
    public void afterEveryTest(){
        parser.setInputStream(new CommonTokenStream(lexer));
        parser.start();
        Assert.assertEquals(0, parser.getNumberOfSyntaxErrors());
    }

    /*
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
    }*/

    @Test
    public void testTest2(){
        lexer.setInputStream(new ANTLRInputStream("int i = 5"));
    }
}
