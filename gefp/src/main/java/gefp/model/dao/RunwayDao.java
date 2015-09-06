package gefp.model.dao;

import java.util.List;

import gefp.model.Runway;

public interface RunwayDao {
	Runway addrunway(Runway runway);
	Runway getrunway(String runway);
	Runway getrunwaybyId(Long id);
	List<Runway> getrunway();
	Runway saveRunway(Runway runway);
}
