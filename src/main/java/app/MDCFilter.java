package app;


import org.slf4j.MDC;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@Component
@EnableAutoConfiguration
public class MDCFilter extends OncePerRequestFilter {

    public static final String APP_CORRELATION_ID = "app_correlation_id";

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        MDC.clear();

        String userAgent = request.getHeader("User-Agent");

        if (!StringUtils.isEmpty(userAgent)){
            MDC.put("request_user_agent", userAgent);
        }

        if (StringUtils.isEmpty(MDC.get(APP_CORRELATION_ID))) {
            MDC.put(APP_CORRELATION_ID, UUID.randomUUID().toString());
        }

        MDC.put("system_platform", System.getProperty("os.name"));

        doFilter(request, response, filterChain);
    }

}