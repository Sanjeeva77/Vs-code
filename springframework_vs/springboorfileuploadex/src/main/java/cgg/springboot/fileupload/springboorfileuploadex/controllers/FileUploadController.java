package cgg.springboot.fileupload.springboorfileuploadex.controllers;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cgg.springboot.fileupload.springboorfileuploadex.payload.FileResponse;
import cgg.springboot.fileupload.springboorfileuploadex.services.FileService;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/file")
public class FileUploadController {

    @Autowired
    private FileService fileService;

    @Value("${project.images}")
    private String path;

    @PostMapping("/upload")
    public ResponseEntity<FileResponse> fileUpload(@RequestParam("image") MultipartFile image){
        
        String fileName=null;

    try {

        //validations
        if(image.isEmpty()){
             return new ResponseEntity<>(new FileResponse(fileName, "image is not uploaded due to error on the server"), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if(!image.getContentType().equals("image/jpeg"))
        {
                        
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
            body(new FileResponse(image.getOriginalFilename(),"only JPEG files are allowed"));
        }
       fileName= this.fileService.uploadImage(path,image);
        //repository call
        //file name save in db
    } catch (IOException e) {
        
        e.printStackTrace();
        return new ResponseEntity<>(new FileResponse(fileName, "image is not uploaded due to error on the server"), HttpStatus.INTERNAL_SERVER_ERROR);

    }

    return new ResponseEntity<>(new FileResponse(fileName, "image uploaded Successfully"), HttpStatus.OK);

    }

    //method to serve files
    @GetMapping(value="/images/{imageName}",produces=MediaType.IMAGE_JPEG_VALUE)
    public void downloadImage(@PathVariable("imageName") String imageName,HttpServletResponse response) throws IOException{

        InputStream is=this.fileService.getResource(path,imageName);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(is, response.getOutputStream());
        
    }
    

}
