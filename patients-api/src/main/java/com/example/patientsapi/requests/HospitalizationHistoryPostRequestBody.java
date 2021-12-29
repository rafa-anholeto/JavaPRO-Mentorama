package com.example.patientsapi.requests;


import lombok.Data;

import javax.persistence.Id;

@Data
public class HospitalizationHistoryPostRequestBody {

    private Long patientId;
    private String dateAndEntryPatientHour;
    private String dateAndExitPatientHour;

    private String description;
}
