package gefp.model.dao;

import gefp.model.Checkpoint;

public interface CheckpointDao {
	
	Checkpoint addcheckpoint(Checkpoint checkpoint);
	String getnamebyId(long cid);
	Checkpoint getcheckpoint(long id);
	Checkpoint savecheckpoint(Checkpoint checkpoint);
}
