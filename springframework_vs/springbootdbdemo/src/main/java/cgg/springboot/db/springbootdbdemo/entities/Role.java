package cgg.springboot.db.springbootdbdemo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@Table(name="roles")
@AllArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int roleId;

    
    private String roleName;


}
