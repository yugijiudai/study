package com.immoc.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yugi
 * @apiNote
 * @since 2017-07-12
 */
@Data
@NoArgsConstructor
public class City {

    private Long id;

    private String cityName;

    public City(String cityName) {
        this.cityName = cityName;
    }
}
