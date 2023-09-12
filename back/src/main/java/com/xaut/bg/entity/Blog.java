package com.xaut.bg.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Blog {
    int id;
    int user_id;
    String title;
    String description;
    String content;
    @JsonFormat(pattern = "yyyy:MM:dd HH:mm:ss",timezone = "GMT+8:00")
    Date created;
    int status;

    public Blog(int id, int user_id, String title, String description, String content, Date created, int status) {
        this.id = id;
        this.user_id = user_id;
        this.title = title;
        this.description = description;
        this.content = content;
        this.created = created;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                ", created=" + created +
                ", status=" + status +
                '}';
    }
}
