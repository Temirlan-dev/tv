package kg.info.tv.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegionDto {
    @JsonProperty("RegionID")
    private Integer regionId;
    @JsonProperty("RegionName")
    private String regionName;
    @JsonProperty("RegionTypeID")
    private String regionTypeId;
    @JsonProperty("Code")
    private String code;
    @JsonProperty("RegionCode")
    private String regionCode;
}
