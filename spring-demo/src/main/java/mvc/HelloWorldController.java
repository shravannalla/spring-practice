package mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

    //need a controller method to show the initial show form
    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }
    //need controller method t process html form
}
