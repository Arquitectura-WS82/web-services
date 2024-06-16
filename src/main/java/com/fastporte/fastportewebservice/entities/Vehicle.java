package com.fastporte.fastportewebservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "vehicle")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Vehicle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "driver_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    // @MapsId
    // @JsonIgnore
    private Driver driver;

//    @Column(name = "brand", nullable = false)
//    private String brand;

    @Column(name = "photo", nullable = false)
    private String photo;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "quantity", nullable = false)
    private Long quantity;

    @Column(name = "dimension_width", nullable = true)
    private Float dimensionWidth;

    @Column(name = "dimension_height", nullable = true)
    private Float dimensionHeight;

    @Column(name = "dimension_length", nullable = true)
    private Float dimensionLength;

}
