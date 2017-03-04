package custome_interface;

import model.User;

public interface UserRepository {
	User add(User user);
	User update();
	User delete();
	User query();
}
