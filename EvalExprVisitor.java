
public class EvalExprVisitor extends ExprBaseVisitor<Integer>

{

    @Override

    public Integer visitEnt(ExprParser.EntContext ctx)

    {

        return Integer.valueOf(ctx.ENT().getText());

    }

    @Override

    public Integer visitSumRes(ExprParser.SumResContext ctx)

    {

        if (ctx.op.getType() == ExprParser.Sum)

            return visit(ctx.expr(0)) + visit(ctx.expr(1));

        return visit(ctx.expr(0)) - visit(ctx.expr(1));

    }

    @Override

    public Integer visitMulDiv(ExprParser.MulDivContext ctx)

    {

        if (ctx.op.getType() == ExprParser.Mul)

            return visit(ctx.expr(0)) * visit(ctx.expr(1));

        return visit(ctx.expr(0)) / visit(ctx.expr(1));

    }

    @Override

    public Integer visitParen(ExprParser.ParenContext ctx)

    {

        return visit(ctx.expr());

    }

}