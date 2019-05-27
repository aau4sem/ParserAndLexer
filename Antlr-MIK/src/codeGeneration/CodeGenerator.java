package codeGeneration;

import model.dataTypes.GamePiece;
import model.utils.buildInFunction.BuildInFunction;
import model.utils.buildInFunction.BuildInFunctionChange;
import model.utils.buildInFunction.BuildInFunctionMove;
import model.utils.buildInFunction.BuildInFunctionWait;

import java.io.*;
import java.lang.reflect.Array;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Comparator;

public class CodeGenerator {

    private String templateDirectoryPath;
    private String outputDirectoryPath;

    private ArrayList<GamePiece> gamePieces;
    private ArrayList<BuildInFunction> actionCalls;
    private ArrayList<String> gamePieceNames;
    private String boardPath;

    private String fileSeparator = System.getProperty("file.separator");

    public CodeGenerator(ArrayList<GamePiece> gamePieces, String boardPath, ArrayList<BuildInFunction> actionCalls) {
        this.gamePieces = gamePieces;
        this.actionCalls = actionCalls;
        this.gamePieceNames = getAllGamePieceNames(gamePieces);
        this.boardPath = boardPath;

        // Get folder paths
        String classPath = CodeGenerator.class.getProtectionDomain().getCodeSource().getLocation().toString();
        String rootProjectPath = CodeGenerator.class.getProtectionDomain().getCodeSource().getLocation().toString().substring(0, classPath.length() - 15);
        rootProjectPath = rootProjectPath.substring(6);

        // When retrieving a path with space within it is translated to %20, we replace these with spaces.
        rootProjectPath = rootProjectPath.replaceAll("%20", " ");

        templateDirectoryPath = rootProjectPath + "webContent/template/";
        outputDirectoryPath = rootProjectPath + "webContent/output/";
    }

