package app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import static net.logstash.logback.argument.StructuredArguments.*;

@Component
public class CalculationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CalculationService.class);

    public void calculate() {
        Instant start = Instant.now();
        try {
            Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);

        Map logArgs = new HashMap();
        logArgs.put("calculation_time", timeElapsed.toMillis());
        logArgs.put("class", CalculationService.class);
        logArgs.put("method", "calculate");

        LOGGER.info("CalculationService {}", entries(logArgs));

        LOGGER.info("calculation processing took: " + String.valueOf(timeElapsed.toMillis()));
    }

}
