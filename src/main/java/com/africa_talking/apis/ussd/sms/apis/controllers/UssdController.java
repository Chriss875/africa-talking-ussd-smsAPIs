package com.africa_talking.apis.ussd.sms.apis.controllers;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.africa_talking.apis.ussd.sms.apis.service.AfricaTalkingService;


@RestController
@RequiredArgsConstructor
@RequestMapping("/ussd")
public class UssdController {
    private final AfricaTalkingService africaTalkingService;

    @PostMapping()
    public String handleUssdRequest(
        @RequestParam String sessionId,
        @RequestParam String serviceCode,
        @RequestParam String phoneNumber,
        @RequestParam String text
    ) {
        if(text==null||text.isEmpty()){
        return "CON KARIBU! Andika namba yako ya simu";
    } else {
        africaTalkingService.sendSms(phoneNumber);
        return "END Tumepokea namba yako, tutakutumia orodha ya kazi kwa SMS.";
    }
}
}