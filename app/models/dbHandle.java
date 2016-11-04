package models;


import com.avaje.ebean.Ebean;
import com.avaje.ebean.Transaction;
import play.*;
import play.mvc.*;
import play.data.*;
import play.data.format.*;
import models.User.*;
import java.util.*;

public class dbHandle {
    private User t = new User();
    public List<User> all(){
      return t.find.where().findList();
    }  

    public User get(Long id){
      return t.find.where().eq("id", id).findUnique();
    }

    public User getUser(String name){
      return t.find.where().eq("name",name).findUnique();
    }

    public String getPassword(String name){
      try{
        User user = t.find.where().eq("name",name).findUnique();
        if(user==null) return null;
        return user.password;
      }catch(Exception e){
        e.printStackTrace();
      }
      return null;
    }
    public boolean saveUser(String name,String password,String email,String secureQuestion, String secureAnswer){
      try{
        if(t.find.where().eq("name",name).findUnique()!=null) return false;
        User user = new User();
        user.name = name;
        user.password = password;
        user.email = email;
        user.secureQuestion = secureQuestion;
        user.secureAnswer = secureAnswer;
        user.save();
        return true;
      }catch(Exception e){
         e.printStackTrace();
      }
      return false;
    }

    public User save(User obj){
      if(obj.id != null){
        obj.update();
      }else{
        obj.save();
      }
      return obj;
    }

    public void delete(Long id){
      t.find.byId(id).delete();
    }


}
