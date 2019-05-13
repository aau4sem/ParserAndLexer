package basicParsing;

import gen.Tactic;
import gen.TacticLexer;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class BasicParsingTests2 {

    private static TacticLexer lexer;
    private static Tactic parser;

    @After
    public void afterEveryTest(){
        parser = new Tactic(new CommonTokenStream(lexer));
        parser.prog();
        Assert.assertEquals(0, parser.getNumberOfSyntaxErrors());
    }

    @Test
    public void test0() {
        lexer = new TacticLexer(new ANTLRInputStream("int temp_int;;"));
    }
    @Test
    public void test1() {
        lexer = new TacticLexer(new ANTLRInputStream("float temp_float;;"));
    }
    @Test
    public void test2() {
        lexer = new TacticLexer(new ANTLRInputStream("bool temp_bool;;"));
    }
    @Test
    public void test3() {
        lexer = new TacticLexer(new ANTLRInputStream("string string_temp;;"));
    }
    @Test
    public void test4() {
        lexer = new TacticLexer(new ANTLRInputStream("vector temp_vector;;"));
    }
    @Test
    public void test5() {
        lexer = new TacticLexer(new ANTLRInputStream("GamePiece temp_GamePiece;;"));
    }
    @Test
    public void test6() {
        lexer = new TacticLexer(new ANTLRInputStream("float int_to_float_test1;;"));
    }
    @Test
    public void test7() {
        lexer = new TacticLexer(new ANTLRInputStream("int float_to_int_test2;;"));
    }
    @Test
    public void test8() {
        lexer = new TacticLexer(new ANTLRInputStream("int[10] arr_int_test;;"));
    }
    @Test
    public void test9() {
        lexer = new TacticLexer(new ANTLRInputStream("float[10] arr_float_test;;"));
    }
    @Test
    public void test10() {
        lexer = new TacticLexer(new ANTLRInputStream("bool[10] arr_bool_test;;"));
    }
    @Test
    public void test11() {
        lexer = new TacticLexer(new ANTLRInputStream("vector[10] arr_vector_test;;"));
    }
    @Test
    public void test12() {
        lexer = new TacticLexer(new ANTLRInputStream("GamePiece[10] arr_gp_test;;"));
    }
    @Test
    public void test13() {
        lexer = new TacticLexer(new ANTLRInputStream("int[2][2] mul_arr_test;;"));
    }
    @Test
    public void test14() {
        lexer = new TacticLexer(new ANTLRInputStream("procedure_test1(){};;"));
    }
    @Test
    public void test15() {
        lexer = new TacticLexer(new ANTLRInputStream("procedure_test2(int x, string b){};;"));
    }
    @Test
    public void test16() {
        lexer = new TacticLexer(new ANTLRInputStream("temp_int = 2;;"));
    }
    @Test
    public void test17() {
        lexer = new TacticLexer(new ANTLRInputStream("temp_int = temp_int + 3;;"));
    }
    @Test
    public void test18() {
        lexer = new TacticLexer(new ANTLRInputStream("temp_int = temp_int + temp_int;;"));
    }
    @Test
    public void test19() {
        lexer = new TacticLexer(new ANTLRInputStream("temp_int = temp_int - temp_int;;"));
    }
    @Test
    public void test20() {
        lexer = new TacticLexer(new ANTLRInputStream("temp_int = temp_int * temp_int;;"));
    }
    @Test
    public void test21() {
        lexer = new TacticLexer(new ANTLRInputStream("temp_int = temp_int / temp_int;;"));
    }
    @Test
    public void test22() {
        lexer = new TacticLexer(new ANTLRInputStream("temp_int = temp_int % temp_int;;"));
    }
    @Test
    public void test23() {
        lexer = new TacticLexer(new ANTLRInputStream("temp_bool = temp_int < temp_int;;"));
    }
    @Test
    public void test24() {
        lexer = new TacticLexer(new ANTLRInputStream("temp_bool = temp_int > temp_int;;"));
    }
    @Test
    public void test25() {
        lexer = new TacticLexer(new ANTLRInputStream("temp_bool = temp_int == temp_int;;"));
    }
    @Test
    public void test26() {
        lexer = new TacticLexer(new ANTLRInputStream("temp_int = -23;;"));
    }
    @Test
    public void test27() {
        lexer = new TacticLexer(new ANTLRInputStream("temp_float = 2.4;;"));
    }
    @Test
    public void test28() {
        lexer = new TacticLexer(new ANTLRInputStream("temp_float = temp_float + 4.3;;"));
    }
    @Test
    public void test29() {
        lexer = new TacticLexer(new ANTLRInputStream("temp_float = temp_float + temp_float;;"));
    }
    @Test
    public void test30() {
        lexer = new TacticLexer(new ANTLRInputStream("temp_float = temp_float - temp_float;;"));
    }
    @Test
    public void test31() {
        lexer = new TacticLexer(new ANTLRInputStream("temp_float = temp_float * temp_float;;"));
    }
    @Test
    public void test32() {
        lexer = new TacticLexer(new ANTLRInputStream("temp_float = temp_float / temp_float;;"));
    }
    @Test
    public void test33() {
        lexer = new TacticLexer(new ANTLRInputStream("temp_bool = temp_float < temp_float;;"));
    }
    @Test
    public void test34() {
        lexer = new TacticLexer(new ANTLRInputStream("temp_bool = temp_float > temp_float;;"));
    }
    @Test
    public void test35() {
        lexer = new TacticLexer(new ANTLRInputStream("temp_bool = temp_float == temp_float;;"));
    }
    @Test
    public void test36() {
        lexer = new TacticLexer(new ANTLRInputStream("temp_bool = true;;"));
    }
    @Test
    public void test37() {
        lexer = new TacticLexer(new ANTLRInputStream("temp_bool = false;;"));
    }
    @Test
    public void test38() {
        lexer = new TacticLexer(new ANTLRInputStream("temp_bool = temp_bool || temp_bool;;"));
    }
    @Test
    public void test39() {
        lexer = new TacticLexer(new ANTLRInputStream("temp_bool = temp_bool && temp_bool;;"));
    }
    @Test
    public void test40() {
        lexer = new TacticLexer(new ANTLRInputStream("temp_bool = temp_bool != true;;"));
    }
    @Test
    public void test41() {
        lexer = new TacticLexer(new ANTLRInputStream("temp_bool = temp_bool != false;;"));
    }
    @Test
    public void test42() {
        lexer = new TacticLexer(new ANTLRInputStream("temp_bool = temp_bool == temp_bool;;"));
    }
    @Test
    public void test43() {
        lexer = new TacticLexer(new ANTLRInputStream("string_temp = \"\";;"));
    }
    @Test
    public void test44() {
        lexer = new TacticLexer(new ANTLRInputStream("string_temp = \"qwerty\";;"));
    }
    @Test
    public void test45() {
        lexer = new TacticLexer(new ANTLRInputStream("bool_temp = string_temp == string_temp;;"));
    }
    @Test
    public void test46() {
        lexer = new TacticLexer(new ANTLRInputStream("temp_vector = (1, 2);;"));
    }
    @Test
    public void test47() {
        lexer = new TacticLexer(new ANTLRInputStream("temp_vector = (4, 3, 5);;"));
    }
    @Test
    public void test48() {
        lexer = new TacticLexer(new ANTLRInputStream("temp_vector = temp_vector + temp_vector;;"));
    }
    @Test
    public void test49() {
        lexer = new TacticLexer(new ANTLRInputStream("temp_vector = temp_vector - temp_vector;;"));
    }
    @Test
    public void test50() {
        lexer = new TacticLexer(new ANTLRInputStream("bool_temp = temp_vector == temp_vector;;"));
    }
    @Test
    public void test51() {
        lexer = new TacticLexer(new ANTLRInputStream("temp_GamePiece.position = (1,2);;"));
    }
    @Test
    public void test52() {
        lexer = new TacticLexer(new ANTLRInputStream("temp_GamePiece.size = 5;;"));
    }
    @Test
    public void test53() {
        lexer = new TacticLexer(new ANTLRInputStream("temp_GamePiece.color = \"\";;"));
    }
    @Test
    public void test54() {
        lexer = new TacticLexer(new ANTLRInputStream("temp_GamePiece.opacity = 0.5;;"));
    }
    @Test
    public void test55() {
        lexer = new TacticLexer(new ANTLRInputStream("temp_GamePiece.label = \"label_text\";;"));
    }
    @Test
    public void test56() {
        lexer = new TacticLexer(new ANTLRInputStream("temp_GamePiece.shape = \"\";;"));
    }
    @Test
    public void test57() {
        lexer = new TacticLexer(new ANTLRInputStream("mul_arr_test[0][0] = 1;;"));
    }
    @Test
    public void test58() {
        lexer = new TacticLexer(new ANTLRInputStream("mul_arr_test[0][1] = 2;;"));
    }
    @Test
    public void test59() {
        lexer = new TacticLexer(new ANTLRInputStream("mul_arr_test[1][0] = 3;;"));
    }
    @Test
    public void test60() {
        lexer = new TacticLexer(new ANTLRInputStream("mul_arr_test[1][1] = 4;;"));
    }
    @Test
    public void test61() {
        lexer = new TacticLexer(new ANTLRInputStream("int_to_float_test1 = 5;;"));
    }
    @Test
    public void test62() {
        lexer = new TacticLexer(new ANTLRInputStream("float_to_int_test2 = 5.4;;"));
    }

    @Test
    public void test63() {
        lexer = new TacticLexer(new ANTLRInputStream("if (true){}else{};"));
    }
    @Test
    public void test71() {
        lexer = new TacticLexer(new ANTLRInputStream("while (true){};"));
    }

    @Test
    public void test75() {
        lexer = new TacticLexer(new ANTLRInputStream("procedure_test1();;"));
    }
    @Test
    public void test76() {
        lexer = new TacticLexer(new ANTLRInputStream("procedure_test2(5, \"test\");;"));
    }
    @Test
    public void test77() {
        lexer = new TacticLexer(new ANTLRInputStream("move(temp_GamePiece, temp_vector, temp_int);;"));
    }
    @Test
    public void test78() {
        lexer = new TacticLexer(new ANTLRInputStream("change(temp_GamePiece, temp_string, temp_string, temp_int);;"));
    }

}
