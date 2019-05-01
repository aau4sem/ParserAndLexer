package codeGeneration;

import model.dataTypes.GamePiece;

import java.io.File;
import java.util.ArrayList;

public class CodeGenerator {

    /** Ali, the JS god, want the following:
     * - GamePieces
     * - Levels of the board
     * - Animations????*/

    private ArrayList<GamePiece> gamePieces;
    private ArrayList<String> gamePieceNames;
    private ArrayList<String> boardPaths;

    public CodeGenerator(ArrayList<GamePiece> gamePieces, ArrayList<String> boardPaths) {
        this.gamePieces = gamePieces;
        this.gamePieceNames = getAllGamePieceNames(gamePieces);
        this.boardPaths = boardPaths;
    }

    public void generateAll(){

        //index.html
        generateLinesForIndexSelector(gamePieceNames);
        generateLinesForIndexObjects(gamePieces);
        generateLinesForIndexButtons(boardPaths.size());

        //stylesheet.css
        generateStringForStylesheetBoard(boardPaths.get(0));
        generateStringsForStylesheetGamePieces(gamePieces);

        //animations.js
        generateStringForAnimationsAnimationList(gamePieces);
        generateStringsForAnimationFunctions(gamePieces);


    }

    public void generateCompleteFolder(){

        //index.html


    }

    //private Stream

    /** @return all names of the given gamePieces. */
    private ArrayList<String> getAllGamePieceNames(ArrayList<GamePiece> gamePieces){
        ArrayList<String> gamePieceNames = new ArrayList<>();

        for(GamePiece gp : gamePieces)
            gamePieceNames.add(gp.getIdentifierName());

        return gamePieceNames;
    }

    //index.html generators ----------------------------------------

    /** @return a list containing the lines for the selector part of the index.html.
     * Format: <option>GamePieceName</option>
     * @param gamePieceNames a list of all names of gamePieces*/
    private ArrayList<String> generateLinesForIndexSelector(ArrayList<String> gamePieceNames){

        ArrayList<String> generatedLines = new ArrayList<>();

        for(String name : gamePieceNames)
            generatedLines.add("<option>" + name + "</option>");

        return generatedLines;
    }

    /** @return a list containing the lines for the objects part of the index.html.
     * Format: <div class:"tag tag tag..">Label</div>
     * @param gamePieces a list of all gamePieces. */
    private ArrayList<String> generateLinesForIndexObjects(ArrayList<GamePiece> gamePieces){

        ArrayList<String> generatedLines = new ArrayList<>();

        for(GamePiece gp : gamePieces){
            StringBuilder sb = new StringBuilder();

            sb.append("<div class=\"");
            //TODO TAGS //TOOD Has to be generated in the css file
            sb.append("\">");
            sb.append(gp.getLabel()); //LABEL
            sb.append("</div>");

            generatedLines.add(sb.toString());
        }

        return generatedLines;
    }

    /** @return a list containing the lines for the button part of the index.html.
     * Format: <button disabled type="button">NUMBER</button>
     * @param numberOfLevels the number of levels. */
    private ArrayList<String> generateLinesForIndexButtons(int numberOfLevels){

        ArrayList<String> generatedLines = new ArrayList<>();

        for(int i = 0; i < numberOfLevels; i++)
            generatedLines.add("<button disabled type=\"button\">" + i+1 + "</button>");

        return generatedLines;
    }

    //stylesheet.css generators ---------------------------------------------------------

    /** @return the .board section of stylesheet.css.
     * @param boardImagePath the path for the background image of the board.
     * //TODO only one level is supported atm.*/
    private String generateStringForStylesheetBoard(String boardImagePath){

        int width = 1000;
        int height = 700;

        StringBuilder sb = new StringBuilder();

        sb.append(".board {\n");
        sb.append("width: ").append(width).append("px;\n");
        sb.append("height: ").append(height).append("px;\n");
        sb.append("display: inline-block;\n");
        sb.append("background-image: url(\"").append(boardImagePath).append("\");\n");
        sb.append("background-size: 100% 100%;\n");
        sb.append("position: relative;\n");
        sb.append("margin: auto;\n");
        sb.append("}\n");

        return sb.toString();
    }

    /**@return a list of strings for the gamePieces part in stylesheet.css.
     * @param gamePieces a list of all gamePieces. */
    private ArrayList<String> generateStringsForStylesheetGamePieces(ArrayList<GamePiece> gamePieces){

        ArrayList<String> generatedStrings = new ArrayList<>();

        for( GamePiece gp : gamePieces){
            StringBuilder sb = new StringBuilder();

            sb.append(".").append(gp.getIdentifierName()).append("{\n");
            //TODO more?
            sb.append("}\n");

            generatedStrings.add(sb.toString());
        }

        return generatedStrings;
    }

    //animations.js generators ---------------------------------
    /** @return a string for the animationsList of the animations.js file.
     * @param gamePieces a list of all GamePieces. */
    private String generateStringForAnimationsAnimationList(ArrayList<GamePiece> gamePieces){
        StringBuilder sb = new StringBuilder();

        sb.append("const animationsList = {\n");

        for(int i = 0; i < gamePieces.size(); i++){
            sb.append(gamePieces.get(i).getIdentifierName()).append(": ").append(gamePieces.get(i).getIdentifierName()).append("()");

            if(i != gamePieces.size() -1)
                sb.append(",\n");
            else
                sb.append("\n");
        }

        sb.append("}\n");

        return sb.toString();
    }

    /** @return a string for the function part of the animations.js file.
     * @param gamePieces a list of all GamePieces. */
    private ArrayList<String> generateStringsForAnimationFunctions(ArrayList<GamePiece> gamePieces){

        ArrayList<String> generatedStrings = new ArrayList<>();

        for(GamePiece gp : gamePieces){
            StringBuilder sb = new StringBuilder();

            sb.append("function ").append(gp.getIdentifierName()).append("() {\n");
            sb.append("return anime({\n");
            sb.append("targets: ").append("'.").append(gp.getIdentifierName()).append("',\n"); //TODO Has to be changed?
            sb.append("keyframes: [\n");
            //TODO keyframes! Format: {left: 20, top: 500, duration: 1000},
            sb.append("],\n");
            sb.append("loop: false,\n");
            sb.append("easing: 'linear',\n");
            sb.append("autoplay: false\n");
            sb.append("});\n");
            sb.append("}");

            generatedStrings.add(sb.toString());
        }

        return generatedStrings;
    }
}
