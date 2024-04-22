package org.top.test.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author JXS
 */
@Data
@Builder
public class UserDto {
    private String phone;
    private String code;
}
