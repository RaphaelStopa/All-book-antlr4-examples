import antlr.LExpr;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class LexprMain {

    public static void main(String[] args) throws IOException {
        final CodePointCharStream input = CharStreams.fromString("1+2*3");
        antlr.LExprLexer lexer = new antlr.LExprLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        antlr.LExprParser parser = new antlr.LExprParser(tokens);
        parser.setBuildParseTree(true);      // tell ANTLR to build a parse tree
        ParseTree tree = parser.s(); // parse
        // show tree in text form
        System.out.println(tree.toStringTree(parser));

        ParseTreeWalker walker = new ParseTreeWalker();
        LExpr evalProp = new LExpr();
        walker.walk(evalProp, tree);
        System.out.println("properties result = " +evalProp.getValue(tree));
    }
}
