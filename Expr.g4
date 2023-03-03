grammar Expr;
prog: stat+;

stat:
	expr NEWLINE			# imprimir
	| ID '=' expr NEWLINE	# asignar
	| NEWLINE				# blanco;
expr:
	expr op = ('*' | '/') expr		# MulDiv
	| expr op = ('+' | '-') expr	# SumRes
	| ENT							# Ent
	| '(' expr ')'					# Paren;

Mul: '*';
Div: '/';
Sum: '+';
Res: '-';
NEWLINE: '\r'? '\n' -> skip;
ENT: [0-9]+;
ID: [a-zA-Z][a-zA-Z0-9]*;
WS: [ \t]+ -> skip;