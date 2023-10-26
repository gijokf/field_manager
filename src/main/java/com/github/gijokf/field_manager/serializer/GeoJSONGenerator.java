package com.github.gijokf.field_manager.serializer;

import com.github.gijokf.field_manager.dto.geoJSON.Feature;
import com.github.gijokf.field_manager.dto.geoJSON.FeatureCollectionData;
import com.github.gijokf.field_manager.dto.geoJSON.Properties;
import com.github.gijokf.field_manager.dto.geoJSON.Geometry;
import com.github.gijokf.field_manager.model.Field;

import java.util.*;

public class GeoJSONGenerator {
    public static FeatureCollectionData generateGeoJSON(List<Field> fields) {
        List<Feature> features = new ArrayList<>();

        for (Field field : fields) {
            //Para cada geometry, converter para coordinates <List<List<List<Double>>>
            List<List<List<Double>>> coordinates = GeometryToDoubleConverter.convertGeometryToCoordinates(field.getGeom());

            Properties properties = new Properties(field.getCdId(), field.getCdIdFarm());
            Geometry geometry = new Geometry("Polygon", coordinates);
            Feature feature = new Feature("Feature", properties, geometry);
            features.add(feature);
        }

        return new FeatureCollectionData("FeatureCollection", features);
    }


}