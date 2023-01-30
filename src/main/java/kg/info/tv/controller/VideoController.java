package kg.info.tv.controller;

import kg.info.tv.exeptions.TVException;
import kg.info.tv.services.TokensService;
import kg.info.tv.services.VideoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;

@RequestMapping("/video")
@RestController
@Slf4j
public class VideoController {

    @Autowired
    private TokensService tokensService;
    private final VideoService videoService;

    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadVideo(@RequestHeader("token") String token,
                                         @RequestParam("image") MultipartFile file) {
        log.info("Filename : " + file.getOriginalFilename());
        log.info("Size : " + file.getSize());
        log.info("Content type : " + file.getContentType());
        ResponseEntity<?> responseEntity = tokensService.verifyLogin(token);
        if (!responseEntity.getStatusCode().equals(HttpStatus.OK)) {
            return responseEntity;
        }
        try {
            String upload = videoService.uploadVideoToPath(file);
            return ResponseEntity.ok(upload);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Failed to save file", HttpStatus.CONFLICT);
        } catch (TVException e) {
            return new ResponseEntity<>(e.toString(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/download/{filename}")
    public Resource download(@PathVariable String filename) {
        Path pathToFile = Path.of("./uploads/" + filename);
        UrlResource resource = null;
        try {
            resource = new UrlResource(pathToFile.toUri());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return resource;
    }
}
