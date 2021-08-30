package se.nackademin.java20.lab1.presentation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import se.nackademin.java20.lab1.risk.Risk;
import se.nackademin.java20.lab1.risk.RiskAssesmentDto;

import java.io.DataInput;

import static org.junit.jupiter.api.Assertions.*;

class RiskTest {

    @Test
    void falseResult(){
        String url = "http://localhost:8082/risk/12345";
        ResponseEntity<String> responseEntity = new RestTemplate().getForEntity(url, String.class);
        String actual = "{\"pass\":false}";
        assertEquals(responseEntity.getBody(), actual);
    }




    @Test
    public void deserializedTest() throws JsonProcessingException {
        String json = "{\"pass\": true}";
        RiskAssesmentDto riskAssesmentDto = new ObjectMapper().readValue(json, RiskAssesmentDto.class);
        assertTrue(riskAssesmentDto.isPass());
    }

    @Test
    public void jsonTest(){
        String url = "http://localhost:8082/risk/12345";
        ResponseEntity<RiskAssesmentDto> responseEntity = new RestTemplate().getForEntity(url, RiskAssesmentDto.class);

    }


}