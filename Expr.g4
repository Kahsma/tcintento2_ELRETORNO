grammar Expr;

expr:
	expr op = ('*' | '/') expr		# MulDiv
	| expr op = ('+' | '-') expr	# SumRes
	| ENT							# Ent
	| '(' expr ')'					# Paren;

Mul: '*';
Div: '/';
Sum: '+';
Res: '-';
NEWLINE: [ \t\r\n]+ -> skip;
ENT: [0-9]+;
