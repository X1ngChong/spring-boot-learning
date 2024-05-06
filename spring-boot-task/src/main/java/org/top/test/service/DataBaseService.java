package org.top.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.top.test.entity.CronTriggers;
import org.top.test.mapper.Mapper;

import java.util.List;

/**
 * @author JXS
 */
@Service
public class DataBaseService{

    @Autowired
    Mapper mapper;

   public List<CronTriggers> selAllData(){
     return  mapper.findAll();
    }
}
