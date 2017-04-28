package com.murali.logistics.configuration;

import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.murali.logistics.entities.ProjectEntity;

import javax.sql.DataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.murali.logistics")
@EnableTransactionManagement  //Hibernate connection changes
public class MvcConfiguration extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Bean(name = "viewResolver")
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver irvr = new InternalResourceViewResolver();

		irvr.setPrefix("/WEB-INF/views/");
		irvr.setSuffix(".jsp");

		return irvr;
	}
	
	//Step 1: Creating Data Source
	@Bean(name="dataSource")
	public DataSource getDataSource() {
		
		BasicDataSource ds = new BasicDataSource();
		
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springtraining");
		ds.setUsername("root");
		ds.setPassword("root");
		
		return ds;
		
	}
	
	//Step 2: Creating Hibernate Properties
	
	public Properties getHibernateProperties() {
		Properties prop = new Properties();
		
		prop.put("hibernate.show_sql", "true");
		prop.put("hibernate.hbm2ddl.auto", "update");
		prop.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		
		
		return prop;
	}
	
	//Step 3: Creating Session Factory
	
	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		
		LocalSessionFactoryBuilder lsfb = new LocalSessionFactoryBuilder(dataSource);
		
		lsfb.addProperties(getHibernateProperties());
		lsfb.addAnnotatedClasses(ProjectEntity.class);
		
		SessionFactory sf = lsfb.buildSessionFactory();
		
		return sf;
	}
	
	//Step 4: Creating Hibernate Transaction manager
	
	@Autowired
	@Bean//(name="transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		
		HibernateTransactionManager htm = new HibernateTransactionManager(sessionFactory);
		
		return htm;
		
	}

}
