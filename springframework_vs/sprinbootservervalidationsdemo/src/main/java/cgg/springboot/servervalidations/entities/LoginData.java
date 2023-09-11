package cgg.springboot.servervalidations.entities;

import cgg.springboot.servervalidations.validations.ImageNameValid;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class LoginData{@NotBlank(message="User Name cannot e empty..") 
@Size(min=3,max=12,message="User Name must be 3-12 characters") 
String userName;
@Pattern(regexp="[a-zA-Z0-9]+\\.[a-zA-Z0-9]+@gmail\\.com",message="Invalid Email")String eamil;
@AssertTrue(message="Must Agree Terms and conditions")boolean agrred;
    
    public LoginData(){
        this("","",false);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEamil() {
        return eamil;
    }

    public void setEamil(String eamil) {
        this.eamil = eamil;
    }

    public boolean isAgrred() {
        return agrred;
    }

    @ImageNameValid
    private String imageName;
    public void setAgrred(boolean agrred) {
        this.agrred = agrred;
    }

    @Override
    public String toString() {
        return "LoginData [userName=" + userName + ", eamil=" + eamil + ", agrred=" + agrred + "]";
    }

    public LoginData(
            @NotBlank(message = "User Name cannot e empty..") @Size(min = 3, max = 12, message = "User Name must be 3-12 characters") String userName,
            @Pattern(regexp = "[a-zA-Z0-9]+\\.[a-zA-Z0-9]+@gmail\\.com", message = "Invalid Email") String eamil,
            @AssertTrue(message = "Must Agree Terms and conditions") boolean agrred) {
        this.userName = userName;
        this.eamil = eamil;
        this.agrred = agrred;
    }
    
}
