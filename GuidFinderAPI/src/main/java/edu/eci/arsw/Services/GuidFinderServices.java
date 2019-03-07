package edu.eci.arsw.Services;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.GuidFinderDesktop.GuidFinder;
import edu.eci.arsw.Model.UiRequest;
import edu.eci.arsw.Model.UiResponse;
import edu.eci.arsw.Persistence.PersistenceException;
import edu.eci.arsw.Persistence.ipml.GuidFinderPersitenceVolatileMemory;

@Service
public class GuidFinderServices {

	@Autowired
	GuidFinderPersitenceVolatileMemory gp;

	public List<UiResponse> getAll() throws PersistenceException {
		// TODO Auto-generated method stub
		return gp.getAll();

	}
	
	public UiResponse consult(UiRequest uuid) throws PersistenceException {
		return gp.consult(uuid);
		
	}

}
