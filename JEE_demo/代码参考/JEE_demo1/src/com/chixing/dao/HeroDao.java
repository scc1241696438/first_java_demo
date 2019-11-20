package com.chixing.dao;

import com.chixing.pojo.Hero;

import java.util.List;

public interface HeroDao {
    /**
     * 添加一个新Hero
     * @param hero 新的hero对象
     * @return  返回是否添加成功，true表示添加成功，false表示添加失败
     */
    public boolean insert(Hero hero);

    /**
     * 修改hero对象信息
     * @param hero 要修改的hero对象
     * @return 返回是否修改成功，true表示修改成功，false表示修改失败
     */
    public boolean update(Hero hero);

    /**
     * 删除hero对象信息
     * @param hero 要删除的hero对象
     * @return 返回是否删除成功，true表示删除成功，false表示删除失败
     */
    public boolean delete(Hero hero);

    /**
     * 查询所有的hero信息
     * @return 返回所有的hero集合信息
     */
    public List<Hero> selectAll();

    /**
     * 根据主键查询hero信息
     * @param id hero的主键
     * @return 返回对应的hero对象
     */
    public List<Hero> selectByPrimaryKey(int id);
}
