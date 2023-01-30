package kg.info.tv.repository;

import kg.info.tv.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DeviceRepository extends JpaRepository<Device, String> {

    @Query(value = "SELECT * FROM devices u WHERE u.mac = ?1", nativeQuery = true)
    Device getFile_data(String ipAddress);
}
