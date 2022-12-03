package np.com.suulaav.financemanager.core.service.domain;

/**
 * @author Sulav created on 12/3/22
 */
public interface Domain {
  public String getId();

  public void setId(String id);

  public String getCreatedOn();

  public void setCreatedOn(String createdOn);

  public String getLastModifiedOn();

  public void setLastModifiedOn(String lastModifiedOn);

  public String getCreatedBy();

  public void setCreatedBy(String createdBy);

  public String getLastModifiedBy();

  public void setLastModifiedBy(String lastModifiedBy);

  public String getDeletedOn();

  public void setDeletedOn(String deletedOn);

  public String getDeletedBy();

  public void setDeletedBy(String deletedBy);

  public boolean isActive();

  public void setActive(boolean active);

  public boolean isDeleted();

  public void setDeleted(boolean deleted);

  void validate();
}