grammar Tac;




program : statement+;

statement : let | show ;

let : VAR '=' INT ;
show : 'show' (INT | VAR) ;

VAR : [a-z]+ ;
INT : [0-9]+ ;
WS  : [ \n\t]+ -> skip;

//Grammar taken from:
//https://medium.com/@shalithasuranga/build-your-own-programming-language-with-antlr-5201955537a5