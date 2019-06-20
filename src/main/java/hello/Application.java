package hello;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import hello.storage.StorageProperties;
import hello.storage.StorageService;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  // Spring boot 提供 CommandLineRunner 在项目启动后加载一些内容
  @Bean
  CommandLineRunner init(StorageService storageService) {
    return (args) -> { // lambda 表达式
      storageService.deleteAll();
      storageService.init();
    };
  }
}