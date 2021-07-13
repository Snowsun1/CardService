package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @Column(unique = true)
    private String fio;
    @NonNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirthday;
    @NonNull
    private String email;

    @OneToMany(cascade = {CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    private List<BankCard> bankCards = new ArrayList<>();

    public User(@NonNull String fio, @NonNull LocalDate dateOfBirthday, @NonNull String email) {
        this.fio = fio;
        this.dateOfBirthday = dateOfBirthday;
        this.email = email;
    }
}
