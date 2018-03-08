package com.egfeign.entity;


/**
 * <p>
 * 
 * </p>
 *
 * @author taotao
 * @since 2018-03-03
 */
public class TbAdmin  {



    /**
     * 主键id
     */
    private Integer uid;
    /**
     * 姓名
     */
    private String uname;
    /**
     * 密码
     */
    private String upass;
    /**
     * 性别
     */
    private String usex;
    /**
     * 邮箱
     */
    private String uemil;


    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpass() {
        return upass;
    }

    public void setUpass(String upass) {
        this.upass = upass;
    }

    public String getUsex() {
        return usex;
    }

    public void setUsex(String usex) {
        this.usex = usex;
    }

    public String getUemil() {
        return uemil;
    }

    public void setUemil(String uemil) {
        this.uemil = uemil;
    }


    @Override
    public String toString() {
        return "TbAdmin{" +
        ", uid=" + uid +
        ", uname=" + uname +
        ", upass=" + upass +
        ", usex=" + usex +
        ", uemil=" + uemil +
        "}";
    }

}
