lexer grammar TacticLexer;

//Keywords
NEW         :       'new';
LPAREN      :       '(';
RPAREN      :       ')';
LCURLY      :       '{';
RCURLY      :       '}';
TEAM        :       'Team';
PLAYER      :       'Player';
BOARD       :       'Board';
INTEGER     :       'int';
BOOL        :       'bool';
SEPERATOR   :       ',';
IF          :       'if';
ELSEIF      :       'elseif';
ELSE        :       'else';
TRUE        :       'true';
FLASE       :       'false';
FOR         :       'for' ;
WHILE       :       'while';
DOT         :       '.';
STRING_MARK :       '"';


// Literals
DIGIT           : ('0'..'9') ;
LETTER          : [a-z] | [A-Z] ;
WORD            : LETTER LETTER* ;
NUMBER          : DIGIT+;
ASSIGN          : '='  ;
ADDITION        : '+'  ;
SUBTRACTION     : '-'  ;
DIVISION        : ' / '  ; // This currently has to have spaces on both sides. Ask Mikkel why..
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
INCREMENT               : '++' ;

// Whitespace and comments
WS              : [ \t\r\n]+    -> channel(HIDDEN);
COMMENT         : '/*' .*? '*/' -> skip;
LINE_COMMENT    : '//' ~[\r\n]* -> skip;

