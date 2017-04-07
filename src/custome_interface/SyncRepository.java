package custome_interface;

import java.util.List;

import model.Travel;

public interface SyncRepository {
	List<Travel> syncTravel(String userId, String time);
	List<Travel> syncTravelItem(String travelId, String time);
}
