package np.com.suulaav.financemanager.core.dao.entity;

/**
 * @author Sulav created on 12/3/22
 */
public interface Entity {
  public String getId();

  public void setId(String id);

  public java.sql.Date getCreatedOn();

  public void setCreatedOn(java.sql.Date createdOn);

  public String getCreatedBy();

  public void setCreatedBy(String createdBy);

  public java.sql.Date  getLastModifiedOn();

  public void setLastModifiedOn(java.sql.Date lastModifiedOn);

  public String getLastModifiedBy();

  public void setLastModifiedBy(String lastModifiedBy);

  public java.sql.Date  getDeletedOn();

  public void setDeletedOn(java.sql.Date deletedOn);

  public String getDeletedBy();

  public void setDeletedBy(String deletedBy);

  public boolean isActive();

  public void setActive(boolean active);

  public boolean isDeleted();

  public void setDeleted(boolean deleted);
}