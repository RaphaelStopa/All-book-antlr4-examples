import antlr.HelloWalker;
import antlr.gen.antlr.HelloLexer;
import antlr.gen.antlr.HelloParser;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;

public class Sample {
    public static void main(String[] args) throws IOException {
        final CodePointCharStream input = CharStreams.fromString("hello rrr");


        // create a lexer that feeds off of input CharStream
        HelloLexer lexer = new HelloLexer( input);

        // create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream( lexer );

        // create a parser that feeds off the tokens buffer
        HelloParser parser = new HelloParser( tokens );

        ParseTree tree = parser.r();  // begin parsing at rule r
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk( new HelloWalker(), tree );
    }
}
