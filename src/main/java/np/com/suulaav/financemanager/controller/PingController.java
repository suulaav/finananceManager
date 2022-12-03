package np.com.suulaav.financemanager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sulav created on 12/2/22
 */
@RestController
@RequestMapping(value = "/ping")
public class PingController {
  @GetMapping
  public String ping() {
    return "success";
  }
}