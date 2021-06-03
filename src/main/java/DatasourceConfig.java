

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatasourceConfig {
    @Bean
    public DataSource datasource() {
        return DataSourceBuilder.create()
          .driverClassName("org.postgresql.Driver")
          .url("postgres://uzohbqpbcolxlr:b284a2690413a7d19e7f952997ce7192b412a5d9b139828fb48e5d69e9d7dc2c@ec2-3-234-22-132.compute-1.amazonaws.com:5432/d2n3iml9tsqdev")
          .username("root")
          .password("root")
          .build();	

          
    }
}