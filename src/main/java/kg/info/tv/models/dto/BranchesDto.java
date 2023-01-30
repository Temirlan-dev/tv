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
public class BranchesDto {
    @JsonProperty("ID")
    private Integer id;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Address")
    private String address;
}
