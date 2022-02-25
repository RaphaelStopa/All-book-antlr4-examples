import antlr.ExprLexer;
import antlr.ExprParser;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Expr {
    public static void main(String[] args) throws FileNotFoundException {
//        String inputFile = null;
//        if ( args.length>0 ) inputFile = args[0];
        final CodePointCharStream input = CharStreams.fromString("193\n" +
                "a = 5\n" +
                "b = 6\n" +
                "a+b*2\n" +
                "(1+2)*3\n");
//        if ( inputFile!=null ) is = new FileInputStream(inputFile);
//        ANTLRInputStream input = new ANTLRInputStream(is);
        ExprLexer lexer = new ExprLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExprParser parser = new ExprParser(tokens);
        ParseTree tree = parser.prog(); // parse; start at prog
        System.out.println(tree.toStringTree(parser)); // print tree as text

    }
}
