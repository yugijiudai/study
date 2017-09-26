<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.${subpackage}.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import ${basepackage}.${subpackage}.model.${className};

import framework.generic.dao.Order;
import framework.generic.dao.Page;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/generic-dao.xml", "/generic-dao-mybatis.xml", "/app.xml" })
@Transactional
public class ${className}DaoTest {

	@Resource
	private ApplicationContext appplicationContext;

	@Resource
	private ${className}Dao ${classNameLower}Dao;

	@Before
	public void init() {
	}

	@After
	public void destory() {
	}

	@Test
	@Transactional
	public void test() {
		Assert.assertNotNull(${classNameLower}Dao);
		${className} ${classNameLower} = new ${className}();
		// TODO ${classNameLower}.setCode("test code");
		${classNameLower} = ${classNameLower}Dao.create(${classNameLower});
		Assert.assertNotNull(${classNameLower});

		List<${className}> ${classNameLower}List = ${classNameLower}Dao.read();
		Assert.assertNotNull(${classNameLower}List);
		Assert.assertTrue(${classNameLower}List.size() > 0);

		${classNameLower} = ${classNameLower}Dao.read(${classNameLower}.getId());
		Assert.assertNotNull(${classNameLower});

		String newValue = "test user update";
		// TODO ${classNameLower}.setClientCode(newValue);
		${classNameLower} = ${classNameLower}Dao.update(${classNameLower});
		${classNameLower} = ${classNameLower}Dao.read(${classNameLower}.getId());
		Assert.assertNotNull(${classNameLower});
		// TODO Assert.assertEquals(${classNameLower}.getClientCode(), newValue);

		${classNameLower}Dao.delete(${classNameLower});
		Assert.assertNotNull(${classNameLower});
		List<${className}> new${className}List = ${classNameLower}Dao.read();
		Assert.assertEquals(new${className}List.size() + 1, ${classNameLower}List.size());
	}
}
