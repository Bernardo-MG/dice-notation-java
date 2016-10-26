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
	dice
	| binaryOp
	| value
;

binaryOp
:
	dice OPERATOR function
	| value OPERATOR function
;

dice
:
	DIGIT DSEPARATOR DIGIT
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

DSEPARATOR
:
	( 'd' | 'D' )
;

DIGIT
:
	('0'..'9')+
;