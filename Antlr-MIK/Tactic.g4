parser grammar Tactic;

options { tokenVocab = TacticLexer; }

start   : exprs ;
exprs   : expr ENDSTNT | exprs exprs | exprNEs ;
        //| exprs exprNEs | exprNEs exprs | exprNEs; //Handle statements without ;
expr    : arithExpr
        | bicAssignment | identifier | dotStmt
        | boardDcl | intDcl | boolDcl | arrayDcl | arrayAssign | stringDcl;
dcl     : boardDcl | intDcl | boolDcl | arrayDcl | stringDcl ;
exprNEs : exprNEs exprNEs | condStmt | loopStmt ; //expr that does not need to be ended with ';'

integer         : NUMBER | DIGIT ;
word            : WORD | LETTER ;
string          : STRING_MARK word STRING_MARK ;
identifier      : word ;
value           : identifier | integer | bool | string;

dotStmt     : (buildInClass | BOARD) DOT LPAREN arguments* RPAREN;

//Declaration
boardDcl    : BOARD LPAREN string RPAREN ; // This current says that the board only takes a string. Early type checking ok?
intDcl      : INTEGER identifier ASSIGN (integer | arithExpr | identifier) | INTEGER identifier;
boolDcl     : BOOL identifier ASSIGN boolStmt | BOOL identifier;
stringDcl   : STRING identifier ASSIGN (string | identifier);
arrayDcl    : (INTEGER | buildInClass | BOOL) LBRACKET integer? RBRACKET identifier (ASSIGN LCURLY (arrayExpr(SEPERATOR arrayExpr)*) RCURLY)?;


//Datastructure operations
arrayExpr   : boolStmt | arithExpr | bicInstantiation | identifier | dotStmt | arrayDcl | value ;
arrayAssign : identifier (((LBRACKET integer RBRACKET)+ ASSIGN arrayExpr) | (LBRACKET RBRACKET ASSIGN LCURLY (arrayExpr(SEPERATOR arrayExpr)*) RCURLY));


//Arithmetic operations
arithExpr : ( addExpr | subExpr | divExpr | mulExpr | modExpr) ((ADDITION | SUBTRACTION | DIVISION | MULTIPLY | MODULO) (identifier|integer))*;
addExpr : (identifier | integer) ADDITION (identifier | integer) ;
subExpr : (identifier | integer) SUBTRACTION (identifier | integer) ;
divExpr : (identifier | integer) DIVISION (identifier | integer) ;
mulExpr : (identifier | integer) MULTIPLY (identifier | integer) ;
modExpr : (identifier | integer) MODULO (identifier | integer) ;


buildInClass    : TEAM | PLAYER ;

bicAssignment   : bicDcl ASSIGN bicInstantiation | identifier ASSIGN bicInstantiation;
bicDcl          : buildInClass identifier;
bicInstantiation: NEW buildInClass LPAREN arguments* RPAREN ;
type            : buildInClass ;

arguments       : identifier | arguments SEPERATOR arguments | string | value ;

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