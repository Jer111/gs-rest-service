@Configuration
public class DatasourceConfig {
    @Bean
    public DataSource datasource() {
        return DataSourceBuilder.create()
          .driverClassName("org.postgresql.Driver")
          .url("jdbc:postgres://ixqalgeogichke:51cb309c63c536fe8e2774e210c9fbd5a91cd14db8e24e4f61890243a6102495@ec2-34-232-191-133.compute-1.amazonaws.com:5432/d9grch13herp6n")
          .username("")
          .password("")
          .build();	
    }
}