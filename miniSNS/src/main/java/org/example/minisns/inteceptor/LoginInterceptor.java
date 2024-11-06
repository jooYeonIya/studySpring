package org.example.minisns.inteceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.example.minisns.user.session.SessionConst;
import org.example.minisns.user.session.UserSession;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    HttpSession session = request.getSession();
    if (session != null) {
      Object attribute = session.getAttribute(SessionConst.USER_SESSION);
      if (attribute != null || attribute instanceof UserSession) {
        UserSession userSession = (UserSession) attribute;
        log.info("userSession => {}", userSession);
        return true;
      }
    }
    response.sendRedirect(request.getContextPath() + "/login?redirectURI=" + request.getRequestURI());
    return false;
  }
}
