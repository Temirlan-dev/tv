package kg.info.tv.models.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum RateCategoryEnum {
    CASH(1),
    CASHLESS(2),
    NBKR(3);

    private final int code;

    public int getCode() {
        return this.code;
    }

    RateCategoryEnum(int code) {
        this.code = code;
    }

    @JsonCreator
    public static RateCategoryEnum getByCode(String code) {
        int category = Integer.parseInt(code);
        for (RateCategoryEnum type : values()) {
            if (type.getCode() == category) {
                return type;
            }
        }
        throw new IllegalArgumentException("Not found RateCategoryEnum for value: " + code);
    }
}
