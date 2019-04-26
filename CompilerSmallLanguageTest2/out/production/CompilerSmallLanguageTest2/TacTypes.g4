grammar TacTypes;


start   : exprs ;
exprs   : expr ENDSTNT | exprs exprs ;

expr    : intDcl | floatDcl | print;

print   : PRINT LETTER ;
intDcl : INT LETTER ASSIGN DIGIT ;
floatDcl : FLOAT LETTER ASSIGN DIGIT ;

ASSIGN      : '=' ;
DIGIT       : ('0'..'9') ;
LETTER      : [a-z] | [A-Z] ;
ENDSTNT     : ';'  ;
PRINT       : 'print' ;

INT         : 'int' ;
FLOAT       : 'float' ;


WS          : [ \n\t\r]+      -> skip; // skip newlines and tabs