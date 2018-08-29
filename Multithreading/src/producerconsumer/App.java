package producerconsumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class App
{
	public static void main(String[] args)
	{
		Thread producerThread=new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				try
				{
					producer();
				} catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		Thread consumerThread=new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				try
				{
					consumer();
				} catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		producerThread.start();
		consumerThread.start();
		
		try
		{
			producerThread.join();
			consumerThread.join();
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	static BlockingQueue<Integer> blockingQueue=new ArrayBlockingQueue<>(10);
	
	private static void producer() throws InterruptedException
	{
		Random random=new Random();
		
		while(true)
		{
			blockingQueue.put(random.nextInt(100));
		}
	}
	
	private static void consumer() throws InterruptedException
	{
		Random random=new Random();
	
		while(true)
		{
			Thread.sleep(100);
			
			if(random.nextInt(10)==0)
			{
				Integer value=blockingQueue.take();
				System.out.println("Taken value: "+value);
			}
		}
	}
}
