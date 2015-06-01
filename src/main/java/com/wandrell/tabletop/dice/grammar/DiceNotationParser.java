package com.wandrell.tabletop.dice.grammar;

// Generated from DiceNotation.g4 by ANTLR 4.5
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.RuntimeMetaData;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.VocabularyImpl;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;

@SuppressWarnings({ "all", "warnings", "unchecked", "unused", "cast" })
public class DiceNotationParser extends Parser {
    static {
        RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION);
    }

    protected static final DFA[]                  _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache = new PredictionContextCache();
    public static final int                       OPERATOR_ADD        = 1,
            SEPARATOR = 2, NUMBER = 3;
    public static final int                       RULE_formula        = 0,
            RULE_integerOpAdd = 1, RULE_integerDice = 2, RULE_diceHeader = 3,
            RULE_diceSides = 4, RULE_value = 5;
    public static final String[]                  ruleNames           = {
            "formula", "integerOpAdd", "integerDice", "diceHeader",
            "diceSides", "value"                                     };

    private static final String[]                 _LITERAL_NAMES      = {};
    private static final String[]                 _SYMBOLIC_NAMES     = { null,
            "OPERATOR_ADD", "SEPARATOR", "NUMBER"                    };
    public static final Vocabulary                VOCABULARY          = new VocabularyImpl(
                                                                              _LITERAL_NAMES,
                                                                              _SYMBOLIC_NAMES);

    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[]                  tokenNames;
    static {
        tokenNames = new String[_SYMBOLIC_NAMES.length];
        for (int i = 0; i < tokenNames.length; i++) {
            tokenNames[i] = VOCABULARY.getLiteralName(i);
            if (tokenNames[i] == null) {
                tokenNames[i] = VOCABULARY.getSymbolicName(i);
            }

            if (tokenNames[i] == null) {
                tokenNames[i] = "<INVALID>";
            }
        }
    }

    @Override
    @Deprecated
    public String[] getTokenNames() {
        return tokenNames;
    }

    @Override
    public Vocabulary getVocabulary() {
        return VOCABULARY;
    }

    @Override
    public String getGrammarFileName() {
        return "DiceNotation.g4";
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    public DiceNotationParser(TokenStream input) {
        super(input);
        _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA,
                _sharedContextCache);
    }

    public static class FormulaContext extends ParserRuleContext {
        public IntegerDiceContext integerDice() {
            return getRuleContext(IntegerDiceContext.class, 0);
        }

        public IntegerOpAddContext integerOpAdd() {
            return getRuleContext(IntegerOpAddContext.class, 0);
        }

        public ValueContext value() {
            return getRuleContext(ValueContext.class, 0);
        }

        public FormulaContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_formula;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DiceNotationListener)
                ((DiceNotationListener) listener).enterFormula(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DiceNotationListener)
                ((DiceNotationListener) listener).exitFormula(this);
        }
    }

    public final FormulaContext formula() throws RecognitionException {
        FormulaContext _localctx = new FormulaContext(_ctx, getState());
        enterRule(_localctx, 0, RULE_formula);
        try {
            setState(15);
            switch (getInterpreter().adaptivePredict(_input, 0, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                    {
                        setState(12);
                        integerDice();
                    }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                    {
                        setState(13);
                        integerOpAdd();
                    }
                    break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                    {
                        setState(14);
                        value();
                    }
                    break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class IntegerOpAddContext extends ParserRuleContext {
        public IntegerDiceContext integerDice() {
            return getRuleContext(IntegerDiceContext.class, 0);
        }

        public TerminalNode OPERATOR_ADD() {
            return getToken(DiceNotationParser.OPERATOR_ADD, 0);
        }

        public ValueContext value() {
            return getRuleContext(ValueContext.class, 0);
        }

        public IntegerOpAddContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_integerOpAdd;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DiceNotationListener)
                ((DiceNotationListener) listener).enterIntegerOpAdd(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DiceNotationListener)
                ((DiceNotationListener) listener).exitIntegerOpAdd(this);
        }
    }

    public final IntegerOpAddContext integerOpAdd() throws RecognitionException {
        IntegerOpAddContext _localctx = new IntegerOpAddContext(_ctx,
                getState());
        enterRule(_localctx, 2, RULE_integerOpAdd);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(17);
                integerDice();
                setState(18);
                match(OPERATOR_ADD);
                setState(19);
                value();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class IntegerDiceContext extends ParserRuleContext {
        public DiceHeaderContext diceHeader() {
            return getRuleContext(DiceHeaderContext.class, 0);
        }

        public DiceSidesContext diceSides() {
            return getRuleContext(DiceSidesContext.class, 0);
        }

        public IntegerDiceContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_integerDice;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DiceNotationListener)
                ((DiceNotationListener) listener).enterIntegerDice(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DiceNotationListener)
                ((DiceNotationListener) listener).exitIntegerDice(this);
        }
    }

    public final IntegerDiceContext integerDice() throws RecognitionException {
        IntegerDiceContext _localctx = new IntegerDiceContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_integerDice);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(21);
                diceHeader();
                setState(22);
                diceSides();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class DiceHeaderContext extends ParserRuleContext {
        public TerminalNode SEPARATOR() {
            return getToken(DiceNotationParser.SEPARATOR, 0);
        }

        public TerminalNode NUMBER() {
            return getToken(DiceNotationParser.NUMBER, 0);
        }

        public DiceHeaderContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_diceHeader;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DiceNotationListener)
                ((DiceNotationListener) listener).enterDiceHeader(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DiceNotationListener)
                ((DiceNotationListener) listener).exitDiceHeader(this);
        }
    }

    public final DiceHeaderContext diceHeader() throws RecognitionException {
        DiceHeaderContext _localctx = new DiceHeaderContext(_ctx, getState());
        enterRule(_localctx, 6, RULE_diceHeader);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(25);
                _la = _input.LA(1);
                if (_la == NUMBER) {
                    {
                        setState(24);
                        match(NUMBER);
                    }
                }

                setState(27);
                match(SEPARATOR);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class DiceSidesContext extends ParserRuleContext {
        public TerminalNode NUMBER() {
            return getToken(DiceNotationParser.NUMBER, 0);
        }

        public DiceSidesContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_diceSides;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DiceNotationListener)
                ((DiceNotationListener) listener).enterDiceSides(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DiceNotationListener)
                ((DiceNotationListener) listener).exitDiceSides(this);
        }
    }

    public final DiceSidesContext diceSides() throws RecognitionException {
        DiceSidesContext _localctx = new DiceSidesContext(_ctx, getState());
        enterRule(_localctx, 8, RULE_diceSides);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(29);
                match(NUMBER);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ValueContext extends ParserRuleContext {
        public TerminalNode NUMBER() {
            return getToken(DiceNotationParser.NUMBER, 0);
        }

        public ValueContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_value;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DiceNotationListener)
                ((DiceNotationListener) listener).enterValue(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DiceNotationListener)
                ((DiceNotationListener) listener).exitValue(this);
        }
    }

    public final ValueContext value() throws RecognitionException {
        ValueContext _localctx = new ValueContext(_ctx, getState());
        enterRule(_localctx, 10, RULE_value);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(31);
                match(NUMBER);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static final String _serializedATN = "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\5$\4\2\t\2\4\3\t"
                                                      + "\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\2\5\2\22\n\2\3\3\3\3\3\3"
                                                      + "\3\3\3\4\3\4\3\4\3\5\5\5\34\n\5\3\5\3\5\3\6\3\6\3\7\3\7\3\7\2\2\b\2\4"
                                                      + "\6\b\n\f\2\2 \2\21\3\2\2\2\4\23\3\2\2\2\6\27\3\2\2\2\b\33\3\2\2\2\n\37"
                                                      + "\3\2\2\2\f!\3\2\2\2\16\22\5\6\4\2\17\22\5\4\3\2\20\22\5\f\7\2\21\16\3"
                                                      + "\2\2\2\21\17\3\2\2\2\21\20\3\2\2\2\22\3\3\2\2\2\23\24\5\6\4\2\24\25\7"
                                                      + "\3\2\2\25\26\5\f\7\2\26\5\3\2\2\2\27\30\5\b\5\2\30\31\5\n\6\2\31\7\3\2"
                                                      + "\2\2\32\34\7\5\2\2\33\32\3\2\2\2\33\34\3\2\2\2\34\35\3\2\2\2\35\36\7\4"
                                                      + "\2\2\36\t\3\2\2\2\37 \7\5\2\2 \13\3\2\2\2!\"\7\5\2\2\"\r\3\2\2\2\4\21"
                                                      + "\33";
    public static final ATN    _ATN           = new ATNDeserializer()
                                                      .deserialize(_serializedATN
                                                              .toCharArray());
    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}