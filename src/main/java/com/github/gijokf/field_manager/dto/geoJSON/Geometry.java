package com.github.gijokf.field_manager.dto.geoJSON;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record Geometry(
        @JsonProperty("type")
        String type,

        @JsonProperty("coordinates")
        List<List<List<Double>>> coordinates
) {
        public Geometry(String type, List<List<List<Double>>> coordinates) {
                this.type = type;
                this.coordinates = coordinates;
        }
}