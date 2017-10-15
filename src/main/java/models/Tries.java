package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tries")
public class Tries {
	@Id
	@Column(name = "nameoftribe")
	private String nameoftribe;
	private String chief;
	
	public String getNameoftribe() {
		return nameoftribe;
	}
	public void setNameoftribe(String nameoftribe) {
		this.nameoftribe = nameoftribe;
	}
	public String getChief() {
		return chief;
	}
	public void setChief(String chief) {
		this.chief = chief;
	}
}
