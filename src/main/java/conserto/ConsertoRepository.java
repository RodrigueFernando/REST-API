package conserto;

import org.hibernate.query.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface ConsertoRepository extends JpaRepository<Conserto,Long> {

   List<Conserto> findAllByAtivoTrue();

}
