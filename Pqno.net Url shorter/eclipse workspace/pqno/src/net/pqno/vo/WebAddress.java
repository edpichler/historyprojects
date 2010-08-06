package net.pqno.vo;

import java.util.Calendar;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.Unique;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class WebAddress {

	@PrimaryKey()
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;

	@Persistent
	@Unique
	private Suffix suffix;
	@Persistent
	private java.util.Date timestamp;
	@Persistent
	@Unique
	private String originalUrl;

	public WebAddress() {
		timestamp = Calendar.getInstance().getTime();
	}

	public void setSuffix(Suffix suffix) {
		this.suffix = suffix;
	}

	public Suffix getSuffix() {
		return suffix;
	}

	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}

	public String getOriginalUrl() {
		return originalUrl;
	}

	public void setTimestamp(java.util.Date timestamp) {
		this.timestamp = timestamp;
	}

	public java.util.Date getTimestamp() {
		return timestamp;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
}
