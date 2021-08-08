package com.tom.utils;

import com.tom.entity.bean.Image;
import com.tom.exception.BasicException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author Alfalfa99
 * @version 1.0
 * @date 2020/10/22 15:13
 * 图片上传工具类
 */
@ConfigurationProperties("image.config")
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageUploadUtil {
    private List<String> type;
    private String path;

    /**
     * 检查图片类型是否符合要求
     *
     * @param imageType 文件后缀名
     * @return 是否符合
     */
    private Boolean checkImageType(String imageType) {
        return type.contains(imageType);
    }

    public Image uploadImage(MultipartFile image) {
        // 获得文件后缀名
        String imageName = image.getContentType();
        // 获得文件后缀名称
        if (imageName == null) {
            throw new BasicException("文件有误！");
        }
        String md5 = FileMd5Util.getImageMd5(image);
        String imageType = imageName.substring(imageName.indexOf("/") + 1);
        if (!checkImageType(imageType)) {
            throw new BasicException("文件类型有误");
        }
        //动态获取服务器路径
        String uri = System.getProperty("user.dir");
        //使用md5和文件类型组成新的文件名
        String fileName = md5 + "." + imageType;
        //获取相对路径
        String relatePath = path + DateTimeTransferUtil.helpCreateFolds() + fileName;
        //将获取的服务器路径 + 路径 + 年 + 月 + 文件名 拼接
        String realPath = uri + relatePath;
        //创建返回体
        Image imageEntity = new Image(relatePath, DateTimeTransferUtil.getNowTimeStamp());
        // 如果目录不存在则创建目录
        File imageFile = new File(realPath);
        if (!imageFile.exists()) {
            if (!imageFile.mkdirs()) {
                throw new BasicException("新建目标文件夹失败！");
            }
        }
        //保存文件到指定目录
        try {
            image.transferTo(imageFile);
        } catch (IOException e) {
            throw new BasicException("保存文件时出错！");
        }
        return imageEntity;
    }
}