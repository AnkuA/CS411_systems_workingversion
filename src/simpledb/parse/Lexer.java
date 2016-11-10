package simpledb.parse;

import java.util.*;
import java.io.*;
// AA: Added this for regex support
import java.util.regex.Pattern;

/**
 * The lexical analyzer.
 * @author Edward Sciore
 */
public class Lexer {
   private Collection<String> keywords;
   private StreamTokenizer tok;
   
   /**
    * Creates a new lexical analyzer for SQL statement s.
    * @param s the SQL statement
    */
   public Lexer(String s) {
      initKeywords();
      tok = new StreamTokenizer(new StringReader(s));
      tok.ordinaryChar('.');
      tok.lowerCaseMode(true); //ids and keywords are converted
      nextToken();
   }
   
//Methods to check the status of the current token
   
   /**
    * Returns true if the current token is
    * the specified delimiter character.
    * @param d a character denoting the delimiter
    * @return true if the delimiter is the current token
    */
   public boolean matchDelim(char d) {
      return d == (char)tok.ttype;
   }
   
   /*
    * AA: Added a regex to test whether a string is a float or not
    * Returns true if inString is a format compatible with float 
    */
   private boolean testFloatRegex(String inString) {
      final String Digits     = "(\\p{Digit}+)";
      final String HexDigits  = "(\\p{XDigit}+)";
      // an exponent is 'e' or 'E' followed by an optionally
      // signed decimal integer.
      final String Exp        = "[eE][+-]?"+Digits;
      final String fpRegex    =
          ("[\\x00-\\x20]*"+  // Optional leading "whitespace"
           "[+-]?(" + // Optional sign character
           "NaN|" +           // "NaN" string
           "Infinity|" +      // "Infinity" string

           // A decimal floating-point string representing a finite positive
           // number without a leading sign has at most five basic pieces:
           // Digits . Digits ExponentPart FloatTypeSuffix
           //
           // Since this method allows integer-only strings as input
           // in addition to strings of floating-point literals, the
           // two sub-patterns below are simplifications of the grammar
           // productions from section 3.10.2 of
           // The Java Language Specification.
           
           // Digits ._opt Digits_opt ExponentPart_opt FloatTypeSuffix_opt
           "((("+Digits+"(\\.)?("+Digits+"?)("+Exp+")?)|"+

           // . Digits ExponentPart_opt FloatTypeSuffix_opt
           "(\\.("+Digits+")("+Exp+")?)|"+

           // Hexadecimal strings
           "((" +
           // 0[xX] HexDigits ._opt BinaryExponent FloatTypeSuffix_opt
           "(0[xX]" + HexDigits + "(\\.)?)|" +

           // 0[xX] HexDigits_opt . HexDigits BinaryExponent FloatTypeSuffix_opt
           "(0[xX]" + HexDigits + "?(\\.)" + HexDigits + ")" +

           ")[pP][+-]?" + Digits + "))" +
	       "[fFdD]?))" +
	       "[\\x00-\\x20]*");// Optional trailing "whitespace"

      if (Pattern.matches(fpRegex, inString))
          return true;
      else {
          return false;
      }
   }
   
   /**
    * AA: Added this
    * Returns true if the current token is a float.
    * @return true if the current token is a float
    */
   public boolean matchFloatConstant() {
      return tok.ttype == StreamTokenizer.TT_NUMBER;
   }
   
   /**
    * Returns true if the current token is an integer.
    * @return true if the current token is an integer
    */
   public boolean matchIntConstant() {
	   // AA: Added additional check for integer divisibility
      return tok.ttype == StreamTokenizer.TT_NUMBER && ((tok.nval % 1) == 0);
   }
   
   /**
    * Returns true if the current token is a string.
    * @return true if the current token is a string
    */
   public boolean matchStringConstant() {
      return '\'' == (char)tok.ttype;
   }
   
   /**
    * Returns true if the current token is the specified keyword.
    * @param w the keyword string
    * @return true if that keyword is the current token
    */
   public boolean matchKeyword(String w) {
      return tok.ttype == StreamTokenizer.TT_WORD && tok.sval.equals(w);
   }
   
   /**
    * Returns true if the current token is a legal identifier.
    * @return true if the current token is an identifier
    */
   public boolean matchId() {
      //return  tok.ttype==StreamTokenizer.TT_WORD && !keywords.contains(tok.sval);
	   if(tok.sval !=null && tok.sval.equals('*'))
		   return true;
	   return  tok.ttype==StreamTokenizer.TT_WORD && !keywords.contains(tok.sval);
   }
   
//Methods to "eat" the current token
   
   /**
    * Throws an exception if the current token is not the
    * specified delimiter. 
    * Otherwise, moves to the next token.
    * @param d a character denoting the delimiter
    */
   public void eatDelim(char d) {
      if (!matchDelim(d))
         throw new BadSyntaxException();
      nextToken();
   }
   
   /**
    * AA: Added this
    * Throws an exception if the current token is not 
    * a float. 
    * Otherwise, returns that float and moves to the next token.
    * @return the float value of the current token
    */
   public float eatFloatConstant() {
      if (!matchFloatConstant())
         throw new BadSyntaxException();
      float i = (float) tok.nval;
      nextToken();
      return i;
   }
   
   /**
    * Throws an exception if the current token is not 
    * an integer. 
    * Otherwise, returns that integer and moves to the next token.
    * @return the integer value of the current token
    */
   public int eatIntConstant() {
      if (!matchIntConstant())
         throw new BadSyntaxException();
      int i = (int) tok.nval;
      nextToken();
      return i;
   }
   
   /**
    * Throws an exception if the current token is not 
    * a string. 
    * Otherwise, returns that string and moves to the next token.
    * @return the string value of the current token
    */
   public String eatStringConstant() {
      if (!matchStringConstant())
         throw new BadSyntaxException();
      String s = tok.sval; //constants are not converted to lower case
      nextToken();
      return s;
   }
   
   /**
    * Throws an exception if the current token is not the
    * specified keyword. 
    * Otherwise, moves to the next token.
    * @param w the keyword string
    */
   public void eatKeyword(String w) {
      if (!matchKeyword(w))
         throw new BadSyntaxException();
      nextToken();
   }
   
   /**
    * Throws an exception if the current token is not 
    * an identifier. 
    * Otherwise, returns the identifier string 
    * and moves to the next token.
    * @return the string value of the current token
    */
   public String eatId() {
//      if (!matchId())
//         throw new BadSyntaxException();
//      String s = tok.sval;
//      nextToken();
//      return s;
      String s;
      if(tok.sval.equals('*')){
    	  System.out.println("Yes");
    	  s = "*";
      }else{
    	  s = tok.sval;
      }
      nextToken();
      return s;
   }
   
   private void nextToken() {
      try {
         tok.nextToken();
      }
      catch(IOException e) {
         throw new BadSyntaxException();
      }
   }
   
   private void initKeywords() {
      keywords = Arrays.asList("select", "from", "where", "and","or",
                               "insert", "into", "values", "delete", "update", "set", 
                               "create", "table", "int", "varchar", "view", "as", "index", "on");
   }
}