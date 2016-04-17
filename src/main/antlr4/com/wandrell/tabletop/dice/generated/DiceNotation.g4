/** 
 * Dice notation grammar.
 * 
 * Dice notation was created around Dungeons & Dragons as a way to represent
 * dice rolls, and later evolved through several other tabletop RPGs.
 */
grammar DiceNotation;

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