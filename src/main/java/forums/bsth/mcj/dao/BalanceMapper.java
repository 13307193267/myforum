package forums.bsth.mcj.dao;

import java.util.List;

import forums.bsth.mcj.entity.Balance;
import forums.bsth.mcj.util.PageHelper;
import forums.bsth.mcj.util.PageModel;

public interface BalanceMapper {
    List<Balance> all(Balance balance);
    
    List<Balance> selectPage(PageHelper<Balance> pageHelper);
    
    
  //查询所以数据（分页查询的准备）
  	List<Balance> selectUserListWithPage(PageModel<Balance> pageModel);
  	
  	//查询数据的总数
  	int selectUserCountWithPage(PageModel<Balance> pageModel);
  	
    
    int getCount(PageHelper<Balance> pageHelper);
    
    void add(Balance balance);
    
    void upd(Balance balance);
    
    void del(Balance balance);
}