package forums.bsth.mcj.service;

import java.util.List;

import forums.bsth.mcj.entity.User;

public interface UserService {
	void insert(User user);

	List<User> allUsers();

	int count();

	// 登录验证
	User yz(User user);

	// 登录验证
	User login(User user);

}