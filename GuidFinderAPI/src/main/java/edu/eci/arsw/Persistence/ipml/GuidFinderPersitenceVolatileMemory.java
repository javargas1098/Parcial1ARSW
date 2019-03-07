package edu.eci.arsw.Persistence.ipml;

import java.util.List;
import java.util.Date;
import java.util.LinkedList;

import java.util.UUID;
import edu.eci.arsw.Model.*;
import edu.eci.arsw.GuidFinderDesktop.GuidFinder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.eci.arsw.Persistence.GuidPersistence;
import edu.eci.arsw.Persistence.PersistenceException;

@Component("gc")

public class GuidFinderPersitenceVolatileMemory implements GuidPersistence {

	@Autowired
	GuidFinder uuids;
	List<UiResponse> responses=new LinkedList<>();


	
	
	@Override
	public List<UiResponse> getAll() throws PersistenceException {
		return responses;
	}

	@Override
	public UiResponse consult(UiRequest guidToFind) throws PersistenceException {
		// TODO Auto-generated method stub
		UiResponse response = new UiResponse(uuids.countGuids(guidToFind.getRequest()), new Date(), guidToFind.getRequest());
		responses.add(response);
		return response;
	}

//	@Override
//	public UiRequest consult(UiRequest name) throws PersistenceException {
//		UiResponse c =new UiResponse(fk.consult);
//		
//		if ((c = uids.get(name)) == null) {
//			throw new PersistenceException("The given function to update does not exit");
//		}
//		return c;
//
//	}
}
