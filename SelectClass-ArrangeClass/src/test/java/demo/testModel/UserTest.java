package demo.testModel;

/**
 * @author hezhensheng
 * @version 1.0
 * @description User
 * @date 2019/6/7 15:36
 */

public class UserTest {
    public int id;
    public String name;

    public UserTest() {
    }

    public UserTest(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserTest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

//    @Override
//    public boolean equals(Object anObject) {
//        if (this == anObject) {
//            return true;
//        }
//        if (anObject instanceof UserTest) {
//            UserTest obj = (UserTest)anObject;
//            if (this.id == obj.id && this.name.equals(obj.name)) {
//                return true;
//            }
//        }
//        return false;
//    }
}
