package fourbooks.damookja.domain.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class LogFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("=== LogFilter init ===");
    }

    @Override
    public void destroy() {
        log.info("=== LogFilter destroy ===");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("=== LogFilter doFilter ===");

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String requestURI = request.getRequestURI();

        try {
            log.info("[REQUEST] {}", requestURI);
        } finally {
            log.info("[RESPONSE] {}", requestURI);
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
