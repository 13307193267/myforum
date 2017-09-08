package forums.bsth.mcj.entity;

import java.util.Date;

public class Bbs {
    private Integer id;

    private Integer userid;

    private String title;

    private String ip;

    private Integer repleycount;

    private Integer replyuserid;

    private Date createtime;

    private Date lastreplytime;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Integer getRepleycount() {
        return repleycount;
    }

    public void setRepleycount(Integer repleycount) {
        this.repleycount = repleycount;
    }

    public Integer getReplyuserid() {
        return replyuserid;
    }

    public void setReplyuserid(Integer replyuserid) {
        this.replyuserid = replyuserid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getLastreplytime() {
        return lastreplytime;
    }

    public void setLastreplytime(Date lastreplytime) {
        this.lastreplytime = lastreplytime;
    }
}