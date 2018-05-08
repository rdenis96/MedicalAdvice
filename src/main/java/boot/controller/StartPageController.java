package boot.controller;

import boot.model.User;
import boot.service.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;


@Controller
public class StartPageController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String loadPage()
    {
        return "StartPage";
    }

    @RequestMapping(value = "loginValidation", method = RequestMethod.POST)
    @ResponseBody
    public int validateLogin(@ModelAttribute("username") String username,
                              @ModelAttribute("password") String password,
                             Model model)
    {
        User user = userService.getByUsernameAndPassword(username,password);
        if(user != null)
        {
            return HttpServletResponse.SC_OK;
        }
        return HttpServletResponse.SC_FORBIDDEN;
    }

    @RequestMapping(value = "registerValidation", method = RequestMethod.POST)
    @ResponseBody
    public  int validateRegister(@ModelAttribute("username") String username,
                                 @ModelAttribute("password") String password,
                                 @ModelAttribute("email") String email)
    {
        User user = userService.getByUsername(username);
        if(user != null)
            return HttpServletResponse.SC_FORBIDDEN;

        user = userService.getByEmail(email);
        if(user != null)
            return HttpServletResponse.SC_FORBIDDEN;

        userService.Add(user);
        return HttpServletResponse.SC_OK;
    }

}
