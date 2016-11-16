package models;


import com.avaje.ebean.Ebean;
import com.avaje.ebean.Transaction;
import play.*;
import play.mvc.*;
import play.data.*;
import play.data.format.*;
import models.User.*;
import models.ServicePublications.*;
import java.util.*;

public class dbHandle {
    private User t = new User();
    private ServicePublications sp = new ServicePublications();
    private Projects projects = new Projects();

    public User get(Long id) {
        return t.find.where().eq("id", id).findUnique();
    }

    public User getUser(String name){
      return t.find.where().eq("name",name).findUnique();
    }

    public String getPassword(String name) {
        try {
            User user = t.find.where().eq("name", name).findUnique();
            if (user == null) return null;
            return user.password;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean saveUser(String name, String password, String email, String secureQuestion, String secureAnswer) {
        try {
            if (t.find.where().eq("name", name).findUnique() != null) return false;
            User user = new User();
            user.name = name;
            user.password = password;
            user.email = email;
            user.secureQuestion = secureQuestion;
            user.secureAnswer = secureAnswer;
            user.save();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

   /* public User save(User obj){
      if(obj.id != null){
        obj.update();
      }else{
        obj.save();
      }
      return obj;
    }*/
/*
    public void delete(Long id){
      t.find.byId(id).delete();
    }*/

    public ServicePublications getProviderInfo(String username){
      try{
        ServicePublications spublications = sp.find.where().eq("username",username).findUnique();
        if(spublications == null) return null;
        return spublications;
      } catch (Exception e) {
        e.printStackTrace();
      }
      return null;
    }
    public boolean updateProviderInfo(String username, String credential,String researchAreas, String publications, String professionalServices){
      try{

        if(sp.find.where().eq("username",username).findUnique()!=null){
          ServicePublications spp= sp.find.where().eq("username",username).findUnique();
          spp.credential = credential;
          spp.researchAreas = researchAreas;
          spp.publications = publications;
          spp.professionalServices = professionalServices;
          spp.update();
        }
        else{
          ServicePublications spp = new ServicePublications();
          spp.username = username;
          spp.credential = credential;
          spp.researchAreas = researchAreas;
          spp.publications = publications;
          spp.professionalServices = professionalServices;
          spp.save();
        }

        return true;
      }catch(Exception e){
         e.printStackTrace();
      }
      return false;
    }



    public boolean updateProjects(String projectName, String username, String projectDescription, String requiredExpertise, String begintime, String endtime, String price, String status){
      try{

        if(projects.find.where().eq("projectName",projectName).eq("publisher",username).findUnique()!=null){
          Projects proj= projects.find.where().eq("projectName",projectName).eq("username",username).findUnique();
          proj.projectName = projectName;
          proj.publisher = username;
          proj.status = status;
          proj.projectDescription = projectDescription;
          proj.requiredExpertise = requiredExpertise;
          proj.begintime = begintime;
          proj.endtime = endtime;
          proj.price = price;
          proj.update();
        }
        else{
          Projects proj = new Projects();
          proj.projectName = projectName;
          proj.publisher = username;
          proj.status = status;
          proj.projectDescription = projectDescription;
          proj.requiredExpertise = requiredExpertise;
          proj.begintime = begintime;
          proj.endtime = endtime;
          proj.price = price;
          proj.save();
        }

        return true;
      }catch(Exception e){
         e.printStackTrace();
      }
      return false;
    }

    public List<Projects> getProject(){
      try{
        List<Projects> proj = projects.find.all();
        if(proj == null) return null;
        return proj;
      } catch (Exception e) {
        e.printStackTrace();
      }
      return null;
    }

}
