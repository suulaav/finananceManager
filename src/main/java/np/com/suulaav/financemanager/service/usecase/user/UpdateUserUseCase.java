package np.com.suulaav.financemanager.service.usecase.user;

import np.com.suulaav.financemanager.core.helper.string.StringUtils;
import np.com.suulaav.financemanager.core.usecase.AbstractUpdateUseCase;
import np.com.suulaav.financemanager.dao.api.user.UserDao;
import np.com.suulaav.financemanager.dao.entity.user.UserEntity;
import np.com.suulaav.financemanager.dao.entity.user.UserEntityConverter;
import np.com.suulaav.financemanager.service.domain.user.UserDomain;

/**
 * @author Sulav created on 12/3/22
 */
public class UpdateUserUseCase extends AbstractUpdateUseCase {
  private final UserDao userDao;
  private UserDomain userDomain;

  public UpdateUserUseCase(UserDao userDao) {
    super(userDao, new UserEntityConverter());
    this.userDao = userDao;
  }

  @Override
  protected String lastModifiedBy() {
    return "SYSTEM";
  }

  @Override
  protected UserEntity validateIfExists() {
    this.userDomain = (UserDomain) this.updateRequest;
    String email = this.userDomain.getEmail();
    if (StringUtils.isBlankOrNull(email)) {
      throw new RuntimeException("Email is Empty");
    }
    UserEntity userEntity = userDao.findByEmailContainsIgnoreCase(email);
    if (userEntity == null) {
      throw new RuntimeException("User doesn't exist");
    }
    return userEntity;
  }
}