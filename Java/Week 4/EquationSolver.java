class EquationSolver {

    public double solve(String equation)
    {
        double result;
        DSAQueue postfix;

        postfix = parseInfixToPostfix(equation);
        result = evaluatePostfix(postfix);

        return result;
    }

    private DSAQueue parseInfixToPostfix(String equation)
    {

        DSAQueue postfix = new DSACircularQueue();
        String buffer[];
        buffer = equation.split(" ");
        DSAStack opStack = new DSAStack();
        Object parsed;

        for (String term : buffer)
        {
            parsed = parseNextTerm(term);

            if (parsed instanceof Double)
            {
                postfix.enqueue(parsed);
            } else
            {
                switch ((char) parsed) {
                case '(' -> {
                    opStack.push(parsed);
                }
                case ')' -> {
                    while ((char) opStack.top() != '(')
                    {
                        postfix.enqueue((char) opStack.pop());
                    }
                    opStack.pop();
                }
                case '+', '-', '*', '/' -> {
                    while (!opStack.isEmpty() && (char) opStack.top() != '('
                            && precedenceOf((char) opStack.top()) >= precedenceOf((char) parsed))
                    {
                        postfix.enqueue((char) opStack.pop());
                    }
                    opStack.push(parsed);
                }
                default -> {
                    postfix.enqueue(parsed);
                }
                }
            }
        }
        while (!opStack.isEmpty())
        {
            postfix.enqueue(opStack.pop());
        }

        return postfix;
    }

    private double evaluatePostfix(DSAQueue postfixQueue)
    {
        DSAStack operandStack = new DSAStack();
        char operator;
        double num1, num2, total;

        while (!postfixQueue.isEmpty())
        {
            if (postfixQueue.peek() instanceof Double)
            {
                operandStack.push(postfixQueue.dequeue());
            } else
            {
                operator = (char) postfixQueue.dequeue();
                num2 = (double) operandStack.pop();
                num1 = (double) operandStack.pop();
                operandStack.push(executeOperation(operator, num1, num2));

            }

        }
        total = (double) operandStack.pop();
        return total;

    }

    private int precedenceOf(char theOp)
    {
        int precedence;
        switch (theOp) {
        case '+', '-' -> {
            precedence = 1;
        }
        case '*', '/' -> {
            precedence = 2;
        }
        default -> {
            precedence = 0;
        }
        }
        return precedence;
    }

    private double executeOperation(char op, double op1, double op2)
    {
        double result = 0;
        switch (op) {
        case '+' -> {
            result = op1 + op2;
        }
        case '-' -> {
            result = op1 - op2;
        }
        case '*' -> {
            result = op1 * op2;
        }
        case '/' -> {
            result = op1 / op2;
        }
        }
        return result;
    }

    private Object parseNextTerm(String term)
    {
        Object parsed;
        double isDouble;

        if (term.length() > 1)
        {
            isDouble = Double.parseDouble(term);
            parsed = (double) isDouble;
        } else
        {
            switch (term.charAt(0)) {
            case '+', '-', '*', '/', '(', ')' -> {
                parsed = term.charAt(0);
            }
            default -> {
                isDouble = Double.parseDouble(term);
                parsed = isDouble;
            }
            }
        }

        return parsed;
    };
}
