package edu.eci.arsw.GuidFinderDesktop;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;
import java.util.UUID;

public class Threads extends Thread {
	private int hilos;
	private int rango;
	public static UUID[] guids;
	public static Boolean flag = true;

	public Threads(int hilos, int rango) {

		// TODO Auto-generated constructor stub
		this.hilos = hilos;
		this.rango = rango;

	}

	@Override
	public void run() {
		while (true) {
			try {

				Threads.flag = false;
				for (int i = hilos; i < rango; i++) {

					FileInputStream fi;
					fi = new FileInputStream(new File("guids.eci"));
					ObjectInputStream oi = new ObjectInputStream(fi);

					guids = (UUID[]) oi.readObject();

					oi.close();
					fi.close();
				}

				synchronized (Threads.flag) {
					Threads.flag.notifyAll();

				}

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}

	}

}
