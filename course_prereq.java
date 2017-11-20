public class course_prereq{

	public String degree;
	public String year;
	public course pcourse;

	void course_prereq(){

		degree = new String("ALL");
		year = new String("ALL");
		pcourse = new course();
		pcourse.set_name("NONE");

		
	}
	public void set_year(String year)
	{
		this.year = year;
	}
	public void set_degree(String degree)
	{
		this.degree= degree;
	}
	public void set_course(course c)
	{
		this.pcourse = c;
	}
	public void show()
	{
		System.out.print(", Prereq course is: "+this.pcourse.name+", degree eligible: "+this.degree + ", year eligible: "+this.year);
	}
}