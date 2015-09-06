package gefp.model.dao;

import gefp.model.Cell;
import gefp.model.Plan;
import gefp.model.Runway;
import gefp.model.Stage;
import java.util.List;

public interface CellDao {

		List<Cell> getcells();
		List<Cell> getcelldetail(Plan plan , Runway runway, Stage stage);
		Cell savecell(Cell cell);
		Cell getcellbyId(long cid);
		Cell getcell( Plan plan, Runway runway, Stage stage);
		
}
