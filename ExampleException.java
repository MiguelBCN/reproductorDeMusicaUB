import java.util.Scanner;

public class ExampleException {
    public static void main(String[] args) {
        /*INTRODUCCION
         * To use exceptions we use the try and catch the exceptions are use to control the errors by example divide by 0
         * that STOP our program with exception even if we have an error the program continues */

        //There are MULTIPLE kind of Errors but catch (Exception e) will catch them all

        //EXAMPLE 1 DIVIDE BY 0
        int num1, num2;
        int x = 1;
        Scanner sc = new Scanner(System.in);

        //The next code is a bucle that continues as long we get an error
        System.out.println("EXAMPLE 1 DIVIDE BY 0");
        do {
            try {
                System.out.println("Enter first number: ");
                num1 = sc.nextInt();
                System.out.println("Enter second number: ");
                num2 = sc.nextInt();
                //the error would appear here if we divide by 0 we gop to catch and display the erros and the loop continues
                int div = num1 / num2;
                System.out.println(div);
                x = 2;
            } catch (Exception e) {
                System.out.println("You cant do that (divide by 0 a int....)");
                System.out.println("The error is " + e);
            }
        } while (x == 1);

        System.out.println("EXAMPLE 2 ELEMENT NOT FOUND");
        //EXAMPLE 2 ELEMENT NOT FOUND
        int[] numbers = {0, 1, 2};

        try {
            System.out.println(numbers[3]);
        } catch (Exception e) {
            System.out.println("The next element couldn´t be found");
            System.out.println("The error is " + e);
        } finally {
        /* El codi que es posa en el bloc “finally”, s’executa sempre, tant si s’ha produït
        una excepció com si tot ha anat bé.*/
        }

    }
}
