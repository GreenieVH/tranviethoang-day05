package lab04JspServlet.servlet;


import java.io.IOException; // Fixed import
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab04JspServlet.beans.Product;
import lab04JspServlet.conn.ConnectionUtils;
import lab04JspServletJ.utils.ProductUtils;

@WebServlet("/productEdit") // Fixed annotation
public class ProductEditServlet extends HttpServlet { // Corrected class name
    private static final long serialVersionUID = 1L;

    public ProductEditServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String errorString = null;
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/productEdit.jsp");

        // Lấy dữ liệu mã sản phẩm từ request
        String code = (String) request.getParameter("code");
        if (code == null || code.equals("")) { // Fixed the condition
            errorString = "Bạn chưa chọn sản phẩm cần sửa";
            request.setAttribute("errorString", errorString);
            dispatcher.forward(request, response);
            return;
        }

        Connection conn = null;
        Product product = null;
        try {
            conn = ConnectionUtils.getMSSQLConnection();
            product = ProductUtils.findProduct(conn, code);
            if (product == null) {
                errorString = "Không tìm thấy sản phẩm có mã " + code;
            }
        } catch (Exception e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }

        // Khi có lỗi
        if (errorString != null || product == null) {
            request.setAttribute("errorString", errorString);
            dispatcher.forward(request, response);
            return;
        }

        // Khi không có lỗi
        request.setAttribute("errorString", null); // Set errorString to null if there's no error
        request.setAttribute("product", product);
        dispatcher.forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String errorString = null;

        // Lấy dữ liệu trên form
        String code = (String) request.getParameter("code");
        String name = (String) request.getParameter("name");
        String priceStr = (String) request.getParameter("price");
        float price = 0;

        try {
            price = Float.parseFloat(priceStr);
        } catch (Exception e) {
            errorString = e.getMessage();
        }

        Product product = new Product(code, name, price);

        if (errorString != null) {
            request.setAttribute("errorString", errorString);
            request.setAttribute("product", product);
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/productEdit.jsp");
            dispatcher.forward(request, response);
            return;
        }

        Connection conn = null;
        try {
            conn = ConnectionUtils.getMSSQLConnection();
            ProductUtils.updateProduct(conn, product);
            response.sendRedirect(request.getContextPath() + "/productList");
        } catch (Exception e) {
            e.printStackTrace();
            errorString = e.getMessage();
            request.setAttribute("errorString", errorString);
            request.setAttribute("product", product);
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/productEdit.jsp");
            dispatcher.forward(request, response);
        }
    }

}
