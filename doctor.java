
package disease_analyzer;

/**
 *
 * @author User
 */
public class doctor extends admin {
    int doctor_id;
    doctor()
    {
        
    }
    doctor(int a,String b, String c, String d,String y,String x,String e,String f, String g){
        doctor_id = a;
        f_name = b;
        l_name = c;
        email = d;
        user_name = y;
        password = x;
        address = e;
        phone = f;
        age = g;
    }

    doctor(String a, String b,String c,String d,String e,String f){
        f_name = a;
        l_name = b;
        age = c;
        email = d;
        address = e;
        phone  = f;
    }
    

    
    public int get_doctor_id(){
        return doctor_id;
    }
    @Override
    public String get_first_name(){
        return f_name;
    }
    @Override
    public String get_last_name(){
        return l_name;
    }
    @Override
    public String get_email(){
        return email;
    }
    @Override
    public String get_user_name(){
        return user_name;
    }
    @Override
    public String get_password(){
        return password;
    }
    @Override
    public String get_address(){
        return address;
    }
    @Override
    public String get_phone_number(){
        return phone;
    }
    @Override
    public String get_age(){
        return age;
    }
}
