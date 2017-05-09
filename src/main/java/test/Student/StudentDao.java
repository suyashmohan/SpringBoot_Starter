package test.Student;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Suyash on 09-05-2017.
 */

@Repository
public interface StudentDao extends CrudRepository<Student, Long> {
}
