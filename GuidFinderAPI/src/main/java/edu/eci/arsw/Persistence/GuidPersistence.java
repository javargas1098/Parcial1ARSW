package edu.eci.arsw.Persistence;

import java.util.List;
import java.util.Set;


import edu.eci.arsw.Model.*;
import edu.eci.arsw.GuidFinderDesktop.*;
import java.util.UUID;
public interface GuidPersistence {
	
	
	public List<UiResponse> getAll() throws PersistenceException;

	public UiResponse consult(UiRequest guidToFind) throws PersistenceException;
}
