package se.nackademin.java20.lab1.risk;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RiskAssesmentDto {

    private boolean pass;

    @JsonCreator
    public void RiskAssessmentDto(@JsonProperty("pass") boolean pass) {
        this.pass = pass;
    }

    public boolean isPass() {
        return pass;
    }



}
