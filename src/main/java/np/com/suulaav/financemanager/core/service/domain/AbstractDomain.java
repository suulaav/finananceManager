package np.com.suulaav.financemanager.core.service.domain;

import lombok.Data;

/**
 * @author Sulav created on 11/21/22
 */
@Data
public abstract class AbstractDomain implements Domain {
  protected String id;
  protected String createdOn;
  protected String lastModifiedOn;
  protected String createdBy;
  protected String lastModifiedBy;
  protected String deletedOn;
  protected String deletedBy;
  protected boolean active;
  protected boolean deleted;

}