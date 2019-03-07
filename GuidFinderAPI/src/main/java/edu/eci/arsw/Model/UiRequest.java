package edu.eci.arsw.Model;

import java.util.UUID;

public class UiRequest {
	private UUID request;

	public UiRequest() {
		// TODO Auto-generated constructor stub
	}

	public UUID getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = UUID.fromString(request);
	}

}
