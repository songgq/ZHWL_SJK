package com.ustcsoft.jt.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/3/20.
 */
@ApiModel(value = "学生入参", description = "学生入参")
public class Student implements Serializable{

    @ApiModelProperty(value = "学生姓名", name = "name", example = "xiaoming")
    private String name;
    @ApiModelProperty(value = "学生年龄", name = "age", example = "15")
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Student(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
