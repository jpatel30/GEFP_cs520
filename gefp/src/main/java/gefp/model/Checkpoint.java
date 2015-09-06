package gefp.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Checkpoint")
public class Checkpoint {

	@Id
	@GeneratedValue
	Long id;

	String description;
	
	@ManyToMany(mappedBy="checkpoints")
	List<User> user;
	
	public Checkpoint() {
		
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
