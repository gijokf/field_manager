package com.github.gijokf.field_manager.dto.geoJSON;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Properties(
        @JsonProperty("cd_id")
        Long cdId,

        @JsonProperty("cd_id_farm")
        Long cdIdFarm
) {
}