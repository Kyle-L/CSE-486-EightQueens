
public class EightQueensTester {
	public static void main(String[] args) {
		EightQueensProblem problem = new EightQueensProblem();

		System.out.println("The starting board...");
		problem.printBoard();
		problem.minConflicts();
		System.out.println("\n\nThe solved board...\n");
		problem.printBoard();
	}
}
