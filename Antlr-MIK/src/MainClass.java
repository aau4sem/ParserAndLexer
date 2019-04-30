import CustomListeners.VariableCollectorListener;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import gen.*;

public class MainClass {

    /** This method will run the entire compiler. */
    public static void main(String[] args) {
        try{
            /* Simple main example:
            CharStream input = new ANTLRFileStream("compilerInput.tac"); //Load an input to compile
            TacticLexer lexer = new TacticLexer(input);  //Create the lexer
            Tactic parser = new Tactic(new CommonTokenStream(lexer)); //Create the parser
            parser.addParseListener(new TypeCheckerListener()); //Attach listener. This is done to run code on steps of the tree walk
            parser.start(); // Run the parser
            */

            //Main example with multiple listeners/parses:
            CharStream input = new ANTLRFileStream("compilerInput.tac"); //Load an input to compile
            TacticLexer lexer = new TacticLexer(input);  //Create the lexer
            Tactic parser = new Tactic(new CommonTokenStream(lexer)); //Create the parser
            //Listener 1
            TypeCheckerListener listener1 = new TypeCheckerListener();
            parser.addParseListener(listener1); //Attach listener. This is done to run code on steps of the tree walk
            parser.prog(); // Run the parser
            parser.removeParseListener(listener1);
            //Listener 2
            parser.reset();
            TestListener listener2 = new TestListener();
            parser.addParseListener(listener2);
            parser.prog();

            //Example using new VariableCollectorListener
            /*
            CharStream input = new ANTLRFileStream("compilerInput.tac"); //Load an input to compile
            TacticLexer lexer = new TacticLexer(input);  //Create the lexer
            Tactic parser = new Tactic(new CommonTokenStream(lexer)); //Create the parser
            //Listener 1
            VariableCollectorListener variableListener = new VariableCollectorListener();
            parser.addParseListener(variableListener); //Attach listener. This is done to run code on steps of the tree walk
            parser.prog(); // Run the parser*/



            //https://stackoverflow.com/questions/15050137/once-grammar-is-complete-whats-the-best-way-to-walk-an-antlr-v4-tree
            //Walk the tree multiple times with different listeners
            //ParseTree tree = parser.component();

            // MAYBE THIS STRUCTURE: CREATE THE TREE -> COLLECT VARIABLES AND FUNCTIONS with scope data -> type checking -> semantics check?

        } catch (IOException ex){
            Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex); //Reports if no file was found.
        }
    }
}
