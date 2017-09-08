package forums.bsth.mcj.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import forums.bsth.mcj.entity.PasswordUtil;
import forums.bsth.mcj.entity.User;
import forums.bsth.mcj.service.UserService;

@Controller
public class LoginController {

	@Autowired private UserService uService;
	
	@RequestMapping(value = "/login" , method = RequestMethod.POST)
	@ResponseBody
	public User Login(User user,HttpSession session){
		user.setUserpassword(PasswordUtil.string2MD5(user.getUserpassword())); 
		user = uService.login(user);
		/*System.out.println(user.getUserInfo().getEmail());*/
		session.setAttribute("user", user);
		return user;
	}
	
	@RequestMapping(value = "/logout")
	public String logout(SessionStatus sessionStatus) {
		sessionStatus.setComplete();;
		return "login.jsp";
	}
}
