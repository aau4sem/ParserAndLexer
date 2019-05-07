parser grammar Tactic;

//Used for when generating:
@header {
    package gen;
}

options { tokenVocab = TacticLexer; }

prog    : ((procedureDef | dcl) ENDSTNT)* (stmt ENDSTNT)*;
stmt    : arithExpr | identifier | dotStmt | dotAssignment | arrayAssign | procedureCall | condStmt | whileStmt | assignment;
dcl     : intDcl | boolDcl | arrayDcl | stringDcl | gpDcl | floatDcl | vecDcl;

integer         : NUMBER | DIGIT ;
floatVal        : (NUMBER | DIGIT) DOT (NUMBER | DIGIT);
number          : integer | floatVal ;
word            : WORD | LETTER ;
string          : STRINGTEXT ;
identifier      : word (WORD|NUMBER|DIGIT|LETTER)*;
value           : identifier | number | bool | string | vec;
vec             : LPAREN number SEPERATOR number (SEPERATOR number)? RPAREN;
type            : INTEGER | FLOAT | VEC | BOOL | STRING | GAMEPIECE ;

procedureCall    : identifier LPAREN arguments? RPAREN;
procedureDef     : identifier LPAREN (type identifier (SEPERATOR type identifier)*)? RPAREN procedureBlock;
procedureBlock   : LCURLY (stmt ENDSTNT)* RCURLY;

dotStmt         : identifier ((DOT identifier(LBRACKET number? RBRACKET)*))+ ;
dotAssignment   : dotStmt ASSIGN value;

//Declaration
intDcl      : INTEGER identifier;
floatDcl    : FLOAT identifier;
vecDcl      : VEC identifier;
boolDcl     : BOOL identifier;
stringDcl   : STRING identifier;
gpDcl       : GAMEPIECE identifier;
arrayDcl    : type (LBRACKET integer RBRACKET)+ identifier;

assignment  : identifier (LBRACKET integer RBRACKET)* ASSIGN (value | arithExpr | procedureCall | boolStmt | vecExpr | (identifier (LBRACKET integer RBRACKET)*) | dotStmt);

//Datastructure operations
arrayExpr   : boolStmt | arithExpr | gpDcl | identifier | dotStmt | arrayDcl | value | vec | floatDcl | vecExpr ;
arrayAssign : identifier (((LBRACKET number RBRACKET)+ ASSIGN arrayExpr) | (LBRACKET RBRACKET ASSIGN LCURLY (arrayExpr(SEPERATOR arrayExpr)*) RCURLY));


//Arithmetic operations
arithExpr : ( addExpr | subExpr | divExpr | mulExpr | modExpr) ((ADDITION | SUBTRACTION | DIVISION | MULTIPLY | MODULO) (identifier | number))*;
addExpr : (identifier | number) ADDITION (identifier | number) ;
subExpr : (identifier | number) SUBTRACTION (identifier | number) ;
divExpr : (identifier | number) DIVISION (identifier | number) ;
mulExpr : (identifier | number) MULTIPLY (identifier | number) ;
modExpr : (identifier | number) MODULO (identifier | number) ;

vecExpr    : (vecAdd | vecSub) ((ADDITION | SUBTRACTION) (identifier | vec))* ;
vecAdd     : (identifier | vec) ADDITION (identifier | vec) ;
vecSub     : (identifier | vec) SUBTRACTION (identifier | vec) ;

arguments       : value | arguments SEPERATOR arguments ;

//Control structures
condStmt        : ifStmt elseStmt? ;
block           : LCURLY (stmt ENDSTNT)* RCURLY ;
ifStmt          : IF LPAREN (boolStmt) RPAREN  block ;
elseStmt        : ELSE block ;

whileStmt       : WHILE LPAREN boolStmt RPAREN block ;

//Conditional
boolStmt        : (value boolOperaters value | bool | identifier);
bool            : (TRUE | FALSE) ;
boolOperaters   : (BOOL_EQUAL | BOOL_N_EQUAL | BOOL_COND_AND | BOOL_COND_OR
                | BOOL_LESS | BOOL_GREATER | BOOL_LESS_OR_EQUAL | BOOL_GREATER_OR_EQUAL) ;