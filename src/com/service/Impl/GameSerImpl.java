package com.service.Impl;

import com.pojo.Game;
import com.service.GameSer;

import java.util.List;

import static com.util.Vessel.gameDao;

public class GameSerImpl implements GameSer {
    @Override
    public List<Game> queryGame() {
        return gameDao.queryGame();
    }

    @Override
    public int addGame(Game game) {

        return gameDao.addGame(game);
    }

    @Override
    public int delGame(Game game) {
        return gameDao.delGame(game);
    }

    @Override
    public int altGame(Game game) {
        return gameDao.altGame(game);
    }
}
