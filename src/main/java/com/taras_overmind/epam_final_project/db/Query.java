package com.taras_overmind.epam_final_project.db;


/**
 * Contains all queries
 */
public class Query {

    //Select_as queries

    //Simple select queries
    public static final String SELECT_ALL_USERS = "SELECT * FROM USERS";
    public static final String SELECT_USER_BY_LOGIN = "SELECT * FROM USERS WHERE LOGIN = ?";
    public static final String SELECT_THEME_BY_ID = "SELECT * FROM THEMES WHERE theme_id = ?";
    public static final String SELECT_THEME_BY_NAME = "SELECT * FROM THEMES WHERE name_theme = ?";
    public static final String SELECT_LECTURER_BY_ID = "SELECT * FROM LECTURERS WHERE id = ?";
    public static final String SELECT_STUDENT_BY_ID_USER =  "SELECT * FROM STUDENTS WHERE ID_USER=?";



    //Complex select queries
    public static final String SELECT_LAST_USER_ID = "SELECT MAX(ID_USER) FROM USERS";
    public static final String SELECT_LAST_THEME_ID = "SELECT MAX(ID_THEME) FROM THEMES";
    public static final String SELECT_LAST_STUDENT_ID = "SELECT MAX(ID) FROM STUDENTS";
    public static final String SELECT_LAST_LECTURER_ID = "SELECT MAX(ID) FROM LECTURERS";

    //Create queries
    public static final String CREATE_USER = "INSERT INTO USERS          VALUES (DEFAULT, ?, ?, null, ?, ?)";
    public static final String CREATE_THEME = "INSERT INTO THEMES          VALUES (DEFAULT, ?)";
    public static final String CREATE_COURSE =              "INSERT INTO COURSES        VALUES (DEFAULT, ?, ?, ?, ?, ?)";
    public static final String CREATE_STUDENT = "INSERT INTO STUDENTS    VALUES (DEFAULT, ?, ?, ?, ?)";
    public static final String CREATE_LECTURER = "INSERT INTO LECTURERS    VALUES (DEFAULT, ?, ?, ?, ?)";
    public static final String REGISTER_USER_ON_COURSE = "INSERT INTO STUDENT_COURSE VALUES (DEFAULT, ?, ?)";

    public static final String SELECT_INFO_ABOUT_COURSE_BY_USER_ID_AND_BY_COURSE_STATUS_ID = "SELECT DISTINCT  NAME_COURSE, DURATION, THEMES.NAME_THEME, LECTURERS.SURNAME, LECTURERS.NAME, LECTURERS.PATRONYMIC FROM STUDENTS INNER JOIN STUDENT_COURSE ON STUDENT_COURSE.ID_STUDENT=STUDENTS.ID INNER JOIN COURSES ON STUDENT_COURSE.ID_COURSE=COURSES.ID_COURSE INNER JOIN STATUSES ON STATUSES.ID_STATUS = COURSES.ID_STATUS INNER JOIN THEMES ON COURSES.ID_THEME = THEMES.ID_THEME INNER JOIN LECTURERS ON COURSES.ID_LECTURER = LECTURERS.ID INNER JOIN USERS ON USERS.ID_USER = STUDENTS.ID_USER WHERE USERS.id_user= ? AND STATUSES.id_status = ?";
    public static final String SELECT_FINISHED_COURSE_BY_USER_ID = "SELECT DISTINCT  NAME_COURSE, DURATION, THEMES.NAME_THEME, LECTURERS.SURNAME, LECTURERS.NAME, LECTURERS.PATRONYMIC, MARK FROM STUDENTS INNER JOIN STUDENT_COURSE ON STUDENTS.ID = STUDENT_COURSE.ID_STUDENT INNER JOIN COURSES ON STUDENT_COURSE.ID_COURSE = COURSES.ID_COURSE INNER JOIN STATUSES ON COURSES.ID_STATUS = STATUSES.ID_STATUS INNER JOIN THEMES ON COURSES.ID_THEME = THEMES.ID_THEME INNER JOIN JOURNAL ON STUDENT_COURSE.ID_STUDENT_COURSE = JOURNAL.ID_STUDENT_COURSE INNER JOIN LECTURERS ON COURSES.ID_LECTURER = LECTURERS.ID INNER JOIN USERS ON STUDENTS.ID_USER = USERS.ID_USER WHERE STATUSES.ID_STATUS = 4 AND USERS.id_user=?";

