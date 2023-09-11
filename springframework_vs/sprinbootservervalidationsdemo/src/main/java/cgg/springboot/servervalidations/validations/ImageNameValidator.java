package cgg.springboot.servervalidations.validations;

import java.util.logging.Logger;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ImageNameValidator implements ConstraintValidator<ImageNameValid,String> {

    private Logger logger=Logger.getLogger(ImageNameValidator.class.getName());
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        
        logger.info("Message from isValid : "+value);
        //logic 
        if(value.isBlank()){
            return false;

        }

        return true;
    }

}
