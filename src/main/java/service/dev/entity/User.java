package service.dev.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@Getter
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
@Table(name = "user")
public class User extends BaseTimeEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "user=idx")
    private long idx;


    @Column(nullable = false, length = 30)
    private String id;//아이디

    @Column(nullable = false, length = 30)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    //    @NotEmpty
    private String password;//비밀번호

    //    @NotEmpty
    @Column(nullable = false, length = 30)
    private String name;//이름(실명)

    //    @NotEmpty
    @Column(nullable = false, length = 30)
    private String mobile;//번호

    //    @NotEmpty
    @Column(nullable = false, length = 30)
    private String email;//이메일

    public User(){}

    @Column(nullable = false, length = 30)
    private LocalDateTime joinDate;

    @PrePersist
    public void joinDate() {
        this.joinDate = LocalDateTime.now();
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public String getUsername() {
        return this.id;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isEnabled() {
        return true;
    }



    public void modify(String mobile, String email) {
        this.mobile = mobile;
        this.email = email;
    }

    @Builder
    public User(String id, String password, String name, String mobile, String email ) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.mobile = mobile;
        this.email = email;
    }
}