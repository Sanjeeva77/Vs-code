package cgg.springboot.fileupload.springboorfileuploadex.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FileResponse {
    
    private String fileName;
    private String message;
}
