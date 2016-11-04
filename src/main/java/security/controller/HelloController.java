package security.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @RequestMapping(value = { "/", "/welcome" }, method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView welcome() {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Welcome - Spring Security Hello World");
        model.addObject("message", "This is welcome page!");
        model.setViewName("hello");
        return model;

    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView admin() {
        ModelAndView model = new ModelAndView();
        model.addObject("title", "Admin - Spring Security Hello World");
        model.addObject("message", "This is protected page!");
        model.setViewName("admin");

        return model;
    }

    //新增加的Action方法，映射到
    // 1. /login 登录页面的常规显示
    // 2. /login?error 登录验证失败的展示
    // 3. /login?logout 注销登录的处理
    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView login(
            @RequestParam(value = "msg", required = false) String msg) {

        ModelAndView model = new ModelAndView();
        if (msg != null && "error".equals(msg)) {
            model.addObject("error", "Invalid username and password!");
        }

        if (msg != null && "logout".equals(msg)) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        model.setViewName("login");

        return model;

    }


    // for 403 access denied page
    @RequestMapping(value = "/403", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView accesssDenied() {

        ModelAndView model = new ModelAndView();

        // check if user is login
        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            model.addObject("username", userDetail.getUsername());
        }

        model.setViewName("comm/403");
        return model;

    }

}

