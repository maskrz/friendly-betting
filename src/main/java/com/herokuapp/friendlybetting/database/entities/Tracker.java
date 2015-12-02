package com.herokuapp.friendlybetting.database.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class Tracker extends Logger {
	
	/** time stamp of entity update */
	@Column(name="refreshtimestamp")
	@Temporal(TemporalType.TIMESTAMP)
	private Date refreshTimestamp;

	@Override
	public String toString() {
		return "Tracker [refreshTimestamp=" + refreshTimestamp + ", "
				+ super.toString() + "]";
	}

	public Date getRefreshTimestamp() {
		return refreshTimestamp;
	}

	public void setRefreshTimestamp(Date refreshTimestamp) {
		this.refreshTimestamp = refreshTimestamp;
	}
}
