package qlang_interpreter;

// Generated from Pil.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class PilParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, BOOLEAN=34, TYPES=35, ANDTHEN=36, ORELSE=37, TEXT=38, 
		INTEGER=39, FLOAT=40, ID=41, COMMENT=42, WS=43;
	public static final int
		RULE_program = 0, RULE_statementComposition = 1, RULE_statementWithBreak = 2, 
		RULE_statement = 3, RULE_if = 4, RULE_loop = 5, RULE_write = 6, RULE_assignment = 7, 
		RULE_expr = 8, RULE_idset = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statementComposition", "statementWithBreak", "statement", 
			"if", "loop", "write", "assignment", "expr", "idset"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'if'", "'then'", "'else'", "'end'", "'loop'", "'until'", 
			"'while'", "'do'", "'writeln'", "','", "'write'", "':='", "'('", "')'", 
			"'-'", "'+'", "'not'", "'*'", "':'", "'%'", "'='", "'>='", "'<='", "'>'", 
			"'<'", "'/='", "'and'", "'or'", "'xor'", "'implies'", "'read'", "'error'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, "BOOLEAN", 
			"TYPES", "ANDTHEN", "ORELSE", "TEXT", "INTEGER", "FLOAT", "ID", "COMMENT", 
			"WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
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
	public String getGrammarFileName() { return "Pil.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PilParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(PilParser.EOF, 0); }
		public StatementCompositionContext statementComposition() {
			return getRuleContext(StatementCompositionContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PilListener ) ((PilListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PilListener ) ((PilListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PilVisitor ) return ((PilVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2199023260740L) != 0)) {
				{
				setState(20);
				statementComposition();
				}
			}

			setState(23);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementCompositionContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public List<StatementWithBreakContext> statementWithBreak() {
			return getRuleContexts(StatementWithBreakContext.class);
		}
		public StatementWithBreakContext statementWithBreak(int i) {
			return getRuleContext(StatementWithBreakContext.class,i);
		}
		public StatementCompositionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementComposition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PilListener ) ((PilListener)listener).enterStatementComposition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PilListener ) ((PilListener)listener).exitStatementComposition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PilVisitor ) return ((PilVisitor<? extends T>)visitor).visitStatementComposition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementCompositionContext statementComposition() throws RecognitionException {
		StatementCompositionContext _localctx = new StatementCompositionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statementComposition);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(25);
					statementWithBreak();
					}
					} 
				}
				setState(30);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(33);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(31);
				statement();
				}
				break;
			case 2:
				{
				setState(32);
				statementWithBreak();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementWithBreakContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public StatementWithBreakContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementWithBreak; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PilListener ) ((PilListener)listener).enterStatementWithBreak(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PilListener ) ((PilListener)listener).exitStatementWithBreak(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PilVisitor ) return ((PilVisitor<? extends T>)visitor).visitStatementWithBreak(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementWithBreakContext statementWithBreak() throws RecognitionException {
		StatementWithBreakContext _localctx = new StatementWithBreakContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statementWithBreak);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			statement();
			setState(36);
			match(T__0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public WriteContext write() {
			return getRuleContext(WriteContext.class,0);
		}
		public IfContext if_() {
			return getRuleContext(IfContext.class,0);
		}
		public LoopContext loop() {
			return getRuleContext(LoopContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PilListener ) ((PilListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PilListener ) ((PilListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PilVisitor ) return ((PilVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(38);
				assignment();
				}
				break;
			case T__9:
			case T__11:
				{
				setState(39);
				write();
				}
				break;
			case T__1:
				{
				setState(40);
				if_();
				}
				break;
			case T__5:
				{
				setState(41);
				loop();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfContext extends ParserRuleContext {
		public IfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if; }
	 
		public IfContext() { }
		public void copyFrom(IfContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfElseContext extends IfContext {
		public StatementCompositionContext elseStat;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<StatementCompositionContext> statementComposition() {
			return getRuleContexts(StatementCompositionContext.class);
		}
		public StatementCompositionContext statementComposition(int i) {
			return getRuleContext(StatementCompositionContext.class,i);
		}
		public IfElseContext(IfContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PilListener ) ((PilListener)listener).enterIfElse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PilListener ) ((PilListener)listener).exitIfElse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PilVisitor ) return ((PilVisitor<? extends T>)visitor).visitIfElse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfContext if_() throws RecognitionException {
		IfContext _localctx = new IfContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_if);
		int _la;
		try {
			_localctx = new IfElseContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			match(T__1);
			setState(45);
			expr(0);
			setState(46);
			match(T__2);
			setState(47);
			statementComposition();
			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(48);
				match(T__3);
				setState(49);
				((IfElseContext)_localctx).elseStat = statementComposition();
				}
			}

			setState(52);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LoopContext extends ParserRuleContext {
		public LoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop; }
	 
		public LoopContext() { }
		public void copyFrom(LoopContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LoopFullContext extends LoopContext {
		public Token loopUntil;
		public Token loopWhile;
		public StatementCompositionContext statementComposition() {
			return getRuleContext(StatementCompositionContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<StatementWithBreakContext> statementWithBreak() {
			return getRuleContexts(StatementWithBreakContext.class);
		}
		public StatementWithBreakContext statementWithBreak(int i) {
			return getRuleContext(StatementWithBreakContext.class,i);
		}
		public LoopFullContext(LoopContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PilListener ) ((PilListener)listener).enterLoopFull(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PilListener ) ((PilListener)listener).exitLoopFull(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PilVisitor ) return ((PilVisitor<? extends T>)visitor).visitLoopFull(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LoopSimpleContext extends LoopContext {
		public Token loopUntil;
		public Token loopWhile;
		public StatementCompositionContext statementComposition() {
			return getRuleContext(StatementCompositionContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public LoopSimpleContext(LoopContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PilListener ) ((PilListener)listener).enterLoopSimple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PilListener ) ((PilListener)listener).exitLoopSimple(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PilVisitor ) return ((PilVisitor<? extends T>)visitor).visitLoopSimple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopContext loop() throws RecognitionException {
		LoopContext _localctx = new LoopContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_loop);
		int _la;
		try {
			setState(82);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new LoopFullContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(54);
				match(T__5);
				setState(58);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2199023260740L) != 0)) {
					{
					{
					setState(55);
					statementWithBreak();
					}
					}
					setState(60);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(65);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__6:
					{
					setState(61);
					((LoopFullContext)_localctx).loopUntil = match(T__6);
					setState(62);
					expr(0);
					}
					break;
				case T__7:
					{
					setState(63);
					((LoopFullContext)_localctx).loopWhile = match(T__7);
					setState(64);
					expr(0);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(67);
				match(T__8);
				setState(68);
				statementComposition();
				setState(69);
				match(T__4);
				}
				break;
			case 2:
				_localctx = new LoopSimpleContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(71);
				match(T__5);
				setState(72);
				statementComposition();
				setState(77);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__6:
					{
					setState(73);
					((LoopSimpleContext)_localctx).loopUntil = match(T__6);
					setState(74);
					expr(0);
					}
					break;
				case T__7:
					{
					setState(75);
					((LoopSimpleContext)_localctx).loopWhile = match(T__7);
					setState(76);
					expr(0);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(79);
				match(T__8);
				setState(80);
				match(T__4);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WriteContext extends ParserRuleContext {
		public WriteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_write; }
	 
		public WriteContext() { }
		public void copyFrom(WriteContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class WritelnExprContext extends WriteContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public WritelnExprContext(WriteContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PilListener ) ((PilListener)listener).enterWritelnExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PilListener ) ((PilListener)listener).exitWritelnExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PilVisitor ) return ((PilVisitor<? extends T>)visitor).visitWritelnExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class WriteExprContext extends WriteContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public WriteExprContext(WriteContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PilListener ) ((PilListener)listener).enterWriteExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PilListener ) ((PilListener)listener).exitWriteExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PilVisitor ) return ((PilVisitor<? extends T>)visitor).visitWriteExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WriteContext write() throws RecognitionException {
		WriteContext _localctx = new WriteContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_write);
		try {
			int _alt;
			setState(104);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
				_localctx = new WritelnExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(84);
				match(T__9);
				setState(90);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(85);
						expr(0);
						setState(86);
						match(T__10);
						}
						} 
					}
					setState(92);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				}
				setState(93);
				expr(0);
				}
				break;
			case T__11:
				_localctx = new WriteExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(94);
				match(T__11);
				setState(100);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(95);
						expr(0);
						setState(96);
						match(T__10);
						}
						} 
					}
					setState(102);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				}
				setState(103);
				expr(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentContext extends ParserRuleContext {
		public IdsetContext idset() {
			return getRuleContext(IdsetContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PilListener ) ((PilListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PilListener ) ((PilListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PilVisitor ) return ((PilVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			idset();
			setState(107);
			match(T__12);
			setState(108);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public Type eType;
		public String varName;
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
			this.eType = ctx.eType;
			this.varName = ctx.varName;
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprReadContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprReadContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PilListener ) ((PilListener)listener).enterExprRead(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PilListener ) ((PilListener)listener).exitExprRead(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PilVisitor ) return ((PilVisitor<? extends T>)visitor).visitExprRead(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprBinaryLogicalContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode ANDTHEN() { return getToken(PilParser.ANDTHEN, 0); }
		public TerminalNode ORELSE() { return getToken(PilParser.ORELSE, 0); }
		public ExprBinaryLogicalContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PilListener ) ((PilListener)listener).enterExprBinaryLogical(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PilListener ) ((PilListener)listener).exitExprBinaryLogical(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PilVisitor ) return ((PilVisitor<? extends T>)visitor).visitExprBinaryLogical(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprBooleanContext extends ExprContext {
		public TerminalNode BOOLEAN() { return getToken(PilParser.BOOLEAN, 0); }
		public ExprBooleanContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PilListener ) ((PilListener)listener).enterExprBoolean(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PilListener ) ((PilListener)listener).exitExprBoolean(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PilVisitor ) return ((PilVisitor<? extends T>)visitor).visitExprBoolean(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprFloatContext extends ExprContext {
		public TerminalNode FLOAT() { return getToken(PilParser.FLOAT, 0); }
		public ExprFloatContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PilListener ) ((PilListener)listener).enterExprFloat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PilListener ) ((PilListener)listener).exitExprFloat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PilVisitor ) return ((PilVisitor<? extends T>)visitor).visitExprFloat(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprTextContext extends ExprContext {
		public TerminalNode TEXT() { return getToken(PilParser.TEXT, 0); }
		public ExprTextContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PilListener ) ((PilListener)listener).enterExprText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PilListener ) ((PilListener)listener).exitExprText(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PilVisitor ) return ((PilVisitor<? extends T>)visitor).visitExprText(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprParenthesisContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprParenthesisContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PilListener ) ((PilListener)listener).enterExprParenthesis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PilListener ) ((PilListener)listener).exitExprParenthesis(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PilVisitor ) return ((PilVisitor<? extends T>)visitor).visitExprParenthesis(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprMultDivModContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprMultDivModContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PilListener ) ((PilListener)listener).enterExprMultDivMod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PilListener ) ((PilListener)listener).exitExprMultDivMod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PilVisitor ) return ((PilVisitor<? extends T>)visitor).visitExprMultDivMod(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprErrorContext extends ExprContext {
		public ExprErrorContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PilListener ) ((PilListener)listener).enterExprError(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PilListener ) ((PilListener)listener).exitExprError(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PilVisitor ) return ((PilVisitor<? extends T>)visitor).visitExprError(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprUnaryContext extends ExprContext {
		public Token op;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprUnaryContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PilListener ) ((PilListener)listener).enterExprUnary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PilListener ) ((PilListener)listener).exitExprUnary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PilVisitor ) return ((PilVisitor<? extends T>)visitor).visitExprUnary(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprAddMinusContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprAddMinusContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PilListener ) ((PilListener)listener).enterExprAddMinus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PilListener ) ((PilListener)listener).exitExprAddMinus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PilVisitor ) return ((PilVisitor<? extends T>)visitor).visitExprAddMinus(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprIntegerContext extends ExprContext {
		public TerminalNode INTEGER() { return getToken(PilParser.INTEGER, 0); }
		public ExprIntegerContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PilListener ) ((PilListener)listener).enterExprInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PilListener ) ((PilListener)listener).exitExprInteger(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PilVisitor ) return ((PilVisitor<? extends T>)visitor).visitExprInteger(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprIdContext extends ExprContext {
		public IdsetContext idset() {
			return getRuleContext(IdsetContext.class,0);
		}
		public ExprIdContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PilListener ) ((PilListener)listener).enterExprId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PilListener ) ((PilListener)listener).exitExprId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PilVisitor ) return ((PilVisitor<? extends T>)visitor).visitExprId(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprBinaryRelationalContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprBinaryRelationalContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PilListener ) ((PilListener)listener).enterExprBinaryRelational(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PilListener ) ((PilListener)listener).exitExprBinaryRelational(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PilVisitor ) return ((PilVisitor<? extends T>)visitor).visitExprBinaryRelational(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprTypeConversionContext extends ExprContext {
		public Token type;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode TYPES() { return getToken(PilParser.TYPES, 0); }
		public ExprTypeConversionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PilListener ) ((PilListener)listener).enterExprTypeConversion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PilListener ) ((PilListener)listener).exitExprTypeConversion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PilVisitor ) return ((PilVisitor<? extends T>)visitor).visitExprTypeConversion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__13:
				{
				_localctx = new ExprParenthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(111);
				match(T__13);
				setState(112);
				expr(0);
				setState(113);
				match(T__14);
				}
				break;
			case T__15:
			case T__16:
			case T__17:
				{
				_localctx = new ExprUnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(115);
				((ExprUnaryContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 458752L) != 0)) ) {
					((ExprUnaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(116);
				expr(13);
				}
				break;
			case INTEGER:
				{
				_localctx = new ExprIntegerContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(117);
				match(INTEGER);
				}
				break;
			case FLOAT:
				{
				_localctx = new ExprFloatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(118);
				match(FLOAT);
				}
				break;
			case ID:
				{
				_localctx = new ExprIdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(119);
				idset();
				}
				break;
			case TEXT:
				{
				_localctx = new ExprTextContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(120);
				match(TEXT);
				}
				break;
			case BOOLEAN:
				{
				_localctx = new ExprBooleanContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(121);
				match(BOOLEAN);
				}
				break;
			case TYPES:
				{
				_localctx = new ExprTypeConversionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(122);
				((ExprTypeConversionContext)_localctx).type = match(TYPES);
				setState(123);
				match(T__13);
				setState(124);
				expr(0);
				setState(125);
				match(T__14);
				}
				break;
			case T__31:
				{
				_localctx = new ExprReadContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(127);
				match(T__31);
				setState(129);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					setState(128);
					expr(0);
					}
					break;
				}
				}
				break;
			case T__32:
				{
				_localctx = new ExprErrorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(131);
				match(T__32);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(148);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(146);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						_localctx = new ExprMultDivModContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(134);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(135);
						((ExprMultDivModContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 3670016L) != 0)) ) {
							((ExprMultDivModContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(136);
						expr(13);
						}
						break;
					case 2:
						{
						_localctx = new ExprAddMinusContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(137);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(138);
						((ExprAddMinusContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__15 || _la==T__16) ) {
							((ExprAddMinusContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(139);
						expr(12);
						}
						break;
					case 3:
						{
						_localctx = new ExprBinaryRelationalContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(140);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(141);
						((ExprBinaryRelationalContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 264241152L) != 0)) ) {
							((ExprBinaryRelationalContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(142);
						expr(11);
						}
						break;
					case 4:
						{
						_localctx = new ExprBinaryLogicalContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(143);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(144);
						((ExprBinaryLogicalContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 210184962048L) != 0)) ) {
							((ExprBinaryLogicalContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(145);
						expr(10);
						}
						break;
					}
					} 
				}
				setState(150);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IdsetContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PilParser.ID, 0); }
		public IdsetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_idset; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PilListener ) ((PilListener)listener).enterIdset(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PilListener ) ((PilListener)listener).exitIdset(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PilVisitor ) return ((PilVisitor<? extends T>)visitor).visitIdset(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdsetContext idset() throws RecognitionException {
		IdsetContext _localctx = new IdsetContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_idset);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 8:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 12);
		case 1:
			return precpred(_ctx, 11);
		case 2:
			return precpred(_ctx, 10);
		case 3:
			return precpred(_ctx, 9);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001+\u009a\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0001\u0000\u0003\u0000\u0016\b\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0005\u0001\u001b\b\u0001\n\u0001\f\u0001"+
		"\u001e\t\u0001\u0001\u0001\u0001\u0001\u0003\u0001\"\b\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0003\u0003+\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0003\u00043\b\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0005\u00059\b\u0005\n\u0005\f\u0005<\t\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005B\b\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005N\b\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005S\b\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006Y\b\u0006\n\u0006\f\u0006"+
		"\\\t\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0005\u0006c\b\u0006\n\u0006\f\u0006f\t\u0006\u0001\u0006\u0003\u0006"+
		"i\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003"+
		"\b\u0082\b\b\u0001\b\u0003\b\u0085\b\b\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005"+
		"\b\u0093\b\b\n\b\f\b\u0096\t\b\u0001\t\u0001\t\u0001\t\u0000\u0001\u0010"+
		"\n\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0000\u0005\u0001\u0000"+
		"\u0010\u0012\u0001\u0000\u0013\u0015\u0001\u0000\u0010\u0011\u0001\u0000"+
		"\u0016\u001b\u0002\u0000\u001c\u001f$%\u00ab\u0000\u0015\u0001\u0000\u0000"+
		"\u0000\u0002\u001c\u0001\u0000\u0000\u0000\u0004#\u0001\u0000\u0000\u0000"+
		"\u0006*\u0001\u0000\u0000\u0000\b,\u0001\u0000\u0000\u0000\nR\u0001\u0000"+
		"\u0000\u0000\fh\u0001\u0000\u0000\u0000\u000ej\u0001\u0000\u0000\u0000"+
		"\u0010\u0084\u0001\u0000\u0000\u0000\u0012\u0097\u0001\u0000\u0000\u0000"+
		"\u0014\u0016\u0003\u0002\u0001\u0000\u0015\u0014\u0001\u0000\u0000\u0000"+
		"\u0015\u0016\u0001\u0000\u0000\u0000\u0016\u0017\u0001\u0000\u0000\u0000"+
		"\u0017\u0018\u0005\u0000\u0000\u0001\u0018\u0001\u0001\u0000\u0000\u0000"+
		"\u0019\u001b\u0003\u0004\u0002\u0000\u001a\u0019\u0001\u0000\u0000\u0000"+
		"\u001b\u001e\u0001\u0000\u0000\u0000\u001c\u001a\u0001\u0000\u0000\u0000"+
		"\u001c\u001d\u0001\u0000\u0000\u0000\u001d!\u0001\u0000\u0000\u0000\u001e"+
		"\u001c\u0001\u0000\u0000\u0000\u001f\"\u0003\u0006\u0003\u0000 \"\u0003"+
		"\u0004\u0002\u0000!\u001f\u0001\u0000\u0000\u0000! \u0001\u0000\u0000"+
		"\u0000\"\u0003\u0001\u0000\u0000\u0000#$\u0003\u0006\u0003\u0000$%\u0005"+
		"\u0001\u0000\u0000%\u0005\u0001\u0000\u0000\u0000&+\u0003\u000e\u0007"+
		"\u0000\'+\u0003\f\u0006\u0000(+\u0003\b\u0004\u0000)+\u0003\n\u0005\u0000"+
		"*&\u0001\u0000\u0000\u0000*\'\u0001\u0000\u0000\u0000*(\u0001\u0000\u0000"+
		"\u0000*)\u0001\u0000\u0000\u0000+\u0007\u0001\u0000\u0000\u0000,-\u0005"+
		"\u0002\u0000\u0000-.\u0003\u0010\b\u0000./\u0005\u0003\u0000\u0000/2\u0003"+
		"\u0002\u0001\u000001\u0005\u0004\u0000\u000013\u0003\u0002\u0001\u0000"+
		"20\u0001\u0000\u0000\u000023\u0001\u0000\u0000\u000034\u0001\u0000\u0000"+
		"\u000045\u0005\u0005\u0000\u00005\t\u0001\u0000\u0000\u00006:\u0005\u0006"+
		"\u0000\u000079\u0003\u0004\u0002\u000087\u0001\u0000\u0000\u00009<\u0001"+
		"\u0000\u0000\u0000:8\u0001\u0000\u0000\u0000:;\u0001\u0000\u0000\u0000"+
		";A\u0001\u0000\u0000\u0000<:\u0001\u0000\u0000\u0000=>\u0005\u0007\u0000"+
		"\u0000>B\u0003\u0010\b\u0000?@\u0005\b\u0000\u0000@B\u0003\u0010\b\u0000"+
		"A=\u0001\u0000\u0000\u0000A?\u0001\u0000\u0000\u0000BC\u0001\u0000\u0000"+
		"\u0000CD\u0005\t\u0000\u0000DE\u0003\u0002\u0001\u0000EF\u0005\u0005\u0000"+
		"\u0000FS\u0001\u0000\u0000\u0000GH\u0005\u0006\u0000\u0000HM\u0003\u0002"+
		"\u0001\u0000IJ\u0005\u0007\u0000\u0000JN\u0003\u0010\b\u0000KL\u0005\b"+
		"\u0000\u0000LN\u0003\u0010\b\u0000MI\u0001\u0000\u0000\u0000MK\u0001\u0000"+
		"\u0000\u0000NO\u0001\u0000\u0000\u0000OP\u0005\t\u0000\u0000PQ\u0005\u0005"+
		"\u0000\u0000QS\u0001\u0000\u0000\u0000R6\u0001\u0000\u0000\u0000RG\u0001"+
		"\u0000\u0000\u0000S\u000b\u0001\u0000\u0000\u0000TZ\u0005\n\u0000\u0000"+
		"UV\u0003\u0010\b\u0000VW\u0005\u000b\u0000\u0000WY\u0001\u0000\u0000\u0000"+
		"XU\u0001\u0000\u0000\u0000Y\\\u0001\u0000\u0000\u0000ZX\u0001\u0000\u0000"+
		"\u0000Z[\u0001\u0000\u0000\u0000[]\u0001\u0000\u0000\u0000\\Z\u0001\u0000"+
		"\u0000\u0000]i\u0003\u0010\b\u0000^d\u0005\f\u0000\u0000_`\u0003\u0010"+
		"\b\u0000`a\u0005\u000b\u0000\u0000ac\u0001\u0000\u0000\u0000b_\u0001\u0000"+
		"\u0000\u0000cf\u0001\u0000\u0000\u0000db\u0001\u0000\u0000\u0000de\u0001"+
		"\u0000\u0000\u0000eg\u0001\u0000\u0000\u0000fd\u0001\u0000\u0000\u0000"+
		"gi\u0003\u0010\b\u0000hT\u0001\u0000\u0000\u0000h^\u0001\u0000\u0000\u0000"+
		"i\r\u0001\u0000\u0000\u0000jk\u0003\u0012\t\u0000kl\u0005\r\u0000\u0000"+
		"lm\u0003\u0010\b\u0000m\u000f\u0001\u0000\u0000\u0000no\u0006\b\uffff"+
		"\uffff\u0000op\u0005\u000e\u0000\u0000pq\u0003\u0010\b\u0000qr\u0005\u000f"+
		"\u0000\u0000r\u0085\u0001\u0000\u0000\u0000st\u0007\u0000\u0000\u0000"+
		"t\u0085\u0003\u0010\b\ru\u0085\u0005\'\u0000\u0000v\u0085\u0005(\u0000"+
		"\u0000w\u0085\u0003\u0012\t\u0000x\u0085\u0005&\u0000\u0000y\u0085\u0005"+
		"\"\u0000\u0000z{\u0005#\u0000\u0000{|\u0005\u000e\u0000\u0000|}\u0003"+
		"\u0010\b\u0000}~\u0005\u000f\u0000\u0000~\u0085\u0001\u0000\u0000\u0000"+
		"\u007f\u0081\u0005 \u0000\u0000\u0080\u0082\u0003\u0010\b\u0000\u0081"+
		"\u0080\u0001\u0000\u0000\u0000\u0081\u0082\u0001\u0000\u0000\u0000\u0082"+
		"\u0085\u0001\u0000\u0000\u0000\u0083\u0085\u0005!\u0000\u0000\u0084n\u0001"+
		"\u0000\u0000\u0000\u0084s\u0001\u0000\u0000\u0000\u0084u\u0001\u0000\u0000"+
		"\u0000\u0084v\u0001\u0000\u0000\u0000\u0084w\u0001\u0000\u0000\u0000\u0084"+
		"x\u0001\u0000\u0000\u0000\u0084y\u0001\u0000\u0000\u0000\u0084z\u0001"+
		"\u0000\u0000\u0000\u0084\u007f\u0001\u0000\u0000\u0000\u0084\u0083\u0001"+
		"\u0000\u0000\u0000\u0085\u0094\u0001\u0000\u0000\u0000\u0086\u0087\n\f"+
		"\u0000\u0000\u0087\u0088\u0007\u0001\u0000\u0000\u0088\u0093\u0003\u0010"+
		"\b\r\u0089\u008a\n\u000b\u0000\u0000\u008a\u008b\u0007\u0002\u0000\u0000"+
		"\u008b\u0093\u0003\u0010\b\f\u008c\u008d\n\n\u0000\u0000\u008d\u008e\u0007"+
		"\u0003\u0000\u0000\u008e\u0093\u0003\u0010\b\u000b\u008f\u0090\n\t\u0000"+
		"\u0000\u0090\u0091\u0007\u0004\u0000\u0000\u0091\u0093\u0003\u0010\b\n"+
		"\u0092\u0086\u0001\u0000\u0000\u0000\u0092\u0089\u0001\u0000\u0000\u0000"+
		"\u0092\u008c\u0001\u0000\u0000\u0000\u0092\u008f\u0001\u0000\u0000\u0000"+
		"\u0093\u0096\u0001\u0000\u0000\u0000\u0094\u0092\u0001\u0000\u0000\u0000"+
		"\u0094\u0095\u0001\u0000\u0000\u0000\u0095\u0011\u0001\u0000\u0000\u0000"+
		"\u0096\u0094\u0001\u0000\u0000\u0000\u0097\u0098\u0005)\u0000\u0000\u0098"+
		"\u0013\u0001\u0000\u0000\u0000\u0010\u0015\u001c!*2:AMRZdh\u0081\u0084"+
		"\u0092\u0094";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}