package com.xaut.bg.controller;

import com.xaut.bg.entity.Blog;
import com.xaut.bg.entity.BlogInfo;
import com.xaut.bg.entity.User;
import com.xaut.bg.mapper.BlogMapper;
import com.xaut.bg.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;


@RestController
@CrossOrigin
public class BlogController {
    int pageSize = 5;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BlogMapper blogMapper;

    @GetMapping("/users")
    public List query(){
        List<User> users = userMapper.find();
        System.out.println(users);
        return users;
    }

    @GetMapping("/test")
    public void Test()
    {
        System.out.println(TimeZone.getDefault());
    }
    @PostMapping("/blog/edit")
    public void addBlog(@RequestBody Blog blog)
    {
        Date day = new Date();

        blog.setCreated(day);
        blog.setUser_id(1);
        blog.setStatus(1);

        blogMapper.addBlog(blog);
    }

    @GetMapping("/blog/all")
    @Transactional
    public BlogInfo findAllBlogs()
    {
        BlogInfo blogInfo = new BlogInfo();
        List<Blog> blogs = blogMapper.findAllBlogs();
        Collections.reverse(blogs);

        int len = blogs.size();
        int currentPage = 1;
        int pageSize = 5;
        int total = len / pageSize + 1;

        System.out.println("------------->"+ total + "<---------------");
        blogInfo.setBlogs(blogs);
        blogInfo.setCurrentPage(currentPage);
        blogInfo.setPageSize(pageSize);
        blogInfo.setTotal(total);


        return blogInfo;
    }

    @GetMapping("/blog/page")
    public BlogInfo findBlogsByPage(@RequestParam int currentPage)
    {
        BlogInfo blogInfo = new BlogInfo();
        List<Blog> blogs = blogMapper.findAllBlogs();

        // 反转链表
        Collections.reverse(blogs);

        int len = blogs.size() - 1;
        int start = (currentPage - 1) * pageSize;
        int end = ((start + pageSize - 1) > len) ? len : (start + pageSize - 1);

        blogInfo.setCurrentPage(currentPage);
        blogInfo.setTotal(len + 1);
        blogInfo.setPageSize(5);
        blogInfo.setBlogs(blogs.subList(start,end + 1));

        return blogInfo;
    }

    @GetMapping("/blog/id")
    public Blog findBlogById(@RequestParam("id") int id)
    {
        return blogMapper.findBlogById(id);
    }


    @PostMapping("/blog/update")
    public void updateBlog(@RequestBody Blog blog)
    {
        blogMapper.updateBlog(blog);
    }

    @GetMapping("/blog/delete")
    public void deleteBlog(@RequestParam int id)
    {
        System.out.println("-------------------->ID:"+id+"<------delete Blog ");
        blogMapper.deleteBlog(id);
    }
}
