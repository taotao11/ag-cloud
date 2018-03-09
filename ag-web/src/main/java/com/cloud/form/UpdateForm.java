package com.cloud.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 更新数据的表单提交
 */
public class UpdateForm extends AdminForm {
    private Integer uid;
    @Min(0)
    public UpdateForm() {
        super();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer id) {
        this.uid = id;
    }

    @Override
    public String toString() {
        return "UpdateForm{" +
                "uid=" + uid +
                '}';
    }
}
