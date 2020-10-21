package lab12zad2;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Mieszkanie implements Runnable {
	
	Random generator = new Random();
	int nrMieszkania,czasSprawdzeniaAwarii;
	BlockingQueue lista;
	int PWystapieniaAwarii;
	
	Mieszkanie(int nrMieszkania,BlockingQueue lista, int czasSprawdzeniaAwarii, int PWystapieniaAwarii)
	{
		this.nrMieszkania = nrMieszkania;
		this.lista = lista;
		this.czasSprawdzeniaAwarii =  czasSprawdzeniaAwarii;
		this.PWystapieniaAwarii = PWystapieniaAwarii;
	}
	
	@Override
	public void run() {

		while(true)
		{
			try {
				Thread.sleep(czasSprawdzeniaAwarii*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			int a = generator.nextInt(PWystapieniaAwarii)+1;
			if(a==1)
			{
				System.out.println("Awaria w mieszkaniu nr: "+ nrMieszkania);
				lista.add(nrMieszkania);
			}
			else
				System.out.println("Wszystko w porzadku w mieszkaniu nr : "+ nrMieszkania);
				
		}
		
	}
}
