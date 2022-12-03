package np.com.suulaav.financemanager.controller.user;

import lombok.extern.slf4j.Slf4j;
import np.com.suulaav.financemanager.core.helper.response.RestResponse;
import np.com.suulaav.financemanager.service.api.user.UserCrudService;
import np.com.suulaav.financemanager.service.domain.user.UserDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sulav created on 11/21/22
 */
@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
  private final UserCrudService userCrudService;

  @Autowired
  public UserController(UserCrudService userCrudService) {
    this.userCrudService = userCrudService;
  }

  @PostMapping
  public String insert(UserDomain userDomain) {
    log.debug("Inside : User -> Insert");
    return userCrudService.insert(userDomain);
  }

  @PutMapping
  public String update(UserDomain userDomain) {
    log.debug("Inside : User -> Update");
    return userCrudService.update(userDomain);
  }

  @GetMapping("/search/id/{id}")
  public ResponseEntity findOne(@PathVariable("id") String id) {
    log.debug("Inside : User -> FindOne");
    return RestResponse.ok(userCrudService.findOne(id));
  }

  @GetMapping("/search/list")
  public ResponseEntity findAll() {
    log.debug("Inside : User -> FindAll");
    return RestResponse.ok(userCrudService.findAll());
  }

  @PostMapping("/search/list")
  public ResponseEntity findAllWithPagination(Pageable pageable) {
    log.debug("Inside : User -> FindAllWithPagination");
    return RestResponse.ok(userCrudService.findAllWithPagination(pageable));
  }
}