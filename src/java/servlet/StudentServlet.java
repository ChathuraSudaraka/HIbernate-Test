package servlet;

import model.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class StudentServlet extends HttpServlet {

    private final StudentDAO dao = new StudentDAO();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        String path = req.getPathInfo();
        try {
            // Only allow GET /student to list all students
            if (path == null || path.isEmpty()) {
                for (Student s : dao.listAll()) {
                    out.println("{ id=" + s.getId() + ", name='" + s.getName() + "', age=" + s.getAge() + " }");
                }
            } else {
                out.println("Only /student is supported");
            }
        } catch (Exception e) {
            e.printStackTrace(out);
        }
    }

    /*
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        String path = req.getPathInfo();
        if (path != null) {
            path = path.trim();
            if (path.equals("/") || path.isEmpty()) {
                path = "";
            }
            if (path.startsWith("/")) {
                path = path.substring(1);
            }
        }
        if (path != null && !path.isEmpty()) {
            out.println("POST only on /student");
            return;
        }
        try {
            String name = req.getParameter("name"), age = req.getParameter("age");
            if (name == null || name.trim().isEmpty()) {
                out.println("name required");
                return;
            }
            Student s = new Student();
            s.setName(name.trim());
            Integer ageVal = null;
            try {
                ageVal = (age == null || age.isEmpty()) ? null : Integer.valueOf(age);
            } catch (Exception e) {
                ageVal = null;
            }
            s.setAge(ageVal);
            Long id = dao.save(s);
            out.println("Created id=" + id);
        } catch (Exception e) {
            e.printStackTrace(out);
        }
    }
     */

 /*
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        String path = req.getPathInfo();
        if (path != null) {
            path = path.trim();
            if (path.equals("/") || path.isEmpty()) {
                path = "";
            }
            if (path.startsWith("/")) {
                path = path.substring(1);
            }
        }
        try {
            if (path == null || path.isEmpty()) {
                out.println("PUT requires /student/{id}");
                return;
            }
            Long id = null;
            try {
                id = (path == null || path.isEmpty()) ? null : Long.valueOf(path);
            } catch (Exception e) {
                id = null;
            }
            if (id == null) {
                out.println("invalid id");
                return;
            }
            Student s = dao.get(id);
            if (s == null) {
                out.println("Not found");
                return;
            }
            String name = req.getParameter("name"), age = req.getParameter("age");
            if (name != null && !name.trim().isEmpty()) {
                s.setName(name.trim());
            }
            if (age != null && !age.isEmpty()) {
                Integer ageVal = null;
                try {
                    ageVal = Integer.valueOf(age);
                } catch (Exception e) {
                    ageVal = null;
                }
                s.setAge(ageVal);
            }
            dao.update(s);
            out.println("Updated id=" + id);
        } catch (Exception e) {
            e.printStackTrace(out);
        }
    }
     */

 /*
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        String path = req.getPathInfo();
        if (path != null) {
            path = path.trim();
            if (path.equals("/") || path.isEmpty()) {
                path = "";
            }
            if (path.startsWith("/")) {
                path = path.substring(1);
            }
        }
        try {
            if (path == null || path.isEmpty()) {
                out.println("DELETE requires /student/{id}");
                return;
            }
            Long id = null;
            try {
                id = (path == null || path.isEmpty()) ? null : Long.valueOf(path);
            } catch (Exception e) {
                id = null;
            }
            if (id == null) {
                out.println("invalid id");
                return;
            }
            dao.delete(id);
            out.println("Deleted id=" + id);
        } catch (Exception e) {
            e.printStackTrace(out);
        }
    }
     */
}
