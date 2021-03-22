package DijkstrasTwoStack;

import java.util.Scanner;

public class Algo {

    public static void main(String[] args) {
        System.out.println(algo());

    }
        public static Double algo () {
            //init stacks
            Stack<Double> ValueStack = new Stack<>();
            Stack<String> OperatorStack = new Stack<>();

            //init scanner
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the expression");

            Integer o=( ( 5 + ( 3 * 8 ) ) - ( 2 * 7 ) );
            String[] operator=o.toString().split(" ");

            //String[] operator = input.nextLine().split(" ");


            //go through array
            for (String s : operator) {
                switch (s) {
                    //check operator and push on stack
                    case "(":
                        break;
                    case "+":
                        OperatorStack.push(s);
                    case "-":
                        OperatorStack.push(s);
                    case "*":
                        OperatorStack.push(s);
                    case "/":
                        OperatorStack.push(s);
                    case "%":
                        OperatorStack.push(s);
                    case ")": {
                        //If we have right parentheses calculate until that point
                        String operators = OperatorStack.pop();
                        double Value = ValueStack.pop();
                        switch (operators) {
                            case "+":
                                Value = ValueStack.pop() + Value;
                                break;
                            case "-":
                                Value = ValueStack.pop() - Value;
                                break;
                            case "*":
                                Value = ValueStack.pop() * Value;
                                break;
                            case "/":
                                Value = ValueStack.pop() / Value;
                                break;
                            case "%":
                                Value = ValueStack.pop() % Value;
                                break;

                        }
                        //push calculated value onto the stack
                        ValueStack.push(Value);

                    }
                    break;
                    default:
                        //parse string to double
                        try {
                            double num = Double.parseDouble(s);
                            ValueStack.push(num);

                        }
                        //if conversion cant be done throw exception
                        catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                        break;
                }

            }
            //return result
            return ValueStack.pop();


        }


}