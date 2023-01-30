package kg.info.tv.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import kg.info.tv.models.enums.RateCategoryEnum;

import java.math.BigDecimal;

public class RateDto {
    @JsonProperty("usd_buy")
    private BigDecimal USDbuy;
    @JsonProperty("usd_sale")
    private BigDecimal USDsale;
    @JsonProperty("eur_buy")
    private BigDecimal EURbuy;
    @JsonProperty("eur_sale")
    private BigDecimal EURsale;
    @JsonProperty("rub_buy")
    private BigDecimal RUBbuy;
    @JsonProperty("rub_sale")
    private BigDecimal RUBsale;
    @JsonProperty("kzt_buy")
    private BigDecimal KZTbuy;
    @JsonProperty("kzt_sale")
    private BigDecimal KZTsale;
    @JsonProperty("category")
    private RateCategoryEnum category;
}
