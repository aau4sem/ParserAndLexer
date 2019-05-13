import java.io.*;
import java.util.ArrayList;

public class Generator {

    private String fileSeparator = System.getProperty("file.separator");
    private String inputFolder;
    private String outputFolder;

    public Generator() {

        //Get folder paths
        String classPath = Generator.class.getProtectionDomain().getCodeSource().getLocation().toString();
        String rootProjectPath = Generator.class.getProtectionDomain().getCodeSource().getLocation().toString().substring(0, classPath.length() - 29);
        rootProjectPath = rootProjectPath.substring(6);
        inputFolder = rootProjectPath + "input/";
        outputFolder = rootProjectPath + "output/";
    }

    public ArrayList<String> removeCommentLines(ArrayList<String> in){
        ArrayList<String> out = new ArrayList<>();

        for(String line : in){
            if(line.charAt(0) == '/' && line.charAt(1) == '/')
                continue;
            else{
                out.add(line);
            }
        }

        return out;
    }

    public void generate(String fileName){

        ArrayList<String> lines = getAllLinesFromFile(inputFolder + fileSeparator + fileName);
        lines = formatLinesToStrings(lines);
        lines = removeCommentLines(lines);
        ArrayList<String> outputLines = generateTestCodeLines(lines);
        writeFile(outputFolder + fileSeparator + "output" + fileName, outputLines);
    }

    public ArrayList<String> formatLinesToStrings(ArrayList<String> in){
        ArrayList<String> out = new ArrayList<>();

        for(String line : in){

            StringBuilder formattetLine = new StringBuilder();

            for(char c : line.toCharArray()){

                if(c == '"')
                    formattetLine.append("\\");

                formattetLine.append(c);
            }

            out.add(formattetLine.toString());
        }

        return out;
    }

    private void writeFile(String desiredPath, ArrayList<String> linesToWrite){

        File file = new File(desiredPath);
        try {
            if(!file.createNewFile()){
                throw new IllegalArgumentException(); //Could not create file
            }
        } catch (IOException e) {
            e.printStackTrace(); //Could not create file
        }

        try {
            FileOutputStream fos = new FileOutputStream(file);
            writeLinesToFos(linesToWrite, fos);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeLinesToFos(ArrayList<String> lines, FileOutputStream fos) throws IOException {
        for(String line : lines){
            fos.write(line.getBytes());
            fos.write("\n".getBytes());
        }
    }

    private ArrayList<String> generateTestCodeLines(ArrayList<String> lines){
        ArrayList<String> generatedLines = new ArrayList<>();

        int counter = 0;

        for(String line : lines){

            generatedLines.add("@Test");
            generatedLines.add("public void test" + counter++ + "() {");
            generatedLines.add("lexer = new TacticLexer(new ANTLRInputStream(\"" + line + "\"));");
            generatedLines.add("}");
        }

        return generatedLines;
    }

    private ArrayList<String> getAllLinesFromFile(String filePath){

        BufferedReader reader = null;
        ArrayList<String> lines = new ArrayList<>();

        try {
            reader = new BufferedReader(new FileReader(filePath));
            String text = null;

            while ((text = reader.readLine()) != null) {
                if(text.length() != 0)
                    lines.add(text + ";");
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
}
