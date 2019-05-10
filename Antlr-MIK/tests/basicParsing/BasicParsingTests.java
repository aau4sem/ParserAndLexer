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
        TacticLexer lexer = new TacticLexer(new ANTLRInputStream("int i;"));
        Tactic parser = new Tactic(new CommonTokenStream(lexer));
        //parser.addParseListener(); //Not needed for syntax checking
        parser.prog();

        Assert.assertEquals(0, parser.getNumberOfSyntaxErrors()); //Better solution exists: https://stackoverflow.com/questions/21661899/get-all-antlr-parsing-errors-as-list-of-string

        //Hint: if you want to re-use the parser+lexer instances, call their 'reset()' methods after setting their input streams.
        //https://stackoverflow.com/questions/18110180/processing-a-string-with-antlr4
    }

    @Test
    public void testTest1(){
        lexer = new TacticLexer(new ANTLRInputStream("int i;;"));
    }

    @Test
    public void testTest2(){
        lexer = new TacticLexer(new ANTLRInputStream(";"));
    }

    //Board -----------------------------------------------------------------------------------------------------------------

    @Test
    public void backgroundImage01() {
        lexer = new TacticLexer(new ANTLRInputStream("levels[0] = " + "\"" + "\\some\\path\\pictures1.jpg" + "\"" + ";;"));
    }

    //Declaration -----------------------------------------------------------------------------------------------------------------

    @Test
    public void declaration_variable01() {
        lexer = new TacticLexer(new ANTLRInputStream("int tempInt;;"));
    }

    @Test
    public void declaration_variable02() {
        lexer = new TacticLexer(new ANTLRInputStream("float tempFloat;;"));
    }

    @Test
    public void declaration_variable03() {
        lexer = new TacticLexer(new ANTLRInputStream("bool tempBool;;"));
    }
    @Test
    public void declaration_variable04() {
        lexer = new TacticLexer(new ANTLRInputStream("string stringTemp;;"));
    }

    @Test
    public void declaration_variable05() {
        lexer = new TacticLexer(new ANTLRInputStream("vector tempVector;;"));
    }

    @Test
    public void declaration_variable06() {
        lexer = new TacticLexer(new ANTLRInputStream("GamePiece tempGamePiece;;"));
    }

    @Test
    public void declaration_variable07() {
        lexer = new TacticLexer(new ANTLRInputStream("int[2] tempInt;;"));
    }

    @Test
    public void declaration_variable08() {
        lexer = new TacticLexer(new ANTLRInputStream("float[5] tempFloat;;"));
    }

    @Test
    public void declaration_variable09() {
        lexer = new TacticLexer(new ANTLRInputStream("bool[1] tempBool;;"));
    }
    @Test
    public void declaration_variable10() {
        lexer = new TacticLexer(new ANTLRInputStream("string[7] stringTemp;;"));
    }

    @Test
    public void declaration_variable11() {
        lexer = new TacticLexer(new ANTLRInputStream("vector[2] tempVector;;"));
    }

    @Test
    public void declaration_variable12() {
        lexer = new TacticLexer(new ANTLRInputStream("GamePiece[3] tempGamePiece;;"));
    }

    @Test
    public void declaration_variable13() {
        lexer = new TacticLexer(new ANTLRInputStream("int[4][4] array_2d_test;;"));
    }

    @Test
    public void declaration_variable14() {
        lexer = new TacticLexer(new ANTLRInputStream("int[4][4][5][1][3] array_2d_test;;"));
    }

    @Test
    public void declaration_procedure00(){
        lexer = new TacticLexer(new ANTLRInputStream("test(){x = 5;};;"));
    }

    @Test
    public void declaration_procedure01(){
        lexer = new TacticLexer(new ANTLRInputStream("test(int i, bool f, vector x, float y, string test, GamePiece k){x = 5;};;"));
    }

    @Test
    public void declaration_procedure02(){
        lexer = new TacticLexer(new ANTLRInputStream("test(int i){x = 5;};;"));
    }

    @Test
    public void declaration_procedure03(){
        lexer = new TacticLexer(new ANTLRInputStream("test(bool i){x = 5;};;"));
    }

    @Test
    public void declaration_procedure04(){
        lexer = new TacticLexer(new ANTLRInputStream("test(vector d){x = 5;};;"));
    }

    @Test
    public void declaration_procedure05(){
        lexer = new TacticLexer(new ANTLRInputStream("test(string d){x = 5;};;"));
    }

    @Test
    public void declaration_procedure06(){
        lexer = new TacticLexer(new ANTLRInputStream("test(float d){x = 5;};;"));
    }

    @Test
    public void declaration_procedure07(){
        lexer = new TacticLexer(new ANTLRInputStream("test(GamePiece d){x = 5;};;"));
    }

    @Test
    public void declaration_procedure08(){
        lexer = new TacticLexer(new ANTLRInputStream("test(int[] i){x = 5;};;"));
    }

    @Test
    public void declaration_procedure09(){
        lexer = new TacticLexer(new ANTLRInputStream("test(bool[] i){x = 5;};;"));
    }

    @Test
    public void declaration_procedure10(){
        lexer = new TacticLexer(new ANTLRInputStream("test(vector[] d){x = 5;};;"));
    }

    @Test
    public void declaration_procedure11(){
        lexer = new TacticLexer(new ANTLRInputStream("test(string[] d){x = 5;};;"));
    }

    @Test
    public void declaration_procedure12(){
        lexer = new TacticLexer(new ANTLRInputStream("test(float[] d){x = 5;};;"));
    }

    @Test
    public void declaration_procedure13(){
        lexer = new TacticLexer(new ANTLRInputStream("test(GamePiece[] d){x = 5;};;"));
    }

    @Test
    public void declaration_procedure14(){
        lexer = new TacticLexer(new ANTLRInputStream("test(){x = 5;};;"));
    }

    @Test
    public void declaration_procedure15(){
        lexer = new TacticLexer(new ANTLRInputStream("test(){x = 5 + 5;};;"));
    }

    @Test
    public void declaration_procedure16(){
        lexer = new TacticLexer(new ANTLRInputStream("test(){x.test = 5;};;"));
    }

    @Test
    public void declaration_procedure17(){
        lexer = new TacticLexer(new ANTLRInputStream("test(){x.test = 5 + 5;};;"));
    }

    @Test
    public void declaration_procedure18(){
        lexer = new TacticLexer(new ANTLRInputStream("test(){if(true){i = 5;};};;"));
    }

    @Test
    public void declaration_procedure19(){
        lexer = new TacticLexer(new ANTLRInputStream("test(){if(false){i = 5;}else{i = 6;};};;"));
    }

    @Test
    public void declaration_procedure20(){
        lexer = new TacticLexer(new ANTLRInputStream("test(){while(true){i = 5;};};;"));
    }

    @Test
    public void declaration_procedure21(){
        lexer = new TacticLexer(new ANTLRInputStream("test(){Move();};;"));
    }

    @Test
    public void declaration_procedure22(){
        lexer = new TacticLexer(new ANTLRInputStream("test(){Change();};;"));
    }

    @Test
    public void declaration_procedure23(){
        lexer = new TacticLexer(new ANTLRInputStream("test(){Wait();};;"));
    }

    @Test
    public void declaration_procedure24(){
        lexer = new TacticLexer(new ANTLRInputStream("test(){anotherProcedure();};;"));
    }

    @Test
    public void declaration_procedure25(){
        lexer = new TacticLexer(new ANTLRInputStream("test(){anotherProcedure(x, y, z);};;"));
    }

    //Assignment -----------------------------------------------------------------------------------------------------------------

    @Test
    public void assignment00() {
        lexer = new TacticLexer(new ANTLRInputStream("int intTest1;;"));
    }

    @Test
    public void assignment_int01() {
        lexer = new TacticLexer(new ANTLRInputStream("intTest1 = 2;;"));
    }

    @Test
    public void assignment_int02() {
        lexer = new TacticLexer(new ANTLRInputStream("int_test2 = int_test1 + 3;;"));
    }

    @Test
    public void assignment_int03() {
        lexer = new TacticLexer(new ANTLRInputStream("int_add_test = 1 + 2;;"));
    }

    @Test
    public void assignment_int04() {
        lexer = new TacticLexer(new ANTLRInputStream("int_sub_test = 1 - 3;;"));
    }

    @Test
    public void assignment_int05() {
        lexer = new TacticLexer(new ANTLRInputStream("int_mul_test = 2 * 2;;"));
    }

    @Test
    public void assignment_int06() {
        lexer = new TacticLexer(new ANTLRInputStream("int_div_test = 1 / 4;;"));
    }

    @Test
    public void assignment_int07() {
        lexer = new TacticLexer(new ANTLRInputStream("int_mod_test = 1 % 2;;"));
    }

    @Test
    public void assignment_int08() {
        lexer = new TacticLexer(new ANTLRInputStream("temp_bool = 3 < 2;;"));
    }

    @Test
    public void assignment_int09() {
        lexer = new TacticLexer(new ANTLRInputStream("temp_bool = 1 > 2;;"));
    }

    @Test
    public void assignment_int10() {
        lexer = new TacticLexer(new ANTLRInputStream("temp_bool = 1 == 1;;"));
    }

    @Test
    public void assignment_float00() {
        lexer = new TacticLexer(new ANTLRInputStream("float float_test1;;"));
    }

    @Test
    public void assignment_float01() {
        lexer = new TacticLexer(new ANTLRInputStream("float_test1 = 2.4;;"));
    }

    @Test
    public void assignment_float02() {
        lexer = new TacticLexer(new ANTLRInputStream("float_test2 = float_test1 + 4.3;;"));
    }

    @Test
    public void assignment_float03() {
        lexer = new TacticLexer(new ANTLRInputStream("float_add_test = 1.0 + 1.0;;"));
    }

    @Test
    public void assignment_float04() {
        lexer = new TacticLexer(new ANTLRInputStream("float_sub_test = 1.0 - 1.0;;"));
    }

    @Test
    public void assignment_float05() {
        lexer = new TacticLexer(new ANTLRInputStream("float_mul_test = 1.0 * 1.0;;"));
    }

    @Test
    public void assignment_float06() {
        lexer = new TacticLexer(new ANTLRInputStream("float_div_test = 1.0 / 1.0;;"));
    }

    @Test
    public void assignment_float07() {
        lexer = new TacticLexer(new ANTLRInputStream("temp_bool = 2.0 < 1.0;;"));
    }

    @Test
    public void assignment_float08() {
        lexer = new TacticLexer(new ANTLRInputStream("temp_bool = 2.0 > 2.0;;"));
    }

    @Test
    public void assignment_float09() {
        lexer = new TacticLexer(new ANTLRInputStream("temp_bool = 2.0 ==  2.0;;"));
    }

    @Test
    public void assignment_float10() {
        lexer = new TacticLexer(new ANTLRInputStream("temp_bool = 2.0 ==  2.0;;"));
    }

    @Test
    public void assignment_bool00() {
        lexer = new TacticLexer(new ANTLRInputStream("bool bool_test1;;"));
    }

    @Test
    public void assignment_bool01() {
        lexer = new TacticLexer(new ANTLRInputStream("bool_test1 = true;;"));
    }

    @Test
    public void assignment_bool02() {
        lexer = new TacticLexer(new ANTLRInputStream("bool_test2 = false;;"));
    }

    @Test
    public void assignment_bool03() {
        lexer = new TacticLexer(new ANTLRInputStream("bool_or_test = true || false;;"));
    }

    @Test
    public void assignment_bool04() {
        lexer = new TacticLexer(new ANTLRInputStream("bool_and_test = false && false;;"));
    }

    @Test
    public void assignment_bool05() {
        lexer = new TacticLexer(new ANTLRInputStream("bool_not_test = !true;;"));
    }

    @Test
    public void assignment_bool06() {
        lexer = new TacticLexer(new ANTLRInputStream("temp_bool = true == false;;"));
    }

    @Test
    public void assignment_string00() {
        lexer = new TacticLexer(new ANTLRInputStream("string string_test1;;"));
    }

    @Test
    public void assignment_string01() {
        lexer = new TacticLexer(new ANTLRInputStream("string_test1 = \"\";;"));
    }

    @Test
    public void assignment_string02() {
        lexer = new TacticLexer(new ANTLRInputStream("string_test2 = \"qwerty\";;"));
    }

    @Test
    public void assignment_string03() {
        lexer = new TacticLexer(new ANTLRInputStream("bool_temp = \"qwerty\" == \"qwerty\";;"));
    }

    @Test
    public void assignment_vector00() {
        lexer = new TacticLexer(new ANTLRInputStream("vector vector_test1;;"));
    }

    @Test
    public void assignment_vector01() {
        lexer = new TacticLexer(new ANTLRInputStream("vector_test1 = (1, 2);;"));
    }

    @Test
    public void assignment_vector02() {
        lexer = new TacticLexer(new ANTLRInputStream("vector_test2 = (4, 3, 5);;"));
    }

    @Test
    public void assignment_vector03() {
        lexer = new TacticLexer(new ANTLRInputStream("vector_add_test = (4, 3, 5) + (4, 3, 5);;"));
    }

    @Test
    public void assignment_vector04() {
        lexer = new TacticLexer(new ANTLRInputStream("vector_sub_test = (4, 3, 5) - (4, 3, 5);;"));
    }

    @Test
    public void assignment_vector05() {
        lexer = new TacticLexer(new ANTLRInputStream("bool_temp = (4, 3, 5) == (4, 3, 5);;"));
    }

    @Test
    public void assignment_vector06() {
        lexer = new TacticLexer(new ANTLRInputStream("bool_temp = (4, 3, 5) == (4, 3, 5);;"));
    }

    @Test
    public void assignment_GamePieces01() {
        lexer = new TacticLexer(new ANTLRInputStream("gp_test1.postion = (1,2);;"));
    }

    @Test
    public void assignment_GamePieces02() {
        lexer = new TacticLexer(new ANTLRInputStream("gp_test1.size = 5;;"));
    }

    @Test
    public void assignment_GamePieces03() {
        lexer = new TacticLexer(new ANTLRInputStream("gp_test1.color = \"\";;"));
    }

    @Test
    public void assignment_GamePieces04() {
        lexer = new TacticLexer(new ANTLRInputStream("gp_test1.opasity = 0.5;;"));
    }

    @Test
    public void assignment_GamePieces05() {
        lexer = new TacticLexer(new ANTLRInputStream("gp_test1.label = \"label_text\";;"));
    }


    @Test
    public void assignment_GamePieces06() {
        lexer = new TacticLexer(new ANTLRInputStream("gp_test1.shape = \"\";;"));
    }


    @Test
    public void assignment_dot01() {
        lexer = new TacticLexer(new ANTLRInputStream("temp_int = list_int_test.length;;"));
    }

    // Conditionals -----------------------------------------------------------------------------------------------------------------
    @Test
    public void conditionals_if01() {
        lexer = new TacticLexer(new ANTLRInputStream("if(true){i = 5;};;"));
    }

    @Test
    public void conditionals_if02() {
        lexer = new TacticLexer(new ANTLRInputStream("if(true){i = 4;}else{i = 4;};;"));
    }

    @Test
    public void conditionals_if03() {
        lexer = new TacticLexer(new ANTLRInputStream("if(true){if(true){if(false){i = 5;};};}else{i = 4;};;"));
    }

    @Test
    public void conditionals_if04() {
        lexer = new TacticLexer(new ANTLRInputStream("if(true){while(true){i = 5;};}else{i = 4;};;"));
    }

    @Test
    public void conditionals_if05() {
        lexer = new TacticLexer(new ANTLRInputStream("if(true){i = 4 + 2;}else{i = 4;};;"));
    }

    @Test
    public void conditionals_if06() {
        lexer = new TacticLexer(new ANTLRInputStream("if(true){move(); change(); wait();}else{test(i, x, z);};;"));
    }

    @Test
    public void conditionals_while01() {
        lexer = new TacticLexer(new ANTLRInputStream("while(true){i = 4;};;"));
    }

    @Test
    public void conditionals_while02() {
        lexer = new TacticLexer(new ANTLRInputStream("while(true){while(true){i = 5;};};;"));
    }

    @Test
    public void conditionals_while03() {
        lexer = new TacticLexer(new ANTLRInputStream("while(true){if(true){i = 5;};};;"));
    }

    @Test
    public void conditionals_while04() {
        lexer = new TacticLexer(new ANTLRInputStream("while(true){i = 4 + 5;};;"));
    }

    @Test
    public void conditionals_while05() {
        lexer = new TacticLexer(new ANTLRInputStream("while(true){test();};;"));
    }

    @Test
    public void conditionals_while06() {
        lexer = new TacticLexer(new ANTLRInputStream("while(true){Move(i); Change(i, x, d);};;"));
    }

    // Functions -----------------------------------------------------------------------------------------------------------------
    @Test
    public void procedure_declaration01() {
        lexer = new TacticLexer(new ANTLRInputStream("procedure_test1(){};;"));
    }

    @Test
    public void procedure_declaration02() {
        lexer = new TacticLexer(new ANTLRInputStream("procedure_test2(){ a = 2+2;};;"));
    }

    @Test
    public void procedure_declaration03() {
        lexer = new TacticLexer(new ANTLRInputStream("procedure_test3(int a, float b){ c=b*a;};;"));
    }

    @Test
    public void procedure_declaration04() {
        lexer = new TacticLexer(new ANTLRInputStream("function_test1(GamePiece player){ player.position = (2,2);};;"));
    }

    @Test
    public void procedure_call01() {
        lexer = new TacticLexer(new ANTLRInputStream("procedure();;"));
    }

    @Test
    public void procedure_call02() {
        lexer = new TacticLexer(new ANTLRInputStream("procedure(2);;"));
    }

    @Test
    public void procedure_call03() {
        lexer = new TacticLexer(new ANTLRInputStream("procedure(3,player,5);;"));
    }

    @Test
    public void procedure_call04() {
        lexer = new TacticLexer(new ANTLRInputStream("procedure(a);;"));
    }

    @Test
    public void procedure_call05() {
        lexer = new TacticLexer(new ANTLRInputStream("procedure(2.0);;"));
    }

    @Test
    public void procedure_call06() {
        lexer = new TacticLexer(new ANTLRInputStream("procedure(true);;"));
    }

    @Test
    public void procedure_call07() {
        lexer = new TacticLexer(new ANTLRInputStream("procedure(\"test\");;"));
    }

    // Actions -----------------------------------------------------------------------------------------------------------------
    @Test
    public void action_move01() {
        lexer = new TacticLexer(new ANTLRInputStream("move(temp_GamePiece, temp_vector, temp_int);;"));
    }

    @Test
    public void action_move02() {
        lexer = new TacticLexer(new ANTLRInputStream("move(temp_GamePiece, (2,3,3), 2);;"));
    }

    @Test
    public void action_change01() {
        lexer = new TacticLexer(new ANTLRInputStream("change(temp_GamePiece, temp_string, temp_string, temp_int);;"));
    }

    @Test
    public void action_change02() {
        lexer = new TacticLexer(new ANTLRInputStream("change(temp_GamePiece, \"test\", \"test\", 2);;"));
    }

    // Procedure calls ---------------------------------------------------------------------------------------------
    @Test
    public void procedure_calls01() {
        lexer = new TacticLexer(new ANTLRInputStream("test();;"));
    }

    @Test
    public void procedure_calls02() {
        lexer = new TacticLexer(new ANTLRInputStream("test(2);;"));
    }

    @Test
    public void procedure_calls03() {
        lexer = new TacticLexer(new ANTLRInputStream("test(3.2);;"));
    }

    @Test
    public void procedure_calls04() {
        lexer = new TacticLexer(new ANTLRInputStream("test(true);;"));
    }

    @Test
    public void procedure_calls05() {
        lexer = new TacticLexer(new ANTLRInputStream("test(\"test\");;"));
    }

    @Test
    public void procedure_calls06() {
        lexer = new TacticLexer(new ANTLRInputStream("test((3,4,4));;"));
    }

    @Test
    public void procedure_calls07() {
        lexer = new TacticLexer(new ANTLRInputStream("test((2,3));;"));
    }

    @Test
    public void procedure_calls08() {
        lexer = new TacticLexer(new ANTLRInputStream("test(variable);;"));
    }

    @Test
    public void procedure_calls09() {
        lexer = new TacticLexer(new ANTLRInputStream("test(3.2, variable, 2);;"));
    }

    // Overall parsing ------------------------------------------------------------------------------------------
    @Test
    public void overall01() {
        lexer = new TacticLexer(new ANTLRInputStream("proc(int i){i = 10;}; int x; x = 5; proc(x);;"));
    }

    @Test
    public void overall02() {
        lexer = new TacticLexer(new ANTLRInputStream("proc(int i){i = 10;}; proc2(bool x){x = false;}; int x; x = 5; proc(x); proc2(test); p();;"));
    }

    @Test
    public void overall03() {
        lexer = new TacticLexer(new ANTLRInputStream("int x; int y; x = y;;"));
    }

    @Test
    public void overall04() {
        lexer = new TacticLexer(new ANTLRInputStream("int x; int y; if(true){x = y;};;"));
    }

    @Test
    public void overall05() {
        lexer = new TacticLexer(new ANTLRInputStream("proc(int i){i = 10;}; proc2(bool x){x = false;};;"));
    }
}
