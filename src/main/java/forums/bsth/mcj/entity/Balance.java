package forums.bsth.mcj.entity;

import java.util.Date;

public class Balance {
    private Integer id;

    private Integer userid;

    private Double balance;

    private String remarks;

    private Date createtime;
    
    private Date updatetime;

    private Double yusuan;

    private User user;
    
    
    
    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

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

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
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

	public Double getYusuan() {
        return yusuan;
    }

    public void setYusuan(Double yusuan) {
        this.yusuan = yusuan;
    }
}