package com.wandrell.tabletop.dice.grammar;

// Generated from DiceNotation.g4 by ANTLR 4.5
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.RuntimeMetaData;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.VocabularyImpl;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({ "all", "warnings", "unchecked", "unused", "cast" })
public class DiceNotationLexer extends Lexer {
    static {
        RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION);
    }

    protected static final DFA[]                  _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache = new PredictionContextCache();
    public static final int                       OPERATOR_ADD        = 1,
            SEPARATOR = 2, NUMBER = 3;
    public static String[]                        modeNames           = { "DEFAULT_MODE" };

    public static final String[]                  ruleNames           = {
            "OPERATOR_ADD", "SEPARATOR", "NUMBER"                    };

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

    public DiceNotationLexer(CharStream input) {
        super(input);
        _interp = new LexerATNSimulator(this, _ATN, _decisionToDFA,
                _sharedContextCache);
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
    public String[] getModeNames() {
        return modeNames;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    public static final String _serializedATN = "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\5\24\b\1\4\2\t\2"
                                                      + "\4\3\t\3\4\4\t\4\3\2\3\2\3\3\3\3\3\4\3\4\7\4\20\n\4\f\4\16\4\23\13\4\2"
                                                      + "\2\5\3\3\5\4\7\5\3\2\5\4\2--//\4\2FFff\3\2\62;\24\2\3\3\2\2\2\2\5\3\2"
                                                      + "\2\2\2\7\3\2\2\2\3\t\3\2\2\2\5\13\3\2\2\2\7\r\3\2\2\2\t\n\t\2\2\2\n\4"
                                                      + "\3\2\2\2\13\f\t\3\2\2\f\6\3\2\2\2\r\21\t\4\2\2\16\20\t\4\2\2\17\16\3\2"
                                                      + "\2\2\20\23\3\2\2\2\21\17\3\2\2\2\21\22\3\2\2\2\22\b\3\2\2\2\23\21\3\2"
                                                      + "\2\2\4\2\21\2";
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