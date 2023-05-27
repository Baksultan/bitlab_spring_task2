package com.example.spring_sprint2.controller;


import com.example.spring_sprint2.model.ApplicationRequest;
import com.example.spring_sprint2.services.AppReqServices;
import com.example.spring_sprint2.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequiredArgsConstructor
public class HomeController {

    private final AppReqServices appReqServices;
    private final CourseService courseService;

    @GetMapping(value = "/")
    public String indexPage(Model model) {
        model.addAttribute("requests", appReqServices.getAppRequests());
        return "index";
    }

    @GetMapping(value = "/unhandled-req")
    public String unhandledRequestsPage(Model model) {
        model.addAttribute("unhandledRequestsList", appReqServices.unhandledRequestsList());
        return "unhandled-req-page";
    }

    @GetMapping(value = "/handled-req")
    public String handledRequestsPage(Model model) {
        model.addAttribute("handledRequestsList", appReqServices.handledRequestsList());
        return "handled-req-page";
    }

    @GetMapping(value = "/details/{reqId}")
    public String requestDetails(@PathVariable(name = "reqId") Long id, Model model){

        model.addAttribute("req", appReqServices.getRequest(id));

        return "details";
    }

    @PostMapping(value = "/handling")
    public String requestHandling(@RequestParam("id") Long id) {
        appReqServices.changeStatus(id);
        return "redirect:/details/" + id;
    }

    @PostMapping(value = "/delete")
    public String deleteReq(@RequestParam("id") Long id) {
        appReqServices.deleteReq(id);
        return "redirect:/";
    }

    @GetMapping("/add-request")
    public String addReq(Model model) {

        model.addAttribute("courses", courseService.getCourses());

        return "add-req";
    }

    @PostMapping("/add-request")
    public String addReq(ApplicationRequest applicationRequest) {

        appReqServices.addAppRequest(applicationRequest);

        return "redirect:/";
    }


}
