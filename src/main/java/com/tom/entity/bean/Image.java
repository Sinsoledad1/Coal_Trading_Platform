package com.tom.entity.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Alfalfa99
 * @version 1.0
 * @date 2020/10/22 15:17
 * 图片pojo
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Image {
    private String uri;
    private Long timeStamp;
}