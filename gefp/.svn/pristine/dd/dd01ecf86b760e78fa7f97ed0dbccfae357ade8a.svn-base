package gefp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="UsersType")
public class Usertype {
	@Id
	@GeneratedValue
	@Column(name="UserTypeId")
	private int usertypeid;
	@Column(name="Type")
	private String type;
	
	public Usertype(){}

	public int getUsertypeid() {
		return usertypeid;
	}

	public void setUsertypeid(int usertypeid) {
		this.usertypeid = usertypeid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
}
