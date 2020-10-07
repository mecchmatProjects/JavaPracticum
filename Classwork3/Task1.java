package Classwork3;
//OOP task1
class Student{
    public int id;
    public String name;
    public String surname;
    public String fathers;
    public String birthday;
    public String adress;
    public String telephone;
    public String facultet;
    public String curs;
    public String group;
    public Student(int id,String name,String surname,String fathers,String birthday,String adress,String telephone,String facultet,String curs,String group){
        this.id=id;
        this.name=name;
        this.surname=surname;
        this.fathers=fathers;
        this.birthday=birthday;
        this.adress=adress;
        this.telephone=telephone;
        this.facultet=facultet;
        this.curs=curs;
        this.group=group;
    }

    public int getYearFromString() {
        String[] dateArr = getBirthday().split("\\.");
        return Integer.parseInt(dateArr[2]);
    }

    public int getDayFromString() {
        String[] dateArr = getBirthday().split("\\.");
        return Integer.parseInt(dateArr[0]);
    }

    public int getMonthFromString() {
        String[] dateArr = getBirthday().split("\\.");
        return Integer.parseInt(dateArr[1]);
    }

    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }

    public String getFathers(){
        return fathers;
    }

    public String getAdress(){
        return adress;
    }

    public String getTelephone(){
        return telephone;
    }

    public String getFacultet(){
        return facultet;
    }

    public String getCurs(){
        return curs;
    }

    public String getGroup(){
        return group;
    }

    public int getId(){
        return id;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setId(int newid){
        this.id = newid;
    }

    public void setName(String newname){
        this.name=newname;
    }

    public void setSurname(String newsurname){
        this.surname=newsurname;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setFathers(String fathers){
        this.fathers=fathers;
    }

    public void setBirthday(String birthday){
        this.birthday=birthday;
    }

    public void setTelephone(String telephone){
        this.telephone=telephone;
    }

    public void setFacultet(String facultet){
        this.facultet=facultet;
    }

    public void setCurs(String curs){
        this.curs = curs;
    }

    public void setGroup(String group){
        this.group=group;
    }

    public String toString(){
        String info = "Student ID" +  getId()+"\n";
        info+= getSurname()+" "+ getName()+" "+getFathers()+"\n";
        info+="Birthday: day "+ getDayFromString()+", month "+getMonthFromString()+", year "+getYearFromString()+"\n";
        info +="Adress "+ getAdress()+", telephone "+getTelephone()+"\n";
        info+="Faculty "+getFacultet()+", curs "+getCurs()+", group "+getGroup();
        return info;
    }

    public void Faculty(String newfac){
        if(newfac==getFacultet()){
            System.out.println(toString());
        }
    }

    public void Curses(String newfac, String newcurs){
        if(newfac==getFacultet()&&newcurs==getCurs()){
            System.out.println(toString());
        }
    }

    public void checkYear(int check){
        if(check< getYearFromString()){
            System.out.println(toString());
        }
    }

    public void checkGroups(String newfac, String newcurs,String newgroup){
        if(newfac==getFacultet()&&newcurs==getCurs()&&newgroup==getGroup()){
            System.out.println(toString());
        }
    }
}


public class Task1 {
    public static void main(String[] args) {
        Student[] students = new Student[6];
        students[0] = new Student(344445,"Kiril", "Mitroshin","Ivanovich","12.3.2002","Kilova22","3809999","MMF","2","Kompmath");
        students[1] = new Student(346745,"Dima", "Kil","Ivanovich","13.4.2001","Iva2","3888999","MMF","3","Kompmath");
        students[2] = new Student(348845,"Katya", "Nilya","Ivanovna","14.8.2001","Lik5","380095","MMF","3","Kompmath");
        students[3] = new Student(444445,"Mitya", "Danilov","Maximovich","14.5.2002","Pol7","355999","FIT","3","Information");
        students[4] = new Student(348845,"Katya", "Ksiva","Kirilovna","14.6.2001","Lik5","380095","MMF","3","Math");
        students[5] = new Student(348945,"Ira", "Mitina","Aleksandrovna","14.8.2002","Pack5","380085","MMF","2","Math");
        System.out.println("Students of MMF: ");
        for(int i = 0;i<6;i++){
            students[i].Faculty("MMF");
        }
        System.out.println("\n\n");
        System.out.println("Students of MMF on 3 curs: ");
        for(int i = 0;i<6;i++){
            students[i].Curses("MMF","3");
        }
        System.out.println("\n\n");
        System.out.println("Students born after 2001: ");
        for(int i = 0;i<6;i++){
            students[i].checkYear(2001);
        }
        System.out.println("\n\n");
        System.out.println("Students of MMf, 3 curs, Kompmath: ");
        for(int i = 0;i<6;i++){
            students[i].checkGroups("MMF","3","Kompmath");
        }
    }
}
