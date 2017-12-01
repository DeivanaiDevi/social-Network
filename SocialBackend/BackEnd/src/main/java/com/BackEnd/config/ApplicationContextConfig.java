package com.BackEnd.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//import com.SocialNetworkBackEnd.Dao.BlogDao;
//import com.SocialNetworkBackEnd.Dao.BlogDaoImpl;
import com.BackEnd.DAO.UserDAO;
import com.BackEnd.DAO.UserDAOImpl;
//import com.SocialNetworkBackEnd.Model.Blog;
import com.BackEnd.Model.UserDetail;


@Configuration
@EnableTransactionManagement
@ComponentScan("com.SocialNetworkBackEnd.*")
@EnableWebMvc
public class ApplicationContextConfig 
{
	   //1.Creating a DataSource Object which is used for LocalSessionFactory
	    @Autowired
	    @Bean(name="Datasource")
		public DataSource getOracleDataSource()
		{
			DriverManagerDataSource driverManagerDataSource=new DriverManagerDataSource();
			driverManagerDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
			driverManagerDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
			driverManagerDataSource.setUsername("System");
			driverManagerDataSource.setPassword("A");
		//	System.out.println("1");
			return driverManagerDataSource;
		}
		
		//2.Creating Hibernate Properties which is used by LocalSessionFactory
	    @Autowired
	    @Bean(name="Properties")
		public Properties getHibernateProperties()
		{
			Properties properties=new Properties();
			properties.setProperty("hibernate.hbm2ddl.auto", "create");
			properties.put("hibernate.dialect","org.hibernate.dialect.Oracle11gDialect");
			return properties;
		}
		@Autowired
		@Bean(name="sessionFactory")
		public SessionFactory getSessionFactory()
		{
			LocalSessionFactoryBuilder localSessionFactoryBuilder=new LocalSessionFactoryBuilder(getOracleDataSource());
			localSessionFactoryBuilder.addProperties(getHibernateProperties());
			localSessionFactoryBuilder.addAnnotatedClass(UserDetail.class);
			System.out.println("SessionFactory Bean Created");
			return localSessionFactoryBuilder.buildSessionFactory();
		}
		@Autowired
		@Bean(name="TransactionManager")
		public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
		{
			return new HibernateTransactionManager(sessionFactory);
		}
		
		@Autowired
		@Bean(name="userdao")
		public UserDAO getUserDAO(SessionFactory sessionFactory)
		{
			System.out.println("User DAO Created");
			return new UserDAOImpl(sessionFactory);
		}
}