package com.taras_overmind.epam_final_project.command;

import com.taras_overmind.epam_final_project.command.commandResult.CommandResult;
import com.taras_overmind.epam_final_project.command.commandResult.RedirectResult;
import com.taras_overmind.epam_final_project.db.Query;
import com.taras_overmind.epam_final_project.db.dao.ConnectionPool;
import com.taras_overmind.epam_final_project.db.service.LecturerService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class MarkStudentCommand extends Command {

    private static final Logger LOG = Logger.getLogger(MarkStudentCommand.class);

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response, String forward)
            throws IOException, ServletException {

        LOG.trace("Start tracing MarkStudentCommand");

        HttpSession session = request.getSession();
        RedirectResult redirect;
        redirect= new RedirectResult("?command=getLecturerCommand");

        String status = request.getParameter("mark");
        if (status.equals("new")) {
            try (Connection connection = ConnectionPool.getConnection()) {
                int mark = Integer.parseInt(request.getParameter("new_mark"));
                int id = Integer.parseInt(request.getParameter("id"));
                if (connection != null) {
                    try (PreparedStatement statement = connection.prepareStatement(Query.CREATE_MARK_FOR_STUDENT)) {
                        connection.setAutoCommit(false);
                        statement.setInt(1, id);
                        statement.setInt(2, mark);
                        statement.execute();
                        connection.commit();
                    } catch (SQLException ex) {
                        LOG.error(ex.getLocalizedMessage());
                        connection.rollback();
                    }
                }
            } catch (SQLException | NumberFormatException ex) {
                LOG.error(ex.getMessage());
            }
        }

        return redirect;
    }
}