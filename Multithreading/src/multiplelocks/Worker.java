package multiplelocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Worker
{
	private Random rand=new Random();
	private List<Integer> intList1=new ArrayList<>();
	private List<Integer> intList2=new ArrayList<>();
	
	private Object lock1=new Object();
	private Object lock2=new Object();
	
	/*
	public synchronized void stageOne()
	{
		try
		{
			Thread.sleep(10);
		} 
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		intList1.add(rand.nextInt(800));
	}
	
	public synchronized void stageTwo()
	{
		try
		{
			Thread.sleep(1);
		} 
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		intList2.add(rand.nextInt(800));
	}*/
	
	public void stageOne()
	{
		synchronized(lock1)
		{
			try
			{
				Thread.sleep(10);
			} 
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			intList1.add(rand.nextInt(800));
		}
	}
	
	public void stageTwo()
	{
		synchronized(lock2)
		{
			try
			{
				Thread.sleep(1);
			} 
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			intList2.add(rand.nextInt(800));
		}
	}
	
	public void process()
	{
		for (int i=0; i<1000; i++)
		{
			stageOne();
			stageTwo();
		}
	}
	
	public void work()
	{
		System.out.println("Working...");
		
		long start=System.currentTimeMillis();
		process();
		long end=System.currentTimeMillis();
		
		System.out.println("Time taken: "+(end-start)/1000);
		System.out.println("List1: "+intList1.size());
		System.out.println("List2: "+intList2.size());
	}
}
