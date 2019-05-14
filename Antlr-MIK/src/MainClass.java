import codeGeneration.CodeGenerator;
import customListeners.ActionCollectorListener;
import customListeners.BoardListener;
import customListeners.VariableCollectorListener;
import model.dataTypes.GamePiece;
import model.utils.buildInFunction.BuildInFunction;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import gen.*;

public class MainClass {

    /** This method will run the entire compiler. */
    public static void main(String[] args) {
        try{
            //PARSING --------------------------------------------------------
            //Initialize lexer and parser with a file as input
            CharStream input = new ANTLRFileStream("compilerInput.tac"); //Load an input to compile
            TacticLexer lexer = new TacticLexer(input);  //Create the lexer
            Tactic parser = new Tactic(new CommonTokenStream(lexer)); //Create the parser

            //Initialize the listeners
            VariableCollectorListener variableListener = new VariableCollectorListener(); //Collects variables as they are declared
            ActionCollectorListener actionCollectorListener = new ActionCollectorListener(variableListener); //Collects action-function-calls
            BoardListener boardListener = new BoardListener(); //Collects information about the build-in board

            //Attach the listeners. This is done to run code on steps of the tree walk.
            parser.addParseListener(variableListener);
            parser.addParseListener(actionCollectorListener);
            parser.addParseListener(boardListener);

            // Run the parser
            parser.prog();

            //CALCULATIONS --------------------------------------------------
            //TODO pre-codeGeneration-calculations??? Is this needed??

            //CODE GENERATION -----------------------------------------------
            //Get list of collected action-calls
            ArrayList<BuildInFunction> actionCalls = new ArrayList<>(actionCollectorListener.getActionFunctions());
            //Get the list of paths
            String boardPath = boardListener.getBoardPath();
            //Get all GamePieces
            ArrayList<GamePiece> gamePieces = variableListener.getAllGamePieces();
            //TODO Get other needed data.
            
            //Instantiate and run CodeGenerator
            CodeGenerator cg = new CodeGenerator(gamePieces, boardPath);
            cg.generateCompleteFolder();

        } catch (IOException ex){
            Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex); //Reports if no file was found.
        }
    }

    /* THIS SECTION CONTAINS OLD MAIN-CLASS EXAMPLES:

    //Simple main example:
    CharStream input = new ANTLRFileStream("compilerInput.tac"); //Load an input to compile
    TacticLexer lexer = new TacticLexer(input);  //Create the lexer
    Tactic parser = new Tactic(new CommonTokenStream(lexer)); //Create the parser
    parser.addParseListener(new TypeCheckerListener()); //Attach listener. This is done to run code on steps of the tree walk
    parser.start(); // Run the parser

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



    //This does not work, maybe wrong version of Antlr?
    //https://stackoverflow.com/questions/15050137/once-grammar-is-complete-whats-the-best-way-to-walk-an-antlr-v4-tree
    //Walk the tree multiple times with different listeners
    //ParseTree tree = parser.component();


    */
}
