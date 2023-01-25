package com.taras_overmind.epam_final_project.command;

import com.taras_overmind.epam_final_project.command.commandResult.CommandResult;
import com.taras_overmind.epam_final_project.command.commandResult.RedirectResult;
import com.taras_overmind.epam_final_project.db.repository.StudentRepo;
import com.taras_overmind.epam_final_project.db.repository.UserRepo;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RegisterOnCourseCommand extends Command {
    private static final Logger LOG = Logger.getLogger(MarkStudentCommand.class);

    private final StudentRepo studentRepo = new StudentRepo();

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response, String forward)
            throws IOException, ServletException {

        LOG.trace("Start tracing RegisterOnCourseCommand");

        HttpSession session = request.getSession();
        RedirectResult redirect;
        redirect = new RedirectResult("?command=getStudentCommand");
        try {
        int id = Integer.parseInt(String.valueOf(session.getAttribute("id")));
        int courseId = Integer.parseInt(request.getParameter("id_course"));
        new UserRepo().registerUserOnCourse(id, courseId);
        } catch ( NumberFormatException ex) {
            LOG.error(ex.getMessage());
        }

        return redirect;
    }
}
