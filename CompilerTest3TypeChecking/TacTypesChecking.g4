grammar TacTypesChecking;


start   : exprs ;
exprs   : expr ENDSTNT | exprs exprs ;

expr    : intDcl | floatDcl | print | intPlus;

print   : PRINT LETTER ;
intDcl : INT LETTER ASSIGN DIGIT ;
floatDcl : FLOAT LETTER ASSIGN DIGIT ;

intPlus : (LETTER | DIGIT) PLUS (LETTER | DIGIT) ;

ASSIGN      : '=' ;
DIGIT       : ('0'..'9') ;
LETTER      : [a-z] | [A-Z] ;
ENDSTNT     : ';'  ;
PRINT       : 'print' ;
PLUS        : '+' ;

INT         : 'int' ;
FLOAT       : 'float' ;


WS          : [ \n\t\r]+      -> skip; // skip newlines and tabs