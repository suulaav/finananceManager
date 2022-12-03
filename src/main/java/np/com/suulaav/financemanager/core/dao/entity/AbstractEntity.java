package np.com.suulaav.financemanager.core.dao.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


@MappedSuperclass
@Data
public abstract class AbstractEntity implements Entity {
  @Id
  @Column(name = "id", nullable = false)
  private String id;

  @Column(name = "created_on")
  private java.sql.Date createdOn;

  @Column(name = "created_by")
  protected String createdBy;

  @Column(name = "last_modified_on")
  protected java.sql.Date lastModifiedOn;

  @Column(name = "last_modified_by")
  protected String lastModifiedBy;

  @Column(name = "deleted_on")
  protected java.sql.Date deletedOn;

  @Column(name = "deleted_by")
  protected String deletedBy;

  @Column(name = "is_active")
  protected boolean active;

  @Column(name = "is_deleted")
  protected boolean deleted;

}