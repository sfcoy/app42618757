package com.stackoverflow.p42618757.web;

import java.io.IOException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stackoverflow.p42618757.api.ServiceBeanInterface;

/**
 * @author sfcoy
 */
@WebServlet(urlPatterns = "/")
public class Client extends HttpServlet {

    private static final long serialVersionUID = 3018345651448328971L;

    private static final String SERVICE_BEAN_JNDI_NAME = "java:global/serverapp/ServiceBean!com.stackoverflow.p42618757.api.ServiceBeanInterface";
    //        @EJB(lookup= SERVICE_BEAN_JNDI_NAME)
    private transient ServiceBeanInterface serviceBeanInterface;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try {
            Context initialContext = new InitialContext();
            serviceBeanInterface = (ServiceBeanInterface) initialContext.lookup(SERVICE_BEAN_JNDI_NAME);
            System.out.println(serviceBeanInterface.getClass());
        } catch (NamingException e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write(serviceBeanInterface.getHelloString());
    }

}
