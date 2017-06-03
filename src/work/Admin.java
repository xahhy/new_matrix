package work;

import common.CellWorld;
import common.Utils;

import javax.servlet.annotation.WebServlet;
import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by hhy on 2017/6/2.
 */
@WebServlet(name = "Admin", urlPatterns = {"/am"})
public class Admin extends javax.servlet.http.HttpServlet {
    CellWorld world ;
    public static ArrayList<Point> test_big(){
        ArrayList<Point> bigMap = new ArrayList<Point>();
        bigMap.add(new Point(0, 0));
        bigMap.add(new Point(2, 0));
        bigMap.add(new Point(0, 2));
        bigMap.add(new Point(2, 2));

        bigMap.add(new Point(12, 0));
        bigMap.add(new Point(14, 0));
        bigMap.add(new Point(12, 2));
        bigMap.add(new Point(14, 2));

        bigMap.add(new Point(1, 1));
        bigMap.add(new Point(3, 1));
        bigMap.add(new Point(4, 1));
        bigMap.add(new Point(5, 1));
        bigMap.add(new Point(9, 1));
        bigMap.add(new Point(10, 1));
        bigMap.add(new Point(11, 1));
        bigMap.add(new Point(13, 1));


        bigMap.add(new Point(1, 3));
        bigMap.add(new Point(1, 4));
        bigMap.add(new Point(1, 5));
        bigMap.add(new Point(1, 9));
        bigMap.add(new Point(1, 10));
        bigMap.add(new Point(1, 11));
        bigMap.add(new Point(1, 13));

        bigMap.add(new Point(0, 12));
        bigMap.add(new Point(0, 14));
        bigMap.add(new Point(2, 12));
        bigMap.add(new Point(2, 14));

        bigMap.add(new Point(3, 13));
        bigMap.add(new Point(4, 13));
        bigMap.add(new Point(5, 13));

        bigMap.add(new Point(9, 13));
        bigMap.add(new Point(10, 13));
        bigMap.add(new Point(11, 13));

        bigMap.add(new Point(13, 13));

        bigMap.add(new Point(12, 12));
        bigMap.add(new Point(14, 12));
        bigMap.add(new Point(12, 14));
        bigMap.add(new Point(14, 14));
        bigMap.add(new Point(7, 6));
        bigMap.add(new Point(7, 7));
        bigMap.add(new Point(8, 7));
        bigMap.add(new Point(6, 7));
        bigMap.add(new Point(13, 3));
        bigMap.add(new Point(13, 4));
        bigMap.add(new Point(13, 5));
        bigMap.add(new Point(13, 9));
        bigMap.add(new Point(13, 10));
        bigMap.add(new Point(13, 11));

        return bigMap;
    }
    public Admin() {
        world = new CellWorld(15,15);
        ArrayList<Point> input = new ArrayList<Point>();
        input = test_big();
        world.initialize(input);
    }
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("text/plain;charset=UTF-8;pageEncoding=UTF-8");
        String result = "Matrix";
        /* mission detail */
//        result = Utils.get_JSON()
        String start = request.getParameter("start");
        if (start != null) {
            if(start.equals("start"))
            {
                ArrayList<Point> input = new ArrayList<Point>();
                System.out.println(start);
                int offset=0;
                input.add(new Point(0+offset,1+offset));
                input.add(new Point(1+offset,1+offset));
                input.add(new Point(2+offset,1+offset));
                world.initialize(input);
            }
        }
        result = world.Next_JSON();
        /* end */
        PrintWriter out = response.getWriter();
        out.print(result);
        out.flush();
        out.close();
    }
}
