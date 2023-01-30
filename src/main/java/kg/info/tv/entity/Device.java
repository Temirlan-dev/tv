package kg.info.tv.entity;

import jakarta.persistence.*;
import kg.info.tv.config.HashMapConverter;
import lombok.Data;

import java.util.Map;
@Data
@Table(name = "devices")
@Entity
public class Device {
    @Id
    @Column(name = "mac")
    private String macAddress;
    private String name;
    @Column(name = "office_id", insertable = false, updatable = false)
    private int officeId;
    @Convert(converter = HashMapConverter.class)
    Map<String, Object> version;

    public Device() {
    }
    public Device(String macAddress, String name, Integer officeId) {
        this.macAddress = macAddress;
        this.name = name;
        this.officeId = officeId;
    }
    public Device(String macAddress, String name, int officeId, Map<String, Object> version) {
        this.macAddress = macAddress;
        this.name = name;
        this.officeId = officeId;
        this.version = version;
    }
}
