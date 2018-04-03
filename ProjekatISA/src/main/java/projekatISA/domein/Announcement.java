package projekatISA.domein;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Entity(name="announcement")
public class Announcement {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="name")
	private String name;

	
	@Column(name="description")
	private String description;
	
	
	@Temporal(value = TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", shape = JsonFormat.Shape.STRING,timezone = "Europe/Madrid")
	@Column(name="date")
	private Date date;

	
	/*
	 * 
	 * Moras za sliku jos ovde napravitiii!!!
	 * private Image img;
	 * 
	 */
	
	@JsonManagedReference
	@OneToMany(fetch=FetchType.LAZY, mappedBy="announcement")
	private Set<Bid> bid = new HashSet<>();
	
	
	public Announcement() {
		
		
	}

	public Announcement(String name,String description,Date date) {
		this.name=name;
		this.description=description;
		this.date=date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Set<Bid> getBid() {
		return bid;
	}

	public void setBid(Set<Bid> bid) {
		this.bid = bid;
	}
	
	public List<Bid> getBids(){
		List<Bid> bids = new ArrayList<>(bid);
		if(bids.size()>0) {
			return bids;
		}
		return null;
	}
		
		
	}
	

