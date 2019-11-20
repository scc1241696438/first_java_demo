import com.chixing.dao.CustomerDao;
import com.chixing.dao.CustomerDaoImpl;
import com.chixing.dao.HeroDao;
import com.chixing.dao.HeroDaoImpl;
import com.chixing.pojo.Customer;
import com.chixing.pojo.Hero;
import org.junit.Test;

import java.util.List;

public class TestHeroDao {

    @Test
    public  void testSelectAllHero(){
        HeroDao dao = new HeroDaoImpl();
       List<Hero> heroList =   dao.selectAll();
       for(Hero hero:heroList){
           System.out.println(hero);
       }
    }


    @Test
    public  void testSelectCustomer(){
        CustomerDao dao = new CustomerDaoImpl();
        Customer customer =   dao.selectByCustNameAndPwd("张明","abc123");

            System.out.println(customer);

    }


}
