package org.top.test.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class Address implements Serializable {
    private String location;
    private String name;
}
