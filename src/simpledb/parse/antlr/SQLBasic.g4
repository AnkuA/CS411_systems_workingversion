grammar SQLBasic;

@parser::members 
{
  @Override
  public void notifyErrorListeners(Token offendingToken, String msg, RecognitionException ex)
  {
    throw new RuntimeException(msg); 
  }
}

@lexer::members 
{
  @Override
  public void recover(RecognitionException ex) 
  {
    throw new RuntimeException(ex.getMessage()); 
  }
}

parse
 : select ';' EOF
 | error* EOF
 ;

error
 : UNEXPECTED_CHAR
	{ throw new RuntimeException("UNEXPECTED_CHAR=" + $UNEXPECTED_CHAR.text); }
 ;

select
 : K_SELECT optional_top_term? distinct_or_all? selectexpressions K_FROM fromexpressions
   optional_where_expression? optional_group_by_expression? optional_having_expression?
   optional_order_by_expression? optional_limit_expression? optional_offset_expression?
 ;

optional_top_term
 : K_TOP POSITIVE_INT
 ;

distinct_or_all
 : K_DISTINCT
 | K_ALL
 ;

selectexpressions
 : selectexpression
 | selectexpression ',' selectexpressions
 ;

selectexpression
 : simpleselectexpression
 | aggregateselectexpression
 ;

simpleselectexpression
 : '*'
 | fullname as_alias_expression?
 | name '.' '*'
 ;

aggregateselectexpression
 : aggregation '(' simpleselectexpression ')'
 ;

aggregation
 : K_COUNT
 | K_AVG
 | K_MAX
 | K_MIN
 ;

fromexpressions
 : fromexpression
 | fromexpression ',' fromexpressions
 ;

fromexpression
 : name as_alias_expression?
 ;

name
 : '`' IDENTIFIER '`'
 | '"' IDENTIFIER '"'
 | '\'' IDENTIFIER '\''
 | IDENTIFIER
 ;

fullname
 : name
 | name '.' name
 ;

optional_where_expression
 : K_WHERE expression
 ;

optional_group_by_expression
 : K_GROUP K_BY fullname
 ;

optional_having_expression
 : K_HAVING expression
 ;

optional_order_by_expression
 : K_ORDER K_BY fullname sort_order? null_order?
 ;

sort_order
 : K_ASC
 | K_DESC
 ;

null_order
 : K_NULLS K_LAST
 | K_NULLS K_FIRST
 ;

optional_limit_expression
 : K_LIMIT POSITIVE_INT
 ;

optional_offset_expression
 : unmatchable { /*nothing, not to be implemented*/ }
 ;

expression
 : andcondition
 | andcondition K_OR expression
 ;

andcondition
 : condition
 | condition K_AND andcondition
 ;

condition
 : operand COMPARATOR operand
 | K_NOT condition
 | '(' expression ')'
 ;

COMPARATOR
 : '='
 | '>'
 | '<'
 | '<='
 | '>='
 | '<>'
 | '!='
 ;

operand
 : fullname
 | constant
 ;

constant
 : intconstant
 | STRINGCONSTANT
 | floatconstant
 ;

intconstant
 : PLUS_OR_MINUS? POSITIVE_INT
 ;

STRINGCONSTANT
 : '\'' ( ~'\'' | '\'\'' )* '\''
 ;

floatconstant
 : PLUS_OR_MINUS? FLOATCONTENTS
 ;

FLOATCONTENTS
 : DIGIT* '.' DIGIT+
 ;

POSITIVE_INT
 : DIGIT+
 ;

PLUS_OR_MINUS
 : '+'
 | '-'
 ;

as_alias_expression
 : K_AS name
 ;

nothing
 : (EOF EOF)?
 ;

unmatchable
 : EOF EOF
 ;










// http://www.sqlite.org/lang_keywords.html
K_ABORT : A B O R T;
K_ACTION : A C T I O N;
K_ADD : A D D;
K_AFTER : A F T E R;
K_ALL : A L L;
K_DISTINCT : D I S T I N C T;
K_ALTER : A L T E R;
K_ANALYZE : A N A L Y Z E;
K_AND : A N D;
K_AS : A S;
K_ASC : A S C;
K_BY : B Y;
K_DESC : D E S C;
K_FOR : F O R;
K_FROM : F R O M;
K_GROUP : G R O U P;
K_HAVING : H A V I N G;
K_IN : I N;
K_IS : I S;
K_LIMIT : L I M I T;
K_NOT : N O T;
K_NULL : N U L L;
K_OF : O F;
K_OFFSET : O F F S E T;
K_ON : O N;
K_OR : O R;
K_ORDER : O R D E R;
K_SELECT : S E L E C T;
K_TO : T O;
K_WHERE : W H E R E;
K_WITH : W I T H;
K_NULLS : N U L L S;
K_TOP : T O P;
K_COUNT: C O U N T;
K_AVG : A V G;
K_MAX : M A X;
K_MIN : M I N;
K_FIRST : F I R S T;
K_LAST : L A S T;

IDENTIFIER
 : [a-zA-Z_] [a-zA-Z_0-9]*
 ;

SINGLE_LINE_COMMENT
 : '--' ~[\r\n]* -> channel(HIDDEN)
 ;

MULTILINE_COMMENT
 : '/*' .*? ( '*/' | EOF ) -> channel(HIDDEN)
 ;

SPACES
 : [ \u000B\t\r\n] -> channel(HIDDEN)
 ;

UNEXPECTED_CHAR
 : .
 ;

fragment DIGIT : [0-9];
fragment A : [aA];
fragment B : [bB];
fragment C : [cC];
fragment D : [dD];
fragment E : [eE];
fragment F : [fF];
fragment G : [gG];
fragment H : [hH];
fragment I : [iI];
fragment J : [jJ];
fragment K : [kK];
fragment L : [lL];
fragment M : [mM];
fragment N : [nN];
fragment O : [oO];
fragment P : [pP];
fragment Q : [qQ];
fragment R : [rR];
fragment S : [sS];
fragment T : [tT];
fragment U : [uU];
fragment V : [vV];
fragment W : [wW];
fragment X : [xX];
fragment Y : [yY];
fragment Z : [zZ];
