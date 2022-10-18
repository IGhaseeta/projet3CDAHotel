package com.eql.Hotel.util;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


@Component
public class ImageUpload {
    private final String UPLOAD_FOLDER = "src\\main\\resources\\static\\img\\image-room";
    public boolean uploadImage(MultipartFile imageRoom){
        boolean isUpload = false;
        try{
            Files.copy(
                    imageRoom.getInputStream(),
                    Paths.get(UPLOAD_FOLDER + File.separator,
                            imageRoom.getOriginalFilename()),
                            StandardCopyOption.REPLACE_EXISTING);
                    isUpload = true;
        }catch (Exception e){
            e.printStackTrace();
        }return isUpload;
    }

    public boolean checkExisted(MultipartFile imageRoom){
        boolean isExisted = false;
        try {
            File file = new File(UPLOAD_FOLDER + "\\" + imageRoom.getOriginalFilename());
            isExisted = file.exists();
        }catch (Exception e){
            e.printStackTrace();
        }
            return isExisted;
    }


}
