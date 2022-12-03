package np.com.suulaav.financemanager.dao.entity.user;

import lombok.Data;
import np.com.suulaav.financemanager.core.dao.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Sulav created on 12/2/22
 */
@Table(name = "users")
@Entity
@Data
public class UserEntity extends AbstractEntity {
  @Column(name = "full_name")
  private String fullName;

  @Column(name = "email")
  private String email;

  @Column(name = "phone_number")
  private String phoneNumber;

  @Column(name = "address")
  private String address;

  @Column(name = "password")
  private String password;

  @Column(name = "roles")
  private String roles;
}