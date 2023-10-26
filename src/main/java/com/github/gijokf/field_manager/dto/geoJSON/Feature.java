package com.github.gijokf.field_manager.dto.geoJSON;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Feature(
        @JsonProperty("type")
        String type,

        @JsonProperty("properties")
        Properties properties,

        @JsonProperty("geometry")
        Geometry geometry
) {
        public Feature(String type, Properties properties, Geometry geometry) {
                this.type = type;
                this.properties = properties;
                this.geometry = geometry;
        }
}