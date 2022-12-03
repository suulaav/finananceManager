package np.com.suulaav.financemanager.dao.api.user;

import np.com.suulaav.financemanager.dao.entity.user.UserEntity;
import org.springframework.stereotype.Repository;

/**
 * @author Sulav created on 12/3/22
 */
@Repository
public interface CustomUserDao {
  UserEntity findBySomething(String id);
}