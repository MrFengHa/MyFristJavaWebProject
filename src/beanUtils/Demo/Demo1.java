package beanUtils.Demo;

import beanUtils.domain.Person;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class Demo1 {
    public static void main(String[] args) throws Exception{
        fun2();
    }

    /**
     * 将map属性直接封装到一个bean中
     */
    private static void fun2() throws Exception{
        Map<String,String> map = new HashMap<String, String>();
        map.put("name","冯根源");
        map.put("age","22");
        map.put("gender","男");
        Person person = new Person();
        BeanUtils.populate(person,map);

    }

    static void fun1() throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        String className = "beanUtils.domain.Person";
        Class personClass = Class.forName(className);
        Object personBean = personClass.newInstance();
        BeanUtils.setProperty(personBean,"name","张三");
        BeanUtils.setProperty(personBean,"age","23");
        BeanUtils.setProperty(personBean,"gender","男");

        System.out.println();
    }


}
