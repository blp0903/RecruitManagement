package com.jcohy.recruit.enums;

public enum ResumeStatus implements BaseEnum {

    NORMAL("0","正常"),
    DELETE("1","删除");

    private final String value;
    private final String cnName;
    ResumeStatus(String value, String cnName){
        this.cnName=cnName;
        this.value=value;
    }
    public String getValue() {
        return value;
    }
    public String getCnName() {
        return cnName;
    }
    public String getEnumValue() {
        return this.value;
    }
}
