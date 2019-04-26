import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainClass {

    /** This method will run the entire compiler. */
    public static void main(String[] args) {
        try{
            CharStream input = new ANTLRFileStream("compilerInput.tac"); //Load an input to compile
            TacticLexer lexer = new TacticLexer(input);  //Create the lexer
            Tactic parser = new Tactic(new CommonTokenStream(lexer)); //Create the parser
            //parser.addParseListener(new TacTypesCheckingLangCustomListener()); //Attach listener. This is done to run code on steps of the tree walk
            parser.start(); // Run the parser

        } catch (IOException ex){
            Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex); //Reports if no file was found.
        }
    }
}
