import java.util.*;  //For adding ArrayList
public class course{

	public String name;
	public int max_stud;
	public professor prof;
	public int stud_enrolled;
	public ArrayList<student> slist;
	public course_prereq prereq;

	
	public course()
	{
		this.name = new String("NONE");
		this.stud_enrolled = 0;
		this.max_stud = 2000;
		prof = new professor();
		slist = new ArrayList<student>();
		prereq = new course_prereq();

	}
	void add_prerequisites(String degree, String year, course c)
	{
		this.prereq.set_degree(degree);
		this.prereq.set_year(year);
		this.prereq.set_course(c);
	}

	boolean eligibility_check(student s)
	{	
		//System.out.println("YAYAYA "+this.prereq.year.equals("ALL"));

		//if no prerequisites and all year eligible and all degree eligible return true;
		if ( this.prereq.pcourse.name.equals("NONE") & this.prereq.year.equals("ALL") & this.prereq.degree.equals("ALL"))
			{

				return true;
			}
		else
		return (s.courses.contains(this.prereq.pcourse) & s.year.equals(this.prereq.year) & s.degree.equals(this.prereq.degree));


	}

	
	public void set_name(String name)
	{
		this.name = name;
	}

	public void set_max_stud(int max_stud)
	{
		this.max_stud = max_stud;
	}


	public void Modify(int max_stud, professor p)
	{
		this.max_stud = max_stud;
		this.prof = p;
		//System.out.println(this);

	} 

	public void set_prof(professor p)
	{
		this.prof = p;
		boolean flag = false;
		for(int i=0;i<p.course_assigned.size();i++)
		{

			if(p.course_assigned.get(i).name.equals(this.name))
			{
				flag = true;
			}
		}
		if (flag==false)
		{
		p.assign(this);
		}

	}


	public void show()
	{
		System.out.println();
		System.out.print("course name: "+this.name);
		System.out.print(", prof_assigned:"+this.prof.name);
		System.out.print(", max_students: "+this.max_stud);
		System.out.print(", students enrolled: ");
		for(int i=0;i<this.slist.size();i++)
		System.out.print(" "+(i+1)+"."+this.slist.get(i).name);
	 	this.prereq.show();
		System.out.println();
		System.out.println();

	}
		
}
