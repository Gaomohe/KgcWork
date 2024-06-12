package com.util;

import com.dao.GameDao;
import com.dao.Impl.GameDaoImpl;
import com.dao.Impl.StuInfoDaoImpl;
import com.dao.StuInfoDao;
import com.service.GameSer;
import com.service.Impl.GameSerImpl;
import com.service.Impl.StuInfoSerImpl;
import com.service.StuInfoSer;

public class Vessel {
    public static GameDao gameDao = new GameDaoImpl();
    public static StuInfoDao stuInfoDao = new StuInfoDaoImpl();
    public static GameSer gameSer = new GameSerImpl();
    public static StuInfoSer stuInfoSer = new StuInfoSerImpl();
}
