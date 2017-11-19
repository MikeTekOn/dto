package weclaw.domain.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import weclaw.domain.GameCharacter;

@Entity
public class ApplicationUserDto {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String name;

	private String email;

	private String date;
	
	@OneToMany(mappedBy = "applicationUser")
	private List<GameCharacter> gameCharacters;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<GameCharacter> getGameCharacters() {
		return gameCharacters;
	}

	public void setGameCharacters(List<GameCharacter> gameCharacters) {
		this.gameCharacters = gameCharacters;
    }
    
    public Date getLastLoginDateConverted(String timezone) throws ParseException {
        dateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
        return dateFormat.parse(this.date);
    }
 
    public void setLastLoginDate(Date date, String timezone) {
        dateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
        this.date = dateFormat.format(date);
    }

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}