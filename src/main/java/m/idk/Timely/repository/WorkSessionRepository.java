package m.idk.Timely.repository;

import m.idk.Timely.model.WorkSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//defining the interface to use CRUD operations
@Repository
public interface WorkSessionRepository extends JpaRepository <WorkSession, Long> {

}
