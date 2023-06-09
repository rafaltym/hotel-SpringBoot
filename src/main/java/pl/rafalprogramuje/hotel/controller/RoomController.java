package pl.rafalprogramuje.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.rafalprogramuje.hotel.entity.Room;
import pl.rafalprogramuje.hotel.repository.RoomRepository;

import java.util.List;

@Controller
public class RoomController {
    @Autowired
    private RoomRepository repo;

    @GetMapping({"/showRooms"})
    public ModelAndView showRooms() {
        ModelAndView mav = new ModelAndView("list-rooms");
        List<Room> rooms = repo.findAll();
        mav.addObject("rooms", rooms);
        return mav;
    }

    @GetMapping("/addRoomForm")
    public ModelAndView addRoomForm() {
        ModelAndView mav = new ModelAndView("add-room-form");
        Room newRoom = new Room();
        mav.addObject("room", newRoom);
        return mav;
    }

    @PostMapping("/saveRoom")
    public String saveRoom(@ModelAttribute Room room) {
        repo.save(room);
        return "redirect:/showRooms";
    }

    @GetMapping("/showRoomUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam Long roomId) {
        ModelAndView mav = new ModelAndView("add-room-form");
        Room room = repo.findById(roomId).get();
        mav.addObject("room", room);
        return mav;

    }

    @GetMapping("/deleteRoom")
    public String deleteRoom(@RequestParam Long roomId) {
        repo.deleteById(roomId);
        return "redirect:/showRooms";
    }

}
