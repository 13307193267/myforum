package forums.bsth.mcj.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Slogin {
	@RequestMapping(value="ssass")  
	public ModelAndView login(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("welcome");                      //返回的文件名 
		mav.addObject("message", "hello kity");
		
		List<String> list = new ArrayList<String>();
		list.add("java");
		list.add("c++");
		list.add("oracle");
		mav.addObject("bookList",list);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("zhangsan", "北京");
		map.put("lisi", "上海");
		map.put("wangwu", "深圳");
		mav.addObject("map",map);
		return mav;
	}
}
