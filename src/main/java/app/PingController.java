package app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PingController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PingController.class);

    @RequestMapping("/ping")
    public String ping(@RequestHeader HttpHeaders headers) {

        String userAgent = headers.get(HttpHeaders.USER_AGENT).get(0);
        String token = headers.get("Token").get(0);

        LOGGER.info("/ping was called. user_agent[" + userAgent + "] token[" + token + "]");


        LOGGER.info("more data");
        return "pong";
    }

}
