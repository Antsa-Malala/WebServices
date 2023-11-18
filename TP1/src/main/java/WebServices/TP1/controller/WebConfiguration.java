package WebServices.TP1.controller;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import WebServices.TP1.model.Intercepteur;

@Configuration
public class WebConfiguration implements WebMvcConfigurer{


    private final Intercepteur interceptor;

    public WebConfiguration(Intercepteur interceptor) {
        this.interceptor = interceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor);
    }

}
