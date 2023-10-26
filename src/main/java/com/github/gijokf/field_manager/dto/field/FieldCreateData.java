package com.github.gijokf.field_manager.dto.field;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.gijokf.field_manager.dto.geoJSON.FeatureCollectionData;

public record FieldCreateData(
        @JsonProperty("cd_id")
        Long cdId,

        @JsonProperty("cd_id_farm")
        Long cdIdFarm,

        @JsonProperty("fields")
        FeatureCollectionData featureCollectionData
) {
}