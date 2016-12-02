package controllers;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Transaction;
import play.*;
import play.libs.Json;
import play.mvc.*;

import views.html.*;
import play.data.DynamicForm;
import play.data.Form;
import play.data.*;
import play.data.format.*;
import models.*;
import java.util.*;

import static play.libs.Json.toJson;

public class Application extends Controller {
    private dbHandle db = new dbHandle();
    public Result index() {
        db.saveUser("admin", "admin", "admin", "admin", "admin");
        return ok(index.render());
    }

    public Result getName() {
        return ok(index.render());
    }

    public Result loginSubmit() {

        DynamicForm form = Form.form().bindFromRequest();

        if (form.data().size() != 2) {
            return badRequest("Bad Login Request");
        } else {
            String userName = form.get("userName");
            String password = form.get("password");
            String dbPassword = db.getPassword(userName);
            if (password.equals(dbPassword)) {
                return ok("login Success");
            } else {
                return notFound("Invalid Login");
            }
        }
    }

    public Result registerUser() {
        DynamicForm form = Form.form().bindFromRequest();
        if (form.data().size() != 5) {
            System.out.println(form.data());
            return badRequest("Bad Register Request");
        } else {
            String userName = form.get("username");
            String password = form.get("password");
            String email = form.get("email");
            String question = form.get("question");
            String answer = form.get("answer");
            try {
                boolean register = db.saveUser(userName, password, email, question, answer);
                if (register) {
                    return ok("Register Success");
                } else {
                    return ok("User Exists");
                }
            } catch (Exception e) {
                e.printStackTrace();
                return badRequest("Bad Register Request");
            }

        }
    }

    public Result getUserInfo(String username) {
        User user = db.getUser(username);
        return user == null ? notFound() : ok(toJson(user));
    }

    public Result getBugs() {
        List<Bug> bugs = db.getBugs();
        return (bugs == null) ? notFound() : ok(toJson(bugs));
    }

    public Result reportBug() {
        DynamicForm form = Form.form().bindFromRequest();
        if (form.data().size() != 3) {
            System.out.println(form.data());
            return badRequest("Bad report Request");
        } else {
            String bugname = form.get("bugname");
            String description = form.get("description");
            String status = form.get("status");
            try {
                boolean report = db.saveBug(bugname, description, status);
                if (report) {
                    return ok("Report Success");
                } else {
                    return ok("Bug Exists");
                }
            } catch (Exception e) {
                e.printStackTrace();
                return badRequest("Bad Report Request");
            }

        }
    }

    public Result getProviderInfo(String username) {
        ServiceProvider provider = db.getProviderInfo(username);

        return (provider == null) ? notFound() : ok(toJson(provider));

    }

    public Result updateProviderInfo(String username) {
        DynamicForm form = Form.form().bindFromRequest();
        if (form.data().size() != 6) {
            System.out.println(form.data());
            return badRequest("Bad update length!");
        } else {
            String credential = form.get("credential");
            String researchAreas = form.get("researchAreas");
            String publications = form.get("publications");
            String professionalServices = form.get("professionalServices");

            String keyword = form.get("keyword");
            try {
                boolean register = db.updateProviderInfo(username, credential, researchAreas, publications, professionalServices, keyword);

                if (register) {
                    return ok("Update Success");
                } else {
                    return ok("Update Failure");
                }
            } catch (Exception e) {
                e.printStackTrace();
                return badRequest("Bad update Request");
            }
        }
    }

    public Result getServiceUsers() {
        List<ServiceUser> serviceUsers = db.getServiceUsers();
        return (serviceUsers == null) ? notFound() : ok(toJson(serviceUsers));
    }

    public Result updateServiceUser(String username) {
        DynamicForm form = Form.form().bindFromRequest();
        String keywords = form.get("keywords");
        try {
            boolean update = db.updateServiceUser(username, keywords);
            if (update) {
                return ok("Update Success");
            } else {
                return ok("Update Failure");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return badRequest("Bad update Request");
        }
    }

    public Result publishProject(String username) {
        DynamicForm form = Form.form().bindFromRequest();
        if (form.data().size() != 7) {
            System.out.println(form.data());
            return badRequest("Bad publish length!");
        } else {
            String projectName = form.get("projectName");
            String projectDescription = form.get("projectDescription");
            String requiredExpertise = form.get("requiredExpertise");
            String begintime = form.get("begintime");
            String endtime = form.get("endtime");
            String price = form.get("price");
            String status = form.get("status");
            try {
                boolean register = db.updateProjects(projectName, username,projectDescription, requiredExpertise, begintime, endtime, price, status);
                if (register) {
                    return ok("Create Success");
                } else {
                    return ok("Create Failure");
                }
            } catch (Exception e) {
                e.printStackTrace();
                return badRequest("Bad update Request");
            }
        }
    }

    public Result getProjects() {
        List<Projects> projects = db.getProject();
        return (projects == null) ? notFound() : ok(toJson(projects));
    }

    public Result deleteProject() {
        DynamicForm form = Form.form().bindFromRequest();
        String project = form.get("project");
        try {
            boolean delete = db.deleteProjectByName(project);
            if (delete) {
                return ok("Delete Success");
            } else {
                return ok("Delete Failure");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return badRequest("Bad delete Request");
        }
    }

    public Result getProjectByPublisher(String username) {

        List<Projects> project = db.getProjectByPublisher(username);
        return (project == null) ? notFound() : ok(toJson(project));
    }

    public Result getProjectByProvider(String username) {

        List<Projects> project = db.getProjectByProvider(username);
        return (project == null) ? notFound() : ok(toJson(project));
    }

    public Result getServiceUserByName(String username) {
        ServiceUser serviceUser = db.getServiceUserByName(username);
        return (serviceUser == null) ? notFound() : ok(toJson(serviceUser));
    }

    public Result getProjectByStatus(String status) {
        List<Projects> projects = db.getProjectByStatus(status);
        return (projects == null) ? notFound() : ok(toJson(projects));
    }

    public Result updateProjectProvider(String username) {
        DynamicForm form = Form.form().bindFromRequest();
        String project = form.get("project");
        try {
            boolean update = db.updateProjectProvider(username, project);
            if (update) {
                return ok("Update Success");
            } else {
                return ok("Update Failure");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return badRequest("Bad update Request");
        }
    }

    public Result updateProjectStatus(String status) {
        DynamicForm form = Form.form().bindFromRequest();
        String project = form.get("project");
        try {
            boolean update = db.updateProjectStatus(project, status);
            if (update) {
                return ok("Update Success");
            } else {
                return ok("Update Failure");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return badRequest("Bad update Request");
        }
    }

    public Result getRatingsByProject(String projectname) {
        Rates rating = db.getRatingsByProject(projectname);
        return (rating == null) ? notFound() : ok(toJson(rating));
    }

    public Result getAllProviders() {
        //List<ServiceProvider> sps = db.getProviders();
        List<List<String>> list = db.getALLProviders();
        return (list == null) ? notFound() : ok(toJson(list));
        // TODO: search
    }

    public Result updateRating() {
        DynamicForm form = Form.form().bindFromRequest();
        String project = form.get("project");
        String user = form.get("user");
        String provider = form.get("provider");
        String projectrate = form.get("projectrate");
        String providerrate = form.get("providerrate");
        String comment = form.get("comment");
        try {
            boolean update = db.updateRating(project, user, provider, Integer.parseInt(projectrate), Integer.parseInt(providerrate), comment);
            if (update) {
                return ok("Update Success");
            } else {
                return ok("Update Failure");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return badRequest("Bad update Request");
        }
    }

}
