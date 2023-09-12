package com.xaut.bg.entity;

import java.util.List;

public class BlogInfo {
    private List<Blog> blogs;
    private int currentPage;

    private int total;

    private int pageSize;


    public BlogInfo(List<Blog> blogs, int currentPage, int total, int pageSize) {
        this.blogs = blogs;
        this.currentPage = currentPage;
        this.total = total;
        this.pageSize = pageSize;
    }

    public BlogInfo()
    {

    }
    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "BlogInfo{" +
                "blogs=" + blogs +
                ", currentPage=" + currentPage +
                ", total=" + total +
                ", pageSize=" + pageSize +
                '}';
    }
}
