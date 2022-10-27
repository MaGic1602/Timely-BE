package m.idk.Timely.service;

import m.idk.Timely.model.WorkSession;
import m.idk.Timely.repository.WorkSessionRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

//service gets data from controller and passes it to DB
@Service
public class WorkSessionServiceImplementation implements WorkSessionService {

private final WorkSessionRepository workSessionRepository;

    public WorkSessionServiceImplementation(WorkSessionRepository workSessionRepository) {
        this.workSessionRepository = workSessionRepository;
    }

    //save
    @Override
    @CrossOrigin
    public WorkSession saveWorkSession(WorkSession workSession) {
        return workSessionRepository.save(workSession);
    }



    //read
    @Override
    public List<WorkSession> fetchWorkSessionList() {
        return workSessionRepository.findAll();
    }

//update
    @Override
    @CrossOrigin
    public WorkSession updateWorkSession(WorkSession workSession, Long sessionId)  {
        WorkSession session;

        session = workSessionRepository.findById(sessionId).orElseThrow();


        WorkSession toUpdate = workSessionRepository.getReferenceById(sessionId);
        toUpdate.setDuration(workSession.getDuration());
        //toUpdate.setDuration(workSession.getEndDate().compareTo(workSession.getStartDate()));
        long duration = Math.abs(workSession.getEndDate().getTime() - session.getStartDate().getTime());


        long difference_In_Seconds
                = (duration
                / 1000)
                % 60;

        long difference_In_Minutes
                = (duration
                / (1000 * 60))
                % 60;

        long difference_In_Hours
                = (duration
                / (1000 * 60 * 60))
                % 24;

        String durationDate = difference_In_Hours + "h : " + difference_In_Minutes + "m : " + difference_In_Seconds + "s";

        toUpdate.setDuration(durationDate);
        toUpdate.setEndDate(workSession.getEndDate());
        toUpdate.setSessionName(workSession.getSessionName());



 return workSessionRepository.save(session);
    }

    @Override
    public void deleteWorkSession(Long sessionId) {
        workSessionRepository.deleteById(sessionId);

    }

public void deleteAllWorkSessions()
{
    workSessionRepository.deleteAll(workSessionRepository.findAll());
}
}
