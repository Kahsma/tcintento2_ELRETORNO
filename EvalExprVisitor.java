import org.antlr.v4.runtime.misc.ParseCancellationException;

public class EvalExprVisitor extends ExprBaseVisitor<Integer> {
    @Override
    public Integer visitEnt(ExprParser.EntContext ctx) {
        return Integer.parseInt(ctx.ENT().getText());
    }

    @Override
    public Integer visitSumRes(ExprParser.SumResContext ctx) {
        int left = visit(ctx.expr(0));
        int right = visit(ctx.expr(1));
        if (ctx.op.getType() == ExprParser.Sum) {
            return left + right;
        }
        return left - right;
    }

    @Override
    public Integer visitMulDiv(ExprParser.MulDivContext ctx) {
        int left = visit(ctx.expr(0));
        int right = visit(ctx.expr(1));
        if (ctx.op.getType() == ExprParser.Mul) {
            return left * right;
        }
        if (right == 0) {
            throw new ParseCancellationException("Division by zero");
        }
        return left / right;
    }

    @Override
    public Integer visitParen(ExprParser.ParenContext ctx) {
        return visit(ctx.expr());
    }
}
