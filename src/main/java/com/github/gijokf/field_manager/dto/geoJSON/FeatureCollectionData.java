package com.github.gijokf.field_manager.dto.geoJSON;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record FeatureCollectionData(
        @JsonProperty("type")
        String type,

        @JsonProperty("features")
        List<Feature> features
) {
    public FeatureCollectionData(String type, List<Feature> features) {
        this.type = type;
        this.features = features;
    }
}