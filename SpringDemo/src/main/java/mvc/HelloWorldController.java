package mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

    //need a controller method to show the initial show form
    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }
    //need controller method to process html form
    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

    //new controller method to read form data and
    //add data to model
    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model){
        //read the request parameter from html form
        String theName=request.getParameter("studentName");
        //convert the data to all caps
        theName=theName.toUpperCase();
        //create message
        String result="Yo!"+theName;
        //add message to mddel
        model.addAttribute("message", result);

        return "helloworld";
    }

    @RequestMapping("/processFormVersionThree")
    public String processFormVersionThree(
            @RequestParam("studentName") String theName,
            Model model){
        //convert the data to all caps
        theName=theName.toUpperCase();
        //create message
        String result="Hey from v3! "+theName;
        //add message to mddel
        model.addAttribute("message", result);

        return "helloworld";
    }
}
