package basicParsing;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.*;
import gen.*;

public class BasicParsingTests {

    private static TacticLexer lexer;
    private static Tactic parser;

    @After
    public void afterEveryTest(){
        parser = new Tactic(new CommonTokenStream(lexer));
        parser.prog();
        Assert.assertEquals(0, parser.getNumberOfSyntaxErrors());
    }

    public void testTest(){

        //CharStream input = new ANTLRFileStream("FILENAME");

        //ANTLRInputStream input = new ANTLRInputStream("int i = 5;");
        //TacticLexer lexer = new TacticLexer(input);
        TacticLexer lexer = new TacticLexer(new ANTLRInputStream("int i = 5;"));
        Tactic parser = new Tactic(new CommonTokenStream(lexer));
        //parser.addParseListener(); //Not needed for syntax checking
        parser.prog();

        Assert.assertEquals(0, parser.getNumberOfSyntaxErrors()); //Better solution exists: https://stackoverflow.com/questions/21661899/get-all-antlr-parsing-errors-as-list-of-string

        //Hint: if you want to re-use the parser+lexer instances, call their 'reset()' methods after setting their input streams.
        //https://stackoverflow.com/questions/18110180/processing-a-string-with-antlr4
    }

    @Test
    public void testTest1(){
        lexer = new TacticLexer(new ANTLRInputStream("int i = 5;"));
    }

    @Test
    public void testTest2(){
        lexer = new TacticLexer(new ANTLRInputStream(""));
    }

    //Board -----------------------------------------------------------------------------------------------------------------

    @Test
    public void backgroundImage01() {
        lexer = new TacticLexer(new ANTLRInputStream("levels[0] = " + "\"" + "\\some\\path\\pictures1.jpg" + "\"" + ";"));
    }

    //Declaration -----------------------------------------------------------------------------------------------------------------

    @Test
    public void declaration01() {
        lexer = new TacticLexer(new ANTLRInputStream("int tempInt;"));
    }

    @Test
    public void declaration02() {
        lexer = new TacticLexer(new ANTLRInputStream("float tempFloat;"));
    }

    @Test
    public void declaration03() {
        lexer = new TacticLexer(new ANTLRInputStream("bool tempBool;"));
    }
    @Test
    public void declaration04() {
        lexer = new TacticLexer(new ANTLRInputStream("stringTemp;"));
    }

    @Test
    public void declaration05() {
        lexer = new TacticLexer(new ANTLRInputStream("vector tempVector;"));
    }

    @Test
    public void declaration06() {
        lexer = new TacticLexer(new ANTLRInputStream("GamePiece tempGamePiece;"));
    }

    //Build-in types -----------------------------------------------------------------------------------------------------------------

    @Test
    public void buildInType_int00() {
        lexer = new TacticLexer(new ANTLRInputStream("intTest1 = 2;"));
    }

    @Test
    public void buildInType_int01() {
        lexer = new TacticLexer(new ANTLRInputStream("int intTest1 = 2;"));
    }

    @Test
    public void buildInType_int02() {
        lexer = new TacticLexer(new ANTLRInputStream("int int_test2 = int_test1 + 3;"));
    }

    @Test
    public void buildInType_int03() {
        lexer = new TacticLexer(new ANTLRInputStream("int int_add_test = 1 + 2;"));
    }

    @Test
    public void buildInType_int04() {
        lexer = new TacticLexer(new ANTLRInputStream("int int_sub_test = 1 - 3;"));
    }

    @Test
    public void buildInType_int05() {
        lexer = new TacticLexer(new ANTLRInputStream("int int_mul_test = 2 * 2;"));
    }

    @Test
    public void buildInType_int06() {
        lexer = new TacticLexer(new ANTLRInputStream("int int_div_test = 1 / 4;"));
    }

    @Test
    public void buildInType_int07() {
        lexer = new TacticLexer(new ANTLRInputStream("int int_mod_test = 1 % 2;"));
    }

    @Test
    public void buildInType_int08() {
        lexer = new TacticLexer(new ANTLRInputStream("temp_bool = 3 < 2;"));
    }

    @Test
    public void buildInType_int09() {
        lexer = new TacticLexer(new ANTLRInputStream("temp_bool = 1 > 2;"));
    }

    @Test
    public void buildInType_int10() {
        lexer = new TacticLexer(new ANTLRInputStream("temp_bool = 1 == 1;"));
    }

    @Test
    public void buildInType_float00() {
        lexer = new TacticLexer(new ANTLRInputStream("float_test1 = 2.4;"));
    }

    @Test
    public void buildInType_float01() {
        lexer = new TacticLexer(new ANTLRInputStream("float float_test1 = 2.4;"));
    }

    @Test
    public void buildInType_float02() {
        lexer = new TacticLexer(new ANTLRInputStream("float float_test2 = float_test1 + 4.3;"));
    }

    @Test
    public void buildInType_float03() {
        lexer = new TacticLexer(new ANTLRInputStream("float float_add_test = 1.0 + 1.0;"));
    }

