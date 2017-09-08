package forums.bsth.mcj.dao;

import java.util.List;

import forums.bsth.mcj.entity.Schedule;

public interface ScheduleMapper {
	List<Schedule> all();

	void add(Schedule schedule);

	void upd(Schedule schedule);

	void del(Schedule schedule);
}