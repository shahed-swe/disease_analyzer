package disease_analyzer;

/**
 *
 * @author User
 */
public class admin {

    int admin_id;
    String f_name;
    String l_name;
    String email;
    String user_name;
    String password;
    String age;
    String phone;
    String address;
    admin()
    {
        
    }
    admin(int a,String b, String c, String d,String y,String x,String e,String f, String g){
        admin_id = a;
        f_name = b;
        l_name = c;
        email = d;
        user_name = y;
        password = x;
        address = e;
        phone = f;
        age = g;
    }

    public int get_admin_id(){
        return admin_id;
    }
    public String get_first_name(){
        return f_name;
    }
    public String get_last_name(){
        return l_name;
    }
    public String get_email(){
        return email;
    }
    public String get_user_name(){
        return user_name;
    }
    public String get_password(){
        return password;
    }
    public String get_address(){
        return address;
    }
    public String get_phone_number(){
        return phone;
    }
    public String get_age(){
        return age;
    }
}
