package com.example.patientsapi.mapper;

import com.example.patientsapi.Entities.HospitalizationHistory;
import com.example.patientsapi.requests.HospitalizationHistoryPostRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class HospitalizationHistoryMapper {
    public static final HospitalizationHistoryMapper INSTANCE = Mappers.getMapper(HospitalizationHistoryMapper.class);

    public abstract HospitalizationHistory toHospitalization(HospitalizationHistoryPostRequestBody hospitalizationHistoryPostRequestBody);
}
