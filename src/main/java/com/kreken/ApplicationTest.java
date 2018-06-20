package com.kreken;

import com.kreken.constants.ConstantCmd;
import com.kreken.constants.ConstantModule;
import com.kreken.handler.InvokerHandler;
import com.kreken.handler.InvokerHandlerManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Test
    public void TestSpringNetty(){
        InvokerHandler invoker1 = InvokerHandlerManager.getInvoker(ConstantModule.STUDENT, ConstantCmd.ADD);
        invoker1.invoke("xy1");
    }
}
