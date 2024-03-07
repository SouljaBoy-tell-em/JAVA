package com.example.application;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;


@Entity
@Table(name = "UserTable")
public class User implements UserDetails, Serializable {

//    @Pattern(regexp = "^[A-Z][a-z]*$",
//            message = "Enter the correct firstname")
    @Column(name = "Firstname")
    private String Firstname;

//    @Pattern(regexp = "^[A-Z][a-z]*$",
//            message = "Enter the correct lastname")
    @Column(name = "Lastname")
    private String Lastname;

//    @Pattern(regexp = "^[a-z]+[a-z0-9]*@[a-z]+.[a-z]+$",
//            message = "Enter the correct Email")
    @Column(name = "Email")
    private String Email;

//    @Pattern(regexp = "^[A-Za-z]+[A-Za-z0-9]*$",
//            message = "Enter the correct username")
    @Id
    @Column(name = "Username")
    private String Username;

    @Column(name = "Password")
    private String Password;

    public User() {

    }

    public User(String Firstname, String Lastname, String Email,
                String Username,  String Password) {

        this.Firstname = Firstname;
        this.Lastname  =  Lastname;
        this.Email     =     Email;
        this.Username  =  Username;
        this.Password  =  Password;
    }

    public User(User user) {

        this.Firstname = user.getFirstname();
        this.Lastname  = user.getLastname();
        this.Email     = user.getEmail();
        this.Username  = user.getUsername();
        this.Password  = user.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"),
                             new SimpleGrantedAuthority("ROLE_ADMIN"));
    }
    public String getEmail() {
        return Email;
    }
    public String getFirstname() {
        return Firstname;
    }
    public String getLastname() {
        return Lastname;
    }
    @Override public String getPassword() {
        return Password;
    }
    @Override public String getUsername() {
        return Username;
    }
    @Override public boolean isAccountNonExpired() {
        return true;
    }
    @Override public boolean isAccountNonLocked() {
        return true;
    }
    @Override public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override public boolean isEnabled() {
        return true;
    }
    public void setEmail(String email) {
        Email = email;
    }
    public void setFirstname(String firstname) {
        Firstname = firstname;
    }
    public void setLastname(String lastname) {
        Lastname = lastname;
    }
    public void setPassword(String Password) {
        this.Password = Password;
    }
    public void setUsername(String Username) {
        this.Username = Username;
    }


}
