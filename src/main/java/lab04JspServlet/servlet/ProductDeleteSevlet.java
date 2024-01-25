package lab04JspServlet.servlet;

import java.io.IOException;
import java.sql.Connection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab04JspServlet.conn.ConnectionUtils;
import lab04JspServletJ.utils.ProductUtils;



@WebServlet("/productDelete")
public class ProductDeleteSevlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ProductDeleteSevlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String errorString = null;
        String code = (String) request.getParameter("code");
        Connection conn = null;

        try {
            conn = ConnectionUtils.getMSSQLConnection();
            ProductUtils.deleteProduct(conn, code);
        } catch (Exception e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }

        if (errorString != null) {
            request.setAttribute("errorString", errorString);
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/productDeleteError.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/productList");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
