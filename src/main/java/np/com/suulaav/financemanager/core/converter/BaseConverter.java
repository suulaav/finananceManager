package np.com.suulaav.financemanager.core.converter;

import np.com.suulaav.financemanager.core.dao.entity.AbstractEntity;
import np.com.suulaav.financemanager.core.service.domain.AbstractDomain;

/**
 * @author Sulav created on 11/21/22
 */
public abstract class BaseConverter<E extends AbstractEntity, S extends AbstractDomain> {
  public BaseConverter() {}

  protected void toBaseEntity(E entity, S serviceObject) {
    entity.setActive(serviceObject.isActive());
    entity.setCreatedBy(serviceObject.getCreatedBy());
    entity.setCreatedOn(
        new java.sql.Date(
            Long.valueOf(
                serviceObject.getCreatedOn() != null
                    ? Long.valueOf(serviceObject.getCreatedOn())
                    : 0l)));
    entity.setLastModifiedBy(serviceObject.getLastModifiedBy());
    entity.setLastModifiedOn(
        new java.sql.Date(
            Long.valueOf(
                serviceObject.getLastModifiedOn() != null
                    ? Long.valueOf(serviceObject.getLastModifiedOn())
                    : 0l)));
    entity.setDeleted(serviceObject.isDeleted());
    entity.setDeletedBy(serviceObject.getDeletedBy());
    entity.setDeletedOn(
        new java.sql.Date(
            Long.valueOf(
                serviceObject.getDeletedOn() != null
                    ? Long.valueOf(serviceObject.getDeletedOn())
                    : 0l)));
    entity.setId(serviceObject.getId());
  }

  protected void toBaseDomain(E entity, S serviceObject) {
    serviceObject.setLastModifiedBy(entity.getLastModifiedBy());
    serviceObject.setCreatedBy(entity.getCreatedBy());
    serviceObject.setDeletedBy(entity.getDeletedBy());
    serviceObject.setDeleted(entity.isDeleted());
    serviceObject.setActive(entity.isActive());
    serviceObject.setId(entity.getId());
    serviceObject.setDeletedOn(
        entity.getDeletedOn() != null ? entity.getDeletedOn().toString() : null);
    serviceObject.setCreatedOn(
        entity.getCreatedOn() != null ? entity.getCreatedOn().toString() : null);
    serviceObject.setLastModifiedOn(
        entity.getLastModifiedOn() != null ? entity.getLastModifiedOn().toString() : null);
  }
}