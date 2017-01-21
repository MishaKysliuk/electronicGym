package com.egym.model.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Path;

/**
 * Created by MichaelMAC on 14.01.17.
 */
public class FileHelper {
    /**
     * Need to transfer this method to util class
     * @param gymPassImage
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
