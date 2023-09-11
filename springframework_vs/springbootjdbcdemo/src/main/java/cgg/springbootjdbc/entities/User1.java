package cgg.springbootjdbc.entities;


public record User1(String username,String password,String email,String role) {
    
    public User1(){
        this(null,null,null,null);
    }
}
