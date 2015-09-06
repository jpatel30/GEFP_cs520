package gefp.model;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Plan")
public class Plan {

	@Id
	@GeneratedValue
	Long id;

	String name;

	@OneToMany
	@OrderColumn
	List<Stage> stages;

	@OneToMany
	@OrderColumn
	List<Runway> runways;

	@OneToMany
	
	Set<Cell> cells;

	Date publishedDate;

	public Plan() {
		super();
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

	public List<Stage> getStages() {
		return stages;
	}

	public void setStages(List<Stage> stages) {
		this.stages = stages;
	}

	public List<Runway> getRunways() {
		return runways;
	}

	public void setRunways(List<Runway> runways) {
		this.runways = runways;
	}

	public Set<Cell> getCells() {
		return cells;
	}

	public void setCells(Set<Cell> cells) {
		this.cells = cells;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	public Runway removerunways(int runwayid) {
		for (int i = 0; i < runways.size(); ++i)
			if (runways.get(i).getId().equals(runwayid))
				return runways.remove(i);

		return null;
	}

	public Stage removestages(int stageid) {
		for (int i = 0; i < stages.size(); i++) {
			System.out.println("StageID : " + stageid + " StagesGet ID : "
					+ stages.get(i).getId());
			if (stages.get(i).getId() == stageid) {
				System.out.println("INSIDE IF StageID : " + stageid + " StagesGet ID : " + stages.get(i).getId());
				
				return stages.remove(i);
			}
		}
		return null;
	}

}
