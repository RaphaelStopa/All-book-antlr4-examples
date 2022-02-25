package antlr;

/** Convert short array inits like {1,2,3} to "\u0001\u0002\u0003" */
public class ArrayInitWalker extends antlr.ArrayInitBaseListener {

    /** Translate { to " */
    @Override
    public void enterInit(antlr.ArrayInitParser.InitContext ctx){
        System.out.print('"');
    }

    /** Translate } to " */
    @Override
    public void exitInit(antlr.ArrayInitParser.InitContext ctx){
        System.out.print('"');
    }

    @Override
    public void enterValue(antlr.ArrayInitParser.ValueContext ctx){
        int value = Integer.valueOf(ctx.INT().getText());
        System.out.printf("\\u%04x", value);
    }


}
