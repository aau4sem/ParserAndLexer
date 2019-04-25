import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CharStream;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TacLang{

    public static void main(String[] args) {
        try{
            CharStream input = (CharStream) new ANTLRFileStream("testCode.tac");


        } catch (IOException ex){
            Logger.getLogger(x.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}