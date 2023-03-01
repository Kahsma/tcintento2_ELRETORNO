public class EvalExprVisitor extends ExprBaseVisitor<Integer> {
    @Override
    public Integer visitEnt(ExprParser.EntContext ctx) {
        return Integer.valueOf(ctx.ENT().getText());
    }

    @Override
    public Integer visitSumRes(ExprParser.SumResContext ctx) {
        Integer left = visit(ctx.expr(0)); // Evaluación de la expresión izquierda
        Integer right = visit(ctx.expr(1)); // Evaluación de la expresión derecha
        if (left != null && right != null) {
            if (ctx.op.getType() == ExprParser.Sum) { // Determinar si es suma o resta
                return left + right;
            }
            return left - right;
        }
        return null;
    }

    @Override
    public Integer visitMulDiv(ExprParser.MulDivContext ctx) {
        Integer left = visit(ctx.expr(0)); // Evaluación de la expresión izquierda
        Integer right = visit(ctx.expr(1)); // Evaluación de la expresión derecha
        if (left != null && right != null) {
            if (ctx.op.getType() == ExprParser.Mul) { // Determinar si es multiplicación o división
                return left * right;
            }
            return left / right;
        }
        return null;
    }

    @Override
    public Integer visitParen(ExprParser.ParenContext ctx) {
        return visit(ctx.expr()); // Evaluación de la expresión dentro de los paréntesis
    }
}