    public static final String SELECT_COURSES_TO_REGISTER = "SELECT COURSES.id_course, COURSES.name_course, COURSES.duration, THEMES.name_theme, LECTURERS.surname, LECTURERS.name, LECTURERS.patronymic \n" +
            "FROM COURSES \n" +
            "JOIN THEMES ON THEMES.id_theme=COURSES.id_theme\n" +
            "JOIN LECTURERS ON LECTURERS.id=COURSES.id_lecturer\n" +
            "WHERE name_course NOT IN\n" +
            "\t( SELECT name_course \n" +
            "\tFROM STUDENTS \n" +
            "\tINNER JOIN STUDENT_COURSE ON STUDENTS.id = STUDENT_COURSE.id_student \n" +
            "\tINNER JOIN COURSES ON COURSES.id_course = STUDENT_COURSE.id_course \n" +
            "\tJOIN USERS on STUDENTS.id_user=USERS.id_user\n" +
            "\tWHERE USERS.id_user=?) \n" +
            "AND id_status=1 \n" +
            "ORDER BY name_course";



    public static final String SELECT_SORTED_COURSES_BY_LECTURER_AND_THEME = " SELECT COURSES.id_course, COURSES.COURSES.ID_THEME, NAME_COURSE, DURATION, NAME_THEME, SURNAME, NAME, PATRONYMIC, NAME_STATUS, count(id_student_course) as COUNT FROM COURSES INNER JOIN THEMES ON THEMES.ID_THEME=COURSES.ID_THEME INNER JOIN LECTURERS ON LECTURERS.ID=COURSES.ID_LECTURER INNER JOIN STATUSES ON STATUSES.ID_STATUS=COURSES.ID_STATUS LEFT JOIN STUDENT_COURSE ON COURSES.id_course = STUDENT_COURSE.id_course WHERE ID = ? AND COURSES.ID_THEME = ? GROUP BY NAME_COURSE ORDER BY";
    public static final String SELECT_SORTED_COURSES_BY_LECTURER = " SELECT COURSES.id_course, COURSES.ID_THEME, NAME_COURSE, DURATION, NAME_THEME, SURNAME, NAME, PATRONYMIC, NAME_STATUS, count(id_student_course) as COUNT FROM COURSES INNER JOIN THEMES ON THEMES.ID_THEME=COURSES.ID_THEME INNER JOIN LECTURERS ON LECTURERS.ID=COURSES.ID_LECTURER INNER JOIN STATUSES ON STATUSES.ID_STATUS=COURSES.ID_STATUS LEFT JOIN STUDENT_COURSE ON COURSES.id_course = STUDENT_COURSE.id_course WHERE ID = ? GROUP BY NAME_COURSE ORDER BY";
    public static final String SELECT_SORTED_COURSES_BY_THEME = "SELECT COURSES.id_course,  COURSES.ID_THEME, NAME_COURSE, DURATION, NAME_THEME, SURNAME, NAME, PATRONYMIC, NAME_STATUS, count(id_student_course) as COUNT FROM COURSES INNER JOIN THEMES ON THEMES.ID_THEME=COURSES.ID_THEME INNER JOIN LECTURERS ON LECTURERS.ID=COURSES.ID_LECTURER INNER JOIN STATUSES ON STATUSES.ID_STATUS=COURSES.ID_STATUS LEFT JOIN STUDENT_COURSE ON COURSES.id_course = STUDENT_COURSE.id_course WHERE COURSES.ID_THEME = ? GROUP BY NAME_COURSE ORDER BY";
    public static final String SELECT_SORTED_COURSES = " SELECT COURSES.id_course, COURSES.ID_THEME, NAME_COURSE, DURATION, NAME_THEME, SURNAME, NAME, PATRONYMIC, NAME_STATUS, count(id_student_course) as COUNT FROM COURSES INNER JOIN THEMES ON THEMES.ID_THEME=COURSES.ID_THEME INNER JOIN LECTURERS ON LECTURERS.ID=COURSES.ID_LECTURER INNER JOIN STATUSES ON STATUSES.ID_STATUS=COURSES.ID_STATUS LEFT JOIN STUDENT_COURSE ON COURSES.id_course = STUDENT_COURSE.id_course GROUP BY NAME_COURSE ORDER BY";



