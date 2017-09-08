package forums.bsth.mcj.service;

import forums.bsth.mcj.entity.BbsContent;

public interface BbsContentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BbsContent record);

    int insertSelective(BbsContent record);

    BbsContent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BbsContent record);

    int updateByPrimaryKeyWithBLOBs(BbsContent record);

    int updateByPrimaryKey(BbsContent record);
}