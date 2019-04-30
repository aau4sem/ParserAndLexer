parser grammar Tactic;

//Used for when generating:
@header {
    package gen;
}

options { tokenVocab = TacticLexer; }

prog    : ((stmt | functionDef) ENDSTNT)* ;
stmt    : arithExpr | identifier | dotStmt | dotAssignment | dcl | arrayAssign | functionCall | condStmt | whileStmt | assignment;
dcl     : intDcl | boolDcl | arrayDcl | stringDcl | gpDcl | floatDcl | vecDcl;

integer         : NUMBER | DIGIT ;
floatVal        : (NUMBER | DIGIT) DOT (NUMBER | DIGIT);
number          : integer | floatVal ;
word            : WORD | LETTER ;
string          : STRING_MARK word? STRING_MARK ;
identifier      : word DIGIT* NUMBER*;
value           : identifier | number | bool | string | vec;
vec             : LPAREN number SEPERATOR number (SEPERATOR number)? RPAREN;
type            : INTEGER | FLOAT | VEC | BOOL | STRING | GAMEPIECE ;

functionCall    : identifier LPAREN arguments? RPAREN;
functionDef     : (type | VOID) identifier LPAREN ((type | VOID) identifier (SEPERATOR (type | VOID) identifier)*)? RPAREN functionBlock;
functionBlock   : LCURLY stmt* (RETURN (value | identifier | vec) ENDSTNT)? RCURLY | LCURLY (RETURN (value | identifier | vec) ENDSTNT)? RCURLY;

dotStmt         : identifier ((DOT identifier(LBRACKET number? RBRACKET)*))+ ;
dotAssignment   : dotStmt ASSIGN value;

//Declaration
intDcl      : INTEGER identifier ASSIGN (number | arithExpr | identifier) | INTEGER identifier;
floatDcl    : FLOAT identifier (ASSIGN (number | identifier | arithExpr))?;
vecDcl      : VEC identifier (ASSIGN vec)?;
boolDcl     : BOOL identifier ASSIGN boolStmt | BOOL identifier;
stringDcl   : STRING identifier (ASSIGN (string | identifier))?;
gpDcl       : GAMEPIECE identifier;
arrayDcl    : type LBRACKET integer RBRACKET identifier (ASSIGN LCURLY (arrayExpr(SEPERATOR arrayExpr)*) RCURLY)?;

assignment  : identifier (LBRACKET integer RBRACKET)? ASSIGN (value | arithExpr | functionCall | identifier | boolStmt);

//Datastructure operations
arrayExpr   : boolStmt | arithExpr | gpDcl | identifier | dotStmt | arrayDcl | value | vec ;
arrayAssign : identifier (((LBRACKET number RBRACKET)+ ASSIGN arrayExpr) | (LBRACKET RBRACKET ASSIGN LCURLY (arrayExpr(SEPERATOR arrayExpr)*) RCURLY));


//Arithmetic operations
arithExpr : ( addExpr | subExpr | divExpr | mulExpr | modExpr) ((ADDITION | SUBTRACTION | DIVISION | MULTIPLY | MODULO) (identifier | number))*;
addExpr : (identifier | number) ADDITION (identifier | number) ;
subExpr : (identifier | number) SUBTRACTION (identifier | number) ;
divExpr : (identifier | number) DIVISION (identifier | number) ;
mulExpr : (identifier | number) MULTIPLY (identifier | number) ;
modExpr : (identifier | number) MODULO (identifier | number) ;

arguments       : value | arguments SEPERATOR arguments ;

//Control structures
condStmt        : ifStmt | ifStmt elseifStmt* elseStmt? ;
block           : LCURLY stmt* RCURLY | LCURLY RCURLY ;
ifStmt          : IF LPAREN (boolStmt) RPAREN  block ;
elseifStmt      : ELSEIF LPAREN (boolStmt) RPAREN  block ;
elseStmt        : ELSE block ;

whileStmt       : WHILE LPAREN boolStmt RPAREN block ;

//Conditional
boolStmt        : (value boolOperaters value | bool | identifier);
bool            : (TRUE | FALSE) ;
boolOperaters   : (BOOL_EQUAL | BOOL_N_EQUAL | BOOL_COND_AND | BOOL_COND_OR
                | BOOL_LESS | BOOL_GREATER | BOOL_LESS_OR_EQUAL | BOOL_GREATER_OR_EQUAL) ;