package com.service;

import com.pojo.Game;

import java.util.List;

public interface GameSer {
    //查
    public List<Game> queryGame();

    //增
    public int addGame(Game game);

    // 删
    public int delGame(Game game);

    // 改
    public int altGame(Game game);
}
