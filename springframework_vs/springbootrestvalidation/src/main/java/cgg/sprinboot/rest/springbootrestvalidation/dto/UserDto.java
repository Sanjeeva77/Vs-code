package cgg.sprinboot.rest.springbootrestvalidation.dto;

import cgg.sprinboot.rest.springbootrestvalidation.valid.ImageNameValid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDto {

    private int id;

    @NotEmpty
    @Size(min=4,message="UserName should be minimun of 4 characters")
    private String name;

    @Email(message="Email Address is not valid")
    private String email;

    @NotEmpty
    @Size(min=4,max=10,message="Password must be minimum of 3 chars and max of 10 chars")
    private String password;

    @NotNull
    private String about;

    @ImageNameValid
    private String imageName;
    

}
