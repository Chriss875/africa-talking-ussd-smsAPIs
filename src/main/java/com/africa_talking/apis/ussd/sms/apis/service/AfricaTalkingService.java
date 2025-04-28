package com.africa_talking.apis.ussd.sms.apis.service;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import java.util.HashMap;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.africa_talking.apis.ussd.sms.apis.repository.TaskRepository;
import org.springframework.web.client.RestTemplate;
import com.africa_talking.apis.ussd.sms.apis.model.Tasks;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AfricaTalkingService {

    private static final String USERNAME = "sandbox";
    private static final String API_KEY = "atsk_a50166aade03afc447463bc22fa758c25050573955f4573c280706c18d8f94a373d8a9db";
    private final String baseUrl = "https://api.africastalking.com/version1/";
    private final RestTemplate restTemplate;
    private final TaskRepository taskRepository;

    public void sendSms(String phoneNumber) {
        Tasks tasks = taskRepository.findByArtisanPhoneNumber(phoneNumber);

        StringBuilder messageBuilder = new StringBuilder("Tasks for today:\n");
        for (String task : tasks.getTasksdescription()) {
            messageBuilder.append(task).append("\n");
        }
        String message = messageBuilder.toString();

        String url = baseUrl + "messaging";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.set("apiKey", API_KEY);

        Map<String, String> body = new HashMap<>();
        body.put("username", USERNAME);
        body.put("to", phoneNumber);
        body.put("message", message);

        HttpEntity<Map<String, String>> request = new HttpEntity<>(body, headers);
        restTemplate.postForObject(url, request, String.class);
    }
}
