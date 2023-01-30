package kg.info.tv.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyRateInfoDto {
    @JsonProperty("CurrencyID")
    private Integer currencyId;
    @JsonProperty("CurrencySymbol")
    private String currencySymbol;
    @JsonProperty("CrossCurrencyID")
    private Integer crossCurrencyId;
    @JsonProperty("CrossCurrencySymbol")
    private String crossCurrencySymbol;
    @JsonProperty("BuyRate")
    private BigDecimal buyRate;
    @JsonProperty("SellRate")
    private BigDecimal sellRate;
}
