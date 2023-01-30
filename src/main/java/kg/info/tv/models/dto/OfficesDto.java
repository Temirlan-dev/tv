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
public class OfficesDto {
    @JsonProperty("ID")
    private Integer id;
    @JsonProperty("BranchID")
    private Integer branchId;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("ShortName")
    private String shortName;
    @JsonProperty("RegionCode")
    private String regionCode;
}
