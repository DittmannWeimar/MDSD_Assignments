package dk.sdu.mmmi.mdsd.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import dk.sdu.mmmi.mdsd.services.MathGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMathParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'var'", "'='", "'+'", "'-'", "'*'", "'/'", "'('", "')'", "'let'", "'in'", "'end'"
    };
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalMathParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalMathParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalMathParser.tokenNames; }
    public String getGrammarFileName() { return "InternalMath.g"; }



     	private MathGrammarAccess grammarAccess;

        public InternalMathParser(TokenStream input, MathGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "MathExp";
       	}

       	@Override
       	protected MathGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleMathExp"
    // InternalMath.g:64:1: entryRuleMathExp returns [EObject current=null] : iv_ruleMathExp= ruleMathExp EOF ;
    public final EObject entryRuleMathExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMathExp = null;


        try {
            // InternalMath.g:64:48: (iv_ruleMathExp= ruleMathExp EOF )
            // InternalMath.g:65:2: iv_ruleMathExp= ruleMathExp EOF
            {
             newCompositeNode(grammarAccess.getMathExpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMathExp=ruleMathExp();

            state._fsp--;

             current =iv_ruleMathExp; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMathExp"


    // $ANTLR start "ruleMathExp"
    // InternalMath.g:71:1: ruleMathExp returns [EObject current=null] : ( (lv_exps_0_0= ruleMath ) )+ ;
    public final EObject ruleMathExp() throws RecognitionException {
        EObject current = null;

        EObject lv_exps_0_0 = null;



        	enterRule();

        try {
            // InternalMath.g:77:2: ( ( (lv_exps_0_0= ruleMath ) )+ )
            // InternalMath.g:78:2: ( (lv_exps_0_0= ruleMath ) )+
            {
            // InternalMath.g:78:2: ( (lv_exps_0_0= ruleMath ) )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalMath.g:79:3: (lv_exps_0_0= ruleMath )
            	    {
            	    // InternalMath.g:79:3: (lv_exps_0_0= ruleMath )
            	    // InternalMath.g:80:4: lv_exps_0_0= ruleMath
            	    {

            	    				newCompositeNode(grammarAccess.getMathExpAccess().getExpsMathParserRuleCall_0());
            	    			
            	    pushFollow(FOLLOW_3);
            	    lv_exps_0_0=ruleMath();

            	    state._fsp--;


            	    				if (current==null) {
            	    					current = createModelElementForParent(grammarAccess.getMathExpRule());
            	    				}
            	    				add(
            	    					current,
            	    					"exps",
            	    					lv_exps_0_0,
            	    					"dk.sdu.mmmi.mdsd.Math.Math");
            	    				afterParserOrEnumRuleCall();
            	    			

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMathExp"


    // $ANTLR start "entryRuleMath"
    // InternalMath.g:100:1: entryRuleMath returns [EObject current=null] : iv_ruleMath= ruleMath EOF ;
    public final EObject entryRuleMath() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMath = null;


        try {
            // InternalMath.g:100:45: (iv_ruleMath= ruleMath EOF )
            // InternalMath.g:101:2: iv_ruleMath= ruleMath EOF
            {
             newCompositeNode(grammarAccess.getMathRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMath=ruleMath();

            state._fsp--;

             current =iv_ruleMath; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMath"


    // $ANTLR start "ruleMath"
    // InternalMath.g:107:1: ruleMath returns [EObject current=null] : (otherlv_0= 'var' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_exp_3_0= ruleExp ) ) ) ;
    public final EObject ruleMath() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_exp_3_0 = null;



        	enterRule();

        try {
            // InternalMath.g:113:2: ( (otherlv_0= 'var' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_exp_3_0= ruleExp ) ) ) )
            // InternalMath.g:114:2: (otherlv_0= 'var' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_exp_3_0= ruleExp ) ) )
            {
            // InternalMath.g:114:2: (otherlv_0= 'var' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_exp_3_0= ruleExp ) ) )
            // InternalMath.g:115:3: otherlv_0= 'var' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_exp_3_0= ruleExp ) )
            {
            otherlv_0=(Token)match(input,11,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getMathAccess().getVarKeyword_0());
            		
            // InternalMath.g:119:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMath.g:120:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMath.g:120:4: (lv_name_1_0= RULE_ID )
            // InternalMath.g:121:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_1_0, grammarAccess.getMathAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMathRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getMathAccess().getEqualsSignKeyword_2());
            		
            // InternalMath.g:141:3: ( (lv_exp_3_0= ruleExp ) )
            // InternalMath.g:142:4: (lv_exp_3_0= ruleExp )
            {
            // InternalMath.g:142:4: (lv_exp_3_0= ruleExp )
            // InternalMath.g:143:5: lv_exp_3_0= ruleExp
            {

            					newCompositeNode(grammarAccess.getMathAccess().getExpExpParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_exp_3_0=ruleExp();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMathRule());
            					}
            					set(
            						current,
            						"exp",
            						lv_exp_3_0,
            						"dk.sdu.mmmi.mdsd.Math.Exp");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMath"


    // $ANTLR start "entryRuleExp"
    // InternalMath.g:164:1: entryRuleExp returns [EObject current=null] : iv_ruleExp= ruleExp EOF ;
    public final EObject entryRuleExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExp = null;


        try {
            // InternalMath.g:164:44: (iv_ruleExp= ruleExp EOF )
            // InternalMath.g:165:2: iv_ruleExp= ruleExp EOF
            {
             newCompositeNode(grammarAccess.getExpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExp=ruleExp();

            state._fsp--;

             current =iv_ruleExp; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExp"


    // $ANTLR start "ruleExp"
    // InternalMath.g:171:1: ruleExp returns [EObject current=null] : this_PlusMinus_0= rulePlusMinus ;
    public final EObject ruleExp() throws RecognitionException {
        EObject current = null;

        EObject this_PlusMinus_0 = null;



        	enterRule();

        try {
            // InternalMath.g:177:2: (this_PlusMinus_0= rulePlusMinus )
            // InternalMath.g:178:2: this_PlusMinus_0= rulePlusMinus
            {

            		newCompositeNode(grammarAccess.getExpAccess().getPlusMinusParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_PlusMinus_0=rulePlusMinus();

            state._fsp--;


            		current = this_PlusMinus_0;
            		afterParserOrEnumRuleCall();
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExp"


    // $ANTLR start "entryRulePlusMinus"
    // InternalMath.g:189:1: entryRulePlusMinus returns [EObject current=null] : iv_rulePlusMinus= rulePlusMinus EOF ;
    public final EObject entryRulePlusMinus() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePlusMinus = null;


        try {
            // InternalMath.g:189:50: (iv_rulePlusMinus= rulePlusMinus EOF )
            // InternalMath.g:190:2: iv_rulePlusMinus= rulePlusMinus EOF
            {
             newCompositeNode(grammarAccess.getPlusMinusRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePlusMinus=rulePlusMinus();

            state._fsp--;

             current =iv_rulePlusMinus; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePlusMinus"


    // $ANTLR start "rulePlusMinus"
    // InternalMath.g:196:1: rulePlusMinus returns [EObject current=null] : (this_MultiDiv_0= ruleMultiDiv ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiDiv ) ) )* ) ;
    public final EObject rulePlusMinus() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_MultiDiv_0 = null;

        EObject lv_right_5_0 = null;



        	enterRule();

        try {
            // InternalMath.g:202:2: ( (this_MultiDiv_0= ruleMultiDiv ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiDiv ) ) )* ) )
            // InternalMath.g:203:2: (this_MultiDiv_0= ruleMultiDiv ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiDiv ) ) )* )
            {
            // InternalMath.g:203:2: (this_MultiDiv_0= ruleMultiDiv ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiDiv ) ) )* )
            // InternalMath.g:204:3: this_MultiDiv_0= ruleMultiDiv ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiDiv ) ) )*
            {

            			newCompositeNode(grammarAccess.getPlusMinusAccess().getMultiDivParserRuleCall_0());
            		
            pushFollow(FOLLOW_7);
            this_MultiDiv_0=ruleMultiDiv();

            state._fsp--;


            			current = this_MultiDiv_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalMath.g:212:3: ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiDiv ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=13 && LA3_0<=14)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalMath.g:213:4: ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiDiv ) )
            	    {
            	    // InternalMath.g:213:4: ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) )
            	    int alt2=2;
            	    int LA2_0 = input.LA(1);

            	    if ( (LA2_0==13) ) {
            	        alt2=1;
            	    }
            	    else if ( (LA2_0==14) ) {
            	        alt2=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 2, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt2) {
            	        case 1 :
            	            // InternalMath.g:214:5: ( () otherlv_2= '+' )
            	            {
            	            // InternalMath.g:214:5: ( () otherlv_2= '+' )
            	            // InternalMath.g:215:6: () otherlv_2= '+'
            	            {
            	            // InternalMath.g:215:6: ()
            	            // InternalMath.g:216:7: 
            	            {

            	            							current = forceCreateModelElementAndSet(
            	            								grammarAccess.getPlusMinusAccess().getPlusLeftAction_1_0_0_0(),
            	            								current);
            	            						

            	            }

            	            otherlv_2=(Token)match(input,13,FOLLOW_6); 

            	            						newLeafNode(otherlv_2, grammarAccess.getPlusMinusAccess().getPlusSignKeyword_1_0_0_1());
            	            					

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalMath.g:228:5: ( () otherlv_4= '-' )
            	            {
            	            // InternalMath.g:228:5: ( () otherlv_4= '-' )
            	            // InternalMath.g:229:6: () otherlv_4= '-'
            	            {
            	            // InternalMath.g:229:6: ()
            	            // InternalMath.g:230:7: 
            	            {

            	            							current = forceCreateModelElementAndSet(
            	            								grammarAccess.getPlusMinusAccess().getMinusLeftAction_1_0_1_0(),
            	            								current);
            	            						

            	            }

            	            otherlv_4=(Token)match(input,14,FOLLOW_6); 

            	            						newLeafNode(otherlv_4, grammarAccess.getPlusMinusAccess().getHyphenMinusKeyword_1_0_1_1());
            	            					

            	            }


            	            }
            	            break;

            	    }

            	    // InternalMath.g:242:4: ( (lv_right_5_0= ruleMultiDiv ) )
            	    // InternalMath.g:243:5: (lv_right_5_0= ruleMultiDiv )
            	    {
            	    // InternalMath.g:243:5: (lv_right_5_0= ruleMultiDiv )
            	    // InternalMath.g:244:6: lv_right_5_0= ruleMultiDiv
            	    {

            	    						newCompositeNode(grammarAccess.getPlusMinusAccess().getRightMultiDivParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_7);
            	    lv_right_5_0=ruleMultiDiv();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getPlusMinusRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_5_0,
            	    							"dk.sdu.mmmi.mdsd.Math.MultiDiv");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePlusMinus"


    // $ANTLR start "entryRuleMultiDiv"
    // InternalMath.g:266:1: entryRuleMultiDiv returns [EObject current=null] : iv_ruleMultiDiv= ruleMultiDiv EOF ;
    public final EObject entryRuleMultiDiv() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiDiv = null;


        try {
            // InternalMath.g:266:49: (iv_ruleMultiDiv= ruleMultiDiv EOF )
            // InternalMath.g:267:2: iv_ruleMultiDiv= ruleMultiDiv EOF
            {
             newCompositeNode(grammarAccess.getMultiDivRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMultiDiv=ruleMultiDiv();

            state._fsp--;

             current =iv_ruleMultiDiv; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMultiDiv"


    // $ANTLR start "ruleMultiDiv"
    // InternalMath.g:273:1: ruleMultiDiv returns [EObject current=null] : (this_Primary_0= rulePrimary ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= rulePrimary ) ) )* ) ;
    public final EObject ruleMultiDiv() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_Primary_0 = null;

        EObject lv_right_5_0 = null;



        	enterRule();

        try {
            // InternalMath.g:279:2: ( (this_Primary_0= rulePrimary ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= rulePrimary ) ) )* ) )
            // InternalMath.g:280:2: (this_Primary_0= rulePrimary ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= rulePrimary ) ) )* )
            {
            // InternalMath.g:280:2: (this_Primary_0= rulePrimary ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= rulePrimary ) ) )* )
            // InternalMath.g:281:3: this_Primary_0= rulePrimary ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= rulePrimary ) ) )*
            {

            			newCompositeNode(grammarAccess.getMultiDivAccess().getPrimaryParserRuleCall_0());
            		
            pushFollow(FOLLOW_8);
            this_Primary_0=rulePrimary();

            state._fsp--;


            			current = this_Primary_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalMath.g:289:3: ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= rulePrimary ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>=15 && LA5_0<=16)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalMath.g:290:4: ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= rulePrimary ) )
            	    {
            	    // InternalMath.g:290:4: ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) )
            	    int alt4=2;
            	    int LA4_0 = input.LA(1);

            	    if ( (LA4_0==15) ) {
            	        alt4=1;
            	    }
            	    else if ( (LA4_0==16) ) {
            	        alt4=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 4, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt4) {
            	        case 1 :
            	            // InternalMath.g:291:5: ( () otherlv_2= '*' )
            	            {
            	            // InternalMath.g:291:5: ( () otherlv_2= '*' )
            	            // InternalMath.g:292:6: () otherlv_2= '*'
            	            {
            	            // InternalMath.g:292:6: ()
            	            // InternalMath.g:293:7: 
            	            {

            	            							current = forceCreateModelElementAndSet(
            	            								grammarAccess.getMultiDivAccess().getMultiLeftAction_1_0_0_0(),
            	            								current);
            	            						

            	            }

            	            otherlv_2=(Token)match(input,15,FOLLOW_6); 

            	            						newLeafNode(otherlv_2, grammarAccess.getMultiDivAccess().getAsteriskKeyword_1_0_0_1());
            	            					

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalMath.g:305:5: ( () otherlv_4= '/' )
            	            {
            	            // InternalMath.g:305:5: ( () otherlv_4= '/' )
            	            // InternalMath.g:306:6: () otherlv_4= '/'
            	            {
            	            // InternalMath.g:306:6: ()
            	            // InternalMath.g:307:7: 
            	            {

            	            							current = forceCreateModelElementAndSet(
            	            								grammarAccess.getMultiDivAccess().getDivLeftAction_1_0_1_0(),
            	            								current);
            	            						

            	            }

            	            otherlv_4=(Token)match(input,16,FOLLOW_6); 

            	            						newLeafNode(otherlv_4, grammarAccess.getMultiDivAccess().getSolidusKeyword_1_0_1_1());
            	            					

            	            }


            	            }
            	            break;

            	    }

            	    // InternalMath.g:319:4: ( (lv_right_5_0= rulePrimary ) )
            	    // InternalMath.g:320:5: (lv_right_5_0= rulePrimary )
            	    {
            	    // InternalMath.g:320:5: (lv_right_5_0= rulePrimary )
            	    // InternalMath.g:321:6: lv_right_5_0= rulePrimary
            	    {

            	    						newCompositeNode(grammarAccess.getMultiDivAccess().getRightPrimaryParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_8);
            	    lv_right_5_0=rulePrimary();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getMultiDivRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_5_0,
            	    							"dk.sdu.mmmi.mdsd.Math.Primary");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiDiv"


    // $ANTLR start "entryRulePrimary"
    // InternalMath.g:343:1: entryRulePrimary returns [EObject current=null] : iv_rulePrimary= rulePrimary EOF ;
    public final EObject entryRulePrimary() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimary = null;


        try {
            // InternalMath.g:343:48: (iv_rulePrimary= rulePrimary EOF )
            // InternalMath.g:344:2: iv_rulePrimary= rulePrimary EOF
            {
             newCompositeNode(grammarAccess.getPrimaryRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePrimary=rulePrimary();

            state._fsp--;

             current =iv_rulePrimary; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimary"


    // $ANTLR start "rulePrimary"
    // InternalMath.g:350:1: rulePrimary returns [EObject current=null] : (this_Number_0= ruleNumber | this_Parenthesis_1= ruleParenthesis | this_VariableUse_2= ruleVariableUse | this_Let_3= ruleLet ) ;
    public final EObject rulePrimary() throws RecognitionException {
        EObject current = null;

        EObject this_Number_0 = null;

        EObject this_Parenthesis_1 = null;

        EObject this_VariableUse_2 = null;

        EObject this_Let_3 = null;



        	enterRule();

        try {
            // InternalMath.g:356:2: ( (this_Number_0= ruleNumber | this_Parenthesis_1= ruleParenthesis | this_VariableUse_2= ruleVariableUse | this_Let_3= ruleLet ) )
            // InternalMath.g:357:2: (this_Number_0= ruleNumber | this_Parenthesis_1= ruleParenthesis | this_VariableUse_2= ruleVariableUse | this_Let_3= ruleLet )
            {
            // InternalMath.g:357:2: (this_Number_0= ruleNumber | this_Parenthesis_1= ruleParenthesis | this_VariableUse_2= ruleVariableUse | this_Let_3= ruleLet )
            int alt6=4;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt6=1;
                }
                break;
            case 17:
                {
                alt6=2;
                }
                break;
            case RULE_ID:
                {
                alt6=3;
                }
                break;
            case 19:
                {
                alt6=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // InternalMath.g:358:3: this_Number_0= ruleNumber
                    {

                    			newCompositeNode(grammarAccess.getPrimaryAccess().getNumberParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Number_0=ruleNumber();

                    state._fsp--;


                    			current = this_Number_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMath.g:367:3: this_Parenthesis_1= ruleParenthesis
                    {

                    			newCompositeNode(grammarAccess.getPrimaryAccess().getParenthesisParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Parenthesis_1=ruleParenthesis();

                    state._fsp--;


                    			current = this_Parenthesis_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalMath.g:376:3: this_VariableUse_2= ruleVariableUse
                    {

                    			newCompositeNode(grammarAccess.getPrimaryAccess().getVariableUseParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_VariableUse_2=ruleVariableUse();

                    state._fsp--;


                    			current = this_VariableUse_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalMath.g:385:3: this_Let_3= ruleLet
                    {

                    			newCompositeNode(grammarAccess.getPrimaryAccess().getLetParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_Let_3=ruleLet();

                    state._fsp--;


                    			current = this_Let_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimary"


    // $ANTLR start "entryRuleParenthesis"
    // InternalMath.g:397:1: entryRuleParenthesis returns [EObject current=null] : iv_ruleParenthesis= ruleParenthesis EOF ;
    public final EObject entryRuleParenthesis() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesis = null;


        try {
            // InternalMath.g:397:52: (iv_ruleParenthesis= ruleParenthesis EOF )
            // InternalMath.g:398:2: iv_ruleParenthesis= ruleParenthesis EOF
            {
             newCompositeNode(grammarAccess.getParenthesisRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParenthesis=ruleParenthesis();

            state._fsp--;

             current =iv_ruleParenthesis; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParenthesis"


    // $ANTLR start "ruleParenthesis"
    // InternalMath.g:404:1: ruleParenthesis returns [EObject current=null] : (otherlv_0= '(' ( (lv_exp_1_0= ruleExp ) ) otherlv_2= ')' ) ;
    public final EObject ruleParenthesis() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_exp_1_0 = null;



        	enterRule();

        try {
            // InternalMath.g:410:2: ( (otherlv_0= '(' ( (lv_exp_1_0= ruleExp ) ) otherlv_2= ')' ) )
            // InternalMath.g:411:2: (otherlv_0= '(' ( (lv_exp_1_0= ruleExp ) ) otherlv_2= ')' )
            {
            // InternalMath.g:411:2: (otherlv_0= '(' ( (lv_exp_1_0= ruleExp ) ) otherlv_2= ')' )
            // InternalMath.g:412:3: otherlv_0= '(' ( (lv_exp_1_0= ruleExp ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,17,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getParenthesisAccess().getLeftParenthesisKeyword_0());
            		
            // InternalMath.g:416:3: ( (lv_exp_1_0= ruleExp ) )
            // InternalMath.g:417:4: (lv_exp_1_0= ruleExp )
            {
            // InternalMath.g:417:4: (lv_exp_1_0= ruleExp )
            // InternalMath.g:418:5: lv_exp_1_0= ruleExp
            {

            					newCompositeNode(grammarAccess.getParenthesisAccess().getExpExpParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_9);
            lv_exp_1_0=ruleExp();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getParenthesisRule());
            					}
            					set(
            						current,
            						"exp",
            						lv_exp_1_0,
            						"dk.sdu.mmmi.mdsd.Math.Exp");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,18,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getParenthesisAccess().getRightParenthesisKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParenthesis"


    // $ANTLR start "entryRuleNumber"
    // InternalMath.g:443:1: entryRuleNumber returns [EObject current=null] : iv_ruleNumber= ruleNumber EOF ;
    public final EObject entryRuleNumber() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumber = null;


        try {
            // InternalMath.g:443:47: (iv_ruleNumber= ruleNumber EOF )
            // InternalMath.g:444:2: iv_ruleNumber= ruleNumber EOF
            {
             newCompositeNode(grammarAccess.getNumberRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNumber=ruleNumber();

            state._fsp--;

             current =iv_ruleNumber; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNumber"


    // $ANTLR start "ruleNumber"
    // InternalMath.g:450:1: ruleNumber returns [EObject current=null] : ( (lv_value_0_0= RULE_INT ) ) ;
    public final EObject ruleNumber() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalMath.g:456:2: ( ( (lv_value_0_0= RULE_INT ) ) )
            // InternalMath.g:457:2: ( (lv_value_0_0= RULE_INT ) )
            {
            // InternalMath.g:457:2: ( (lv_value_0_0= RULE_INT ) )
            // InternalMath.g:458:3: (lv_value_0_0= RULE_INT )
            {
            // InternalMath.g:458:3: (lv_value_0_0= RULE_INT )
            // InternalMath.g:459:4: lv_value_0_0= RULE_INT
            {
            lv_value_0_0=(Token)match(input,RULE_INT,FOLLOW_2); 

            				newLeafNode(lv_value_0_0, grammarAccess.getNumberAccess().getValueINTTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getNumberRule());
            				}
            				setWithLastConsumed(
            					current,
            					"value",
            					lv_value_0_0,
            					"org.eclipse.xtext.common.Terminals.INT");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNumber"


    // $ANTLR start "entryRuleVariableUse"
    // InternalMath.g:478:1: entryRuleVariableUse returns [EObject current=null] : iv_ruleVariableUse= ruleVariableUse EOF ;
    public final EObject entryRuleVariableUse() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableUse = null;


        try {
            // InternalMath.g:478:52: (iv_ruleVariableUse= ruleVariableUse EOF )
            // InternalMath.g:479:2: iv_ruleVariableUse= ruleVariableUse EOF
            {
             newCompositeNode(grammarAccess.getVariableUseRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVariableUse=ruleVariableUse();

            state._fsp--;

             current =iv_ruleVariableUse; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariableUse"


    // $ANTLR start "ruleVariableUse"
    // InternalMath.g:485:1: ruleVariableUse returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleVariableUse() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalMath.g:491:2: ( ( (otherlv_0= RULE_ID ) ) )
            // InternalMath.g:492:2: ( (otherlv_0= RULE_ID ) )
            {
            // InternalMath.g:492:2: ( (otherlv_0= RULE_ID ) )
            // InternalMath.g:493:3: (otherlv_0= RULE_ID )
            {
            // InternalMath.g:493:3: (otherlv_0= RULE_ID )
            // InternalMath.g:494:4: otherlv_0= RULE_ID
            {

            				if (current==null) {
            					current = createModelElement(grammarAccess.getVariableUseRule());
            				}
            			
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            				newLeafNode(otherlv_0, grammarAccess.getVariableUseAccess().getRefMathCrossReference_0());
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariableUse"


    // $ANTLR start "entryRuleLet"
    // InternalMath.g:508:1: entryRuleLet returns [EObject current=null] : iv_ruleLet= ruleLet EOF ;
    public final EObject entryRuleLet() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLet = null;


        try {
            // InternalMath.g:508:44: (iv_ruleLet= ruleLet EOF )
            // InternalMath.g:509:2: iv_ruleLet= ruleLet EOF
            {
             newCompositeNode(grammarAccess.getLetRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLet=ruleLet();

            state._fsp--;

             current =iv_ruleLet; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLet"


    // $ANTLR start "ruleLet"
    // InternalMath.g:515:1: ruleLet returns [EObject current=null] : (otherlv_0= 'let' ( (lv_let_1_0= ruleMath ) ) otherlv_2= 'in' ( (lv_in_3_0= ruleExp ) ) otherlv_4= 'end' ) ;
    public final EObject ruleLet() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_let_1_0 = null;

        EObject lv_in_3_0 = null;



        	enterRule();

        try {
            // InternalMath.g:521:2: ( (otherlv_0= 'let' ( (lv_let_1_0= ruleMath ) ) otherlv_2= 'in' ( (lv_in_3_0= ruleExp ) ) otherlv_4= 'end' ) )
            // InternalMath.g:522:2: (otherlv_0= 'let' ( (lv_let_1_0= ruleMath ) ) otherlv_2= 'in' ( (lv_in_3_0= ruleExp ) ) otherlv_4= 'end' )
            {
            // InternalMath.g:522:2: (otherlv_0= 'let' ( (lv_let_1_0= ruleMath ) ) otherlv_2= 'in' ( (lv_in_3_0= ruleExp ) ) otherlv_4= 'end' )
            // InternalMath.g:523:3: otherlv_0= 'let' ( (lv_let_1_0= ruleMath ) ) otherlv_2= 'in' ( (lv_in_3_0= ruleExp ) ) otherlv_4= 'end'
            {
            otherlv_0=(Token)match(input,19,FOLLOW_10); 

            			newLeafNode(otherlv_0, grammarAccess.getLetAccess().getLetKeyword_0());
            		
            // InternalMath.g:527:3: ( (lv_let_1_0= ruleMath ) )
            // InternalMath.g:528:4: (lv_let_1_0= ruleMath )
            {
            // InternalMath.g:528:4: (lv_let_1_0= ruleMath )
            // InternalMath.g:529:5: lv_let_1_0= ruleMath
            {

            					newCompositeNode(grammarAccess.getLetAccess().getLetMathParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_11);
            lv_let_1_0=ruleMath();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLetRule());
            					}
            					set(
            						current,
            						"let",
            						lv_let_1_0,
            						"dk.sdu.mmmi.mdsd.Math.Math");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,20,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getLetAccess().getInKeyword_2());
            		
            // InternalMath.g:550:3: ( (lv_in_3_0= ruleExp ) )
            // InternalMath.g:551:4: (lv_in_3_0= ruleExp )
            {
            // InternalMath.g:551:4: (lv_in_3_0= ruleExp )
            // InternalMath.g:552:5: lv_in_3_0= ruleExp
            {

            					newCompositeNode(grammarAccess.getLetAccess().getInExpParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_12);
            lv_in_3_0=ruleExp();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLetRule());
            					}
            					set(
            						current,
            						"in",
            						lv_in_3_0,
            						"dk.sdu.mmmi.mdsd.Math.Exp");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,21,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getLetAccess().getEndKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLet"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x00000000000A0030L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000006002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000018002L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000100800L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000200000L});

}