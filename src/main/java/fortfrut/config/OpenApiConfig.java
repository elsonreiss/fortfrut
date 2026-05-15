package fortfrut.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customApi(){
        return new OpenAPI().info(new Info()
                .title("FortFrut System organization")
                .version("0.1 ")
                .description("Fruit stand management system"));

    }
}
