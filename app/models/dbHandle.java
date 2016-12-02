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
    private Rates ra = new Rates();
    private Bug bg = new Bug();

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

    public List<Projects> getProjectByPublisher(String username) {
        try{
            List<Projects> project = projects.find.where().eq("publisher",username).findList();
            if(project == null) return null;
            return project;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Projects> getProjectByProvider(String username) {
        try{
            List<Projects> project = projects.find.where().eq("provider",username).findList();
            if(project == null) return null;
            return project;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Projects> getProjectByStatus(String status) {
        try{
            List<Projects> project = projects.find.where().eq("status",status).findList();
            if(project == null) return null;
            return project;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean deleteProjectByName(String projectName){
      try{
//        //projects.find.where().eq("projectName",projectName).findList();
//          Projects p=projects.find.where().eq("projectName",projectName).findUnique();
//          if(!p) return true;
//          projects.delete(p);
//          return true;
      }catch(Exception e){
          e.printStackTrace();
      }
      return false;
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



    public boolean updateProviderInfo(String username, String credential,String researchAreas, String publications, String professionalServices, String keyword){
      try{

        if(sp.find.where().eq("username",username).findUnique()!=null){
            ServiceProvider spp= sp.find.where().eq("username",username).findUnique();

            spp.credential = credential;
            spp.researchAreas = researchAreas;
            spp.publications = publications;
            spp.professionalServices = professionalServices;
            spp.keyword = keyword;
            spp.update();
        }
        else{
            ServiceProvider spp = new ServiceProvider();
            spp.username = username;
            spp.credential = credential;
            spp.researchAreas = researchAreas;
            spp.publications = publications;
            spp.professionalServices = professionalServices;
            spp.keyword = keyword;
            spp.save();

        }

        return true;
      }catch(Exception e){
         e.printStackTrace();
      }
      return false;
    }

    public boolean updateServiceUser(String username, String keywords) {
        try{

            if(su.find.where().eq("username",username).findUnique()!=null){
                ServiceUser serviceUser= su.find.where().eq("username",username).findUnique();
                serviceUser.keywords = keywords;
                serviceUser.update();
            }
            else{
                ServiceUser serviceUser = new ServiceUser();
                serviceUser.username = username;
                serviceUser.keywords = keywords;
                serviceUser.save();
            }

            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateProjectProvider(String username, String project) {
        try {
            if (projects.find.where().eq("projectName", project).findUnique() != null) {
                Projects proj = projects.find.where().eq("projectName", project).findUnique();
                proj.provider = username;
                proj.status = "Pending";
                proj.update();
            } else {
                Projects proj = new Projects();
                proj.provider = username;
                proj.status = "Pending";
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateProjectStatus(String project, String status) {
        try {
            if (projects.find.where().eq("projectName", project).findUnique() != null) {
                Projects proj = projects.find.where().eq("projectName", project).findUnique();
                proj.status = status;
                proj.update();
            } else {
                Projects proj = new Projects();
                proj.projectName = project;
                proj.status = status;
            }
            return true;
        } catch (Exception e) {
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

    public boolean updateRating(String project, String user, String provider, int projectrate, int providerrate, String comment) {
        try{

            if(ra.find.where().eq("project",project).eq("user",user).findUnique()!=null){
                Rates rating= ra.find.where().eq("project",project).eq("user",user).findUnique();
                rating.project = project;
                rating.user = user;
                rating.provider = provider;
                rating.projectrate = projectrate;
                rating.providerrate = providerrate;
                rating.comment = comment;
                rating.update();
            }
            else{
                Rates rating = new Rates();
                rating.project = project;
                rating.user = user;
                rating.provider = provider;
                rating.projectrate = projectrate;
                rating.providerrate = providerrate;
                rating.comment = comment;
                rating.save();
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

    public List<Bug> getBugs() {
        try{
            List<Bug> bugs = bg.find.all();
            if(bugs == null) return null;
            return bugs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean saveBug(String bugname, String description, String status) {
        try {
            if (bg.find.where().eq("bugname", bugname).findUnique() != null) return false;
            Bug bug = new Bug();
            bug.bugname = bugname;
            bug.description = description;
            bug.status = status;
            bug.save();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<ServiceProvider> getProviders() {
        try{
            List<ServiceProvider> spp = sp.find.all();
            if(spp == null) return null;
            return spp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Rates getRatingsByProject(String project) {
        try{
            Rates rating = ra.find.where().eq("project",project).findUnique();
            if(rating == null) return null;
            return rating;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
