package spring.membership.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//@Controller
public class SpringController
{

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello~");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("data") String data, Model model) {
        model.addAttribute("data", data);
        return "hello";
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("data") String data){
        Hello hello = new Hello();
        hello.setName(data);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
