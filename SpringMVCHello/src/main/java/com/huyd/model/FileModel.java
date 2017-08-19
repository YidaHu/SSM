package com.huyd.model;

import org.springframework.web.multipart.MultipartFile;

/**
 * Author: huyd
 * Date: 2017/8/17 20:40
 * Description:
 */
public class FileModel {
    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}