package cn.lvhaosir.common.base;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by lvhaosir on 2018/4/12.
 */
public interface BaseService<T> {

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<T> queryPageList(Integer pageNum, Integer pageSize);

    /**
     * 条件分页查询
     * @param pageNum
     * @param pageSize
     * @param model
     * @return
     */
    PageInfo<T> queryPageList(Integer pageNum, Integer pageSize, T model);

    /**
     * 查询全部
     * @return
     */
    List<T> queryAllList();

    /**
     * 带有条件参数的查询
     * @param model
     * @return
     */
    List<T> queryParamList(T model);

    /**
     * 查询单个实体类
     * @param id
     * @return
     */
    T loadById(Object id);

    /**
     * 带有条件参数单个实体类的查询
     * @param model
     * @return
     */
    T loadByParam(T model);


    /**
     * 根据实体中的数据查询总数
     * @param model
     * @return
     */
    Integer queryCount(T model);

    /**
     * 保存一个实体，null属性也会被保存,不会使用数据库默认值
     * @param model
     * @return
     */
    Integer save(T model);

    /**
     * 保存一个实体，null属性不会被保存,会使用数据库默认值
     * @param model
     * @return
     */
    Integer saveNoNull(T model);

    /**
     * 根据实体属性作为条件进行删除
     * @param model
     * @return
     */
    Integer deleteByParam(T model);

    /**
     * 根据主键字段进行删除
     * @param id
     * @return
     */
    Integer delete(Object id);

    /**
     * 根据主键更新实体全部字段，null 值也会被更新
     * @param model
     * @return
     */
    Integer update(T model);


    /**
     * 根据主键更新属性不为null的值
     * @param model
     * @return
     */
    Integer updateNoNull(T model);

    // 批量

    /**
     * 批量添加
     * @param list
     * @return
     */
    Integer saveList(List<T> list);

    /**
     * 根据主键字符串进行批量删除，类中只能存在一个带有@Id注解的字段
     * @param ids
     * @return
     */
    Integer deleteByIds(String ids);

    /**
     * ids批量查询，类中只有存在一个带有@Id注解的字段
     * @param ids
     * @return
     */
    List<T> queryByIds(String ids);

    /**
     * 批量更新
     * @param list
     * @return
     */
    Integer updateList(List<T> list);

}
