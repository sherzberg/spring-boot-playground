package app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

import static net.logstash.logback.argument.StructuredArguments.entries;


@RestController
public class PingController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PingController.class);

    @Autowired
    private CalculationService calculationService;

    @RequestMapping("/ping")
    public String ping(@RequestHeader HttpHeaders headers, HttpServletRequest request) {

        Map logArgs = new HashMap();
        logArgs.put("action", "http_request");
        logArgs.put("http_request_route", request.getRequestURI());
        logArgs.put("http_request_method", request.getMethod());
        LOGGER.info("/ping called", entries(logArgs));

        calculationService.calculate();

        LOGGER.info("more data");
        return "pong";
    }

}
