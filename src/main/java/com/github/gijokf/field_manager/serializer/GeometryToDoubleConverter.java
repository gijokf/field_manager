package com.github.gijokf.field_manager.serializer;

import org.locationtech.jts.geom.Geometry;


import java.util.ArrayList;
import java.util.List;

public class GeometryToDoubleConverter {
    public static List<List<List<Double>>> convertGeometryToCoordinates(Geometry geometry) {
        String geomString = geometry.toString();

        geomString = geomString.replace("POLYGON ((", "").replace("))", "");

        String[] rings = geomString.split("\\), \\(");

        List<List<List<Double>>> coordinates = new ArrayList<>();

        for (String ring : rings) {
            List<List<Double>> ringCoordinates = new ArrayList<>();
            String[] points = ring.split(", ");

            for (String point : points) {
                String[] components = point.split(" ");

                List<Double> pointCoordinates = new ArrayList<>();
                pointCoordinates.add(Double.parseDouble(components[0]));
                pointCoordinates.add(Double.parseDouble(components[1]));

                ringCoordinates.add(pointCoordinates);
            }

            coordinates.add(ringCoordinates);
        }

        return coordinates;
    }

}