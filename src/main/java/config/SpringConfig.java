package config;

import DAO.*;
import Service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * Created by Home on 12.09.2017.
 */
@Configuration
public class SpringConfig {
    @Bean
    public CustomerService getUserService() {
        return new CustomerServiceImpl();
    }

    @Bean
    public GoodsService getGoodsService() {
        return new GoodsServiceImpl();
    }

    @Bean
    public SalesService getSalesService() {
        return new SalesServiceImpl();
    }

    @Bean
    public CustomerDao getUserDaoImpl() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/demo?verifyServerCertificate=false&useSSL=true");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return new CustomerDaoImpl(dataSource);
    }

    @Bean
    public ItemDao getItemDaoImpl() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/demo?verifyServerCertificate=false&useSSL=true");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return new ItemDaoImpl(dataSource);
    }

    @Bean
    public SalesDao getSalesDaoImpl() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/demo?verifyServerCertificate=false&useSSL=true");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return new SalesDaoImpl(dataSource);
    }


}
