package gefp.model.dao;

import java.util.List;

import gefp.model.Stage;

public interface StageDao {
	Stage addstage(Stage stage);
	Stage getstage(String stage);
	Stage getstagebyId(Long id);
	List<Stage> getstage();
	Stage saveStage(Stage stage);
}
