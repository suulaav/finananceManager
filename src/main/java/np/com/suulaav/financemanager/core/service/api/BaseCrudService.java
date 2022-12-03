package np.com.suulaav.financemanager.core.service.api;

import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author Sulav created on 11/21/22
 */
public interface BaseCrudService<E, D> {
  String insert(D domain);

  String update(D domain);

  List<D> findAll();

  D findOne(String id);

  List<D> findAllWithPagination(Pageable pageable);
}