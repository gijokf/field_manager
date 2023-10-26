package com.github.gijokf.field_manager.service;

import com.github.gijokf.field_manager.dto.field.FieldCreateData;
import com.github.gijokf.field_manager.dto.geoJSON.FeatureCollectionData;
import com.github.gijokf.field_manager.model.Field;
import com.github.gijokf.field_manager.repository.FieldRepository;
import com.github.gijokf.field_manager.serializer.FieldDataToStringConverter;
import com.github.gijokf.field_manager.serializer.GeoJSONGenerator;
import lombok.RequiredArgsConstructor;

import org.geotools.feature.FeatureCollection;
import org.geotools.feature.FeatureIterator;
import org.geotools.geojson.feature.FeatureJSON;
import org.locationtech.jts.geom.Geometry;
import org.opengis.feature.simple.SimpleFeature;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FieldService {

    private final FieldRepository fieldRepository;

    public FeatureCollectionData register(FieldCreateData data) throws IOException {
        String geoJSON = FieldDataToStringConverter.convertFieldDataToString(data.featureCollectionData());

        FeatureJSON featureJSON = new FeatureJSON();

        FeatureCollection<?, ?> featureCollection = featureJSON.readFeatureCollection(new StringReader(geoJSON));

        FeatureIterator<?> featureIterator = featureCollection.features();

        List<Field> fields = new ArrayList<>();

        while (featureIterator.hasNext()) {
            SimpleFeature feature = (SimpleFeature) featureIterator.next();
            Geometry geometry = (Geometry) feature.getDefaultGeometry();
            Field field = new Field();
            field.setCdIdFarm(data.cdIdFarm());
            field.setGeom(geometry);
            fields.add(field);
        }

        fieldRepository.saveAll(fields);

        return this.read(data.cdIdFarm());
    }

    public FeatureCollectionData read(Long cd_id_farm) {
        List<Field> fields = fieldRepository.findByFarmCdId(cd_id_farm);

        return GeoJSONGenerator.generateGeoJSON(fields);
    }
}