package com.dao.Impl;

import com.dao.GameDao;
import com.pojo.Game;
import com.util.JDBC;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GameDaoImpl implements GameDao {
    //查询
    @Override
    public List<Game> queryGame() {
        String sql = "SELECT * FROM games WHERE gameId > ?";
        Object[] obj = new Object[1];
        obj[0] = 0;
        ResultSet resultSet = JDBC.query(sql, obj);
        List<Game> gameList = new ArrayList<Game>();
        try{
            while(resultSet.next()){
                Game game = new Game();
                game.setgId(resultSet.getInt("gameId"));
                game.setgName(resultSet.getString("gameName"));
                game.setgType(resultSet.getString("gameType"));
                game.setgCompany(resultSet.getString("gameCompany"));
                game.setgYear(resultSet.getString("gameYear"));
                gameList.add(game);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return gameList;
    }

    //增
    @Override
    public int addGame(Game game) {
        String sql = "INSERT INTO games(gameName, gameType, gameCompany, gameYear) VALUE (?,?,?,?)";
        Object[] obj = new Object[4];
        obj[0] = game.getgName();
        obj[1] = game.getgType();
        obj[2] = game.getgCompany();
        obj[3] = game.getgYear();
        int alter = JDBC.alter(sql, obj);
        return alter;
    }

    //删
    @Override
    public int delGame(Game game) {
        String sql = "DELETE FROM games WHERE gameId = ?";
        Object[] objects = new Object[1];
        objects[0] = game.getgId();
        int alter = JDBC.alter(sql, objects);
        return alter;
    }

    //改
    @Override
    public int altGame(Game game) {
        String sql = "UPDATE games SET gameName = ?, gameType = ?, gameCompany = ?, gameYear = ?\n" +
                "WHERE gameId = ?";
        Object[] obj = new Object[5];
        obj[0] = game.getgName();
        obj[1] = game.getgType();
        obj[2] = game.getgCompany();
        obj[3] = game.getgYear();
        obj[4] = game.getgId();
        int alter = JDBC.alter(sql, obj);
        return alter;
    }
}
