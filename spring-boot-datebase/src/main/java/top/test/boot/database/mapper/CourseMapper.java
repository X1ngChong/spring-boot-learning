package top.test.boot.database.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.test.boot.database.entity.Course;

import java.util.List;

@Mapper
public interface CourseMapper {
    /**
     * 查询所有课程（关联查询出每门课程的选课学生）
     * @return List<Course>
     */
    List<Course> selectAll();
}
