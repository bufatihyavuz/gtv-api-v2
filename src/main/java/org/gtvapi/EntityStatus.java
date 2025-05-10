package org.gtvapi;

public enum EntityStatus {

    ACTIVE(1),
    DELETED(2),
    PASSIVE(3);

    private final Integer code;

    EntityStatus(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public static EntityStatus fromCode(Integer code) {
        for (EntityStatus status : values()) {
            if (status.code.intValue() == code.intValue()) return status;
        }
        throw new IllegalArgumentException("Geçersiz durum kodu: " + code);
    }
}

