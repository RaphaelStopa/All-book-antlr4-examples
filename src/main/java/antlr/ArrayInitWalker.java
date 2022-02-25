package antlr;

public class ArrayInitWalker extends antlr.ArrayInitBaseListener {

    @Override
    public void enterInit(antlr.ArrayInitParser.InitContext ctx){
        System.out.print('"');
    }

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