    @Test
    public void buildInType_float04() {
        lexer = new TacticLexer(new ANTLRInputStream("float float_sub_test = 1.0 - 1.0;"));
    }

    @Test
    public void buildInType_float05() {
        lexer = new TacticLexer(new ANTLRInputStream("float float_mul_test = 1.0 * 1.0;"));
    }

    @Test
    public void buildInType_float06() {
        lexer = new TacticLexer(new ANTLRInputStream("float float_div_test = 1.0 / 1.0;"));
    }

    @Test
    public void buildInType_float07() {
        lexer = new TacticLexer(new ANTLRInputStream("temp_bool = 2.0 < 1.0;"));
    }

    @Test
    public void buildInType_float08() {
        lexer = new TacticLexer(new ANTLRInputStream("temp_bool = 2.0 >  2.0;"));
    }

    @Test
    public void buildInType_float09() {
        lexer = new TacticLexer(new ANTLRInputStream("temp_bool = 2.0 ==  2.0;"));
    }

    @Test
    public void buildInType_float10() {
        lexer = new TacticLexer(new ANTLRInputStream("temp_bool = 2.0 ==  2.0;"));
    }

    @Test
    public void buildInType_bool00() {
        lexer = new TacticLexer(new ANTLRInputStream("bool_test1 = true;"));
    }

    @Test
    public void buildInType_bool01() {
        lexer = new TacticLexer(new ANTLRInputStream("bool bool_test1 = true;"));
    }

    @Test
    public void buildInType_bool02() {
        lexer = new TacticLexer(new ANTLRInputStream("bool bool_test2 = false;"));
    }

    @Test
    public void buildInType_bool03() {
        lexer = new TacticLexer(new ANTLRInputStream("bool bool_or_test = true || false;"));
    }

    @Test
    public void buildInType_bool04() {
        lexer = new TacticLexer(new ANTLRInputStream("bool bool_and_test = false && false;"));
    }

    @Test
    public void buildInType_bool05() {
        lexer = new TacticLexer(new ANTLRInputStream("bool bool_not_test = !true;"));
    }

    @Test
    public void buildInType_bool06() {
        lexer = new TacticLexer(new ANTLRInputStream("temp_bool = true == false;"));
    }

    @Test
    public void buildInType_string00() {
        lexer = new TacticLexer(new ANTLRInputStream("string_test1 = \"\";"));
    }

    @Test
    public void buildInType_string01() {
        lexer = new TacticLexer(new ANTLRInputStream("string string_test1 = \"\";"));
    }

    @Test
    public void buildInType_string02() {
        lexer = new TacticLexer(new ANTLRInputStream("string string_test2 = \"qwerty\";"));
    }

    @Test
    public void buildInType_string03() {
        lexer = new TacticLexer(new ANTLRInputStream("bool_temp = \"qwerty\" == \"qwerty\";"));
    }

    @Test
    public void buildInType_vector00() {
        lexer = new TacticLexer(new ANTLRInputStream("vector_test1 = (1, 2);"));
    }

    @Test
    public void buildInType_vector01() {
        lexer = new TacticLexer(new ANTLRInputStream("vector vector_test1 = (1, 2);"));
    }

    @Test
    public void buildInType_vector02() {
        lexer = new TacticLexer(new ANTLRInputStream("vector vector_test2 = (4, 3, 5);"));
    }

    @Test
    public void buildInType_vector03() {
        lexer = new TacticLexer(new ANTLRInputStream("vector vector_add_test = (4, 3, 5) + (4, 3, 5);"));
    }

    @Test
    public void buildInType_vector04() {
        lexer = new TacticLexer(new ANTLRInputStream("vector vector_sub_test = (4, 3, 5) - (4, 3, 5);"));
    }

    @Test
    public void buildInType_vector05() {
        lexer = new TacticLexer(new ANTLRInputStream("bool_temp = (4, 3, 5) == (4, 3, 5);"));
    }

    @Test
    public void buildInType_vector06() {
        lexer = new TacticLexer(new ANTLRInputStream("bool_temp = (4, 3, 5) == (4, 3, 5);"));
    }

    @Test
    public void buildInType_GamePieces01() {
        lexer = new TacticLexer(new ANTLRInputStream("gp_test1.postion = (1,2);"));
    }

    @Test
    public void buildInType_GamePieces02() {
        lexer = new TacticLexer(new ANTLRInputStream("gp_test1.size = 5;"));
    }

    @Test
    public void buildInType_GamePieces03() {
        lexer = new TacticLexer(new ANTLRInputStream("gp_test1.color = \"\";"));
    }

    @Test
    public void buildInType_GamePieces04() {
        lexer = new TacticLexer(new ANTLRInputStream("gp_test1.opasity = 0.5;"));
    }

    @Test
    public void buildInType_GamePieces05() {
        lexer = new TacticLexer(new ANTLRInputStream("gp_test1.label = \"label_text\";"));
    }

