package np.com.suulaav.financemanager.service.api.user;


import np.com.suulaav.financemanager.core.service.api.BaseCrudService;
import np.com.suulaav.financemanager.dao.entity.user.UserEntity;
import np.com.suulaav.financemanager.service.domain.user.UserDomain;

/**
 * @author Sulav created on 11/21/22
 */
public interface UserCrudService extends BaseCrudService<UserEntity, UserDomain> {}