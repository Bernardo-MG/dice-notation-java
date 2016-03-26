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

formula
:
	integerDice 
	| integerOpAdd
	| value
;

integerOpAdd
:
	integerDice OPERATOR_ADD value
;

integerDice
:
	diceHeader diceSides
;

diceHeader
:
	NUMBER? SEPARATOR
;

diceSides
:
	NUMBER
;

value
:
	NUMBER
;

/**
 * Tokens.
 */


// Functions

OPERATOR_ADD
:
	( '+' | '-' )
;

// Dice markers

SEPARATOR
:
	( 'd' | 'D' )
;

NUMBER
:
	[0-9] [0-9]*
;