package np.com.suulaav.financemanager.service.impl.user;

import np.com.suulaav.financemanager.dao.api.user.UserDao;
import np.com.suulaav.financemanager.dao.entity.user.UserEntityConverter;

import np.com.suulaav.financemanager.service.api.user.UserCrudService;
import np.com.suulaav.financemanager.service.domain.user.UserDomain;
import np.com.suulaav.financemanager.service.usecase.user.AddUserUseCase;
import np.com.suulaav.financemanager.service.usecase.user.UpdateUserUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Sulav created on 11/21/22
 */
@Service
public class UserServiceImpl implements UserCrudService {

  private final UserDao userDao;

  @Autowired
  public UserServiceImpl(UserDao userDao) {
    this.userDao = userDao;
  }

  @Override
  public String insert(UserDomain domain) {
    return new AddUserUseCase(userDao).process(domain);
  }

  @Override
  public String update(UserDomain domain) {
    return new UpdateUserUseCase(userDao).process(domain);
  }

  @Override
  public List<UserDomain> findAll() {
    return new UserEntityConverter().toDomainList(userDao.findAll());
  }

  @Override
  public UserDomain findOne(String id) {
    return new UserEntityConverter().toDomain(userDao.findById(id).get());
  }

  @Override
  public List<UserDomain> findAllWithPagination(Pageable page) {
    return new UserEntityConverter().toDomainList(userDao.findAll(page).get().toList());
  }
}