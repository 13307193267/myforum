package forums.bsth.mcj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import forums.bsth.mcj.entity.PasswordUtil;
import forums.bsth.mcj.entity.User;
import forums.bsth.mcj.entity.UserInfo;
import forums.bsth.mcj.service.UserInfoService;
import forums.bsth.mcj.service.UserService;

@Controller
@RequestMapping("/user/*")
@SessionAttributes("user")
public class UserController {

	@Autowired
	UserService uService;
	@Autowired
	UserInfoService uIservice;

	/*
	 * @RequestMapping(value="/add",method=RequestMethod.POST)
	 * 
	 * @ResponseBody public void ss(User user){ uService.insert(user);
	 * 
	 * }
	 */

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@ResponseBody
	public List<User> allUsers() {
		List<User> users = uService.allUsers();
		return users;

	}
	
	@RequestMapping(value = "/zs", method = RequestMethod.GET)
	@ResponseBody
	public int getCount() {
		int num = uService.count();
		return num;

	}
	

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public void addUser(User user, UserInfo userInfo) {
		User users = new User();
		ModelAndView mView = new ModelAndView();
		user.setUserpassword(PasswordUtil.string2MD5(user.getUserpassword())); 
		uService.insert(user);
		userInfo.setUserid(uService.count());
		uIservice.insert(userInfo);
		/*if (users == null) {
			uService.insert(user);
			userInfo.setUserid(uService.count());
			uIservice.insert(userInfo);
			mView.addObject("true", "×¢²á³É¹¦!");
			return mView;
		}else {
			mView.addObject("false", "×¢²áÊ§°Ü!");
		}
		
		return mView;*/
	}
	
	@RequestMapping(value = "/yz" , method = RequestMethod.POST)
	@ResponseBody
	public User  yanZeng(User user){
		user = uService.yz(user);
		if (user != null) {
			return user;
		}else {

			return user;
		}
		
		
	}

}
