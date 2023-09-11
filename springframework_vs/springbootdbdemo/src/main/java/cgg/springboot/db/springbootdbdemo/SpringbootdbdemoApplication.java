package cgg.springboot.db.springbootdbdemo;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import cgg.springboot.db.springbootdbdemo.dao.UserRepo;
import cgg.springboot.db.springbootdbdemo.entities.Role;
import cgg.springboot.db.springbootdbdemo.entities.User1;

@SpringBootApplication
public class SpringbootdbdemoApplication implements CommandLineRunner {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootdbdemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		User1 user=new User1();
		user.setUsername("abc");
		user.setPassword(bCryptPasswordEncoder.encode("abc"));
		user.setRole(new Role(1,"ROLE_NORMAL"));

		userRepo.save(user);

		User1 user1=new User1();
		user1.setUsername("pqr");
		user1.setPassword(bCryptPasswordEncoder.encode("pqr"));
		user1.setRole(new Role(2,"ADMIN_NORMAL"));

		userRepo.save(user1);

		
		
	}

}
