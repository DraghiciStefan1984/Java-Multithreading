package threadpool;

public class Processor implements Runnable
{
	private int id;
	
	public Processor(int id)
	{
		this.id=id;
	}
	
	@Override
	public void run()
	{
		System.out.println("Starting thread "+id);
		try
		{
			Thread.sleep(5000);
		} 
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Stopped thread "+id);
	}
}