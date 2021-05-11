package io.danielpine.github.spring;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class SpringXmlBeanTest {

    private final Log logger = LogFactory.getLog(getClass());

    @Test
    public void xmlBeanFactoryTest() {
        logger.info("Starting..");
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("spring-config.xml"));
        TestBean myTestBean = (TestBean) bf.getBean("testBean");
        logger.info(myTestBean.getName());
    }

    @Test
    public void xmlBeanFactoryTest2() {
        logger.info("Starting..");
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
        xmlBeanDefinitionReader.loadBeanDefinitions(new ClassPathResource("spring-config.xml"));
        TestBean myTestBean = (TestBean) defaultListableBeanFactory.getBean("testBean");
        logger.info(myTestBean.getName());
    }

}
