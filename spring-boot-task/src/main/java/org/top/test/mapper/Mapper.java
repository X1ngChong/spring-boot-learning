package org.top.test.mapper;


import org.top.test.entity.CronTriggers;

import java.util.List;

/**
 * @author JXS
 */
@org.apache.ibatis.annotations.Mapper
public interface Mapper {

     List<CronTriggers> findAll();

}
