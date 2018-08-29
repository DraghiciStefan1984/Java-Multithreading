package latches;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App
{
	public static void main(String[] args)
	{
		CountDownLatch countDownLatch=new CountDownLatch(3);
		
		ExecutorService executorService=Executors.newFixedThreadPool(3);
		
		for(int i=0; i<3; i++)
		{
			executorService.submit(new Processor(countDownLatch));
		}
		
		try
		{
			countDownLatch.await();
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Completed...");
	}
}
