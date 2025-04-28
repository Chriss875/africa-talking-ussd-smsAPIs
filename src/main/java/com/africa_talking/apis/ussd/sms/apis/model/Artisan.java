package com.africa_talking.apis.ussd.sms.apis.model;
import jakarta.persistence.Entity;
import lombok.*;
import jakarta.persistence.*;

@Entity
@Getter
@Setter
@Builder
@Table(name="artsans")
public class Artisan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String artsanName;
    private String phoneNumber;
}
