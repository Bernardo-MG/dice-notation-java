/** 
 * Dice notation grammar.
 * 
 * This is the notation which RPGs and other tabletop games use to represent operations with dice.
 */
grammar DiceNotation;

options { tokenVocab=DiceNotationLexer; }

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
