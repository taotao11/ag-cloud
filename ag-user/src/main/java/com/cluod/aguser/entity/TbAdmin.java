package com.cluod.aguser.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author taotao
 * @since 2018-03-03
 */
@TableName("tb_admin")
public class TbAdmin extends Model<TbAdmin> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "uid", type = IdType.AUTO)
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

    protected Serializable pkVal() {
        return this.uid;
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

    protected Serializable getPrimaryKey() {
        return this.uid;
    }
}
