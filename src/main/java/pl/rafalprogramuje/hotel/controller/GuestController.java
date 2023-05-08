package pl.rafalprogramuje.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.rafalprogramuje.hotel.entity.Guest;
import pl.rafalprogramuje.hotel.repository.GuestRepository;
import pl.rafalprogramuje.hotel.repository.RoomRepository;

import java.util.List;

@Controller
public class GuestController {

    @Autowired
    private GuestRepository repo;

    @GetMapping("/showGuests")
    public ModelAndView showGuests() {
        ModelAndView mav = new ModelAndView("list-guests");
        List<Guest> guests = repo.findAll();
        mav.addObject("guests", guests);
        return mav;

    }


}