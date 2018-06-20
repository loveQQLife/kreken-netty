package com.kreken.service.impl;

import com.kreken.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class StudentServiceImpl implements StudentService {

    private static  final Logger log = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Override
    public void add(String name) {
        log.info("this is add operation ,name = "+ name);
    }
}
