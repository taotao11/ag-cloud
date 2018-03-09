
package com.cloud.form;

/**
 * 接受表单的父对象对象
 * 必须做验证
 */
import com.cloud.entity.TbAdmin;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


public class AdminForm {
    //非空判断
    @NotBlank(message = "用户名不为空")
    private String uname;
    @Length(min = 8,message = "密码最少为8位数")
    private String upass;
    @NotBlank(message = "性别不为空")
    private String usex;
    @Email(message = "邮箱不符合规范")
    private String uemil;

    public AdminForm() {

    }

    @Override
    public String toString() {
        return "AdminForm{" +
                "uname='" + uname + '\'' +
                ", upass='" + upass + '\'' +
                ", usex='" + usex + '\'' +
                ", uemil='" + uemil + '\'' +
                '}';
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


    /**
     * 复制对象
     * @param
     * @return
     */
    public TbAdmin convertAdminBean(){
        return new AdminFormConvert().convert(this);
    }
    private class AdminFormConvert implements FormConvert<AdminForm,TbAdmin> {
        @Override
        public TbAdmin convert(AdminForm adminForm) {
            TbAdmin adminBean = new TbAdmin();
            //复制对象属性
            BeanUtils.copyProperties(adminForm,adminBean);
            return adminBean;
        }
    }

}
