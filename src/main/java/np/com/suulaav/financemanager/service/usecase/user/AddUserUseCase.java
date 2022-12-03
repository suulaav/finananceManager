package np.com.suulaav.financemanager.service.usecase.user;

import np.com.suulaav.financemanager.core.helper.string.StringUtils;
import np.com.suulaav.financemanager.core.usecase.AbstractAddUseCase;
import np.com.suulaav.financemanager.dao.api.user.UserDao;
import np.com.suulaav.financemanager.dao.entity.user.UserEntityConverter;
import np.com.suulaav.financemanager.service.domain.user.UserDomain;

/**
 * @author Sulav created on 11/21/22
 */
public class AddUserUseCase extends AbstractAddUseCase {
  private final UserDao userDao;
  private UserDomain userDomain;

  public AddUserUseCase(UserDao userDao) {
    super(userDao, new UserEntityConverter());
    this.userDao = userDao;
  }

  @Override
  protected String createdBy() {
    return "SYSTEM";
  }

  @Override
  protected boolean isActive() {
    return true;
  }

  @Override
  protected void validateIfAlreadyExists() {
    this.userDomain = (UserDomain) this.addRequest;
    String email = this.userDomain.getEmail();
    if (StringUtils.isBlankOrNull(email)) {
      throw new RuntimeException("Email is Empty");
    }
    var userEntities = userDao.existsUserEntityByEmailContainsIgnoreCase(email);
    if (userEntities) {
      throw new RuntimeException("already exists");
    }
  }
}