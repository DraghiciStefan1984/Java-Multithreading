package waitnotify;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Processor
{
	private LinkedList<Integer> intList=new LinkedList<>();
	private final int LIMIT=10;
	private Object lock=new Object();
	
	public void produce() throws InterruptedException
	{
		int value=0;
		
		while(true)
		{
			synchronized (lock)
			{
				while(intList.size()==LIMIT)
				{
					lock.wait();
				}
				intList.add(value++);	
			}
		}
	}
	
	public void consume() throws InterruptedException
	{
		Random random=new Random();
		
		while(true)
		{
			synchronized (lock)
			{
				while(intList.size()==0)
				{
					lock.wait();
				}
				System.out.println(intList.size());
				int value=intList.removeFirst();
				System.out.println("Value is "+value);	
				lock.notify();
			}
			Thread.sleep(random.nextInt(100));
		}
	}
}
