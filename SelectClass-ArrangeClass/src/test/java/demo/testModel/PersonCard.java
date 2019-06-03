package demo.testModel;

import com.hzs.model.Card;
import com.hzs.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author hezhensheng
 * @version 1.0
 * @description 测试一对一关系
 * @date 2019/5/30 9:00
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring.xml")
public class PersonCard {

    @Autowired
    private SessionFactory sessionFactory;

    @Test
    public void test1(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Card card = session.get(Card.class,1);

        System.out.println(card.getPerson());
        session.getTransaction().commit();

        session.close();

    }

}
