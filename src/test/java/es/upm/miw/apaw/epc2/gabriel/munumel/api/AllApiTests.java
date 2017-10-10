package es.upm.miw.apaw.epc2.gabriel.munumel.api;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import es.upm.miw.apaw.epc2.gabriel.munumel.api.controllers.AllApiControllersTests;
import es.upm.miw.apaw.epc2.gabriel.munumel.api.daos.memory.AllApiDaosMemoryTests;
import es.upm.miw.apaw.epc2.gabriel.munumel.api.entities.AllApiEntitiesTests;

@RunWith(Suite.class)
@SuiteClasses({
	AllApiControllersTests.class,
	AllApiDaosMemoryTests.class,
	AllApiEntitiesTests.class
})
public class AllApiTests {

}
