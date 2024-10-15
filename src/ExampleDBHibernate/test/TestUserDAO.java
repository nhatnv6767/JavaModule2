package ExampleDBHibernate.test;

import ExampleDB.dao.UserDAO;
import ExampleDB.model.User;

import java.util.ArrayList;

public class TestUserDAO {
    public static void main(String[] args) {
        User u1 = new User("u1", "111111", "ho va ten 1");
//        UserDAO.getInstance().insert(u1);

        System.out.println("--------------------------------");
//        User u_find = new User("u1", "111111", "ho va ten 1");
//        User u_result = UserDAO.getInstance().selectById(u_find);
//        System.out.println(u_result);

        User u_find = new User("x\' or 1=1; -- ", "", "");
        User u_result = UserDAO.getInstance().selectById(u_find);
        System.out.println(u_result);

    }
}
