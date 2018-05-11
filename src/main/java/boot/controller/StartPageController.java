package boot.controller;

import boot.model.User;
import boot.service.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "loginValidation", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public int validateLogin(@RequestParam("username") String username,
                              @RequestParam("password") String password)
    {

        System.out.println("USERU BA! " + username + "--" + password + "--");
        User user = userService.getByUsernameAndPassword(username,password);
        if(user != null)
        {
            return 1;
        }
        return 0;
    }

    @RequestMapping(value = "registerValidation", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public  int validateRegister(@ModelAttribute("username") String username,
                                 @ModelAttribute("password") String password,
                                 @ModelAttribute("email") String email)
    {
        System.out.println("USERU BA! " + username + "--" + password + "--" + email);
        User user = userService.getByUsername(username);
        if(user != null)
            return 0;

        user = userService.getByEmail(email);
        if(user != null)
            return 0;

        user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setPrivilege(0);
        user.setEmail(email);
        userService.Add(user);
        return 1;
    }

}
