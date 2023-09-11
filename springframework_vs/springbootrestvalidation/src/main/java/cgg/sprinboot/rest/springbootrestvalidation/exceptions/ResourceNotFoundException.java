package cgg.sprinboot.rest.springbootrestvalidation.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException{

    private String resourceName;
    private String fieldName;
    private Long fieldValue;

    public ResourceNotFoundException(String resourceName,
            String fieldName, long id) {
        super(String.format("%s not found with %s : %s",resourceName,fieldName,id));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = id;
    }

    
    
}
