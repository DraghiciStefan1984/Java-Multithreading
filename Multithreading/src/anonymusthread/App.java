package anonymusthread;

public class App
{
	public static void main(String[] args)
	{
		Thread thread=new Thread(new Runnable()
		{	
			@Override
			public void run()
			{
				for(int i=0; i<10; i++)
				{
					try
					{
						Thread.sleep(100);
						System.out.println("Num: "+i);
					} catch (InterruptedException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}				
			}
		});
		thread.start();
	}
}