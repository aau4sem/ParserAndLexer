parser grammar Tactic;

options { tokenVocab = TacticLexer; }

start   : exprs ;
exprs   : expr ENDSTNT | exprs exprs | exprNEs ;
        //| exprs exprNEs | exprNEs exprs | exprNEs; //Handle statements without ;
expr    : arithExpr
        | instantiation | identifier | dotStmt
        | boardDcl | intDcl | boolDcl ;
exprNEs : exprNEs exprNEs | condStmt | loopStmt ; //expr that does not need to be ended with ';'

integer         : NUMBER | DIGIT;
word            : WORD | LETTER;
identifier      : word ;
value           : identifier | integer | bool ;

dotStmt     : (buildInClass | BOARD) DOT LPAREN arguments* RPAREN;

//Declaration
boardDcl    : BOARD LPAREN word RPAREN ;
intDcl      : INTEGER identifier ASSIGN integer ;
boolDcl     : BOOL identifier ASSIGN bool ;
//Arithmetic operations
arithExpr : ( addExpr | subExpr | divExpr | mulExpr);
addExpr : (identifier | integer) ADDITION (identifier | integer) ;
subExpr : (identifier | integer) SUBTRACTION (identifier | integer) ;
divExpr : (identifier | integer) DIVISION (identifier | integer) ;
mulExpr : (identifier | integer) MULTIPLY (identifier | integer) ;



buildInClass    : TEAM | PLAYER ;

instantiation   : type identifier ASSIGN NEW type LPAREN arguments* RPAREN ;
type            : buildInClass ;

arguments       : identifier | arguments SEPERATOR arguments ;

//Control structures
condStmt        : ifStmt | ifStmt elseifStmt* elseStmt? ;
block           : LCURLY exprs RCURLY | LCURLY RCURLY ;
ifStmt          : IF LPAREN (boolStmt) RPAREN  block ;
elseifStmt      : ELSEIF LPAREN (boolStmt) RPAREN  block ;
elseStmt        : ELSE block ;

loopStmt        : forStmt | whileStmt ;
forStmt         : FOR LPAREN (identifier | intDcl)? ENDSTNT boolStmt ENDSTNT (identifier INCREMENT)? RPAREN block ;
whileStmt       : WHILE LPAREN boolStmt RPAREN BLOCK ;

//Conditional
boolStmt        : (value boolOperaters value | bool | identifier);
bool            : (TRUE | FALSE) ;
boolOperaters   : (BOOL_EQUAL | BOOL_N_EQUAL | BOOL_COND_AND | BOOL_COND_OR
                | BOOL_LESS | BOOL_GREATER | BOOL_LESS_OR_EQUAL | BOOL_GREATER_OR_EQUAL) ;