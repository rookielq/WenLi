package cn.lvhaosir.base.impl;


import cn.lvhaosir.base.BaseMapper;
import cn.lvhaosir.base.BaseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by lvhaosir on 2018/4/12.
 */
public class BaseServiceImpl<T> implements BaseService<T> {

    @Autowired
    private BaseMapper baseMapper;

    @Override
    public PageInfo<T> queryPageList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<T> list = baseMapper.selectAll();
        return new PageInfo<T>(list);
    }

    @Override
    public PageInfo<T> queryPageList(Integer pageNum, Integer pageSize, T model) {
        PageHelper.startPage(pageNum,pageSize);
        List<T> select = baseMapper.select(model);
        return new PageInfo<T>(select);
    }

    @Override
    public List<T> queryAllList() {
        return baseMapper.selectAll();
    }

    @Override
    public List<T> queryParamList(T model) {
        return baseMapper.select(model);
    }

    @Override
    public T loadById(Object id) {
        return (T)baseMapper.selectByPrimaryKey(id);
    }

    @Override
    public T loadByParam(T model) {
        return (T)baseMapper.selectOne(model);
    }

    @Override
    public Integer queryCount(T model) {
        return baseMapper.selectCount(model);
    }

    @Override
    public Integer save(T model) {
        return baseMapper.insert(model);
    }

    @Override
    public Integer saveNoNull(T model) {
        return baseMapper.insertSelective(model);
    }

    @Override
    public Integer deleteByParam(T model) {
        return baseMapper.delete(model);
    }

    @Override
    public Integer delete(Object id) {
        return baseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer update(T model) {
        return baseMapper.updateByPrimaryKey(model);
    }

    @Override
    public Integer updateNoNull(T model) {
        return baseMapper.updateByPrimaryKeySelective(model);
    }

    @Override
    public Integer saveList(List<T> list) {
        return baseMapper.insertList(list);
    }

    @Override
    public Integer deleteByIds(String ids) {
        return baseMapper.deleteByIds(ids);
    }

    @Override
    public List<T> queryByIds(String ids) {
        return baseMapper.selectByIds(ids);
    }

    @Override
    public Integer updateList(List<T> list) {
        Integer count = null;
        for (T t : list) {
            Integer integer = updateNoNull(t);
            count=count+integer;
        }
        return count;
    }
}
