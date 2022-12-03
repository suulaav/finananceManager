package np.com.suulaav.financemanager.core.usecase;

import np.com.suulaav.financemanager.core.converter.Converter;
import np.com.suulaav.financemanager.core.dao.entity.Entity;
import np.com.suulaav.financemanager.core.service.domain.Domain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.UUID;

/**
 * @author Sulav created on 11/21/22
 */
public abstract class AbstractAddUseCase {
  protected Converter entityConverter;
  protected Domain addRequest;
  private final JpaRepository<Entity, String> baseDao;

  protected AbstractAddUseCase(JpaRepository baseDao, Converter entityConverter) {
    this.entityConverter = entityConverter;
    this.baseDao = baseDao;
  }

  public String process(Domain domain) {
        domain.validate();
    this.addRequest = domain;
    this.validateIfAlreadyExists();
    this.prepareDomainForInsert();
    return completeInsert().getId();
  }

  private Entity completeInsert() {
    return baseDao.save(prepareEntity());
  }

  private void prepareDomainForInsert() {
    addRequest.setId(UUID.randomUUID().toString().replace("-", ""));
    addRequest.setActive(this.isActive());
    addRequest.setDeleted(false);
    addRequest.setCreatedBy(this.createdBy());
    addRequest.setLastModifiedBy(this.createdBy());
    addRequest.setCreatedOn(String.valueOf(new Date().getTime()));
    addRequest.setLastModifiedOn(String.valueOf(new Date().getTime()));
  }

  protected Entity prepareEntity() {
    return entityConverter.toEntity(this.addRequest);
  }

  protected abstract String createdBy();

  protected abstract boolean isActive();

  protected abstract void validateIfAlreadyExists();
}