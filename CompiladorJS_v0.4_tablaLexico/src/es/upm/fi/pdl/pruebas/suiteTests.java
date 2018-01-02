package es.upm.fi.pdl.pruebas;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  
  PruebasUnitariasLexico.class,
  PruebasMultiplesTokens.class
})

public class suiteTests {
  // the class remains empty,
  // used only as a holder for the above annotations
}