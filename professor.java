import java.util.*;  //For adding ArrayList
public class professor{



	public String name;
	public String area_of_expertise;
	public ArrayList<course> course_assigned;
	/*
	public professor(String name, String area_of_expertise)
	{
		this.name = name;
		this.area_of_expertise = area_of_expertise;
		this.course_assigned = new ArrayList<course>();
	}
	*/
	public professor()
	{
		this.name = new String("NONE");
		this.area_of_expertise = new String("NONE");
		this.course_assigned = new ArrayList<course>();
	}

	public void set_name(String t)
	{
		this.name = t;
	}

	public void set_area_of_expertise(String t)
	{
		this.area_of_expertise = t;
	}

	public void set_course_assigned(course c)
	{
		this.course_assigned.add(c);
	}

	public void show()
	{
		System.out.print("professor name: "+this.name);
		System.out.print(", area of expertise: "+this.area_of_expertise);
		System.out.print(", courses taken:");
		for (int i=0;i<this.course_assigned.size();i++)
		System.out.print(" "+(i+1)+". "+this.course_assigned.get(i).name);
		System.out.println();
	}
	public void assign(course c)
	{
		this.course_assigned.add(c);
		c.prof = this;
	}
	/*
	public boolean unassign(course c)
	{
		boolean return_bool;
		return_bool = this.course_assigned.remove(c);
		if (return_bool == true)
		{
			c.prof = new professor("","");
		}
		return return_bool;
	}
	*/

}
