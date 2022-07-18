package com.example.CourseWork.web;

import com.example.CourseWork.dao.DaoFactory;
import com.example.CourseWork.dao.impl.inmemory.InMemoryDatabase;
import com.example.CourseWork.dao.impl.inmemory.InMemoryTestData;
import com.example.CourseWork.services.FindingService;
import com.example.CourseWork.services.FindingServiceImpl;
import com.example.CourseWork.services.UserService;
import com.example.CourseWork.services.UserServiceImpl;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.function.UnaryOperator;

@WebListener
public class ApplicationContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        // Must be changed to real database in real project
        InMemoryDatabase database = new InMemoryDatabase();
        InMemoryTestData.generateTo(database);

        DaoFactory daoFactory = database.getDaoFactory();

        FindingService movieService = new FindingServiceImpl(daoFactory);
        sce.getServletContext().setAttribute("movieService", movieService);

        UserService userService = new UserServiceImpl(daoFactory, UnaryOperator.identity());
        sce.getServletContext().setAttribute("userService", userService);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}