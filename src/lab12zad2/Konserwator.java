package lab12zad2;

import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArraySet;

public class Konserwator implements Runnable {

	Random generator = new Random();
	String nazwaKonsumenta;
	BlockingQueue lista;
	int maxCzasNaprawy;

	Konserwator(String name, BlockingQueue lista, int maxCzasNaprawy) {
		this.nazwaKonsumenta = name;
		this.lista = lista;
		this.maxCzasNaprawy = maxCzasNaprawy;
	}

	@Override
	public void run() {

			while (true) {
				if (lista.isEmpty()) {
					System.out.println("Nie mam nic do roboty...");
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					continue;
				}
				int a = (generator.nextInt(maxCzasNaprawy) + 1) * 1000;
				try {
					Thread.sleep(a);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				try {
					System.out.println(nazwaKonsumenta + "- naprawilem mieszkanie nr: " + lista.take());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Nastepne naprawy " + lista);
			}
		
	}
}
