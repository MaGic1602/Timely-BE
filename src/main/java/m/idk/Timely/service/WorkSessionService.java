
package m.idk.Timely.service;

import m.idk.Timely.model.WorkSession;

import java.util.Date;
import java.util.List;

public interface WorkSessionService {
    //save
    WorkSession saveWorkSession(WorkSession workSession);

    //read
    List<WorkSession> fetchWorkSessionList();

    //update
    WorkSession updateWorkSession (WorkSession workSession, Long sessionId) ;

    //delete
    void deleteWorkSession(Long sessionId);

    void deleteAllWorkSessions();

}
