package com.BakEnd.Test;
import static org.junit.Assert.*;

import java.util.List;

import  org.junit .BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.BackEnd.Model.Blog;
import com.BackEnd.DAO.BlogDAO;

public class BlogDAOTest
{
	static BlogDAO blogDAO;
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.BackEnd.*");
		context.refresh();
		blogDAO(BlogDAO)context.getBean("blogDAO");
	}
	@Test
	public void addBlogTest()
	{
		Blog blog =new Blog();
		blog.setBlogName("Core Javs");
		blog.setBlogContent("It is based on simple java programming");
		blog .setUsername("Devi");
		blog.setStatus("A");
		blog.setCreationDate(new java .util.Date());
		assertTrue("Problem in Inserting Blog",blogDAO.addBlog(blog));
	}
	@Test
	public void getBlogTest()
	{
		Blog blog= blogDAO.getBlog(1002);
		assertNotNull("Blog Not Found",blog);
		System.out.println("Blog Name:"+blog.getBlogName+blog.getBlogName());
		System.out.println("Blog Context:"+blog.getBlogContent());
	}
	@Test
	
	public void getAllBlogTest()
	{
		List<Blog>blogList=(List<Blog>)blogDAO.getAllBlogs();
		assertNotNull("Blog List Not Found",blogList.get(0));
		for (Blog blog:blogList)
		{
			System.out.println("Blog ID:"+blogg.getBlogId()+"Blog Name:"+b);
			
		}
	}
	@Test
	public void deleteBlogTest()
	{
		Blog blog=(Blog)blogDAO.getBlog(1002);
		assertTrue("Problem in Deletion",blogDAO.deleteBlog(blog));
	}
	@Test
	public void updateBlogTest()
	{
		Blog blog=(Blog)blogDAO.getBlog(1002);
		blog.setBlogContent("OOPS Exception -Thread-IO-NIO-Localization");
		blog.setBlogNmae("Apple Java");
		asserttrue("problem in updating",blogDAO.updateBlog(blog));
	}
}
@Test
public void approveBlogTest()
{
	Blog blog=(Blog)blogDAO.getBlog(1002);
	asserttrue("problem in Approving",blogDAO.approvingBlog(blog));
	
}
}

