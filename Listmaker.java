import java.util.ArrayList;
import java.util.Scanner;

public class Listmaker
{
    public static void main(String[] args)
    {
        // Create scanner and list
        Scanner in = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();

        boolean done = false;
        String cmd;

        // Main menu loop
        do
        {
            displayList(list);
            displayMenu();

            // Get user command using regex for valid letters
            cmd = SafeInput.getRegExString(in, "Enter a command [A/D/I/P/Q]: ", "[AaDdIiPpQq]");
            cmd = cmd.toUpperCase();

            switch (cmd)
            {
                case "A":
                    addItem(in, list);
                    break;
                case "D":
                    deleteItem(in, list);
                    break;
                case "I":
                    insertItem(in, list);
                    break;
                case "P":
                    printList(list);
                    break;
                case "Q":
                    done = quitProgram(in);
                    break;
            }

        } while (!done);

        System.out.println("Goodbye!");
    }

    // Menu Display
    private static void displayMenu()
    {
        System.out.println("\nMenu Options:");
        System.out.println("A – Add an item to the list");
        System.out.println("D – Delete an item from the list");
        System.out.println("I – Insert an item into the list");
        System.out.println("P – Print the list");
        System.out.println("Q – Quit the program");
        System.out.println();
    }

    // Display the list
    private static void displayList(ArrayList<String> list)
    {
        System.out.println("\nCurrent List:");
        if (list.isEmpty())
        {
            System.out.println("<< List is empty >>");
        }
        else
        {
            for (int i = 0; i < list.size(); i++)
            {
                System.out.printf("%3d: %s\n", i + 1, list.get(i));
            }
        }
    }

    // Add an item
    private static void addItem(Scanner in, ArrayList<String> list)
    {
        String item = SafeInput.getNonZeroLenString(in, "Enter item to add");
        list.add(item);
        System.out.println("Item added!");
    }

    // Delete an item
    private static void deleteItem(Scanner in, ArrayList<String> list)
    {
        if (list.isEmpty())
        {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }

        displayList(list);
        int choice = SafeInput.getRangedInt(in, "Enter the number of the item to delete", 1, list.size());
        list.remove(choice - 1);
        System.out.println("Item deleted!");
    }

    // Insert an item
    private static void insertItem(Scanner in, ArrayList<String> list)
    {
        if (list.isEmpty())
        {
            System.out.println("List is currently empty, inserting as first item.");
            String item = SafeInput.getNonZeroLenString(in, "Enter item to insert");
            list.add(item);
            return;
        }

        displayList(list);
        int position = SafeInput.getRangedInt(in, "Enter the position to insert at", 1, list.size() + 1);
        String item = SafeInput.getNonZeroLenString(in, "Enter item to insert");

        list.add(position - 1, item);
        System.out.println("Item inserted!");
    }

    // Print list only
    private static void printList(ArrayList<String> list)
    {
        System.out.println("\n--- Current List ---");
        if (list.isEmpty())
        {
            System.out.println("<< List is empty >>");
        }
        else
        {
            for (int i = 0; i < list.size(); i++)
            {
                System.out.printf("%3d: %s\n", i + 1, list.get(i));
            }
        }
        System.out.println("--------------------\n");
    }

    // Quit confirmation
    private static boolean quitProgram(Scanner in)
    {
        boolean confirm = SafeInput.getYNConfirm(in, "Are you sure you want to quit?");
        return confirm;
    }
}
