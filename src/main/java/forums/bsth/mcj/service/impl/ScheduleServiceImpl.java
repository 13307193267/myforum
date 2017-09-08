package forums.bsth.mcj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import forums.bsth.mcj.dao.ScheduleMapper;
import forums.bsth.mcj.entity.Schedule;
import forums.bsth.mcj.service.ScheduleService;

@Service
public class ScheduleServiceImpl implements ScheduleService{

	@Autowired  private ScheduleMapper sc;
	
	@Override
	public List<Schedule> selectSchedule() {
		// TODO Auto-generated method stub
		return sc.all();
	}

	@Override
	public void insert(Schedule schedule) {
		// TODO Auto-generated method stub
		sc.add(schedule);
	}

	@Override
	public void update(Schedule schedule) {
		// TODO Auto-generated method stub
		sc.upd(schedule);
	}

	@Override
	public void delete(Schedule schedule) {
		// TODO Auto-generated method stub
		sc.del(schedule);
	}

}
