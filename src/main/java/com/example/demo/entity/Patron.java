package com.example.demo.entity;


import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "patron")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Patron {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private String  contactInfo ;

    @OneToMany(mappedBy = "patron", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BorrowingRecord> borrowingRecords;

    public Patron(String name, String contactInformation) {
    }
}