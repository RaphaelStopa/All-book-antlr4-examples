import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

public class LabeledExpr {
    public static void main(String[] args) throws IOException {
        final CodePointCharStream input = CharStreams.fromString("193\n" +
                "a = 5\n" +
                "b = 6\n" +
                "a+b*2\n" +
                "(1+2)*3\n");
        antlr.LabeledExprLexer lexer = new antlr.LabeledExprLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        antlr.LabeledExprParser parser = new antlr.LabeledExprParser(tokens);
        ParseTree tree = parser.prog(); // parse
        antlr.LabeledExpr eval = new antlr.LabeledExpr();
        eval.visit(tree);
    }
}
