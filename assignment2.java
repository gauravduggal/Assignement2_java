import java.util.*;  //For adding ArrayList
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class assignment2
{
	public static void main(String []args) 
	{

		ArrayList<student> slist = new ArrayList<student>();
		ArrayList<professor> plist = new ArrayList<professor>();
		ArrayList<course> clist = new ArrayList<course>();
		String temp1 = new String();
		String temp2 = new String();
		String temp3 = new String();
		student s = new student();
		professor p = new professor();
		course c = new course();
		boolean flag = false;
		System.out.println("Assignment2");
		String fileName = new String("data.txt");
		try (Scanner scanner = new Scanner(new File(fileName))) {

      while (scanner.hasNext()){
        String line = scanner.nextLine();
        line = line.toUpperCase();
        //System.out.println(line);
        String [] part = line.split(" ");
        
        switch(part[0])
        {
          case "ADDS":
          s = new student();
          s.set_name(part[1]+" "+part[2]);
          s.set_rollno(part[3]);
          s.set_degree(part[4]);
          s.set_year(part[5]);
          slist.add(s);
          System.out.println("student "+s.name+" added");
          
          break;
          case "ADDP":
          //System.out.println(slist.size());
          //System.out.println(slist.get(1).name);
          p = new professor();
          p.set_name(part[1]+" "+part[2]);;
          p.set_area_of_expertise(part[3]);
          plist.add(p);
          System.out.println("prof added "+part[1]+" "+part[2]);

          break;
          case "ADDC":
          temp1 = part[3]+" "+part[4];
          //search for temp1 in plist
          c = new course();
          c.set_name(part[1]);
          c.set_max_stud(Integer.parseInt(part[2]));
          //c.show();
          flag = false;
          for (int i=0;i<plist.size();i++)
          {	
          	//System.out.println(temp1);
          	if (plist.get(i).name.equals(temp1))
          	{
          		p = plist.get(i);
          		c.set_prof(p);
          		//if none prereq then set prereq as none course
          		if (part[7].equals("NONE"))
          			{
          				c.add_prerequisites(part[5],part[6],new course());
          				flag = true;
          				clist.add(c);
          				System.out.println("Course: "+part[1]+" added");
          			}
          		else
          		{
          			for (int j = 0;j<clist.size();j++)
          			{
          				if(clist.get(j).name.equals(part[7]))
          				{
          					c.add_prerequisites(part[5],part[6],clist.get(j));
          					flag = true;
          					clist.add(c);
          					System.out.println("Course: "+part[1]+" added");
          					break;
          				}
          				
          			}

          		}
          		
          	}
          	
          }
          if (flag == false)
          	{
          		System.out.println("Professor "+temp1+" does not exist or Prerequisite "+part[7]+" needs to be added before adding "+part[1]);
          	}
          
          break;
          case "SHOWS":
          temp1 = part[1]+" "+part[2];
          flag = false;
          //System.out.println("yay"+temp1);
          for (int i=0;i<slist.size();i++)
          {	
          	if(slist.get(i).name.equals(temp1))
          		{
          			slist.get(i).show();
          			flag=true;
          		}
          		break;
          }
          if (flag==false)
          {
          	System.out.println("student "+temp1+" not found");
          }

          break;

          case "SHOWC":
          temp1 = part[1];
          flag = false;
          
          for (int i=0;i<clist.size();i++)
          {	
          	if(clist.get(i).name.equals(temp1)==true)
          		{
          			//System.out.println("YAY");
          			clist.get(i).show();
          			flag=true;
          			break;
          		}
          		
          }
          if (flag==false)
          {
          	System.out.println("course "+temp1+" not found");
          }

          break;
          case "MODIFY":
          p = new professor();
          //course
          temp1 = part[1];
          //new max_stud
          int temp4 = Integer.parseInt(part[2]);
          //new prof
          temp2 = part[3]+" "+part[4];
          flag=false;
          for(int i=0;i<clist.size();i++)
          {
          	if(clist.get(i).name.equals(temp1))
          	{

          		for(int j = 0;j<plist.size();j++)
          		{
          			if(plist.get(j).name.equals(temp2))
          			{	
          				//System.out.println("yay");
          				if (clist.get(i).slist.size()<temp4)
          				{
          				clist.get(i).max_stud = temp4; 
          				System.out.println("professor "+clist.get(i).prof.name+" changed to "+temp2+" for course "+temp1);
          				clist.get(i).set_prof(plist.get(j));
          				clist.get(i).show();
          				flag = true;
          				break;
          				}
          				else
          				{
          					System.out.println("MAX STUDENT CANNOT BE CHANGED TO "+temp4);
          					flag=true;
          					break;
          				}

          				
          			}
          		}
          		
         		
          	}
          }
          if(flag == false)
          {
          	System.out.println("INVALID MODIFY INPUT");
          }
          flag = false;


          break;
	      case "SHOWP":
          temp1 = part[1]+" "+part[2];
          flag = false;
         //System.out.println("yay "+plist.get(1).name);
          for (int i=0;i<plist.size();i++)
          {	
          	//System.out.println(i);
          	if(plist.get(i).name.equals(temp1))
          		{
          				
          			plist.get(i).show();
          			flag=true;
          			break;

          		}
          }
          if (flag==false)
          {
          	System.out.println("professor "+temp1+" not found");
          }

          break;


          case "ENROLL":
          temp1 = part[2]+" "+part[3];
          temp2 = part[1];
          flag = false;
          c = new course();
          s = new student();
          
          for(int i=0;i<slist.size();i++)
          {
          	if(slist.get(i).name.equals(temp1))
          	{
          		s = slist.get(i);
          		flag = true;
          		break;
          	}
          }
          if (flag == false)
          {
          	System.out.println("student "+temp1+" not found");
          	break;
          }
          flag = false;
          //System.out.println("YAY"+clist.size());
          //add case for not found
          for(int i=0;i<clist.size();i++)
          {

          	if(clist.get(i).name.equals(temp2))
          	{
          		c = clist.get(i);
          		flag = true;
          		break;
          	}
          }
          if (flag == false)
          {
          	System.out.println("course "+temp2+" not found");
          	break;
          }
          else
          {
          s.enroll(c);
          //s.show();
      	  }
          break;
          case "UNENROLL":
          temp1 = part[2]+" "+part[3];
          temp2 = part[1];
          flag = false;
          c = new course();
          s = new student();
          
          for(int i=0;i<slist.size();i++)
          {
          	if(slist.get(i).name.equals(temp1))
          	{
          		s = slist.get(i);
          		flag = true;
          		break;
          	}
          }
          if (flag == false)
          {
          	System.out.println("student "+temp1+" not found");
          	break;
          }
          flag = false;
          //System.out.println("YAY"+clist.size());
          //add case for not found
          for(int i=0;i<clist.size();i++)
          {

          	if(clist.get(i).name.equals(temp2))
          	{
          		c = clist.get(i);
          		flag = true;
          		break;
          	}
          }
          if (flag == false)
          {
          	System.out.println("course "+temp2+" not found");
          	break;
          }
          else
          {
          s.unenroll(c);
          //s.show();
      	  }
          
          break;
                   
          default:
          System.out.println("INCORRECT COMMAND");
          break;
        }
        
        }
      }

        catch (IOException e)
         {
          e.printStackTrace();
          }



//		System.out.println(plist.get(2).name);
		
	}


}