package com.example.myService.entity;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /*@NotNull
    @Size(min=4, max=20)*/
    private String username;
    private String password;
    private String nickname;
    private String email;
    private String phone;

    private Boolean enabled;

    @ManyToMany  // 참고 : https://www.baeldung.com/jpa-many-to-many
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles = new ArrayList<>();

}
