package models;


import com.avaje.ebean.Ebean;
import com.avaje.ebean.Transaction;
import play.*;
import play.mvc.*;
import play.data.*;
import play.data.format.*;
import models.User.*;
import models.ServiceProvider.*;
import models.Projects.*;
import models.ServiceUser.*;
import models.Rates.*;

import java.util.*;

public class dbHandle {
    private User t = new User();
    private ServiceProvider sp = new ServiceProvider();
    private Projects projects = new Projects();
    private ServiceUser su = new ServiceUser();

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

    public ServiceProvider getProviderInfo(String username){
      try{
          ServiceProvider spublications = sp.find.where().eq("username",username).findUnique();
        if(spublications == null) return null;
        return spublications;
      } catch (Exception e) {
        e.printStackTrace();
      }
      return null;
    }

    public Projects getProjectByPublisher(String username) {
        try{
            Projects project = projects.find.where().eq("publisher",username).findUnique();
            if(project == null) return null;
            return project;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Projects getProjectByProvider(String username) {
        try{
            Projects project = projects.find.where().eq("provider",username).findUnique();
            if(project == null) return null;
            return project;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Projects getProjectByStatus(String status) {
        try{
            Projects project = projects.find.where().eq("status",status).findUnique();
            if(project == null) return null;
            return project;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ServiceUser getServiceUserByName(String username) {
        try{
            ServiceUser serviceUser = su.find.where().eq("username",username).findUnique();
            if(serviceUser == null) return null;
            return serviceUser;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateProviderInfo(String username, String credential,String researchAreas, String publications, String professionalServices){
      try{

        if(sp.find.where().eq("username",username).findUnique()!=null){
            ServiceProvider spp= sp.find.where().eq("username",username).findUnique();
          spp.credential = credential;
          spp.researchAreas = researchAreas;
          spp.publications = publications;
          spp.professionalServices = professionalServices;
          spp.update();
        }
        else{
            ServiceProvider spp = new ServiceProvider();
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
