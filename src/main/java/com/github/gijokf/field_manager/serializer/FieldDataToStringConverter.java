package com.github.gijokf.field_manager.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.gijokf.field_manager.dto.geoJSON.FeatureCollectionData;

public class FieldDataToStringConverter {
    public static String convertFieldDataToString(FeatureCollectionData fieldData) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(fieldData);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}