
package edu.chl.TBookWeb;

import edu.chl.tbook.core.Exercise;
import edu.chl.tbook.core.ExerciseCatalogue;
import edu.chl.tbook.core.IExerciseCatalogue;
import edu.chl.tbook.core.IUserCatalogue;
import edu.chl.tbook.core.IWorkoutCatalogue;
import edu.chl.tbook.core.TBook;
import edu.chl.tbook.core.Workout;
import java.util.ArrayList;  
import java.util.Calendar;
import java.util.List;  
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;  
import javax.faces.context.FacesContext;  
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.event.TransferEvent;  
import java.util.Date;  
  
import org.primefaces.model.DualListModel; 
   

@Named("add")
@RequestScoped  
public class AddBB {  
    private IExerciseCatalogue exCat = TBook.INSTANCE.getExerciseCatalogue(); 
    private IUserCatalogue userCat = TBook.INSTANCE.getUserCatalogue();
    private IWorkoutCatalogue workCat = TBook.INSTANCE.getWorkoutCatalogue();
    private DualListModel<String> exercises;
    private String name="";
    private Date date;
    
    FacesContext context = FacesContext.getCurrentInstance();
    HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();

    public AddBB() {

        List<String> exSource = new ArrayList<String>();
        List<String> exTarget = new ArrayList<String>();
        List<Exercise> exes = exCat.getAll();
        for (Exercise e : exes) {
            exSource.add(e.getEname());

        }

        exercises = new DualListModel<String>(exSource, exTarget);
    }

    public DualListModel<String> getExercises() {
        return exercises;
    }

    public void setExercises(DualListModel<String> exercises) {
        this.exercises = exercises;
    }

    public String action() {
        List<Exercise> ex = new ArrayList<Exercise>();
        List<String> etarget = exercises.getTarget();
        for (String e : etarget) {
            ex.add(exCat.find(e));
        }

        workCat.add(new Workout(userCat.find(request.getRemoteUser()), ex,
                name,
                date.getTime()));
        name = "";
        return "index?faces-redirect=true";

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
}
   

