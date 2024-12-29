package mypackage;
import java.util.StringTokenizer;
import java.util.ArrayList;


public class Postfix 
{

    private MyStack<String> stack = new MyStack<>();

    public double calculate(String text) throws Exception
    {
        StringTokenizer tokenizer = new StringTokenizer(text, " ");
        ArrayList<String> arrayList = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) 
        {
            String token = tokenizer.nextToken();
            arrayList.add(token);
        }
        for (String str : arrayList)
        {
            stack.push(str);
            if (str.equals("+") || str.equals("-") || str.equals("/") || str.equals("*") || str.equals("%"))
            {
                stack.pop(); // to get rid of the operator from the stack
                try
                {
                    if (stack.getSize() < 2)
                    {
                        throw new Exception("Not enough operands in the stack.");
                    }
                    String num1 = stack.pop();
                    String num2 = stack.pop();
                    switch(str)
                    {
                        case "+":
                            stack.push(Double.toString(Double.parseDouble(num2) + Double.parseDouble(num1)));
                            break;
                        case "-":
                            stack.push(Double.toString(Double.parseDouble(num2) - Double.parseDouble(num1)));
                            break;
                        case "/":
                            if (Double.parseDouble(num1) == 0) 
                            {
                                throw new Exception("Division by zero.");
                            }
                            stack.push(Double.toString(Double.parseDouble(num2) / Double.parseDouble(num1)));
                            break;
                        case "*":
                            stack.push(Double.toString(Double.parseDouble(num2) * Double.parseDouble(num1)));
                            break;
                        case "%":
                            stack.push(Double.toString(Double.parseDouble(num2) % Double.parseDouble(num1)));
                            break;
                        default:
                            throw new Exception("Invalid operator.");
                    }
                } catch (Exception e)
                {
                    // System.out.println("Error: " + e.getMessage());
                    stack.clear();
                    throw new Exception("Error:" + e.getMessage());
                    // return 0; // throw an error here
                }
            }
        }
        if (stack.getSize() == 1)
        {
            double result = Double.parseDouble(stack.pop());
            System.out.println("You entered " + result);
            return result;
        }
        else
        {
            // System.out.println("Error: Invalid postfix expression.");
            stack.clear();
            throw new Exception("Invalid posfix expression");
            // return 0; // throw an error here
        }
    }
}
