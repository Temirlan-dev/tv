package kg.info.tv.models.dto;

import kg.info.tv.models.enums.OperationResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseClientDTO {
    private Integer office_id;
    private Map<String, Object> video_version;
    private OperationResult operationResult;
    private String message;
}
