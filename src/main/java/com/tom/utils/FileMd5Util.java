package com.tom.utils;

import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author Alfalfa99
 * @version 1.0
 * @date 2020/10/22 14:50
 * 获取图片MD5工具类
 */
@Component
public class FileMd5Util {

    /**
     *
     * @param image 上传的图片
     * @return 图片MD5的值
     */
    public static String getImageMd5(MultipartFile image) {
        try {
            return DigestUtils.md5DigestAsHex(image.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("MD5计算异常");
        }
    }
}
