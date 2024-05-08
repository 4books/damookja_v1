package fourbooks.damookja.application.port.in.web.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Component
public class LogInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        log.info("[INTERCEPTOR PRE HANDLE] {}", requestURI);

        if(requestURI.endsWith("/error")) { //인터셉터 테스트 에러일 땐 어떻게 동작하는지 보기 위해서
            log.error("{} 가 호출됨!", request.getRequestURI());
            response.setStatus(HttpServletResponse.SC_FORBIDDEN); //권한 없음
            response.getWriter().write("Forbidden error!");
            response.getWriter().flush();
            response.getWriter().close();
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("[INTERCEPTOR POST HANDLE] {}", request.getRequestURI());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("[INTERCEPTOR AFTER COMPLETION] {}", request.getRequestURI());
    }
}
