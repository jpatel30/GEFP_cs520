package gefp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Cell")
public class Cell {
	@Id
	@GeneratedValue
	
	Long id;

	@OneToOne
	Plan plan;

	@OneToOne
	Runway runway;

	@OneToOne
	Stage stage;

	@OneToMany
	@OrderColumn
	List<Checkpoint> checkpoints;

	public Cell() {
		super();
		checkpoints = new ArrayList<Checkpoint>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public Runway getRunway() {
		return runway;
	}

	public void setRunway(Runway runway) {
		this.runway = runway;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public List<Checkpoint> getCheckpoints() {
		return checkpoints;
	}

	public void setCheckpoints(List<Checkpoint> checkpoints) {
		this.checkpoints = checkpoints;
	}
	public Checkpoint removecheckpoints(int ckid) {
		for (int i = 0; i < checkpoints.size(); i++) {
			System.out.println(" checkpointsGet ID : "+ checkpoints.get(i).getId());
			if (checkpoints.get(i).getId() == ckid) {
				System.out.println("INSIDE IF checkpointsGet ID : " + checkpoints.get(i).getId());
				
				return checkpoints.remove(i);
			}
		}
		return null;
	}


}
