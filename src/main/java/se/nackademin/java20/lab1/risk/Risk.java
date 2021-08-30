package se.nackademin.java20.lab1.risk;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Risk {
    private final RestTemplate restTemplate;
    private final String url;

    public Risk(RestTemplate restTemplate, String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }

    public boolean isPassingCreditCheck(String userId) {
        final ResponseEntity<RiskAssesmentDto> entity = restTemplate.getForEntity(url + "/risk/" + userId, RiskAssesmentDto.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody().isPass();
        }

        throw new RuntimeException("Could not fetch risk assessment!");
    }
}
