package com.cspsample.main;

import com.cspsample.utilities.Commons;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class ApplicationTest extends Mockito {

    @Test
    public void getRequestTest() throws IOException, ServletException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        ServletContext context = mock(ServletContext.class);

        when(request.getServletContext()).thenReturn(context);
        when(request.getRequestDispatcher("/home.jsp")).thenReturn(dispatcher);

        new Application().doGet(request, response);

        verify(request, times(1)).getRequestDispatcher("/home.jsp");
        verify(request, never()).getSession();
        verify(dispatcher).forward(request, response);
    }
}
