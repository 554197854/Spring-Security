package com.springboot.security.dao;

import com.springboot.security.bean.Menu;
import com.springboot.security.bean.MenuExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface MenuMapper {
    List<Menu> getAllMenu();

    int countByExample(MenuExample example);

    int deleteByExample(MenuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    List<Menu> selectByExample(MenuExample example);

    Menu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Menu record, @Param("example") MenuExample example);

    int updateByExample(@Param("record") Menu record, @Param("example") MenuExample example);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
}