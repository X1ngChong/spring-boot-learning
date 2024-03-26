package top.test.boot.database.entity;

import java.io.Serial;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

/**
 * @author mqxu
 * @TableName t_teacher
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Alias("Teacher")
public class Teacher implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 教师id
     */
    private Integer teacherId;

    /**
     * 教师姓名
     */
    private String teacherName;

    /**
     * 教师管理的班级id
     */
    private Integer clazzId;

    /**
     * 教师管理的班级对象
     */
    private Clazz clazz;

    public String printInfo() {
        return this.teacherId + "," + this.teacherName;
    }
}
