package forums.bsth.mcj.entity;

import java.util.Date;

public class Recharge {
	private Integer id;

	private Integer userid;

	private Double yusuan;

	private Date createtime;

	private Date updatetime;

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

	public Double getYusuan() {
		return yusuan;
	}

	public void setYusuan(Double yusuan) {
		this.yusuan = yusuan;
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
	
	
}