package top.test.boot.database.mapper;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.test.boot.database.entity.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class StudentMapperTest {
    @Resource
    private StudentMapper studentMapper;

    @Test
    void insert() {
        Student student = Student.builder().clazzId(1).studentName("测试学生4").hometown("江苏南京").birthday(LocalDate.now()).build();
        int n = studentMapper.insert(student);
        assertEquals(1, n);
    }

    @Test
    void findStudentById() {
        Student student = studentMapper.findStudentById(1001);
        assertEquals("新的名字", student.getStudentName());
    }

    @Test
    void updateById() {
        Student student = Student.builder().studentId(1001).studentName("新的名字").build();
        int n = studentMapper.updateById(student);
        assertEquals(1, n);
    }

    @Test
    void deleteById() {
        int n = studentMapper.deleteById(1008);
        assertEquals(1, n);
    }

    @Test
    void batchInsert() {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Student student = Student.builder()
                    .studentId(8200 + i)
                    .clazzId(1)
                    .studentName("测试学生321" + i)
                    .hometown("江苏南京")
                    .birthday(LocalDate.now())
                    .build();
            students.add(student);
        }
        int n = studentMapper.batchInsert(students);
        assertEquals(10, n);
    }

    @Test
    void batchDelete() {
        List<Integer> idList = List.of(8000, 8001, 8002);
        int n = studentMapper.batchDelete(idList);
        assertEquals(3, n);
    }

    @Test
    void batchUpdate() {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Student student = Student.builder()
                    .studentId(8100 + i)
                    .clazzId(1)
                    .studentName("测试学生第四次更新" + i)
                    .hometown("江苏南京")
                    .birthday(LocalDate.now())
                    .build();
            students.add(student);
        }
        int n = studentMapper.batchUpdate(students);
        assertEquals(1, n);
    }

    @Test
    void selectByDynamicSql() {
        Student student = Student.builder().hometown("州").build();
        List<Student> students = studentMapper.selectByDynamicSql(student);
        students.forEach(System.out::println);
    }

    /**
     * 多对一  多个学生对应一个班级
     */
    @Test
    void getStudentManyToOne() {
        Student student = studentMapper.getStudentManyToOne(1001);
        log.info(String.valueOf(student));
    }
    @Test
    void getStudent() {
        Student student = studentMapper.getStudent(1001);
        log.info(String.valueOf(student));
    }
}