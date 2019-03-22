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


// Literals
DIGIT           : ('0'..'9') ;
LETTER          : [a-z] | [A-Z] ;
WORD            : LETTER LETTER* ;
NUMBER          : DIGIT+;
ASSIGN          : '='  ;
ADDITION        : '+'  ;
SUBTRACTION     : '-'  ;
DIVISION        : '/'  ;
MULTIPLY        : '*'  ;
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
WS          : [\n\t]+      -> skip; // skip newlines and tabs
//LC          : '//' ~[\r\n]    -> channel(HIDDEN); //skip line comments
//LC          : '//' .*? '//'    -> channel(HIDDEN); //skip line comments
//LC          : '//' .*? '\n'    -> channel(HIDDEN); //skip line comments
//LC          : '//' ~('\n'|'\r')*    -> channel(HIDDEN); //skip line comments
//LC          : '//' ~('\n')    -> channel(HIDDEN); //skip line comments
//LC            : '//' ~[\n] -> channel(HIDDEN);