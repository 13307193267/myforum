package forums.bsth.mcj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import forums.bsth.mcj.dao.UserMapper;
import forums.bsth.mcj.entity.User;
import forums.bsth.mcj.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired private UserMapper userMapper;
	
	@Override
	public void insert(User user) {
		userMapper.add(user);
		
	}

	@Override
	public List<User> allUsers() {
		// TODO Auto-generated method stub
		return userMapper.all();
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return userMapper.count();
	}

	@Override
	public User yz(User user) {
		// TODO Auto-generated method stub
		return userMapper.yz(user);
	}

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return userMapper.login(user);
	}

}
