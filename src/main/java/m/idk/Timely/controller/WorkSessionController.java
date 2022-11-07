package m.idk.Timely.controller;

import m.idk.Timely.model.WorkSession;
import m.idk.Timely.service.WorkSessionService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
//controller receives all http requests and passes them to service
@RestController
public class WorkSessionController {
    //constructor injection
    private final WorkSessionService workSessionService; //or @Autowired

    public WorkSessionController(WorkSessionService workSessionService) {
        this.workSessionService = workSessionService;
    }

    //save
    @PostMapping("/workSession")
    public WorkSession saveWorkSession(
           @Valid @RequestBody WorkSession workSession)
    {
        return workSessionService.saveWorkSession(workSession);
    }

    //read
    @GetMapping("/workSession")
    public List<WorkSession> fetchWorkSessionList()
    {
       return workSessionService.fetchWorkSessionList();
    }

    //update
    @PutMapping("/workSession/{id}")
    public WorkSession updateWorkSession(@RequestBody WorkSession workSession,
                                         @PathVariable("id") Long sessionId)
    {


            return workSessionService.updateWorkSession(workSession, sessionId);

    }

    //delete
    @DeleteMapping("/workSession/{id}")
    public void deleteWorkSession(@PathVariable("id") Long sessionId){

        workSessionService.deleteWorkSession(sessionId);
    }

    @DeleteMapping("/workSession/all")
    public void deleteWorkSessions(){

        workSessionService.deleteAllWorkSessions();
    }



}
