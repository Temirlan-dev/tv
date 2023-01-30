package kg.info.tv.services;

import kg.info.tv.exeptions.TVException;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;

public interface VideoService {
    String uploadVideoToPath(MultipartFile file) throws IOException, TVException;
    Resource downloadFile(String fileName) throws MalformedURLException;
}
