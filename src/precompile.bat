java -cp ".;.\simpledb\parse\antlr\antlr-4.5.3-complete.jar" org.antlr.v4.Tool .\simpledb\parse\antlr\SQLBasic.g4

echo package simpledb.parse.antlr; > tempfile.txt
type .\simpledb\parse\antlr\SQLBasicBaseListener.java >> .\tempfile.txt
type .\tempfile.txt > .\simpledb\parse\antlr\SQLBasicBaseListener.java

echo package simpledb.parse.antlr; > tempfile.txt
type .\simpledb\parse\antlr\SQLBasicLexer.java >> .\tempfile.txt
type .\tempfile.txt > .\simpledb\parse\antlr\SQLBasicLexer.java

echo package simpledb.parse.antlr; > tempfile.txt
type .\simpledb\parse\antlr\SQLBasicListener.java >> .\tempfile.txt
type .\tempfile.txt > .\simpledb\parse\antlr\SQLBasicListener.java

echo package simpledb.parse.antlr; > tempfile.txt
type .\simpledb\parse\antlr\SQLBasicParser.java >> .\tempfile.txt
type .\tempfile.txt > .\simpledb\parse\antlr\SQLBasicParser.java

javac -cp ".;.\simpledb\parse\antlr\antlr-4.5.3-complete.jar" .\simpledb\parse\antlr\SQLBasic*.java
