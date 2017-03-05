package custome_interface;

import java.util.List;

import model.Travel;
import model.TravelItem;

public interface TravelItemRepository {
	TravelItem add(TravelItem travelItem);
	TravelItem update(TravelItem travelItem);
	TravelItem delete(String id);
	TravelItem query(String id);
	List<TravelItem> queryAll(String travel_id);
}
