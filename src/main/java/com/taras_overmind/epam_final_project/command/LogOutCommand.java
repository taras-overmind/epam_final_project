package com.taras_overmind.epam_final_project.command;

import com.taras_overmind.epam_final_project.command.commandResult.CommandResult;
import com.taras_overmind.epam_final_project.command.commandResult.RedirectResult;
import com.taras_overmind.epam_final_project.db.dto.LecturerDTO;
import com.taras_overmind.epam_final_project.db.dto.ThemeDTO;
import com.taras_overmind.epam_final_project.db.repository.LecturerRepo;
import com.taras_overmind.epam_final_project.db.repository.ThemeRepo;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class LogOutCommand extends Command {

    private static final Logger LOG = Logger.getLogger(LogOutCommand.class);

    public CommandResult execute(HttpServletRequest request, HttpServletResponse response, String redirect)
            throws IOException, ServletException {

        HttpSession session = request.getSession();



        session.setAttribute("id", null);
        session.setAttribute("login", null);
        session.setAttribute("password", null);
        session.setAttribute("email", null);
        session.setAttribute("id_state", null);
        session.setAttribute("id_role", null);
        session.setAttribute("user", null);
        session.setAttribute("idTheme", null);
        session.setAttribute("idLecturer", null);
        session.setAttribute("sort", null);
        session.setAttribute("sorting", null);
        session.setAttribute("user", null);
        session.invalidate();
        return new RedirectResult("?command=getLoginCommand");
    }
}
