
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;


public class TacTypesLang{

    public static void main(String[] args) {
        try{
            CharStream input = new ANTLRFileStream("testCode2.tac");
            TacTypesLexer lexer = new TacTypesLexer(input);
            TacTypesParser parser = new TacTypesParser(new CommonTokenStream(lexer));
            parser.addParseListener(new TacTypesLangCustomListener());
            parser.start(); // The very first entry to the grammar

        } catch (IOException ex){
            Logger.getLogger(TacTypesLang.class.getName()).log(Level.SEVERE, null, ex); //Reports if no file was found.
        }
    }
}