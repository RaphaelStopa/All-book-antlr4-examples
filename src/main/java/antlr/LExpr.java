package antlr;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

public class LExpr extends antlr.LExprBaseListener {
    /** maps nodes to integers with Map<ParseTree,Integer> */
    ParseTreeProperty<Integer> values = new ParseTreeProperty<Integer>();

    /** Need to pass e's value out of rule s : e ; */
    public void exitS(antlr.LExprParser.SContext ctx) {
        setValue(ctx, getValue(ctx.e())); // like: int s() { return e(); }
    }

    public void exitMult(antlr.LExprParser.MultContext ctx) {
        int left = getValue(ctx.e(0));  // e '*' e   # Mult
        int right = getValue(ctx.e(1));
        setValue(ctx, left * right);
    }

    public void exitAdd(antlr.LExprParser.AddContext ctx) {
        int left = getValue(ctx.e(0)); // e '+' e   # Add
        int right = getValue(ctx.e(1));
        setValue(ctx, left + right);
    }

    public void exitInt(antlr.LExprParser.IntContext ctx) {
        String intText = ctx.INT().getText(); // INT   # Int
        setValue(ctx, Integer.valueOf(intText));
    }

    public void setValue(ParseTree node, int value) { values.put(node, value); }
    public int getValue(ParseTree node) { return values.get(node); }
}
