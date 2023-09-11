package cgg.sprinboot.rest.springbootrestvalidation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cgg.sprinboot.rest.springbootrestvalidation.dto.UserDto;
import cgg.sprinboot.rest.springbootrestvalidation.payload.ApiResponse;
import cgg.sprinboot.rest.springbootrestvalidation.services.UserService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers(){

        List<UserDto> list=userService.getAllUsers();
        return new ResponseEntity<>(list,HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") int id){
       UserDto userDto=userService.getUserById(id);   
       return ResponseEntity.ok(userDto);

    }
    //post-create user
    @PostMapping("/")
    public ResponseEntity<UserDto> addUser( @Valid @RequestBody UserDto userDto){
        UserDto createdUserDto=userService.addUser(userDto);
        return new ResponseEntity<UserDto>(createdUserDto,HttpStatus.CREATED);
    }

    //put-Update user
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto,@PathVariable ("userId") int uId ){
       UserDto updatedUserDto= userService.updateUser(userDto, uId);
       return ResponseEntity.ok(updatedUserDto);
    }

    //Delete-Delete user
    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") int uId){

        userService.deleteUser(uId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("user Deleted Successfully",true),HttpStatus.OK);

    }
    
}
