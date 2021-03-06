import codeGeneration.CodeGenerator;
import customListeners.ActionCollectorListener;
import customListeners.BoardListener;
import customListeners.VariableCollectorListener;
import model.dataTypes.GamePiece;
import model.utils.CalculatedCalls;
import model.utils.SortByTime;
import model.utils.buildInFunction.BuildInFunction;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import gen.*;

public class MainClass {

    /** This method will run the entire compiler. */
    public static void main(String[] args) {
        try{
            String inputFile = "Antlr-MIK/compilerInput.tac";
            if(args.length ==1){
                inputFile = args[0];
            }

            //PARSING --------------------------------------------------------
            //Initialize lexer and parser with a file as input
            CharStream input = new ANTLRFileStream(inputFile); //Load an input to compile
            TacticLexer lexer = new TacticLexer(input);  //Create the lexer
            Tactic parser = new Tactic(new CommonTokenStream(lexer)); //Create the parser

            //Initialize the listeners
            VariableCollectorListener variableListener = new VariableCollectorListener(); //Collects variables as they are declared
            ActionCollectorListener actionCollectorListener = new ActionCollectorListener(variableListener); //Collects action-function-calls
            BoardListener boardListener = new BoardListener(); //Collects information about the build-in board
            variableListener.setAcl(actionCollectorListener);
            variableListener.setBl(boardListener);

            //Attach the listeners. This is done to run code on steps of the tree walk.
            parser.addParseListener(variableListener);
            parser.addParseListener(actionCollectorListener);
            parser.addParseListener(boardListener);

            // Run the parser
            parser.prog();

            //CALCULATIONS --------------------------------------------------
            //Get all GamePieces
            ArrayList<GamePiece> gamePieces = variableListener.getAllGamePieces();
            //Get list of collected action-calls
            ArrayList<BuildInFunction> actionCalls = new ArrayList<>(actionCollectorListener.getCollectedActionCalls());
            actionCalls.sort(new SortByTime());

            // Code calculation
            ArrayList<BuildInFunction> calculatedCalls = CalculatedCalls.calculate(actionCalls, gamePieces);

            //CODE GENERATION -----------------------------------------------
            //Get board path
            String boardPath = boardListener.getBoardPath();
            
            //Instantiate and run CodeGenerator
            CodeGenerator cg = new CodeGenerator(gamePieces, boardPath, calculatedCalls);
            cg.generateCompleteFolder();

        } catch (IOException ex){
            Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex); //Reports if no file was found.
        }
    }
}
