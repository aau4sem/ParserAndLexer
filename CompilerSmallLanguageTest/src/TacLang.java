import org.antlr.runtime.ANTLRFileStream;

public class TacLang{

    public static void main(String[] args) {
        try{
            CharStream input = (CharStream) new ANTLRFileStream("testCode.tac");
        }
    }
}