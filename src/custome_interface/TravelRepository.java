package custome_interface;

import java.util.List;

import model.Travel;
import model.User;

public interface TravelRepository {
	Travel add(Travel travel);
	Travel update(Travel travel);
	Travel delete(String id);
	Travel query(String id);
	List<Travel> queryAll(String user_id);
}
