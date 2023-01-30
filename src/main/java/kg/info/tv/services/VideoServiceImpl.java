package kg.info.tv.services;

import kg.info.tv.entity.FileData;
import kg.info.tv.exeptions.TVException;
import kg.info.tv.repository.FileDataRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@Service
@Slf4j
public class VideoServiceImpl implements VideoService {

    @Autowired
    private FileDataRepository fileDataRepository;
    private final String FOLDER_PATH="./uploads/";

    @Override
    public String uploadVideoToPath(MultipartFile file) throws IOException, TVException {
        FileData fileDataIsHas = fileDataRepository.findByName(file.getOriginalFilename());
        if(fileDataIsHas != null) {
            throw new TVException("This file already exists");
        }
        String filePath = "./uploads/"
                + file.getOriginalFilename();

        Files.copy(file.getInputStream(),
                Path.of(filePath),
                StandardCopyOption.REPLACE_EXISTING);

        FileData fileData = fileDataRepository.save(FileData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .filePath(filePath).build());

        if (fileData == null) {
            throw new TVException("The error file was not saved to the database");
        }
        return filePath + " Has been saved!!!";
    }

    @Override
    public Resource downloadFile(String fileName) throws MalformedURLException {
        Path pathToFile = Path.of("./uploads/" + fileName);
        UrlResource resource = null;
        resource = new UrlResource(pathToFile.toUri());
        return resource;
    }
}
