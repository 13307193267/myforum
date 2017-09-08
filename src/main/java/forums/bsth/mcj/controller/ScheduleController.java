package forums.bsth.mcj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import forums.bsth.mcj.entity.Balance;
import forums.bsth.mcj.entity.Schedule;
import forums.bsth.mcj.entity.User;
import forums.bsth.mcj.service.BalanceService;
import forums.bsth.mcj.service.ScheduleService;

@Controller
@RequestMapping("/schedule/*")
@SessionAttributes("user")
public class ScheduleController {

	@Autowired private ScheduleService scs;
	@Autowired private BalanceService bs;
	
	@RequestMapping(value = "/all",method = RequestMethod.GET)
	@ResponseBody
	public List<Schedule> all(){
		return scs.selectSchedule();
	}
	
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	@ResponseBody
	public void add(Schedule schedule,Balance balance ,User user){
		
		balance.setUserid(user.getId());
//		balance.setUserid(11);
		List<Balance> sbBalances=bs.selectBalances(balance);
	
		double bals = sbBalances.get(sbBalances.size()-1).getBalance();
		if (schedule.getShouru() ==null) {
			schedule.setShouru(0.0);
		}
		if (schedule.getZhichu() ==null) {
			schedule.setZhichu(0.0);
		}
		schedule.setUserid(user.getId());
//		schedule.setUserid(11);
		scs.insert(schedule);
		balance.setBalance(bals+schedule.getShouru()-schedule.getZhichu());
		balance.setRemarks(sbBalances.get(sbBalances.size()-1).getRemarks());
		balance.setYusuan(sbBalances.get(sbBalances.size()-1).getYusuan());
		balance.setId(sbBalances.get(sbBalances.size()-1).getId());
		bs.update(balance);
		
	}
}
