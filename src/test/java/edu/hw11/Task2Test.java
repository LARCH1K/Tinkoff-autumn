package edu.hw11;

import edu.hw11.task2.ArithmeticUtils;
import edu.hw11.task2.ArithmeticUtilsInterceptor;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;
import net.bytebuddy.implementation.MethodDelegation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static net.bytebuddy.matcher.ElementMatchers.named;

public class Task2Test {

    @Test
    void task2Test() {
        ByteBuddyAgent.install();
        new ByteBuddy()
            .redefine(ArithmeticUtils.class)
            .method(named("sum"))
            .intercept(MethodDelegation.to(ArithmeticUtilsInterceptor.class))
            .make()
            .load(ArithmeticUtils.class.getClassLoader(), ClassReloadingStrategy.fromInstalledAgent());

        Assertions.assertEquals(12, ArithmeticUtils.sum(3, 4));
        Assertions.assertEquals(24, ArithmeticUtils.sum(3, 8));
        Assertions.assertEquals(36, ArithmeticUtils.sum(9, 4));
    }
}
