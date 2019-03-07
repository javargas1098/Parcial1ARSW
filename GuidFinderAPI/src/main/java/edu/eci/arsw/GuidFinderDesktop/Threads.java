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
	public static UUID guidToFind;
	public static int co;

	public Threads(UUID[] guids,int hilos, int rango,UUID guidToFind) {
		this.guids=guids;
		this.hilos = hilos;
		this.rango = rango;
		
		// TODO Auto-generated constructor stub
		this.guidToFind=guidToFind;
	}

	@Override
	public void run() {
		int i = hilos;
		while (i < rango + hilos) {
			try {
				find(i);
				i++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
	private void find(int i) throws InterruptedException {
		if (guids[i].equals(guidToFind)) {
			
			co++;
		}
	}
	

}
