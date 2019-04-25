


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import gen.*;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;


public class TacLang{

    public static void main(String[] args) {
        try{
            CharStream input = (CharStream) new ANTLRFileStream("testCode.tac");
            TacLexer lexer = new TacLexer(input);
            TacParser parser = new TacParser(new CommonTokenStream(lexer));
            parser.addParseListener(new TacLangCustomListener());
            parser.program();

        } catch (IOException ex){
            Logger.getLogger(TacLang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}