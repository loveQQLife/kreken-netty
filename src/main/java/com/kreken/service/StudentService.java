package com.kreken.service;


import com.kreken.annotation.Cmd;
import com.kreken.annotation.Module;
import com.kreken.constants.ConstantCmd;
import com.kreken.constants.ConstantModule;

@Module(moduleId = ConstantModule.STUDENT)
public interface StudentService {

    @Cmd(cmdId = ConstantCmd.ADD)
    public void add(String name);
}
