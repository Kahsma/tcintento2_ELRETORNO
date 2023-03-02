import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.*;

public class ExpresionApp {

    public static void main(String[] args) throws IOException {

        // 1. Lee el archivo de texto con las expresiones
        BufferedReader reader = new BufferedReader(new FileReader("expresiones.txt"));

        String line = null;
        while ((line = reader.readLine()) != null) {

            // 2. Crea un flujo de caracteres a partir de la expresión
            CharStream inputStream = CharStreams.fromString(line);

            // 3. Hace el análisis léxico del flujo y revisa errores
            ExprLexer lexer = new ExprLexer(inputStream);
            lexer.addErrorListener(new BaseErrorListener() {
                @Override
                public void syntaxError(Recognizer<?, ?> r, Object o, int l, int c,
                        String msg, RecognitionException e) {
                    throw new RuntimeException(e);
                }
            });
            CommonTokenStream commonTokenStream = new CommonTokenStream(lexer);

            // 4. Analiza (parsea) el flujo de tokens generado por el lexer
            ExprParser parser = new ExprParser(commonTokenStream);
            parser.setErrorHandler(new BailErrorStrategy());
            ParseTree tree = parser.expr();

            // 5. Evalúa el árbol generado
            EvalExprVisitor evaluator = new EvalExprVisitor();
            Integer result = evaluator.visit(tree);

            // 6. Imprime el resultado
            System.out.println(tree.toStringTree(parser));
            System.out.print(line + " = ");
            System.out.println(result);
        }

        // 7. Cierra el archivo
        reader.close();
    }
}
