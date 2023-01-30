package kg.info.tv.controller;

import kg.info.tv.entity.Device;
import kg.info.tv.repository.DeviceRepository;
import kg.info.tv.repository.FileDataRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@RequestMapping()
@Controller
@Slf4j
public class MainController {
    @Autowired
    private FileDataRepository fileDataRepository;
    @Autowired
    private DeviceRepository deviceRepository;

    @GetMapping("/")
    public String home (Model model) {
        model.addAttribute("devices", "Главная страница");
        return "home";
    }

    @PostMapping("/main")
    public String deviceCreate(Model model) {

        Map<String, Object> qw = new HashMap<>();
        qw.put("qwerty", "qpoiu");
        qw.put("asdfg", "alkjh");
        qw.put("zxcvb", "zmnbv");
        Device device = new Device("121212","qwerty", 7,  qw);
        deviceRepository.save(device);
        return "home";
    }
}
