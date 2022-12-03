package np.com.suulaav.financemanager.core.usecase;

import np.com.suulaav.financemanager.core.converter.Converter;
import np.com.suulaav.financemanager.core.dao.entity.Entity;
import np.com.suulaav.financemanager.core.service.domain.Domain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

/**
 * @author Sulav created on 11/21/22
 */
public abstract class AbstractUpdateUseCase {
  protected Converter<Domain, Entity> entityConverter;
  protected Domain updateRequest;
  private final JpaRepository<Entity, String> baseDao;

  protected AbstractUpdateUseCase(JpaRepository baseDao, Converter entityConverter) {
    this.entityConverter = entityConverter;
    this.baseDao = baseDao;
  }

  public String process(Domain domain) {
    this.updateRequest = domain;
    Entity entity = this.validateIfExists();
    this.prepareDomainForUpdate();
    return baseDao.save(prepareEntity(entity)).getId();
  }

  private void prepareDomainForUpdate() {
    updateRequest.setActive(updateRequest.isActive());
    updateRequest.setDeleted(false);
    updateRequest.setLastModifiedBy(this.lastModifiedBy());
    updateRequest.setCreatedOn(String.valueOf(new Date().getTime()));
    updateRequest.setLastModifiedOn(String.valueOf(new Date().getTime()));
  }

  protected Entity prepareEntity(Entity oldEntity) {
    Entity entity = entityConverter.toEntity(this.updateRequest);
    entity.setId(oldEntity.getId());
    entity.setCreatedBy(oldEntity.getCreatedBy());
    entity.setCreatedOn(oldEntity.getCreatedOn());
    return entity;
  }

  protected abstract String lastModifiedBy();

  protected abstract Entity validateIfExists();
}