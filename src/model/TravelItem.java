package model;

import java.text.DateFormat;
import java.util.UUID;

public class TravelItem {
    private String id;
    private String travel_id;
    private String description;
    private String image;
    private String time;
    public TravelItem() {
    }
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTravel_id() {
		return travel_id;
	}
	public void setTravel_id(String travel_id) {
		this.travel_id = travel_id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
}
