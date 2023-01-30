package kg.info.tv.services;

import kg.info.tv.models.dto.ResponseClientDTO;

public interface ClientService {
    ResponseClientDTO getVersion(String ipAddress);
}
