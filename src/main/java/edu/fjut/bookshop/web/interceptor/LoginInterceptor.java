package edu.fjut.bookshop.web.interceptor;

import edu.fjut.bookshop.common.BookShopConst;
import edu.fjut.bookshop.domain.Admin;
import edu.fjut.bookshop.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by qyw on 2017/6/21
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
      /*  Admin admin = (Admin) request.getSession().getAttribute(BookShopConst.CURRENT_ADMIN);
         User user= (User) request.getSession().getAttribute(BookShopConst.CURRENT_USER);
        String uri = request.getRequestURI();
        if(admin==null && user==null && !"/".equals(uri) && !"/admin".equals(uri) && !"/portal/user/login".equals(uri) && ! "/portal/user/register".equals(uri) && !"/backend/admin/login".equals(uri)){
            String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
            if(uri.indexOf("portal")>0){
                response.sendRedirect(basePath+"/");
            }
            if(uri.indexOf("admin")>0 || uri.indexOf("backend")>0){

                response.sendRedirect(basePath+"/admin");
            }

            return false;
        }*/
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
