package com.africa_talking.apis.ussd.sms.apis.model;
import lombok.*;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tasks")
public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String artisanPhoneNumber;
    @ElementCollection
    private List <String> tasksdescription;
    
}
