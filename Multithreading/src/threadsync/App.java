package threadsync;

import java.util.Scanner;

public class App
{
	public static void main(String[] args)
	{
		Processor processor1=new Processor();
		processor1.start();
		
		System.out.println("Press enter to stop!");
		Scanner scanner=new Scanner(System.in);
		scanner.nextLine();
		processor1.shutDown();
	}
}