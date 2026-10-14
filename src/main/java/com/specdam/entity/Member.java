package com.specdam.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "members")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String rollNumber;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String club; // e.g., SPECDAM, KRIYA, CSI

    @Column(nullable = false)
    private String domain; // DANCE, ART, FILM

    @Column(nullable = false)
    private Integer year;

    @Column(nullable = false)
    private String profilePicUrl;
}
