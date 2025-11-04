import java.util.Scanner;
import java.util.regex.Pattern;

public class SafeInput
{
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String input;
        do
        {
            System.out.print(prompt + ": ");
            input = pipe.nextLine();
            if (input.length() == 0)
            {
                System.out.println("Input must not be empty!");
            }
        } while (input.length() == 0);
        return input;
    }

    public static int getInt(Scanner pipe, String prompt)
    {
        int result = 0;
        boolean valid = false;
        do
        {
            System.out.print(prompt + ": ");
            if (pipe.hasNextInt())
            {
                result = pipe.nextInt();
                valid = true;
            }
            else
            {
                System.out.println("Invalid input. Please enter an integer.");
            }
            pipe.nextLine(); // clear buffer
        } while (!valid);
        return result;
    }

    public static double getDouble(Scanner pipe, String prompt)
    {
        double result = 0;
        boolean valid = false;
        do
        {
            System.out.print(prompt + ": ");
            if (pipe.hasNextDouble())
            {
                result = pipe.nextDouble();
                valid = true;
            }
            else
            {
                System.out.println("Invalid input. Please enter a decimal number.");
            }
            pipe.nextLine(); // clear buffer
        } while (!valid);
        return result;
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        int result = 0;
        boolean valid = false;
        do
        {
            System.out.print(prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextInt())
            {
                result = pipe.nextInt();
                if (result >= low && result <= high)
                {
                    valid = true;
                }
                else
                {
                    System.out.println("Input out of range. Try again.");
                }
            }
            else
            {
                System.out.println("Invalid input. Please enter an integer.");
            }
            pipe.nextLine(); // clear buffer
        } while (!valid);
        return result;
    }

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high)
    {
        double result = 0;
        boolean valid = false;
        do
        {
            System.out.print(prompt + " [" + String.format("%.2f", low)
                    + " - " + String.format("%.2f", high) + "]: ");
            if (pipe.hasNextDouble())
            {
                result = pipe.nextDouble();
                if (result >= low && result <= high)
                {
                    valid = true;
                }
                else
                {
                    System.out.println("Input out of range. Try again.");
                }
            }
            else
            {
                System.out.println("Invalid input. Please enter a decimal number.");
            }
            pipe.nextLine(); // clear buffer
        } while (!valid);
        return result;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        String input;
        boolean valid = false;
        do
        {
            System.out.print(prompt + " [Y/N]: ");
            input = pipe.nextLine().trim();
            if (input.equalsIgnoreCase("Y"))
            {
                return true;
            }
            else if (input.equalsIgnoreCase("N"))
            {
                return false;
            }
            else
            {
                System.out.println("Invalid input. Please enter Y or N.");
            }
        } while (!valid);
        return false;
    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx)
    {
        String input;
        boolean valid = false;
        do
        {
            System.out.print(prompt + ": ");
            input = pipe.nextLine();
            if (Pattern.matches(regEx, input))
            {
                valid = true;
            }
            else
            {
                System.out.println("Input does not match required pattern. Try again.");
            }
        } while (!valid);
        return input;
    }

    public static void prettyHeader(String msg)
    {
        final int width = 60;
        final int sideStars = 3;

        // Top border
        for (int i = 0; i < width; i++)
        {
            System.out.print("*");
        }
        System.out.println();

        // Middle with message
        int spaceForMsg = width - (sideStars * 2);
        int msgLength = msg.length();
        int leftPadding = (spaceForMsg - msgLength) / 2;
        int rightPadding = spaceForMsg - msgLength - leftPadding;

        for (int i = 0; i < sideStars; i++)
        {
            System.out.print("*");
        }
        for (int i = 0; i < leftPadding; i++)
        {
            System.out.print(" ");
        }
        System.out.print(msg);
        for (int i = 0; i < rightPadding; i++)
        {
            System.out.print(" ");
        }
        for (int i = 0; i < sideStars; i++)
        {
            System.out.print("*");
        }
        System.out.println();

        // Bottom border
        for (int i = 0; i < width; i++)
        {
            System.out.print("*");
        }
        System.out.println();
    }
}
