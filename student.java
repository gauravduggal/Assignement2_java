import java.util.*;  //For adding ArrayList
public class student
{
  //Attributes
  public String name;
  public String degree;
  public String year;
  public String rollno;
  public ArrayList<course> courses;


  public student() {
     
   courses = new ArrayList<course>();
   this.name = new String();
   this.degree = new String();
   this.year = new String();
   this.rollno = new String();
   }
  /*public student(String name, String rollno, String degree, String year) {
     
   courses = new ArrayList<course>();
   this.name = name;
   this.degree = degree;
   this.year = year;
   this.rollno = rollno;
   }
*/
   public void set_name(String t)
   {
      this.name = t;
   } 
   public void set_degree(String t)
   {
      this.degree = t;
   }

   public void set_year(String t)
   {
      this.year = t;
   }


   public void set_rollno(String t)
   {
      this.rollno = t;
   }

   public void enroll(course c)
   { 
    boolean flag = false;
    for(int i=0;i<this.courses.size();i++)
    {
      if (courses.get(i).name.equals(c.name))
        {

          flag = true;
          break;
        }
     
    }
    if(flag==false)
    {
    if(c.eligibility_check(this))
      {
        if (c.slist.size()< c.max_stud)
        {
          this.courses.add(c);
        c.slist.add(this);
        c.stud_enrolled++;
        }
        else
        {
          System.out.println("MAX LIMIT FOR STUDENT REACHED FOR: "+c.name);
        }
        //System.out.println("YAYAYAYA ELIGIBLE");
      }  
    else
      {
        System.out.println(this.name+" is not eligible for "+c.name);
      }
    }
    else
      System.out.println("COURSE "+c.name+" ALREADY ENROLLED BY "+this.name);
    //System.out.println(this.name+" enrolled in "+c.name);
   }

  public boolean unenroll(course c)
   {
      //if sucessfully removed then returns true, else returns false
      boolean return_bool;
      return_bool = this.courses.remove(c);
      if (return_bool == true)
      {
        c.stud_enrolled--;
        c.slist.remove(this);
        this.courses.remove(c);
      }
      return return_bool;
    }   

   public void show()
   {
    System.out.println();
    System.out.print("student name: "+this.name);
    System.out.print(", "+ this.degree);
    System.out.print(", year "+this.year);
    System.out.print(", ROLL "+this.rollno);
    System.out.print(", subjects:");
    for (int i=0;i<this.courses.size();i++)
      System.out.print(" "+(i+1)+". "+this.courses.get(i).name);
    System.out.println();
    System.out.println();
   }
}