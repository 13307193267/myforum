package forums.bsth.mcj.dao;

import forums.bsth.mcj.entity.Bbs;

public interface BbsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Bbs record);

    int insertSelective(Bbs record);

    Bbs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Bbs record);

    int updateByPrimaryKey(Bbs record);
}