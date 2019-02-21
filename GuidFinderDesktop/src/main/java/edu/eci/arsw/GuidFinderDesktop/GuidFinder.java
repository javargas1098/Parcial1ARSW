package edu.eci.arsw.GuidFinderDesktop;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.UUID;

public class GuidFinder {

	public GuidFinder(int threads) throws Exception {
		getGuids(threads);
	}

	public static UUID[] getGuids(int threads) throws Exception {
		if(Threads.flag) {
			Threads hilo = null;
			if (Threads.guids == null) {
				System.out.println("es nulo");
			}
			for (int i = 0; i < threads; i++) {
				hilo = new Threads(i, i + 1);
				hilo.start();

			}
			try {
				hilo.join();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			
		}
		else {
			synchronized (Threads.flag) {
				while (!Threads.flag) {
					
					Threads.flag.wait();
				}
				
			}
		}

		

		return Threads.guids;

	}

	public int countGuids(UUID guidToFind) {

		int count = 0;
		for (UUID uuid : Threads.guids) {
			if (uuid.equals(guidToFind)) {
				count++;
			}

		}
		return count;

	}

}
