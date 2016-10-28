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
