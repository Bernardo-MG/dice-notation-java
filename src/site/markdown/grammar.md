# The grammar

Only the most basic grammar is supported. This means basic operations with numbers and dice, but only common dice notation, excluding anything fancy such as percentile or Fudge dice.

Note that the grammar itself serves just to validate and recognize dice notation. The actual operations are handled by the parser.

## Operands

The following values can appear in the grammar as operands:

- Dice, in the style of 2d6.
- Numbers, but only integer values.

## Operations

Only basic arithmetic operations are supported, and these can be applied any valid operand:

- Addition
- Subtraction
