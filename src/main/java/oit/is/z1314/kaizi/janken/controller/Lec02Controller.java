package oit.is.z1314.kaizi.janken.controller;

import java.util.ArrayList;

import java.security.Principal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.method.annotation.ModelAndViewMethodReturnValueHandler;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import oit.is.z1314.kaizi.janken.model.Janken;
import oit.is.z1314.kaizi.janken.model.Entry;
import oit.is.z1314.kaizi.janken.model.User;
import oit.is.z1314.kaizi.janken.model.UserMapper;

@Controller
@RequestMapping("/lec02")
public class Lec02Controller {
  @Autowired
  private Entry room;
  @Autowired
  UserMapper userMapper;

  /**
   *
   * @param model
   * @param prin
   * @return
   */
  // @GetMapping
  // public String lec02(ModelMap model, Principal prin) {
  // String loginUser = prin.getName();
  // this.room.addUser(loginUser);
  // model.addAttribute("room", this.room);
  // model.addAttribute("login_user", loginUser);
  // return "lec02.html";
  // }

  // @GetMapping
  // public String lec02Di() {
  // return "lec02.html";
  // }

  /**
   *
   * @param Hand
   * @param model
   * @return
   */
  @GetMapping("/{Hand}")
  public String result(@PathVariable String Hand, ModelMap model) {
    Janken janken = new Janken();
    String result = janken.judge(Hand);
    model.addAttribute("result", result);
    model.addAttribute("YourHand", janken.ChangeStr(Hand));
    model.addAttribute("CPUHand", "グー");
    return "lec02.html";
  }

  @GetMapping
  public String sample52(ModelMap model, Principal prin) {
    String loginUser = prin.getName();
    ArrayList<User> users = userMapper.selectAllUser();
    model.addAttribute("users", users);
    model.addAttribute("login_user", loginUser);
    return "lec02.html";
  }
}
