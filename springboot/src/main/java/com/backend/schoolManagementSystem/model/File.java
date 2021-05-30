package com.backend.schoolManagementSystem.model;

public class File {
    String fileName;
    String downloadUrl;
    String contentType;
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public String getDownloadUrl() {
        return downloadUrl;
    }
    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }
    public String getContentType() {
        return contentType;
    }
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
    public File(String fileName, String downloadUrl, String contentType) {
        this.fileName = fileName;
        this.downloadUrl = downloadUrl;
        this.contentType = contentType;
    }
    
    
}
