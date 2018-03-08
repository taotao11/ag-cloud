package com.cluod.aguser.entity;

public class Test {
    private String name;
    private String pass;
    private int six;

    @Override
    public String toString() {
        return "Test{" +
                "name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                ", six=" + six +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getSix() {
        return six;
    }

    public void setSix(int six) {
        this.six = six;
    }

    public Test() {

    }
}
