package weclaw.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class GameCharacter {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String name;

    private Integer level;

    private String characterClass;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "applicationUserId", nullable = false)
    private ApplicationUser applicationUser;

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

	/**
	 * @return the level
	 */
	public Integer getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}

	/**
	 * @return the characterClass
	 */
	public String getCharacterClass() {
		return characterClass;
	}

	/**
	 * @param characterClass the characterClass to set
	 */
	public void setCharacterClass(String characterClass) {
		this.characterClass = characterClass;
	}

	public ApplicationUser getUser() {
		return applicationUser;
	}

	public void setUser(ApplicationUser applicationUser) {
		this.applicationUser = applicationUser;
	}

}