package com.batis.demo.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.batis.demo.util.CipherService;
import com.batis.demo.entity.BaseEntity;
import com.batis.demo.util.BeanEncryptUtil;
import com.batis.demo.util.EntityUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author ivy
 * @date 2021年09月02日 9:14
 */
public class BaseServiceImpl<M extends BaseMapper<T>,T extends BaseEntity> extends ServiceImpl<BaseMapper<T>, T>   {


    @Autowired
    CipherService cipherService;
    /**
     * 创建基础信息加密
     * @author ivy
     * @date 2021/9/2 10:17
     * [entity]
     * int
     */
    public int insert(T entity){
        //字段加密
        BeanEncryptUtil.encryptInfo(cipherService, entity);
        //创建基础信息
        EntityUtil.modifyCreateInfo(entity);
        int insert = baseMapper.insert(entity);
        return insert;
    }
    /**
     * 获取列表并解密
     * @author ivy
     * @date 2021/9/2 10:18
     * [queryWrapper]
     * java.util.List
     */
    public List<T> selectList(QueryWrapper queryWrapper){
        List list = baseMapper.selectList(queryWrapper);
        //解密
        list.forEach(i -> {
            BeanEncryptUtil.decryptInfo(cipherService, i);
        });
        return list;
    }
    /**
     * 获取解密对象
     * @author ivy
     * @date 2021/9/2 11:35
     * [wrapper]
     * T
     */
    public T myGetOne(Wrapper<T> wrapper){
        T one = getOne(wrapper);
        BeanEncryptUtil.decryptInfo(cipherService, one);
        return one;
    }
    /**
     * 批量保存
     * @author ivy
     * @date 2021/9/2 11:39
     * [lists]
     * boolean
     */
    public boolean  batchSave(List<T> lists){
        //加密创建基本信息
        lists.forEach(i -> {
            EntityUtil.modifyCreateInfo(i);
            BeanEncryptUtil.encryptInfo(cipherService, i);
        });
        boolean b = saveOrUpdateBatch(lists);
        return b;
    }
    /**
     * 更新
     * @author ivy
     * @date 2021/9/2 11:39
     * [t]
     * boolean
     */
    public boolean update (T t){
        BeanEncryptUtil.encryptInfo(cipherService, t);
        EntityUtil.modifyUpdateInfo(t);
        boolean b = updateById(t);
        return b ;
    }
}
