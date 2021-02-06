package com.example.flightsercher.controller;

import com.example.flightsercher.Model.Passenger;
import com.example.flightsercher.Service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class PassengerController {

    @Autowired
    private PassengerService passengerService;


    @RequestMapping(value={"/login"}, method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value="/registration", method = RequestMethod.GET)
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        Passenger passenger = new Passenger();
        modelAndView.addObject("user", passenger);
        modelAndView.setViewName("registration");
        return modelAndView;
    }
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewPassenger(@Valid Passenger user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        Passenger passengerExists = passengerService.findPassengerByEmail(user.getEmail());
        if (passengerExists != null) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "There is already a user registered with the email provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {
            passengerService.saveUser(user);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new Passenger());
            modelAndView.setViewName("registration");
        }
        return modelAndView;
    }
    @RequestMapping(value="/admin/adminHome", method = RequestMethod.GET)
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Passenger passenger = passengerService.findPassengerByEmail(auth.getName());
        modelAndView.addObject("userName", "Welcome " + passenger.getName() + " " + passenger.getLastName() + " (" + passenger.getEmail() + ")");
        modelAndView.addObject("adminMessage","This Page is available to Users with Admin Role");
        modelAndView.setViewName("admin/adminHome");
        return modelAndView;
    }
    @RequestMapping(value="/user/userHome", method = RequestMethod.GET)
    public ModelAndView passenger(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Passenger passenger = passengerService.findPassengerByEmail(auth.getName());
        modelAndView.addObject("passengerName", "Welcome " + passenger.getName() + " " + passenger.getLastName() + " (" + passenger.getEmail() + ")");
        modelAndView.addObject("passengerMessage","This Page is available to Passenger with User Role");
        modelAndView.setViewName("passenger/passengerHome");
        return modelAndView;
    }
}
