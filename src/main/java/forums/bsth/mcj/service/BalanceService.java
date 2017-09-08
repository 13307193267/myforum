package forums.bsth.mcj.service;

import java.util.List;

import forums.bsth.mcj.entity.Balance;
import forums.bsth.mcj.util.PageHelper;
import forums.bsth.mcj.util.PageModel;

public interface BalanceService {
	List<Balance> selectBalances(Balance balance);

	void selectPage(PageHelper<Balance> pageHelper);

	void insert(Balance balance);

	void update(Balance balance);

	void delete(Balance balance);

	// ∑÷“≥≤È—Ø
	void listUserWithPage(PageModel<Balance> pageModel);
}