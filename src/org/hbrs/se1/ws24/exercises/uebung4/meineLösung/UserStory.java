package org.hbrs.se1.ws24.exercises.uebung4.meineLösung;

import java.io.Serializable;

public class UserStory implements Comparable<UserStory>, Serializable {
    String title;
    int id = 0;
    double priority = 0;
    String project;
    String acceptance;

    public UserStory(int id, String title, String acceptance, String project, double mehrwert, double strafe, double aufwand, double risiko){
        this.id = id;
        this.title = title;
        setPriority(mehrwert,strafe,aufwand,risiko);
        this.acceptance = acceptance;
        this.project = project;
    }
    public void setProject(String project){
        this.project = project;
    }
    public String getProject() {
        return project;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public double getPriority() {
        return priority;
    }
    public void setPriority(double mehrwert, double strafe, double aufwand, double risiko) {
        if(mehrwert < 0 | strafe < 0 | aufwand < 0 | risiko < 0)
            throw new NumberFormatException("negative Zahlen nicht erlaubt");
        this.priority = (mehrwert + strafe)/(aufwand + risiko);
    }

    public String getAcceptance() {
        return acceptance;
    }
    public void setAcceptance(String acceptance) {
        this.acceptance = acceptance;
    }

    @Override
    public int compareTo(UserStory o) {
        return Double.compare(o.priority, this.priority);
    }
    @Override
    public String toString() {
        return "UserStory{" +
                "ID=" + id +
                ", Title='" + title + '\'' +
                ", Priority=" + priority +
                ", Acceptance='" + acceptance + '\'' +
                ", Project='" + project + '\'' +
                '}';
    }
}
