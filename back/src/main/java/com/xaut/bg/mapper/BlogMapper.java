package com.xaut.bg.mapper;

import com.xaut.bg.entity.Blog;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface BlogMapper {
    @Select("select * from m_blog")
    public List<Blog> findAllBlogs();

    @Select("select * from m_blog where id=#{id}")
    public Blog findBlogById(int id);

    @Insert("insert into m_blog(id,user_id,title,description,content,created,status) values(#{id},#{user_id},#{title},#{description},#{content},#{created},#{status});")
    public void addBlog(Blog blog);

    @Update("update m_blog set description=#{description},content=#{content} where id = #{id}")
    public void updateBlog(Blog blog);

    @Delete("delete from m_blog where id=#{id}")
    public void deleteBlog(int id);
}
