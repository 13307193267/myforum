package forums.bsth.mcj.entity;

import java.util.Date;

public class Schedule {
    private Integer id;

    private Integer userid;

    private Double zhichu;

    private Double shouru;

    private String remarks;

    private Date createtime;
    
    private Date updatetime;

    private Double zongshouru;

    private Double zongzhichu;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Double getZhichu() {
        return zhichu;
    }

    public void setZhichu(Double zhichu) {
        this.zhichu = zhichu;
    }

    public Double getShouru() {
        return shouru;
    }

    public void setShouru(Double shouru) {
        this.shouru = shouru;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
    
    public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public Double getZongshouru() {
        return zongshouru;
    }

    public void setZongshouru(Double zongshouru) {
        this.zongshouru = zongshouru;
    }

    public Double getZongzhichu() {
        return zongzhichu;
    }

    public void setZongzhichu(Double zongzhichu) {
        this.zongzhichu = zongzhichu;
    }
}