package forums.bsth.mcj.service;

import java.util.List;

import forums.bsth.mcj.entity.Schedule;

public interface ScheduleService {
	List<Schedule> selectSchedule();

	void insert(Schedule schedule);

	void update(Schedule schedule);

	void delete(Schedule schedule);
}