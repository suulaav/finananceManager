package np.com.suulaav.financemanager.service.domain.user;

import lombok.Data;
import np.com.suulaav.financemanager.core.helper.string.StringUtils;
import np.com.suulaav.financemanager.core.service.domain.AbstractDomain;

/**
 * @author Sulav created on 11/21/22
 */
@Data
public class UserDomain extends AbstractDomain {
  private String fullName;
  private String email;
  private String phoneNumber;
  private String address;
  private String password;
  private String roles;

  @Override
  public void validate() {
    if (StringUtils.isBlankOrNull(fullName)) {
      throw new RuntimeException("Name is Empty");
    }
    if (StringUtils.isBlankOrNull(email)) {
      throw new RuntimeException("Email is Empty");
    }
    if (StringUtils.isBlankOrNull(phoneNumber)) {
      throw new RuntimeException("Phone Number is Empty");
    }
    if (StringUtils.isBlankOrNull(address)) {
      throw new RuntimeException("address is Empty");
    }
    if (StringUtils.isBlankOrNull(password)) {
      throw new RuntimeException("Password is Empty");
    }
    if (StringUtils.isBlankOrNull(roles)) {
      throw new RuntimeException("Roles is Empty");
    }
  }
}