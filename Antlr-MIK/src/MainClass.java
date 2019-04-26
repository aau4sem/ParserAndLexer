import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

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
            //parser.start(); // Run the parser

            //https://stackoverflow.com/questions/15050137/once-grammar-is-complete-whats-the-best-way-to-walk-an-antlr-v4-tree
            //Walk the tree multiple times with different listeners
            //ParseTree tree = parser.component();

        } catch (IOException ex){
            Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex); //Reports if no file was found.
        }
    }
}
