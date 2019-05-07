lexer grammar TacticLexer;

//Used for when generating:
@lexer::header {
    package gen;
}

//Keywords
LPAREN      :       '(';
RPAREN      :       ')';
LCURLY      :       '{';
RCURLY      :       '}';
LBRACKET    :       '[';
RBRACKET    :       ']';
GAMEPIECE   :       'GamePiece';
INTEGER     :       'int';
FLOAT       :       'float';
VEC         :       'vector';
BOOL        :       'bool';
SEPERATOR   :       ',';
IF          :       'if';
ELSEIF      :       'elseif';
ELSE        :       'else';
TRUE        :       'true';
FALSE       :       'false';
WHILE       :       'while';
DOT         :       '.';
STRING_MARK :       '"';
STRING      :       'string';
VOID        :       'void';
RETURN      :       'return';


// Literals
DIGIT           : ('0'..'9') ;
LETTER          : [a-z] | [A-Z] | [_] ;
WORD            : LETTER LETTER* ;
STRINGTEXT      : '"' ~('\r' | '\n' | '"')* '"' ;
NUMBER          : DIGIT+;
ASSIGN          : '='  ;
ADDITION        : '+'  ;
SUBTRACTION     : '-'  ;
DIVISION        : '/'  ; // This currently has to have spaces on both sides. Ask Mikkel why..
MULTIPLY        : '*' ;
MODULO          : '%' ;
ENDSTNT         : ';'  ;
BOOL_EQUAL      : '==' ;
BOOL_N_EQUAL    : '!=' ;
BOOL_COND_AND   : '&&' ;
BOOL_COND_OR    : '||' ;
BOOL_LESS       : '<' ;
BOOL_GREATER            : '>' ;
BOOL_LESS_OR_EQUAL      : '<=' ;
BOOL_GREATER_OR_EQUAL   : '>=' ;

// Whitespace and comments
WS              : [ \t\r\n]+    -> channel(HIDDEN);
COMMENT         : '/*' .*? '*/' -> skip;
LINE_COMMENT    : DIVISION'/' ~[\r\n]* -> skip;

