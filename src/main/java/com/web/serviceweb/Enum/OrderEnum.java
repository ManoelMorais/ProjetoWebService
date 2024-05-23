package com.web.serviceweb.Enum;

import lombok.Getter;

@Getter
public enum OrderEnum {
    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private final int code;

    private OrderEnum(int code) {
        this.code = code;
    }

    public static OrderEnum valueOf(int code) {
        for (OrderEnum value : OrderEnum.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
    throw new IllegalArgumentException("Invalid OrderEnum code");
    }
}
