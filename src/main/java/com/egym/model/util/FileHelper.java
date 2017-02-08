package com.egym.model.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Path;

/**
 * Created by MichaelMAC on 14.01.17.
 */
public class FileHelper {
    /**
     * Copies multipart file to new file.
     * @param gymPassImage multipart file with image
     * @param destination destination path of new file
     */
    public static void transferFile(MultipartFile gymPassImage, Path destination) {
        if(gymPassImage != null && !gymPassImage.isEmpty()){
            try{
                gymPassImage.transferTo(new File(destination.toString()));
            }catch (Exception e){
                e.printStackTrace();
                throw new RuntimeException("Gym pass image saving failed", e);
            }
        }
    }
}
