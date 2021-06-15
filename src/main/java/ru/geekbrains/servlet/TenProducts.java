package ru.geekbrains.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "TenProducts", urlPatterns = "/ten_products")
public class TenProducts extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(TenProducts.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8");

        List<Product> products = new ArrayList();
        products.add(new Product(1, "Яблоко", 1.5f));
        products.add(new Product(2, "Апельсин", 2.5f));
        products.add(new Product(3, "Тыква", 5.0f));
        products.add(new Product(4, "Помидор", 4.0f));
        products.add(new Product(5, "Огурец", 2.5f));
        products.add(new Product(6, "Виноград", 15.8f));
        products.add(new Product(7, "Мандарин", 6.9f));
        products.add(new Product(8, "Киви", 1.2f));
        products.add(new Product(9, "Баклажан", 10.5f));
        products.add(new Product(10, "Арбуз", 100.1f));

        resp.getWriter().printf("<h1>Products</h1>");
        resp.getWriter().printf("<table>");
        resp.getWriter().printf("<tr>");
        resp.getWriter().printf("<td>Id</td>");
        resp.getWriter().printf("<td>Title</td>");
        resp.getWriter().printf("<td>Cost</td>");
        resp.getWriter().printf("</tr>");
        for (Product product : products) {
            resp.getWriter().printf("<tr>");
            resp.getWriter().printf("<td>%d</td>",product.getId());
            resp.getWriter().printf("<td>%s</td>",product.getTitle());
            resp.getWriter().printf("<td>%f</td>",product.getCost());
            resp.getWriter().printf("</tr>");
        }
        resp.getWriter().printf("</table>");
    }
}
