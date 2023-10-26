package com.github.gijokf.field_manager.controller;

import com.github.gijokf.field_manager.dto.field.FieldCreateData;
import com.github.gijokf.field_manager.dto.geoJSON.FeatureCollectionData;
import com.github.gijokf.field_manager.service.FieldService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping({"api/fields"})
@RequiredArgsConstructor
public class FieldController {

    private final FieldService fieldService;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid FieldCreateData data) throws IOException {
        FeatureCollectionData fields = fieldService.register(data);

        return ResponseEntity.ok(fields);
    }

    @GetMapping({"farms/{id}"})
    public ResponseEntity read(@PathVariable Long id) {
        FeatureCollectionData fields = fieldService.read(id);

        if (fields == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Farm not found.");
        }

        return ResponseEntity.ok(fields);
    }
}