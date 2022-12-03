package np.com.suulaav.financemanager.dao.entity.user;

import np.com.suulaav.financemanager.core.converter.BaseConverter;
import np.com.suulaav.financemanager.core.converter.Converter;
import np.com.suulaav.financemanager.dao.entity.user.UserEntity;
import np.com.suulaav.financemanager.service.domain.user.UserDomain;

/**
 * @author Sulav created on 11/21/22
 */
public class UserEntityConverter extends BaseConverter<UserEntity, UserDomain>
    implements Converter<UserDomain, UserEntity> {
  @Override
  public UserDomain toDomain(UserEntity entity) {
    UserDomain domain = new UserDomain();
    domain.setFullName(entity.getFullName());
    domain.setAddress(entity.getAddress());
    domain.setEmail(entity.getEmail());
    domain.setPassword(entity.getPassword());
    domain.setPhoneNumber(entity.getPhoneNumber());
    domain.setRoles(entity.getRoles());
    this.toBaseDomain(entity, domain);
    return domain;
  }

  @Override
  public UserEntity toEntity(UserDomain domain){
    UserEntity entity = new UserEntity();
    entity.setFullName(domain.getFullName());
    entity.setAddress(domain.getAddress());
    entity.setEmail(domain.getEmail());
    entity.setPassword(domain.getPassword());
    entity.setPhoneNumber(domain.getPhoneNumber());
    entity.setRoles(domain.getRoles());
    this.toBaseEntity(entity, domain);
    return entity;
  }
}