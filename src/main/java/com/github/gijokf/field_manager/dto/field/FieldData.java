package com.github.gijokf.field_manager.dto.field;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.gijokf.field_manager.dto.geoJSON.Feature;

import java.util.List;

public record  FieldData(
        @JsonProperty("type")
        String type,

        @JsonProperty("features")
        List<Feature> features
) {
}