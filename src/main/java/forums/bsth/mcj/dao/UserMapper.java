package forums.bsth.mcj.dao;

import java.util.List;

import forums.bsth.mcj.entity.User;

public interface UserMapper {
    void add(User user);
    
    List<User> all();
    
    int count();
    
    //登录验证
    User login(User user);
    
    // 登录验证
    User yz(User user);
}