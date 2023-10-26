package com.github.gijokf.field_manager.model;

import com.github.gijokf.field_manager.dto.field.FieldCreateData;
import jakarta.persistence.*;
import lombok.*;
import org.locationtech.jts.geom.Geometry;

@Entity(name = "Field")
@Table(name = "cdt_field")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "cdId")
public class Field {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_id")
    private Long cdId;

    @Column(name = "cd_id_farm")
    private Long cdIdFarm;

    @Column(columnDefinition = "geometry(Geometry,4326)")
    private Geometry geom;

    @Override
    public String toString() {
        return "Field{" +
                "cdId=" + cdId +
                ", cdIdFarm=" + cdIdFarm +
                ", geom=" + geom +
                '}';
    }
}