    public void generateCompleteFolder(){
        // Delete directory to allow creation of fresh files.
        deleteDirectoryStream(new File(outputDirectoryPath).toPath());

        File folders = new File(outputDirectoryPath + fileSeparator + "css");
        boolean success = folders.mkdirs();
        if(!success)
            throw new IllegalStateException(); // Could not create folders

        // Generate the correct lines for the Index.html file
        // ArrayList<String> buttonLines = generateLinesForIndexButtons(1); Not implemented.
        ArrayList<String> selectorLines = generateLinesForIndexSelector(gamePieceNames);
        ArrayList<String> objectLines = generateLinesForIndexObjects(gamePieces);
        ArrayList<String> outputIndexLines = generateIndexFileStrings(selectorLines, objectLines);

        // Generate the correct lines for the Stylesheet.css file
        ArrayList<String> boardLines = generateStringForStylesheetBoard(boardPath);
        ArrayList<String> gamePiecesLines = generateStringsForStylesheetGamePieces(gamePieces);
        ArrayList<String> outputStylesheetLines = generateStylesheetFileStrings(boardLines, gamePiecesLines);

        // Generate the correct lines for the Animations.js file
        ArrayList<String> animationLines =  generateStringForAnimationsAnimationList(gamePieces);
        ArrayList<String> functionLines = generateStringsForAnimationFunctions(gamePieces, actionCalls);
        ArrayList<String> outputAnimations = generateAnimationsFileStrings(animationLines, functionLines);

        // Write and create the files.
        writeFile(outputDirectoryPath + fileSeparator + "index.html", outputIndexLines); // Index.html
        writeFile(outputDirectoryPath + fileSeparator + "css" + fileSeparator + "stylesheet.css", outputStylesheetLines); // Stylesheet.css
        writeFile(outputDirectoryPath + fileSeparator + "animations.js", outputAnimations); // Animations.js

        // Copy the AnimeJS library.
        File animeFileTemplate = new File(templateDirectoryPath + fileSeparator + "css" + fileSeparator + "anime.js");
        Path animeOutputPath = Paths.get(outputDirectoryPath + fileSeparator + "css" + fileSeparator + "anime.js");
        Path originalPath = animeFileTemplate.toPath();

        try {
            Files.copy(originalPath, animeOutputPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** Deletes all content of the folder at the given path.
     * @param path a path to a folder. */
    private void deleteDirectoryStream(Path path) {
        try {
            Files.walk(path)
                    .sorted(Comparator.reverseOrder())
                    .map(Path::toFile)
                    .forEach(File::delete);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Writes the given list of lines to a file on the given path.
     * @param desiredPath The path that the file should be written to.
     * @param linesToWrite A list of lines that should be written to the file.
     */
    private void writeFile(String desiredPath, ArrayList<String> linesToWrite){
        File file = new File(desiredPath);

        try {
            if(!file.createNewFile()){
                throw new IllegalArgumentException(); //Could not create file
            }
        } catch (IOException e) {
            e.printStackTrace(); // Could not create file
        }

        try {
            FileOutputStream fos = new FileOutputStream(file);
            writeLinesToFos(linesToWrite, fos);
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Writes the given list of lines to the file output stream.
     * @param lines List of lines to be added to the output stream.
     * @param fos File output stream.
     * @throws IOException If something went wrong an IOException is thrown.
     */
    private void writeLinesToFos(ArrayList<String> lines, FileOutputStream fos) throws IOException {
        for(String line : lines){
            fos.write(line.getBytes());
            fos.write("\n".getBytes());
        }
    }

    /** This method finds specific TAGS and change them accordingly within the Animation.js file. */
    private ArrayList<String> generateAnimationsFileStrings(ArrayList<String> animationLines, ArrayList<String> functionLines){

        // Get all lines from the stylesheet template
        ArrayList<String> animationsTemplateLines = getAllLinesFromFile(templateDirectoryPath + "animations.js");

        // Find the "TAGS" and replace with code.
        animationsTemplateLines = replaceTag(animationsTemplateLines, animationLines,"ANIMATIONSLISTTAG");
        animationsTemplateLines = replaceTag(animationsTemplateLines, functionLines,"FUNCTIONTAG");

        return animationsTemplateLines;
    }

    /** This method finds specific TAGS and change them accordingly within the Stylesheet.css file. */
    private ArrayList<String> generateStylesheetFileStrings(ArrayList<String> boardLines, ArrayList<String> gamePieceLines){

        //Get all lines from the stylesheet template
        ArrayList<String> stylesheetTemplateLines = getAllLinesFromFile(templateDirectoryPath + "css/stylesheet.css");

        //Find the "TAGS" and replace with code.
        stylesheetTemplateLines = replaceTag(stylesheetTemplateLines, boardLines,"BOARDTAG");
        stylesheetTemplateLines = replaceTag(stylesheetTemplateLines, gamePieceLines,"GAMEPIECESTAG");

        return stylesheetTemplateLines;
    }

    /** This method finds specific TAGS and change them accordingly within the Index.html file. */
    private ArrayList<String> generateIndexFileStrings(ArrayList<String> selectorLines, ArrayList<String> objectLines){

        //Get all lines from the index template
        ArrayList<String> indexTemplateLines = getAllLinesFromFile(templateDirectoryPath + "index.html");

        //Find the "TAGS" and replace with code.
        //indexTemplateLines = replaceTag(indexTemplateLines, buttonLines, "BUTTONSTAG"); Not yet implemented.
        indexTemplateLines = replaceTag(indexTemplateLines, selectorLines,"SELECTORTAG");
        indexTemplateLines = replaceTag(indexTemplateLines, objectLines, "OBJECTSTAG");

        return indexTemplateLines;
    }

    /** Used when lines has to be placed into a template file.
     * @param sourceStrings contains a strings with the given tag.
     * @param inputStrings the lines that will be replaced where the tag is present in sourceStrings.
     * @param tagToReplace the tag to replace
     * @return sourceStrings where the string matching the given tagToReplace is replaced with all lines in the given inputString. */
    private ArrayList<String> replaceTag(ArrayList<String> sourceStrings, ArrayList<String> inputStrings, String tagToReplace){

        ArrayList<String> endResult = new ArrayList<>();

        for(String sourceLine : sourceStrings){
            //Is the current line the tagToReplace?
            if(sourceLine.trim().compareTo(tagToReplace) == 0){

                //Insert all input strings
                for(String inputLine : inputStrings){
                    endResult.add(inputLine);
                }

            }else{ //If no, add the line to the endResult.
                endResult.add(sourceLine);
            }
        }

        return endResult;
    }

    private ArrayList<String> getAllLinesFromFile(String filePath){

        File file = new File(filePath);

        BufferedReader reader = null;
        ArrayList<String> lines = new ArrayList<>();

        try {
            reader = new BufferedReader(new FileReader(filePath));
            String text = null;

            while ((text = reader.readLine()) != null) {
                lines.add(text);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null){
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return lines;
    }

    /** @return all names of the given gamePieces. */
    private ArrayList<String> getAllGamePieceNames(ArrayList<GamePiece> gamePieces){
        ArrayList<String> gamePieceNames = new ArrayList<>();

        for(GamePiece gp : gamePieces)
            gamePieceNames.add(gp.getName());

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

            sb.append("<div class=\"GamePiece ");
            sb.append(gp.getName());
            sb.append(" ").append(gp.getShape());
            sb.append("\">");
            sb.append("<p class=\"label\">");
            sb.append(gp.getLabel()); //LABEL
            sb.append("</p></div>");

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
            generatedLines.add("<button disabled type=\"button\">" + (i+1) + "</button>");

        return generatedLines;
    }

    //stylesheet.css generators ---------------------------------------------------------

    /** @return the .board section of stylesheet.css.
     * @param boardImagePath the path for the background image of the board. */
    private ArrayList<String> generateStringForStylesheetBoard(String boardImagePath){

        ArrayList<String> generatedLines = new ArrayList<>();

        // Dimensions of the desired board size.
        int width = 1000;
        int height = 700;

        generatedLines.add(".board {");
        generatedLines.add("width: " + width + "px;");
        generatedLines.add("height: " + height + "px;");
        generatedLines.add("display: inline-block;");
        generatedLines.add("background-image: url(\"" + boardImagePath + "\");");
        generatedLines.add("background-size: 100% 100%;");
        generatedLines.add("position: relative;");
        generatedLines.add("margin: auto;");
        generatedLines.add("border: #555555 1px solid;");
        generatedLines.add("background-color: linen;");
        generatedLines.add("}");

        return generatedLines;
    }

    /**@return a list of strings for the gamePieces part in stylesheet.css.
     * @param gamePieces a list of all gamePieces. */
    private ArrayList<String> generateStringsForStylesheetGamePieces(ArrayList<GamePiece> gamePieces){

        ArrayList<String> generatedStrings = new ArrayList<>();

        for( GamePiece gp : gamePieces){
            StringBuilder sb = new StringBuilder();

            sb.append(".").append(gp.getName()).append("{\n");
            sb.append("background-color: ").append(gp.getColor()).append(";\n");
            sb.append("left: ").append(gp.getPosition().getX()).append("px;\n");
            sb.append("top: ").append(gp.getPosition().getY()).append("px;\n");
            sb.append("opacity: ").append(gp.getOpacity()).append(";\n");
            sb.append("}\n");

            generatedStrings.add(sb.toString());
        }

        return generatedStrings;
    }


    /** @return a list of strings for the animationsList of the animations.js file.
     * @param gamePieces a list of all GamePieces. */
    private ArrayList<String> generateStringForAnimationsAnimationList(ArrayList<GamePiece> gamePieces){

        ArrayList<String> generatedLines = new ArrayList<>();

        generatedLines.add("const animationsList = {");

        for(int i = 0; i < gamePieces.size(); i++){

            String lineToAdd = gamePieces.get(i).getName() + ": " + gamePieces.get(i).getName() + "()";

            if(i != gamePieces.size() -1)
                lineToAdd = lineToAdd + ",";

            generatedLines.add(lineToAdd);
        }

        generatedLines.add("};\n");

        return generatedLines;
    }

    /** @return a string for the function part of the animations.js file.
     * @param gamePieces a list of all GamePieces. */

    /**
     * This method generates and formats all animation actions for a GamePiece.
     * They follow a specific format that has been structured within the DOM and therefore is iterated upon several times.
     * @param gamePieces List of all GamePieces
     * @param actionCalls List of all actions.
     */
    private ArrayList<String> generateStringsForAnimationFunctions(ArrayList<GamePiece> gamePieces, ArrayList<BuildInFunction> actionCalls){
        ArrayList<String> generatedStrings = new ArrayList<>();

        for(GamePiece gp : gamePieces){
            StringBuilder sb = new StringBuilder();

            sb.append("function ").append(gp.getName()).append("() {\n");
            sb.append("return anime({\n");
            sb.append("targets: ").append("'.").append(gp.getName()).append("',\n");
            sb.append("keyframes: [\n");

            // Iterate through all actions and the ones that are to be added to keyframes are then appended.
            for (BuildInFunction action : actionCalls){
                if (action instanceof BuildInFunctionMove || action instanceof BuildInFunctionWait || ((BuildInFunctionChange) action).getSecondArgument() == GamePiece.GamePiecePropertyType.POSITION){
                    if (action.getGp().getName().compareTo(gp.getName()) == 0){
                        sb.append("{").append(action.toKeyframe()).append("}, \n");
                    }
                }
            }

            sb.append("],\n");
            sb.append("scale: [\n");

            // Iterate through all actions and add the ones that change the scale of a GamePiece.
            for (BuildInFunction action : actionCalls){
                if (action instanceof BuildInFunctionChange && (((BuildInFunctionChange) action).getSecondArgument() == GamePiece.GamePiecePropertyType.SIZE)){
                    if (action.getGp().getName().compareTo(gp.getName()) == 0){
                        sb.append("{").append(action.toKeyframe()).append("}, \n");
                    }
                }
            }

            sb.append("{}\n");
            sb.append("],\n");
            sb.append("backgroundColor: [\n");

            // Iterate through all actions and add the ones that change the color of a GamePiece.
            for (BuildInFunction action : actionCalls){
                if (action instanceof BuildInFunctionChange && (((BuildInFunctionChange) action).getSecondArgument() == GamePiece.GamePiecePropertyType.COLOR)){
                    if (action.getGp().getName().compareTo(gp.getName()) == 0){
                        sb.append("{").append(action.toKeyframe()).append("}, \n");
                    }
                }
            }

            sb.append("{}\n");
            sb.append("],\n");
            sb.append("opacity: [\n");

            // Iterate through all actions and add the ones that change the opacity of a GamePiece.
            for (BuildInFunction action : actionCalls){
                if (action instanceof BuildInFunctionChange && (((BuildInFunctionChange) action).getSecondArgument() == GamePiece.GamePiecePropertyType.OPACITY)){
                    if (action.getGp().getName().compareTo(gp.getName()) == 0){
                        sb.append("{").append(action.toKeyframe()).append("}, \n");
                    }
                }
            }

            sb.append("{}\n");
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
