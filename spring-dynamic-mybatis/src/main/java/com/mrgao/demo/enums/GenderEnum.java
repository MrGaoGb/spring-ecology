package com.mrgao.demo.enums;

import lombok.Getter;

@Getter
public enum GenderEnum {
    MAN(1, "男"),
    GIRL(2, "女");
    private int index;

    private String name;

    GenderEnum(int index, String name) {
        this.index = index;
        this.name = name;
    }
}
