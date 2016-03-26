/** 
 * Dice notation grammar.
 * 
 * Dice notation was created around Dungeons & Dragons as a way to represent
 * dice rolls, and later evolved through several other tabletop RPGs.
 */
grammar DiceNotationExtended;

/**
 * Rules.
 */
notation
:
	expression
;

expression
:
	operand ( OPERATOR_DIV | ( '+' | '-' ) ) expression
	| dice FUNCTION
	| operand
	| ( '+' | '-' ) operand
;

operand
:
	dice
	| NUMBER
	| operationParenthesis
;

// Parenthesis operation
// For example (1d6) or 2x(1d6)

operationParenthesis
:
	LPAREN expression RPAREN
	| GROUP_MODIFIER operationParenthesis
;

// All the allowed dice

dice
:
	integerDice
	| percentileDice
	| fudgeDice
;

// 1d6: from 1 to second number

integerDice
:
	DiceHeader NUMBER
;

// 1d%: from 1 to 100

percentileDice
:
	DiceHeader PERCENTILE
;

// 1dF: from -1 to 1

fudgeDice
:
	DiceHeader FUDGE
;

DiceHeader
:
	NUMBER? SEPARATOR
;

/**
 * Tokens.
 */

// Modifiers

// Modifies the following group operation

GROUP_MODIFIER
:
	NUMBER TIMES
;

// Functions

FUNCTION
:
	( '+' | '-' ) ( 'L' | 'H' )
;

OPERATOR_ADD
:
	( '+' | '-' )
;

OPERATOR_DIV
:
	( '/' | '*' )
;

TIMES
:
	'x'
;

SIGN
:
	( '+' | '-' )
;

// Dice markers

SEPARATOR
:
	( 'd' | 'D' )
;

PERCENTILE
:
	'%'
;

FUDGE
:
	'F'
;

// Parenthesis

LPAREN
:
	'('
;

RPAREN
:
	')'
;

// Numeric

NUMBER
:
	[0-9] [0-9]*
;