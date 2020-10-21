package lab12zad2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

	public static void main(String[] args) {
		
		BlockingQueue<Integer> kolejka = new LinkedBlockingQueue<Integer>();
		Thread t1 = new Thread(new Konserwator("Konserwator",kolejka,5));
		t1.start();
		mieszkania(10,kolejka);
	}
	
	static void mieszkania(int x, BlockingQueue kolejka)
	{
		for(int i=0;i<x;i++)
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Thread t2 = new Thread(new Mieszkanie(i,kolejka,10,10));
			t2.start();
		}
		
	}

}
