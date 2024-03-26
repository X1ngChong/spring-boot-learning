package top.test.boot.database.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.test.boot.database.entity.Clazz;

/**
 * @author mqxu
 * @description ClazzMapper
 **/
@Mapper
public interface ClazzMapper {
    /**
     * 根据班级id查询班级信息
     *
     * @param clazzId 班级id
     * @return 班级信息
     */
    Clazz getClazzOneToMany(int clazzId);

    Clazz getClazz(int clazzId);
}