    public static final String SELECT_COURSES_BY_LECTURER_AND_THEME = " SELECT COURSES.id_course, COURSES.ID_THEME, NAME_COURSE, DURATION, NAME_THEME, SURNAME, NAME, PATRONYMIC, NAME_STATUS, count(id_student_course) as COUNT FROM COURSES INNER JOIN THEMES ON THEMES.ID_THEME=COURSES.ID_THEME INNER JOIN LECTURERS ON LECTURERS.ID=COURSES.ID_LECTURER INNER JOIN STATUSES ON STATUSES.ID_STATUS=COURSES.ID_STATUS LEFT JOIN STUDENT_COURSE ON COURSES.id_course = STUDENT_COURSE.id_course WHERE ID = ? AND COURSES.ID_THEME = ? GROUP BY NAME_COURSE";
    public static final String SELECT_COURSES_BY_LECTURER = " SELECT COURSES.id_course, COURSES.ID_THEME, NAME_COURSE, DURATION, NAME_THEME, SURNAME, NAME, PATRONYMIC, NAME_STATUS, count(id_student_course) as COUNT FROM COURSES INNER JOIN THEMES ON THEMES.ID_THEME=COURSES.ID_THEME INNER JOIN LECTURERS ON LECTURERS.ID=COURSES.ID_LECTURER INNER JOIN STATUSES ON STATUSES.ID_STATUS=COURSES.ID_STATUS LEFT JOIN STUDENT_COURSE ON COURSES.id_course = STUDENT_COURSE.id_course WHERE ID = ? GROUP BY NAME_COURSE";
    public static final String SELECT_COURSES_BY_THEME = " SELECT COURSES.id_course, COURSES.ID_THEME, NAME_COURSE, DURATION, NAME_THEME, SURNAME, NAME, PATRONYMIC, NAME_STATUS, count(id_student_course) as COUNT FROM COURSES INNER JOIN THEMES ON THEMES.ID_THEME=COURSES.ID_THEME INNER JOIN LECTURERS ON LECTURERS.ID=COURSES.ID_LECTURER INNER JOIN STATUSES ON STATUSES.ID_STATUS=COURSES.ID_STATUS LEFT JOIN STUDENT_COURSE ON COURSES.id_course = STUDENT_COURSE.id_course WHERE COURSES.ID_THEME = ? GROUP BY NAME_COURSE";
    public static final String SELECT_COURSES = " SELECT COURSES.id_course, COURSES.ID_THEME, NAME_COURSE, DURATION, NAME_THEME, SURNAME, NAME, PATRONYMIC, NAME_STATUS, count(id_student_course) as COUNT FROM COURSES INNER JOIN THEMES ON THEMES.ID_THEME=COURSES.ID_THEME INNER JOIN LECTURERS ON LECTURERS.ID=COURSES.ID_LECTURER INNER JOIN STATUSES ON STATUSES.ID_STATUS=COURSES.ID_STATUS LEFT JOIN STUDENT_COURSE ON COURSES.id_course = STUDENT_COURSE.id_course GROUP BY NAME_COURSE";


