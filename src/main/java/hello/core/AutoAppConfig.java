package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "hello.core", // 탐색할 패키지의 시작 위치 지정(Default: @ComponentScan이 있는 클래스의 패키지)
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class) // Scan을 제외할 클래스
)
public class AutoAppConfig {
}