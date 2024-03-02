package com.project.project.user;


import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Entity
@Table(name = "users")
public class User implements Serializable, UserDetails {
    @Id
    @Column(name = "username")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "UniqueCode")
    private long UniqueCode;

    public User() {

    }
    public User(String username, String password, long UniqueCode) {
        this.username = username;
        this.password = password;
        this.UniqueCode = UniqueCode;
    }
    public User(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"),
                             new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public long getUniqueCode() {
        return UniqueCode;
    }
}
