package com.sms.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.sms.provider.SmsProvider;
import com.sms.service.TestService;

@Service
@RequiredArgsConstructor
public class TestServiceImplementation implements TestService {

    private final SmsProvider smsProvider;

    @Override
    public ResponseEntity<String> sendSms(String to) {

        try {
            boolean result = smsProvider.sendSms(to);
            if (!result) return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("메세지 전송에 실패했습니다.");
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("메세지 전송중 예외가 발생했습니다.");
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("메세지 전송에 성공했습니다.");

    }
}
