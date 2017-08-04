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
	| DIGIT
;

binaryOp
:
	dice OPERATOR function
	| DIGIT OPERATOR function
;

dice
:
	DIGIT DSEPARATOR DIGIT
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

WS  : [\t\r\n]+ -> skip ;
