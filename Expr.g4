grammar Expr;

// Definición de reglas
expr:
	expr op = ('*' | '/') expr		# MulDiv
	| expr op = ('+' | '-') expr	# SumRes
	| ENT							# Ent
	| '(' expr ')'					# Paren;

// Definición de tokens
Mul: '*';
Div: '/';
Sum: '+';
Res: '-';
NEWLINE: [\r\n]+ -> skip;
ENT: [0-9]+;

