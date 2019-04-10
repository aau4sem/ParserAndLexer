parser grammar Tactic;

options { tokenVocab = TacticLexer; }

start   : exprs ;
exprs   : expr ENDSTNT | exprs exprs | exprNEs ;
        //| exprs exprNEs | exprNEs exprs | exprNEs; //Handle statements without ;
expr    : arithExpr | identifier | dotStmt | dotAssignment | dcl | arrayAssign | function;
dcl     : boardDcl | intDcl | boolDcl | arrayDcl | stringDcl | gpDcl | floatDcl;
exprNEs : exprNEs exprNEs | condStmt | loopStmt ; //expr that does not need to be ended with ';'

integer         : NUMBER | DIGIT ;
float           : (NUMBER | DIGIT) DOT (NUMBER | DIGIT);
number          : integer | float ;
word            : WORD | LETTER ;
string          : STRING_MARK word STRING_MARK ;
identifier      : word DIGIT* NUMBER*;
value           : identifier | number | bool | string ;
vec             : LPAREN number SEPERATOR number (SEPERATOR number)? RPAREN;

function        : identifier LPAREN arguments RPAREN;

dotStmt         : (identifier | BOARD) ((DOT identifier(LBRACKET number? RBRACKET)*) | DOT function )*;
dotAssignment   : dotStmt ASSIGN (value | vec);

//Declaration
boardDcl    : BOARD LPAREN string RPAREN ; // This current says that the board only takes a string. Early type checking ok?
intDcl      : INTEGER identifier ASSIGN (number | arithExpr | identifier) | INTEGER identifier;
floatDcl    : FLOAT identifier (ASSIGN (number | identifier | arithExpr))?;
boolDcl     : BOOL identifier ASSIGN boolStmt | BOOL identifier;
stringDcl   : STRING identifier ASSIGN (string | identifier);
gpDcl       : GAMEPIECE identifier;
arrayDcl    : (INTEGER | GAMEPIECE | BOOL) LBRACKET RBRACKET identifier (ASSIGN LCURLY (arrayExpr(SEPERATOR arrayExpr)*) RCURLY)?;


//Datastructure operations
arrayExpr   : boolStmt | arithExpr | gpDcl | identifier | dotStmt | arrayDcl | value ;
arrayAssign : identifier (((LBRACKET number RBRACKET)+ ASSIGN arrayExpr) | (LBRACKET RBRACKET ASSIGN LCURLY (arrayExpr(SEPERATOR arrayExpr)*) RCURLY));


//Arithmetic operations
arithExpr : ( addExpr | subExpr | divExpr | mulExpr | modExpr) ((ADDITION | SUBTRACTION | DIVISION | MULTIPLY | MODULO) (identifier | number))*;
addExpr : (identifier | number) ADDITION (identifier | number) ;
subExpr : (identifier | number) SUBTRACTION (identifier | number) ;
divExpr : (identifier | number) DIVISION (identifier | number) ;
mulExpr : (identifier | number) MULTIPLY (identifier | number) ;
modExpr : (identifier | number) MODULO (identifier | number) ;


arguments       : identifier | arguments SEPERATOR arguments | string | value ;

//Control structures
condStmt        : ifStmt | ifStmt elseifStmt* elseStmt? ;
block           : LCURLY exprs RCURLY | LCURLY RCURLY ;
ifStmt          : IF LPAREN (boolStmt) RPAREN  block ;
elseifStmt      : ELSEIF LPAREN (boolStmt) RPAREN  block ;
elseStmt        : ELSE block ;

loopStmt        : forStmt | whileStmt ;
forStmt         : FOR LPAREN (identifier | intDcl)? ENDSTNT boolStmt ENDSTNT ((identifier INCREMENT)| (identifier ASSIGN arithExpr))? RPAREN block ;
whileStmt       : WHILE LPAREN boolStmt RPAREN BLOCK ;

//Conditional
boolStmt        : (value boolOperaters value | bool | identifier);
bool            : (TRUE | FALSE) ;
boolOperaters   : (BOOL_EQUAL | BOOL_N_EQUAL | BOOL_COND_AND | BOOL_COND_OR
                | BOOL_LESS | BOOL_GREATER | BOOL_LESS_OR_EQUAL | BOOL_GREATER_OR_EQUAL) ;