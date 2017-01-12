package com.dolphin.dao;

import com.dolphin.dao.essay.EssayDao;
import com.dolphin.dao.user.UserDao;
import com.dolphin.models.essay.Essay;
import com.dolphin.models.essay.Essay_db;
import com.dolphin.models.user.User_db;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

/**
 * Created by PieceBook on 2017/1/11.
 */
public class DaoTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        /*addUser(context);
        getUserByid(context);
        getUserByUid(context);*/
        //addEssay(context);
        //readEssayById(context);
        //readEssay(context);
        updateUser(context);
    }

    static void addUser(ApplicationContext context) {
        UserDao userDao = (UserDao) context.getBean("userDao");
        User_db user = new User_db();
        /*user.setUid("piecebook");
        user.setUser_name("PieceBook");
        user.setSex(false);
        user.setEmail("piecebook@163.com");*/
        /*user.setUid("xiaoming");
        user.setUser_name("小明");
        user.setSex(false);
        user.setEmail("xiaoming@qq.com");*/
        /*user.setUid("xiaohong");
        user.setUser_name("小红");
        user.setSex(true);
        user.setEmail("xiaohong@qq.com");*/
        /*user.setUid("lili");
        user.setUser_name("丽丽");
        user.setSex(true);
        user.setEmail("lili@163.com");*/
        user.setUid("gg");
        user.setUser_name("刚刚");
        user.setSex(false);
        user.setEmail("gg@qq.com");
        userDao.add(user);
        System.out.println(user.getId());
    }

    static void getUserByid(ApplicationContext context) {
        UserDao userDao = (UserDao) context.getBean("userDao");
        User_db user = userDao.getById(2L);
        System.out.println(user);
    }

    static void getUserByUid(ApplicationContext context) {
        UserDao userDao = (UserDao) context.getBean("userDao");
        User_db user = userDao.getByUid("piecebook");
        System.out.println(user);
    }

    static void updateUser(ApplicationContext context){
        UserDao userDao = (UserDao) context.getBean("userDao");
        User_db user = userDao.getById(3L);
        user.setEmail("newEmail@qq.com");
        userDao.update(user);
    }

    static void addEssay(ApplicationContext context) {
        EssayDao essayDao = (EssayDao) context.getBean("essayDao");
        Essay_db essay = new Essay_db();
        /*essay.setAuthor_id(1L);
        essay.setTitle("第一篇文章");
        essay.setCreate_time(new Date());
        essay.setText("正文第一篇");*/
        /*essay.setAuthor_id(2L);
        essay.setTitle("第二篇文章");
        essay.setCreate_time(new Date());
        essay.setText("正文第二篇");*/
        essay.setAuthor_id(3L);
        essay.setTitle("第三篇文章");
        essay.setCreate_time(new Date());
        essay.setText("正文第三篇");
        essayDao.add(essay);
        System.out.println(essay.getId());
    }

    static void readEssayById(ApplicationContext context) {
        EssayDao essayDao = (EssayDao) context.getBean("essayDao");
        Essay essay = essayDao.readById(2L);
        System.out.println(essay);
    }

    static void readEssay(ApplicationContext context){
        EssayDao essayDao = (EssayDao) context.getBean("essayDao");
        List<Essay> essays = essayDao.read(0L,2L);
        System.out.println(essays);
        System.out.println("end!!!");
        essays = essayDao.read(2L,2L);
        System.out.print(essays);
    }
}
