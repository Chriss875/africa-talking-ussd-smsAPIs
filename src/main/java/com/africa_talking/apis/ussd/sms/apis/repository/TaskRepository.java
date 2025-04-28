package com.africa_talking.apis.ussd.sms.apis.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.africa_talking.apis.ussd.sms.apis.model.Tasks;

@Repository
public interface TaskRepository extends JpaRepository<Tasks, Long>{
    Tasks findByArtisanPhoneNumber(String artisanPhoneNumber);
}
