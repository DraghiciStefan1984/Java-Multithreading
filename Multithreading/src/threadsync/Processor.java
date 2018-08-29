package threadsync;

public class Processor extends Thread
{
	private volatile boolean running=true;
	
	@Override
	public void run()
	{
		while(running)
		{
			try
			{
				Thread.sleep(100);
				System.out.println("Hello");
			} 
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void shutDown()
	{
		running=false;
	}
}