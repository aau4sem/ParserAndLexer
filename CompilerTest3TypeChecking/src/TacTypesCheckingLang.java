
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;


public class TacTypesCheckingLang {

    public static void main(String[] args) {
        try{
            CharStream input = new ANTLRFileStream("testCode3.tac");
            TacTypesCheckingLexer lexer = new TacTypesCheckingLexer(input);
            TacTypesCheckingParser parser = new TacTypesCheckingParser(new CommonTokenStream(lexer));
            parser.addParseListener(new TacTypesCheckingLangCustomListener());
            parser.start(); // The very first entry to the grammar

        } catch (IOException ex){
            Logger.getLogger(TacTypesCheckingLang.class.getName()).log(Level.SEVERE, null, ex); //Reports if no file was found.
        }
    }
}