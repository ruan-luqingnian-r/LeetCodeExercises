import java.util.Date;
import java.util.HashMap;
import java.util.Objects;

/**
 * @Author: ruan
 * Date: 2021/9/22 18:36
 * @Description:
 */
public class Test01 {
    public static void main(String[] args) {



    }
}
class User{
    private int age;
    private String name;
    private Date time;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age,name,time);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }
        User user = (User) obj;
        return age == user.age && Objects.equals(name,user.name) && Objects.equals(time,user.time);
    }
}