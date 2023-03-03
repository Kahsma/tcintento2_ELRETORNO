import java.util.*;

public class EvalExprVisitor extends ExprBaseVisitor<Integer> {
    // Crear tabla de símbolos (nombre de variable -> valor)
    Map<String, Integer> symbolTable = new HashMap<String, Integer>();

    // Visitante para expresiones enteras
    @Override
    public Integer visitEnt(ExprParser.EntContext ctx) {
        return Integer.parseInt(ctx.getText());
    }

    // Visitante para sumas y restas
    @Override
    public Integer visitSumRes(ExprParser.SumResContext ctx) {
        // Visitar operandos izquierdo y derecho
        int left = visit(ctx.expr(0));
        int right = visit(ctx.expr(1));

        // Realizar operación según el operador
        if (ctx.op.getType() == ExprParser.Sum) {
            return left + right;
        } else {
            return left - right;
        }
    }

    // Visitante para multiplicaciones y divisiones
    @Override
    public Integer visitMulDiv(ExprParser.MulDivContext ctx) {
        // Visitar operandos izquierdo y derecho
        int left = visit(ctx.expr(0));
        int right = visit(ctx.expr(1));

        // Realizar operación según el operador
        if (ctx.op.getType() == ExprParser.Mul) {
            return left * right;
        } else {
            return left / right;
        }
    }

    // Visitante para paréntesis
    @Override
    public Integer visitParen(ExprParser.ParenContext ctx) {
        // Visitar expresión entre paréntesis
        return visit(ctx.expr());
    }

    // Visitante para asignaciones
    @Override
    public Integer visitAsignar(ExprParser.AsignarContext ctx) {
        String id = ctx.ID().getText();
        int value = visit(ctx.expr());
        symbolTable.put(id, value);
        return value;
    }

}
