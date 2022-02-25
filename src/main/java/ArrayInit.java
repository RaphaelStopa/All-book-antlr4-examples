import antlr.ArrayInitLexer;
import antlr.ArrayInitParser;
import antlr.ArrayInitWalker;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class ArrayInit {
    public static void main(String[] args) {
        final CodePointCharStream input = CharStreams.fromString("{1,2,3}");
        ArrayInitLexer lexer = new ArrayInitLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ArrayInitParser parser = new ArrayInitParser(tokens);
        ParseTree tree = parser.init();

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new ArrayInitWalker(), tree);
        System.out.println();
    }
}
