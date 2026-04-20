package com.sophors.userapi_springboot.users;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @Email
    @NotBlank
    @Column(unique = true)
    private String email;

    private String phone;
    private String address;

    @Enumerated(EnumType.STRING)
    private Status status = Status.draft;

    private String avatar;

    // ========== ENUM ==========
    public enum Status {
        draft,
        publish,
        deleted
    }
}
