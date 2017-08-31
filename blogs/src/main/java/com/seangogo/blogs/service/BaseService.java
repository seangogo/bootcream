package com.seangogo.blogs.service;

import java.io.Serializable;
import java.util.List;

/**
 * BaseService封装了基础接口crud增删改查和page分页接口等
 * Repository作为底层接口最好不要直接在front或Controller里使用
 * list对于数据较少的表可以全部列出数据，比如Category等信息全部读出并缓存。
 * collect用于分页多次读取数据，比如有10万条记录，其中1万条需要处理，
 * 可以每页读取100条分10次读取，可能内存消耗还是比较大，
 * 后面的ServiceUtil.iterator支持在page接口的基础上依次处理每一条数据
 */
public interface BaseService<Entity> {
    /**
     * 保存对象
     *
     * @param obj 所要保存的对象
     * @return 唯一主键
     */
    <T> Serializable save(T obj);

    /**
     * 删除对象
     *
     * @param obj 所要删除的对象
     */
    <T> void delete(T obj);

    /**
     * 修改对象
     *
     * @param obj 所要修改的对象
     */
    <T> void update(T obj);

    /**
     * 保存或修改
     *
     * @param obj 所要修改的对象
     */
    Object saveOrUpdate(Object obj);

    /**
     * 批量保存
     */
    <T> void batchSave(List<T> entityList);

    /**
     * 批量更新
     */
    <T> void batchUpdate(List<T> entityList);

    /**
     * 批量删除
     */
    <T> void batchDelete(List<T> entityList);

}
