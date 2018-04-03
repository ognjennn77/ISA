package projekatISA.domein;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="annauncement")
public class Annauncement {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="name")
	private String name;

	
	@Column(name="description")
	private String description;
	
	
	@Column(name="date")
	private Date date;

	
	@Column(name="stringdate")
	private String stringdate;
	/*
	 * 
	 * Moras za sliku jos ovde napravitiii!!!
	 * private Image img;
	 * 
	 */
	
	
	
	public Annauncement() {
		
		
	}

	public Annauncement(String name,String description,Date date,String stringdate) {
		this.name=name;
		this.description=description;
		this.date=date;
		this.stringdate=stringdate;
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

	public String getStringdate() {
		return stringdate;
	}

	public void setStringdate(String stringdate) {
		this.stringdate = stringdate;
	}
	
	public void setFormatOnDateAndDate(String d) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		
		try {
			date = sdf.parse(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
