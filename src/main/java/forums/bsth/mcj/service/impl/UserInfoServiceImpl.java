package forums.bsth.mcj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import forums.bsth.mcj.dao.UserInfoMapper;
import forums.bsth.mcj.entity.UserInfo;
import forums.bsth.mcj.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService{

	@Autowired private UserInfoMapper uIMapper;
	
	@Override
	public void insert(UserInfo userInfo) {
		uIMapper.add(userInfo);
	}

}
