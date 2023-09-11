package cgg.sprinboot.rest.springbootrestvalidation.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cgg.sprinboot.rest.springbootrestvalidation.dao.UserRepository;
import cgg.sprinboot.rest.springbootrestvalidation.dto.UserDto;
import cgg.sprinboot.rest.springbootrestvalidation.entities.User1;
import cgg.sprinboot.rest.springbootrestvalidation.exceptions.ResourceNotFoundException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<UserDto> getAllUsers() {
        List<User1> users=userRepository.findAll();
       List<UserDto> userDtos= users.stream().map(user->userToUserDto(user)).collect(Collectors.toList());
       return userDtos;
    }

    public UserDto getUserById(int id) {

        User1 user1=userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("user","Id",id));
        return userToUserDto(user1);
    }

    public UserDto addUser(UserDto userDto) {
       User1 user1=userDtoToUser(userDto);
       User1 savedUser=userRepository.save(user1);
        return userToUserDto(savedUser);
    }

    public UserDto updateUser(UserDto userDto,int userId){
        User1 user1=userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("user","Id",userId));
        
        user1.setName(userDto.getName());
        user1.setPassword(userDto.getPassword());
        user1.setEmail(userDto.getEmail());
        user1.setAbout(userDto.getAbout());
        User1 updatedUser=userRepository.save(user1);
    
        return userToUserDto(updatedUser);
    }
   
    public void deleteUser(int userId){
       User1 user1= userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("user","id",userId));
       userRepository.delete(user1);
    }

    public User1 userDtoToUser(UserDto userDto){
        // User1 user1=new User1();
        // user1.setId(userDto.getId());
        // user1.setName(userDto.getName());
        // user1.setPassword(userDto.getPassword());
        // user1.setEmail(userDto.getEmail());
        // user1.setAbout(userDto.getAbout());

        // return user1;

        User1 user=modelMapper.map(userDto,User1.class);
        return user;

    }

    public UserDto userToUserDto(User1 user1){
        // UserDto userDto=new UserDto();
        // userDto.setId(userDto.getId());
        // userDto.setName(userDto.getName());
        // userDto.setPassword(userDto.getPassword());
        // userDto.setEmail(userDto.getEmail());
        // userDto.setAbout(userDto.getAbout());

        // return userDto;
       UserDto userDto= modelMapper.map(user1,UserDto.class);
       return userDto;
    }

    
}
