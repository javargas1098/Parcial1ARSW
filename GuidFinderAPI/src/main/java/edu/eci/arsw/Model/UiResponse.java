package edu.eci.arsw.Model;


import java.util.Date;
import java.util.UUID;

public class UiResponse {
	private int count;
	private Date fecha;
	private UUID uids;

	public UUID getUids() {
		return uids;
	}

	public void setUids(UUID uids) {
		this.uids = uids;
	}

	public UiResponse() {

	}

	public UiResponse(int count, Date date, UUID uids) {
		this.fecha = date;
		this.count = count;
		this.uids=uids;

	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
