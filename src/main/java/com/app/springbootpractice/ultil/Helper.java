package com.app.springbootpractice.ultil;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@Component
public class Helper {

    public void saveImage(MultipartFile file, Path path)
    {
        Path filePath = path;

        try {
            if(!Files.exists(filePath))
            {
                Files.createDirectories(filePath);
            }
            Files.copy(file.getInputStream(),filePath.resolve(file.getOriginalFilename()),
                    StandardCopyOption.REPLACE_EXISTING);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
