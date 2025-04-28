package com.africa_talking.apis.ussd.sms.apis.service;
import com.africa_talking.apis.ussd.sms.apis.model.Tasks;
import com.africa_talking.apis.ussd.sms.apis.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final TaskRepository taskRepository;

    @Override
    public void run(String... args) throws Exception {
        if (taskRepository.count() == 0) {

            Tasks tasks1 = Tasks.builder()
                    .artisanPhoneNumber("123456789")
                    .tasksdescription(Arrays.asList("Clean the workshop", "Prepare materials", "Check inventory"))
                    .build();

            Tasks tasks2 = Tasks.builder()
                    .artisanPhoneNumber("987654321")
                    .tasksdescription(Arrays.asList("Fix the generator", "Inspect tools", "Update inventory"))
                    .build();
                    
            taskRepository.save(tasks1);
            taskRepository.save(tasks2);
            System.out.println("Sample tasks saved to the database.");
        }
    }
}