    public static final String SELECT_STUDENTS_WITHOUT_MARK = "SELECT USERS.id_user, STUDENT_COURSE.id_student_course, COURSES.name_course, STUDENTS.surname, STUDENTS.name, STUDENTS.PATRONYMIC, STUDENTS.id_user\n" +
            "    FROM STUDENT_COURSE\n" +
            "    INNER JOIN COURSES ON STUDENT_COURSE.id_course = COURSES.id_course\n" +
            "    INNER JOIN STATUSES ON COURSES.id_status = STATUSES.id_status\n" +
            "    INNER JOIN LECTURERS ON COURSES.id_lecturer = LECTURERS.id\n" +
            "    INNER JOIN USERS ON LECTURERS.id_user = USERS.id_user\n" +
            "    INNER JOIN STUDENTS ON STUDENT_COURSE.id_student = STUDENTS.id\n" +
            "    WHERE NOT EXISTS(\n" +
            "    SELECT JOURNAL.id_student_course\n" +
            "    FROM JOURNAL\n" +
            "    WHERE JOURNAL.id_student_course = STUDENT_COURSE.id_student_course\n" +
            "    ) AND COURSES.id_status=3 AND USERS.id_user = ?";
    public static final String SELECT_STUDENTS_WITH_MARK = "SELECT USERS.id_user, STUDENT_COURSE.id_student_course, COURSES.name_course, STUDENTS.surname, STUDENTS.name, STUDENTS.PATRONYMIC, STUDENTS.id_user, JOURNAL.mark\n" +
            "    FROM STUDENT_COURSE\n" +
            "    INNER JOIN COURSES ON STUDENT_COURSE.id_course = COURSES.id_course\n" +
            "    INNER JOIN STATUSES ON COURSES.id_status = STATUSES.id_status\n" +
            "    INNER JOIN LECTURERS ON COURSES.id_lecturer = LECTURERS.id\n" +
            "    INNER JOIN USERS ON LECTURERS.id_user = USERS.id_user\n" +
            "    INNER JOIN STUDENTS ON STUDENT_COURSE.id_student = STUDENTS.id\n" +
            "    INNER JOIN JOURNAL ON JOURNAL.id_student_course = STUDENT_COURSE.id_student_course\n" +
            "    WHERE EXISTS(\n" +
            "    SELECT JOURNAL.id_student_course\n" +
            "    FROM JOURNAL\n" +
            "    WHERE JOURNAL.id_student_course = STUDENT_COURSE.id_student_course\n" +
            "    ) AND COURSES.id_status=3 AND USERS.id_user = ?";


    public static final String CREATE_MARK_FOR_STUDENT =    "INSERT INTO JOURNAL VALUES(?, ?)";

    public static final String UPDATE_MARK_FOR_STUDENT =     "UPDATE JOURNAL  SET MARK = ? WHERE ID_STUDENT_COURSE = ?";

    public static final String SELECT_ALL_THEMES =          "SELECT * FROM THEMES";
    public static final String SELECT_ALL_LECTURERS =       "SELECT * FROM LECTURERS";
    public static final String SELECT_ALL_STATUSES =        "SELECT * FROM STATUSES";
    public static final String SELECT_ALL_COURSES =         "SELECT * FROM COURSES";
    public static final String SELECT_ALL_STUDENTS =        "SELECT * FROM STUDENTS";
    public static final String SELECT_ALL_STUDENT_ON_COURSE="SELECT * FROM STUDENT_COURSE";
    public static final String SELECT_ALL_DEFINITE_COURSE = "SELECT * FROM COURSES WHERE ID_COURSE=?";

    public static final String DELETE_COURSE =      "DELETE FROM COURSES WHERE ID_COURSE=?";
    public static final String DELETE_STUDENT_COURSE =      "DELETE FROM STUDENT_COURSE WHERE ID_COURSE=?";

    public static final String CHANGE_STATE_USER = "UPDATE USERS       SET ID_STATE = ? WHERE ID_USER = ?";


}
