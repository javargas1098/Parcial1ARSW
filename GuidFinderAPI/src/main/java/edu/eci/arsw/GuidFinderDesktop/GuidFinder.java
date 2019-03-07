package edu.eci.arsw.GuidFinderDesktop;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import edu.eci.arsw.Model.UiResponse;

@Component("guidFinder")
public class GuidFinder {
	private static ArrayList<UiResponse> results;
	private LinkedList<UUID> guids;

	private int hilos, tamaño, count;
	public static Integer countGlobal = 0;
	private UUID guidToFind;

	public GuidFinder(int hilos, int tamaño, UUID guid) throws Exception {
		this.hilos = hilos;
		this.tamaño = tamaño;
		this.guidToFind = guid;
	}

	public static LinkedList<UUID> getGuids() throws Exception {

		LinkedList<UUID> guids = new LinkedList<>();
		for (int i = 0; i < 10; i++) {
		
			UUID uuid = UUID.randomUUID();
			guids.add(uuid);
		}
		System.out.println(guids.toString());

		return guids;

	}
	public GuidFinder(UUID uuid) {
		this.guidToFind = uuid;
	}
	
	public GuidFinder() throws Exception {
		guids = getGuids();
	}

	public int countGuids(UUID guidToFind) {

		for (int i = 0; i < guids.size(); i++) {
			if (guids.get(i).toString().equals(guidToFind.toString())) {	
				count++;
			}
		}
		return count;

	}

}