    @Test
    public void buildInType_GamePieces06() {
        lexer = new TacticLexer(new ANTLRInputStream("gp_test1.shape = \"\";"));
    }

    @Test
    public void buildInType_List01() {
        lexer = new TacticLexer(new ANTLRInputStream("int[5] list_int_test;"));
    }

    @Test
    public void buildInType_List02() {
        lexer = new TacticLexer(new ANTLRInputStream("List[float] list_float_test;"));
    }

    @Test
    public void buildInType_List03() {
        lexer = new TacticLexer(new ANTLRInputStream("List[bool] list_bool_test;"));
    }

    @Test
    public void buildInType_List04() {
        lexer = new TacticLexer(new ANTLRInputStream("List[vector] list_vector_test;"));
    }

    @Test
    public void buildInType_List05() {
        lexer = new TacticLexer(new ANTLRInputStream("List[GamePiece] list_gp_test;"));
    }

    @Test
    public void buildInType_List06() {
        lexer = new TacticLexer(new ANTLRInputStream("List[List[int]];"));
    }

    @Test
    public void buildInType_List07() {
        lexer = new TacticLexer(new ANTLRInputStream("list_int_test[1] = 4;"));
    }

    @Test
    public void buildInType_List08() {
        lexer = new TacticLexer(new ANTLRInputStream("temp_int = list_int_test[1];"));
    }

    @Test
    public void buildInType_List09() {
        lexer = new TacticLexer(new ANTLRInputStream("temp_int = list_int_test.length;"));
    }

    // Typecasting -----------------------------------------------------------------------------------------------------------------
    @Test
    public void typeCasting01() {
        lexer = new TacticLexer(new ANTLRInputStream("float int_to_float_test1 = 5;"));
    }

    @Test
    public void typeCasting02() {
        lexer = new TacticLexer(new ANTLRInputStream("int float_to_int_test2 = 5.4;"));
    }

    // Conditionals -----------------------------------------------------------------------------------------------------------------
    @Test
    public void conditionals_if01() {
        lexer = new TacticLexer(new ANTLRInputStream("if(true){};"));
    }

    @Test
    public void conditionals_if02() {
        lexer = new TacticLexer(new ANTLRInputStream("if(true){}elseif(true){}else{};"));
    }

    @Test
    public void conditionals_if03() {
        lexer = new TacticLexer(new ANTLRInputStream("if(true){}else{};"));
    }

    @Test
    public void conditionals_if04() {
        lexer = new TacticLexer(new ANTLRInputStream("if(false){}elseif(true){}elseif(false){}elseif(true){}elseif(true){}elseif(false){}else{};"));
    }

    @Test
    public void conditionals_while01() {
        lexer = new TacticLexer(new ANTLRInputStream("while(true){};"));
    }

    // Functions -----------------------------------------------------------------------------------------------------------------
    @Test
    public void function_declaration01() {
        lexer = new TacticLexer(new ANTLRInputStream("void function_test1(){};"));
    }

    @Test
    public void function_declaration02() {
        lexer = new TacticLexer(new ANTLRInputStream("int function_test1(){ return 2;};"));
    }

    @Test
    public void function_declaration03() {
        lexer = new TacticLexer(new ANTLRInputStream("float function_test1(){ return 2.0;};"));
    }

    @Test
    public void function_declaration04() {
        lexer = new TacticLexer(new ANTLRInputStream("bool function_test1(){ return true;};"));
    }

    @Test
    public void function_call01() {
        lexer = new TacticLexer(new ANTLRInputStream("int test = function();"));
    }

    @Test
    public void function_call02() {
        lexer = new TacticLexer(new ANTLRInputStream("int test = function(2);"));
    }

    @Test
    public void function_call03() {
        lexer = new TacticLexer(new ANTLRInputStream("test = function();"));
    }

    @Test
    public void function_call04() {
        lexer = new TacticLexer(new ANTLRInputStream("test = function(2);"));
    }

    @Test
    public void function_call05() {
        lexer = new TacticLexer(new ANTLRInputStream("test = function(2.0);"));
    }

    @Test
    public void function_call06() {
        lexer = new TacticLexer(new ANTLRInputStream("test = function(true);"));
    }

    @Test
    public void function_call07() {
        lexer = new TacticLexer(new ANTLRInputStream("test = function(\"test\");"));
    }

    // Actions -----------------------------------------------------------------------------------------------------------------
    @Test
    public void action_move01() {
        lexer = new TacticLexer(new ANTLRInputStream("Move(temp_GamePiece, temp_vector, temp_int);"));
    }

    @Test
    public void action_move02() {
        lexer = new TacticLexer(new ANTLRInputStream("Move(temp_GamePiece, (2,3,3), 2);"));
    }

    @Test
    public void action_change01() {
        lexer = new TacticLexer(new ANTLRInputStream("Change(temp_GamePiece, temp_string, temp_string, temp_int);"));
    }

    @Test
    public void action_change02() {
        lexer = new TacticLexer(new ANTLRInputStream("Change(temp_GamePiece, \"test\", \"test\", 2);"));
    }
}
