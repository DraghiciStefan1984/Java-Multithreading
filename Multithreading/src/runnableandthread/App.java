package runnableandthread;

public class App
{
	public static void main(String[] args)
	{
		ThreadRunner threadRunner1=new ThreadRunner();
		threadRunner1.start();
		
		ThreadRunner threadRunner2=new ThreadRunner();
		threadRunner2.start();
		
		Thread runnableRunner1=new Thread(new RunnableRunner());
		runnableRunner1.start();
		
		Thread runnableRunner2=new Thread(new RunnableRunner());
		runnableRunner2.start();
	}
}