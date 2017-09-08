package forums.bsth.mcj.dao;

import forums.bsth.mcj.entity.BbsReply;

public interface BbsReplyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BbsReply record);

    int insertSelective(BbsReply record);

    BbsReply selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BbsReply record);

    int updateByPrimaryKeyWithBLOBs(BbsReply record);

    int updateByPrimaryKey(BbsReply record);
}