package np.com.suulaav.financemanager.dao.api.user;

import np.com.suulaav.financemanager.dao.api.user.CustomUserDao;
import np.com.suulaav.financemanager.dao.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Sulav created on 11/21/22
 */
@Repository
public interface UserDao extends JpaRepository<UserEntity, String>, CustomUserDao {
  boolean existsUserEntityByEmailContainsIgnoreCase(String email);

  UserEntity findByEmailContainsIgnoreCase(String email);
}