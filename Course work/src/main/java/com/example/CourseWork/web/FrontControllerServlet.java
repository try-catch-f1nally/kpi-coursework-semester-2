package com.example.CourseWork.web;

import com.example.CourseWork.model.Finding;
import com.example.CourseWork.model.User;
import com.example.CourseWork.services.FindingService;
import com.example.CourseWork.services.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@WebServlet(name = "FrontControllerServlet", urlPatterns = {"/do/*"})
public class FrontControllerServlet extends HttpServlet {

    FindingService findingService;
    UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        findingService = (FindingService) config.getServletContext().getAttribute("movieService");
        userService = (UserService) config.getServletContext().getAttribute("userService");
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String pathInfo = request.getPathInfo();
        if (pathInfo == null) {
            pathInfo = "/";
        }

        try {
            switch (pathInfo) {
                case "/login":
                    login(request, response);
                    break;
                case "/logout":
                    logout(request, response);
                    break;
                case "/finding":
                    finding(request, response);
                    break;
                case "/addFinding":
                    request.getRequestDispatcher("/WEB-INF/jsp/addFinding.jsp").forward(request, response);
                    break;
                case "/createFinding":
                    createFinding(request, response);
                    break;
                case "/deleteFinding":
                    deleteFinding(request, response);
                    break;
                case "/createAccount":
                    createAccount(request, response);
                    break;
                case "/usersFindings":
                    getUsersFindings(request, response);
                    break;
                case "/register":
                    request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
                    break;
                case "/":
                case "/search":
                default:
                    findings(request, response);
                    break;
            }
        } catch (RuntimeException ex) {
            ex.printStackTrace();
            error(request, response, "Oops, " + ex.getMessage());
        }

    }

    protected void findings(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keywordsString = request.getParameter("keywords");
        List<String> keywords = null;
        boolean search = false;
        if (keywordsString != null && keywordsString.length() != 0) {
            keywords = Arrays.asList(keywordsString.split(" "));
            request.setAttribute("keywords", keywords);
            search = true;

        }
        request.setAttribute("search", search);
        List<Finding> findings = findingService.searchByKeyWords(keywords);
        request.setAttribute("findings", findings);
        request.getRequestDispatcher("/WEB-INF/jsp/findings.jsp").forward(request, response);
    }

    protected void finding(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        Integer findingId = Integer.parseInt(request.getParameter("findingId"));
        Finding finding = findingService.getFindingById(findingId);
        boolean viewByOwner = user != null && user.getListOfFindings().contains(finding);

        request.setAttribute("viewByOwner", viewByOwner);
        request.setAttribute("finding", finding);
        request.getRequestDispatcher("/WEB-INF/jsp/finding.jsp").forward(request, response);
    }

    protected void createFinding(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        String title = new String(request.getParameter("title").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String keywordsParam = new String(request.getParameter("keywords").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        List<String> keywords = Arrays.asList(keywordsParam.split(" "));
        String description = new String(request.getParameter("description").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String contactInformation = new String(request.getParameter("contactInformation").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        if (title.length() == 0 || keywords.size() == 0 || description.length() == 0 || contactInformation.length() == 0) {
            error(request, response, "Будь ласка, заповніть усі поля!");
        }
        findingService.createFinding(title, description, keywords, contactInformation, user);
        response.sendRedirect("./usersFindings");
    }

    protected void deleteFinding(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        Integer findingId = Integer.parseInt(request.getParameter("findingId"));
        findingService.deleteFinding(findingService.getFindingById(findingId), user);
        response.sendRedirect("./usersFindings");
    }

    protected void getUsersFindings(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");

        Collection<Finding> findings = userService.getUsersFindings(user);
        request.setAttribute("usersFindings", findings);
        request.getRequestDispatcher("/WEB-INF/jsp/usersFindings.jsp").forward(request, response);
    }

    protected void createAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = new String(request.getParameter("name").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String login = new String(request.getParameter("login").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String password = new String(request.getParameter("password").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);

        if (name.length() == 0 || login.length() == 0 || password.length() == 0) {
            error(request, response, "Будь ласка, заповніть усі поля!");
        }
        if (userService.getByLogin(login) != null) {
            error(request, response, "Користувач з таким логіном вже існує.");
            return;
        }
        userService.createUser(name, login, password);
        request.getSession().setAttribute("user", userService.getByLogin(login));
        response.sendRedirect(".");
    }

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();

        String login = request.getParameter("login");
        User user = userService.getByLogin(login);
        if (user == null) {
            error(request, response, "Вибачте, користувача з логіном '" + login + "' не існує.");
            return;
        }
        String password = request.getParameter("password");

        if (!userService.checkPassword(user, password)) {
            error(request, response, "Невірний пароль!");
            return;
        }

        request.getSession().setAttribute("user", user);
        response.sendRedirect(".");
    }

    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("movies", findingService.getAllFindings());
        request.getSession().invalidate();
        response.sendRedirect(".");
    }


    protected void error(HttpServletRequest request, HttpServletResponse response, String message) throws ServletException, IOException {
        request.setAttribute("message", message);
        request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
}
