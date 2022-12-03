package np.com.suulaav.financemanager.core.converter;

import np.com.suulaav.financemanager.core.dao.entity.Entity;
import np.com.suulaav.financemanager.core.service.domain.Domain;

import java.text.ParseException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Sulav created on 12/3/22
 */
public interface Converter<T extends Domain, E extends Entity> {
  T toDomain(E var1);

  E toEntity(T var1);

  default List<T> toDomainList(List<E> entities) {
    return entities.isEmpty()
        ? Collections.emptyList()
        : (List) entities.stream().map(this::toDomain).collect(Collectors.toList());
  }
}