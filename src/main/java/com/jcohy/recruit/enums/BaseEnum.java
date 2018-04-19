package com.jcohy.recruit.enums;

public interface BaseEnum<E extends Enum<E>> {
    String getEnumValue();
}