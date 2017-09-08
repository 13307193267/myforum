package forums.bsth.mcj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.alibaba.fastjson.JSONObject;

import forums.bsth.mcj.entity.Balance;
import forums.bsth.mcj.entity.User;
import forums.bsth.mcj.service.BalanceService;
import forums.bsth.mcj.util.PageModel;

@Controller
@RequestMapping("/balance/*")
@SessionAttributes("user")
public class BalanceController {

	@Autowired
	private BalanceService bs;

	@RequestMapping(value = "all", method = RequestMethod.POST)
	@ResponseBody
	public List<Balance> selectBalance(Balance balance) {
		return bs.selectBalances(balance);
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	@ResponseBody
	public void insert(Balance balance, User user) {
		balance.setUserid(user.getId());
//		balance.setUserid(11);
		balance.setBalance(balance.getYusuan());
		bs.insert(balance);
	}
	
	@RequestMapping(value = "upd", method = RequestMethod.POST)
	@ResponseBody
	public void update(Balance balance, User user) {
		System.out.println(user.getId());
		balance.setUserid(user.getId());
		bs.update(balance);
	}
	
	@RequestMapping(value = "del", method = RequestMethod.POST)
	@ResponseBody
	public void delete(Balance balance, User user) {
		bs.delete(balance);
	}
	
/*	@RequestMapping(value = "page", method = RequestMethod.POST)
	@ResponseBody
	public Object page(PageHelper pHelper,User user) {
		Object jsonObject = null;
		try {
            bs.selectPage(pHelper);
            jsonObject = JSONObject.toJSON(pHelper);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
	}*/
	

	//∑÷“≥≤È—Ø
		@RequestMapping(value = "/page",method=RequestMethod.POST)
	    @ResponseBody
	    public Object listUserWithPageForJson(PageModel pageModel) {
	        Object jsonObject = null;
	        try {
	            /*pageModel.setQueryObj(user);*/
	            bs.listUserWithPage(pageModel);
	            jsonObject = JSONObject.toJSON(pageModel);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return jsonObject;
	    }
}
