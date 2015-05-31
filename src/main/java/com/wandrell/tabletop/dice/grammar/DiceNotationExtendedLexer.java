package com.wandrell.tabletop.dice.grammar;

// Generated from DiceNotationExtended.g4 by ANTLR 4.5
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
public class DiceNotationExtendedLexer extends Lexer {
    static {
        RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION);
    }

    protected static final DFA[]                  _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache = new PredictionContextCache();
    public static final int                       T__0                = 1,
            T__1 = 2, DiceHeader = 3, GROUP_MODIFIER = 4, FUNCTION = 5,
            OPERATOR_ADD = 6, OPERATOR_DIV = 7, TIMES = 8, SIGN = 9,
            SEPARATOR = 10, PERCENTILE = 11, FUDGE = 12, LPAREN = 13,
            RPAREN = 14, NUMBER = 15;
    public static String[]                        modeNames           = { "DEFAULT_MODE" };

    public static final String[]                  ruleNames           = {
            "T__0", "T__1", "DiceHeader", "GROUP_MODIFIER", "FUNCTION",
            "OPERATOR_ADD", "OPERATOR_DIV", "TIMES", "SIGN", "SEPARATOR",
            "PERCENTILE", "FUDGE", "LPAREN", "RPAREN", "NUMBER"      };

    private static final String[]                 _LITERAL_NAMES      = { null,
            "'+'", "'-'", null, null, null, null, null, "'x'", null, null,
            "'%'", "'F'", "'('", "')'"                               };
    private static final String[]                 _SYMBOLIC_NAMES     = { null,
            null, null, "DiceHeader", "GROUP_MODIFIER", "FUNCTION",
            "OPERATOR_ADD", "OPERATOR_DIV", "TIMES", "SIGN", "SEPARATOR",
            "PERCENTILE", "FUDGE", "LPAREN", "RPAREN", "NUMBER"      };
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

    public DiceNotationExtendedLexer(CharStream input) {
        super(input);
        _interp = new LexerATNSimulator(this, _ATN, _decisionToDFA,
                _sharedContextCache);
    }

    @Override
    public String getGrammarFileName() {
        return "DiceNotationExtended.g4";
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

    public static final String _serializedATN = "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\21I\b\1\4\2\t\2\4"
                                                      + "\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"
                                                      + "\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\3\3\3\3\4"
                                                      + "\5\4\'\n\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n"
                                                      + "\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\7\20E\n\20"
                                                      + "\f\20\16\20H\13\20\2\2\21\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25"
                                                      + "\f\27\r\31\16\33\17\35\20\37\21\3\2\7\4\2--//\4\2JJNN\4\2,,\61\61\4\2"
                                                      + "FFff\3\2\62;J\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2"
                                                      + "\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2"
                                                      + "\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\3!\3\2"
                                                      + "\2\2\5#\3\2\2\2\7&\3\2\2\2\t*\3\2\2\2\13-\3\2\2\2\r\60\3\2\2\2\17\62\3"
                                                      + "\2\2\2\21\64\3\2\2\2\23\66\3\2\2\2\258\3\2\2\2\27:\3\2\2\2\31<\3\2\2\2"
                                                      + "\33>\3\2\2\2\35@\3\2\2\2\37B\3\2\2\2!\"\7-\2\2\"\4\3\2\2\2#$\7/\2\2$\6"
                                                      + "\3\2\2\2%\'\5\37\20\2&%\3\2\2\2&\'\3\2\2\2\'(\3\2\2\2()\5\25\13\2)\b\3"
                                                      + "\2\2\2*+\5\37\20\2+,\5\21\t\2,\n\3\2\2\2-.\t\2\2\2./\t\3\2\2/\f\3\2\2"
                                                      + "\2\60\61\t\2\2\2\61\16\3\2\2\2\62\63\t\4\2\2\63\20\3\2\2\2\64\65\7z\2"
                                                      + "\2\65\22\3\2\2\2\66\67\t\2\2\2\67\24\3\2\2\289\t\5\2\29\26\3\2\2\2:;\7"
                                                      + "\'\2\2;\30\3\2\2\2<=\7H\2\2=\32\3\2\2\2>?\7*\2\2?\34\3\2\2\2@A\7+\2\2"
                                                      + "A\36\3\2\2\2BF\t\6\2\2CE\t\6\2\2DC\3\2\2\2EH\3\2\2\2FD\3\2\2\2FG\3\2\2"
                                                      + "\2G \3\2\2\2HF\3\2\2\2\5\2&F\2";
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