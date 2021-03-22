import java.text.ParseException;
import java.util.Scanner;

public class homeworkListTester {

	public static void main(String[] args) throws ParseException {

		homeworkList AL = new homeworkList();

		Scanner input = new Scanner(System.in);
		String date;
		boolean sentinal = true;

		// Initial list of assignments with due dates
		AL.add("Math", "11/11/2021");
		AL.add("Data Structures", "10/10/2010");
		AL.add("English", "09/09/2009");
		AL.add("Java", "07/07/2007");
		AL.add("Python", "08/08/2015");

		do {
			System.out.println("1.Add an assignment \n" + "2.Remove an assignment \n" + "3.List of all assignments \n"
					+ "4.Find the earliest assignemnt \n" + "5.Exit");

			System.out.print("\nOption: ");

			int choice = input.nextInt();

			switch (choice) {
			case 1: // Adds an Assignment with due date in MM/DD/YYYY format
				System.out.print("\nType the name of assignment to add: ");
				String assignmentName = input.next();
				System.out.println("When is it due?\n ---MM/DD/YYYY format---");
				date = input.next();
				AL.add(assignmentName, date);
				System.out.println("Assignment " + assignmentName + " due on " + date + " added.");
				System.out.println();

				break;
			case 2: // Removes an Assignment from a list **CASE SENESITIVE**
				System.out.print("Type the name of assignment to remove **CASE SENSITIVE**: ");
				String removeAssignment = input.next();
				AL.removeAssignment(removeAssignment);
				System.out.println("Assignment " + removeAssignment + " removed.");
				break;
			case 3: // Prints current list in order
				System.out.println("The following assingments are on your list: \n");
				AL.print();
				System.out.println("\n");
				break;
			case 4: // Prints the earliest assignment with the due date
				System.out.print("The earliest assignemnt due is: ");
				AL.earliestDate();
				System.out.println();
				break;
			case 5: // Quits the program
				System.out.println("Program terminated");
				sentinal = false;
				break;
			default:
				System.out.println("Invalid selection, try again.\n");
			}
		} while (sentinal);
		input.close(); // Closes Scanner
	}
}
