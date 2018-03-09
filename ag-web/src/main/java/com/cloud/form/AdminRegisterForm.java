package com.cloud.form;

/**
 * 注册表单接受类
 */
public class AdminRegisterForm extends AdminForm{
    private String yzm;

    public AdminRegisterForm() {
        super();
    }

    public String getYzm() {
        return yzm;
    }

    public void setYzm(String yzm) {
        this.yzm = yzm;
    }

    @Override
    public String toString() {
        return "AdminRegisterForm{" +
                "yzm='" + yzm + '\'' +
                '}';
    }
}
