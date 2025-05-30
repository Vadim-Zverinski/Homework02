package by.it_academia;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "Servlet4", urlPatterns = "/fin")
public class fin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String[] rows = req.getParameterValues("rows");

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.write("<table border='1'>");


        long totalNumber = 0;
        long totalPrice = 0;
        for (String row : rows) {
            String[] cells = row.split(",");
            writer.write("<tr>");
            for (String cell : cells) {
                writer.write("<td>" + cell + "</td>");
            }
            long result = Long.parseLong(cells[0]) * Long.parseLong(cells[1]);
            totalPrice += Long.parseLong(cells[0]) * Long.parseLong(cells[1]);
            totalNumber += Long.parseLong(cells[1]);

            writer.write("<td>" + result + "</td>");
            writer.write("</tr>");
        }
        int count = 0;
        while (count < 5) {
            writer.write("<br>");
            count++;
        }
        long averagePrice = totalPrice/totalNumber;

        writer.write("<table>");

        writer.write("<p><span style='color: blue'>Средняя цена &emsp; &emsp; Общая численность</span><p>");
        writer.write("<p><span style='color: grin'>"+averagePrice+" &emsp; &emsp;&emsp; &emsp;"+totalNumber+" </span><p>");
        writer.write("<p><span style='color: blue'>Общая сумма </span><p>");
        writer.write("<p><span style='color: grin'>"+totalPrice+" </span><p>");

    }
}
