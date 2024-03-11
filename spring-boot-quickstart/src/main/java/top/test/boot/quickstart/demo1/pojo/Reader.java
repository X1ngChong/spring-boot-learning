package top.test.boot.quickstart.demo1.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author JXS
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reader implements Serializable {
    private String name;
    private Integer age;
}
