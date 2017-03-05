package custome_interface;

import model.Travel;
import model.User;

public interface TravelRepository {
	Travel add(Travel travel);
	Travel update(Travel travel);
	Travel delete(Travel travel);
	Travel query(String id);
}
