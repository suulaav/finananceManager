package np.com.suulaav.financemanager.dao.impl.user;

import lombok.extern.slf4j.Slf4j;
import np.com.suulaav.financemanager.dao.api.user.CustomUserDao;
import np.com.suulaav.financemanager.dao.entity.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@Slf4j
public class UserDaoImpl implements CustomUserDao {
  @Autowired EntityManager em;

  @Override
  public UserEntity findBySomething(String id) {
    UserEntity userEntity = new UserEntity();
    userEntity.setId(id);
    log.debug("inside custom user dao");
    return (UserEntity) em.find(UserEntity.class, id);
  }
}