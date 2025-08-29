package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogTestController {

    //    private final Logger log = LoggerFactory.getLogger(LogTestController.class); // 또는 이렇게
    //    private final Logger log = LoggerFactory.getLogger(getClass()); // @Sl4fj를 추가하면 이 코드가 없어도 log 사용 가능

    @RequestMapping("log-test")
    public String logTest() {
        String name = "Spring";

        System.out.println("name = " + name);

        // 아래로 갈수록 로그 레벨↑
        log.trace("trace log={}", name);
        log.debug("debug log{}", name); // 개발 서버
        log.info("info log={}", name); // 운영 서버
        log.debug("warn log{}", name);
        log.debug("error log{}", name);

        // + 대신 ,로 해야 하는 이유
        log.trace("trace my log=" + name); // 하면 안됨
        // trace log{}, name 이나 trace log + name 이나 둘 다 문자를 더함
        // 1. +를 쓰면 문자를 더하는 연산은 하지만 출력만 X
        // 2. ,를 쓰면 더하는 연산 자체를 수행하지 않고 출력도 X

        return "ok";
    }
}
