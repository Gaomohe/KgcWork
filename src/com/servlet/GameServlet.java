package com.servlet;

import com.pojo.Game;
import com.util.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

import static com.util.Vessel.gameSer;

@WebServlet("/game")
public class GameServlet extends BaseServlet {
    @Override
    public Class getServlet() {
        return GameServlet.class;
    }

    public String queryGame(HttpServletRequest request, HttpServletResponse response){
        List<Game> gameList = gameSer.queryGame();
        HttpSession session = request.getSession();
        session.setAttribute("gameList",gameList);
        return "queryGame";
    }
}
