package forums.bsth.mcj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import forums.bsth.mcj.dao.BalanceMapper;
import forums.bsth.mcj.entity.Balance;
import forums.bsth.mcj.service.BalanceService;
import forums.bsth.mcj.util.PageHelper;
import forums.bsth.mcj.util.PageModel;

@Service
public class BalanceServiceImpl implements BalanceService {

	@Autowired
	private BalanceMapper ba;

	@Override
	public List<Balance> selectBalances(Balance balance) {
		return ba.all(balance);
	}

	@Override
	public void insert(Balance balance) {
		ba.add(balance);
	}

	@Override
	public void update(Balance balance) {
		ba.upd(balance);
	}

	@Override
	public void delete(Balance balance) {
		ba.del(balance);
	}

	@Override
	public void selectPage(PageHelper<Balance> pageHelper) {
		// TODO Auto-generated method stub
		pageHelper.setRows(ba.selectPage(pageHelper));
		pageHelper.setTotal(ba.getCount(pageHelper));
	}

	@Override
	public void listUserWithPage(PageModel<Balance> pageModel) {
		pageModel.setRows(ba.selectUserListWithPage(pageModel));
		pageModel.setTotal(ba.selectUserCountWithPage(pageModel));
		
	}

	

}
