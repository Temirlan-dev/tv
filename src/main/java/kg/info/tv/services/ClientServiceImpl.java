package kg.info.tv.services;

import kg.info.tv.entity.Device;
import kg.info.tv.models.dto.ResponseClientDTO;
import kg.info.tv.models.enums.OperationResult;
import kg.info.tv.repository.DeviceRepository;
import kg.info.tv.repository.FileDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private DeviceRepository deviceRepository;
    @Autowired
    private FileDataRepository fileDataRepository;

    @Override
    public ResponseClientDTO getVersion(String ipAddress) {

        Device device = deviceRepository.getFile_data(ipAddress);
        if(device==null) {
            return new ResponseClientDTO(null, null,
                                         OperationResult.ERROR, "Error device with this ip does not exist in the database");
        } else {
            return new ResponseClientDTO(device.getOfficeId(), device.getVersion(), OperationResult.OK, "Successfully");
        }
    }
}
