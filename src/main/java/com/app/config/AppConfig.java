package com.app.config;


import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.format.FormatterRegistry;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.app.converter.UserIdToConverter;
import com.app.model.Customer;
import com.app.model.Item;
import com.app.model.OrderMethod;
import com.app.model.ShipmentType;
import com.app.model.Uom;
import com.app.model.Vendor;
import com.app.model.WhUserType;

@EnableWebMvc
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages="com.app")
@PropertySource("classpath:app.properties")
public class AppConfig  implements WebMvcConfigurer{
	
	@Autowired
	private Environment env;
	
	@Autowired
	private UserIdToConverter userConverter;
	
	//1.DataSource Bean
	@Bean
	public BasicDataSource dsObj() {
		BasicDataSource ds=new BasicDataSource();
		
		ds.setDriverClassName(env.getProperty("driver"));
		ds.setUrl(env.getProperty("url"));
		ds.setUsername(env.getProperty("uname"));
		ds.setPassword(env.getProperty("pwd"));
		
		ds.setInitialSize(5);
		ds.setMaxIdle(5);
		ds.setMinIdle(3);
		ds.setMaxTotal(5);
		
		return ds;
	}
	
	//2. SessionFactory Bean
	@Bean
	public LocalSessionFactoryBean sfObj() {
		LocalSessionFactoryBean sf=new LocalSessionFactoryBean();
		
		sf.setDataSource(dsObj());
		sf.setAnnotatedClasses(Uom.class,OrderMethod.class,ShipmentType.class,WhUserType.class,Item.class,Vendor.class,Customer.class);
		sf.setHibernateProperties(props());
		
		return sf;
	}
	private Properties props() {
		
		Properties p=new Properties();
		p.put("hibernate.dialect", env.getProperty("dialect"));
		p.put("hibernate.show_sql", env.getProperty("showsql"));
		p.put("hibernate.format_sql", env.getProperty("fmtsql"));
		p.put("hibernate.hbm2ddl.auto", env.getProperty("ddlauto"));
		
		return p;
		
	}
	
	//3.HibernateTemplate Bean
	@Bean
	public HibernateTemplate htObj() {
		HibernateTemplate ht=new HibernateTemplate();
		ht.setSessionFactory(sfObj().getObject());
		return ht;
	}
	
	//4.HibernateTransaction Manager Bean
	@Bean
	public HibernateTransactionManager htxm() {
		
		HibernateTransactionManager htxm=new HibernateTransactionManager();
		htxm.setSessionFactory(sfObj().getObject());
		
		return htxm;
	}
	
	//5. InternalResourceViewResolver
	@Bean
	public ViewResolver vr() {
		InternalResourceViewResolver ivr=new InternalResourceViewResolver();
		ivr.setPrefix(env.getProperty("mvc.prefix"));
		ivr.setSuffix(env.getProperty("mvc.suffix"));
		return ivr;
	}
	
	public void addFormatters(FormatterRegistry registry) {
		
		registry.addConverter(userConverter);
	}
	

}
