package com.test.senha;

import org.jsmart.zerocode.core.domain.LoadWith;
import org.jsmart.zerocode.core.domain.TestMapping;
import org.jsmart.zerocode.core.runner.parallel.ZeroCodeMultiLoadRunner;
import org.junit.runner.RunWith;

/**
 *
 * @author Clayton
 */

@LoadWith("load_config.properties")
@TestMapping(testClass = ValidadorSenhaTest.class, testMethod = "senha2Test")
//@RunWith(ZeroCodeLoadRunner.class)
@RunWith(ZeroCodeMultiLoadRunner.class)
public class CargaValidadorSenhaTest {
  
}
