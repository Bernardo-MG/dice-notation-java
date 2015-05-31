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

// 1d6: from 1 to second number

formula
:
	integerDice 
	| integerDice OPERATOR_ADD NUMBER
	| value
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