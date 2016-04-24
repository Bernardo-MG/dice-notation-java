/** 
 * Dice notation grammar.
 * 
 * This is the notation which RPGs and other tabletop games use to represent operations with dice.
 */
grammar DiceNotationGrammar;

/**
 * Rules.
 */
 
parse
:
	function
;

function
:
	binaryOp
	| operand
;

unaryOp
:
	OPERATOR function
;

binaryOp
:
	operand OPERATOR function
;

operand
:
	dice
	| value
;

dice
:
	quantity SEPARATOR sides
;

quantity
:
	DIGIT
;

sides
:
	DIGIT
;

value
:
	DIGIT
;

/**
 * Tokens.
 */


// Functions

OPERATOR
:
	( ADD | SUB )
;

// Operators

ADD
:
	'+'
;

SUB
:
	'-'
;

// Dice markers

SEPARATOR
:
	( 'd' | 'D' )
;

DIGIT
:
	('0'..'9')+
;