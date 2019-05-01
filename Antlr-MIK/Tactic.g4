parser grammar Tactic;

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
intDcl      : INTEGER identifier (ASSIGN (number | arithExpr | identifier | functionCall))?;
floatDcl    : FLOAT identifier (ASSIGN (number | identifier | arithExpr | functionCall))?;
vecDcl      : VEC identifier (ASSIGN (vec | vecExpr | functionCall | identifier))?;
boolDcl     : BOOL identifier (ASSIGN (boolStmt | functionCall | identifier))?;
stringDcl   : STRING identifier (ASSIGN (string | identifier | functionCall))?;
gpDcl       : GAMEPIECE identifier (ASSIGN (identifier | functionCall))?;
arrayDcl    : type (LBRACKET integer RBRACKET)+ identifier (ASSIGN (LCURLY (arrayExpr(SEPERATOR arrayExpr)*) RCURLY) | (identifier))?;

assignment  : identifier (LBRACKET integer RBRACKET)* ASSIGN (value | arithExpr | functionCall | boolStmt | vecExpr | (identifier (LBRACKET integer RBRACKET)*) | dotStmt);

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