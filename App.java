import java.util.*;
	class Project{
		public static void main(String [] args){
			Scanner input=new Scanner(System.in);
			Random r=new Random();
		String student [][]=new String[0][2];
		double marks[][]=new double [0][2];
		int find[]=new int[10];
		int option=1;
		int num=11;
		while (true){
		for (int i = 0; i < find.length; i++){
		find[i]=-5;
					}
		marks=addMarks(student,marks);
		if(num>10){
clearConsole();
		System.out.println("--------------------------------------------------------------------------------------");
		System.out.println("|\t\t       WELCOME TO  MARKS MANAGEMENT SYSTEM \t\t\t     |");
		System.out.println("--------------------------------------------------------------------------------------");

		System.out.println("  [1] Add New Student\t\t\t [2] Add New Student With Marks");
		System.out.println("  [3] Add Marks\t\t\t\t [4] Upadate Student Details");
		System.out.println("  [5] Update Marks\t\t\t [6] Delete Student");
		System.out.println("  [7] Print Student Details\t\t [8] Print Student Ranks");
		System.out.println("  [9] Best In Programming Fundamentals\t [10] Best In Databse Management System");
		System.out.println("  [0] Details");
		System.out.println("  [-1 Exist]");
//option erorr
		if(option >10){
		while(num > 10){
		System.out.println("\nPlease you can only select above option >");
		System.out.print("\nEnter an option to continue >");
		num=input.nextInt();
			}
		}else{
		System.out.print("\nEnter an option to continue >");
		num=input.nextInt();
			}
		}					
		String opt="";
		option=num;
//option 1 Start >>>>>>>					 
		if(num==1){
		do{
		clearConsole();
		System.out.println("--------------------------------------------------------------------------------------");
		System.out.println("|\t\t\t\tAdd New Student\t\t\t\t\t     |");
		System.out.println("--------------------------------------------------------------------------------------");
		student=studentAr(student,find);	
		System.out.print("Do you want to add new Student (y/n)>");
		num=errorY(num,opt);
		find[0]=0;
		}while(num!=11);
		find[0]=0;
//option 2 start>>>>>>>>>>>>				
		}else if(num==2){
		clearConsole();
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.println("|\t\t\t     Add New Student With Marks\t\t\t\t        |");
		System.out.println("-----------------------------------------------------------------------------------------");
		student=studentAr(student,find);
		if(find[0]==2){
		find[0]=0;
		System.out.print("\n\t     Do you want to add new Student with marks (y/n)>");
		num=errorY(num,opt);
		}else{
		System.out.println();
		marks=addMarks(student,marks);
			do{ //PF
		System.out.print("\n\tProgramming Fundamentals Marks      :");
		double marks1=input.nextDouble();
		if(existMarks(marks1)){
		marks[find[1]][0]=marks1;
		break;
		}else{
		System.out.println("\tInvalid Number");
		}
		}while(true);

		do{// DB
		System.out.print("\tDatabase Management System Marks    :");
		double marks2=input.nextDouble();
		if(existMarks(marks2)){
		marks[find[1]][1]=marks2;
		break;
		}else{
		System.out.println("\tInvalid Number");
		}
		}while(true);
		System.out.print("\n\t     Do you want to add new Student with marks (y/n)>");
		num=errorY(num,opt);
		}	
//option 3 start>>>>>>>>>>>>							
		}else if(num==3){
clearConsole();
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.println("|\t\t\t\t      Add Marks\t\t\t\t\t        |");
		System.out.println("-----------------------------------------------------------------------------------------");
		marks=marksAr(marks,student,find);
		if(find[3]==1){
		System.out.print("\nMarks added successfull .\n \t\t Do you want to add marks another student ? (y/n) >");
		num=errorY(num,opt);
		}else if(find[3]==2){
		System.out.println("\n\tPrograming Fundamental marks     :" + marks[find[4]][0]);
		System.out.println("\tDatabase Management System marks :" + marks[find[4]][1]);
		System.out.print("\n\tIf you want to add another student [3] or update marks [Enter 5 or Manu 11] >");
		num=input.nextInt();
		do{
		if(num==3 || num==5 || num==11){
		break;
			}else{
		System.out.println("Marks already exists. \n\tif you want to add another student [3] or update marks [Enter 5 or Manu 11] >");
		System.out.print("Sorry you can only use above option only >");	
		num=input.nextInt();
			}
		}while(num !=11 || num !=5);
			}
		if(find[5]==5 || find[5]==11){
		num=find[5]==5 ? 3:11;
		find[5]=0;
			}
//option 4 start>>>>>>>>>>>>							
		}else if(num==4){
clearConsole();
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println("|\t\t\t\tUpdate Student Details\t\t\t\t   |");
		System.out.println("------------------------------------------------------------------------------------");	
		student=upStDe(student);
		num=errorY(num,opt);
		//option 5 start>>>>>>>>>>>>							
		}else if(num ==5){
clearConsole();
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println("|\t\t\t\tUpdate Marks\t\t\t\t\t   |");
		System.out.println("------------------------------------------------------------------------------------");
		marks=upMarks(student,marks,find);
		if(find[0]==1){
		find[0]=0;
			do{
		System.out.print("Do you want to add Student marks ? [3] or update anathor Student marks[5] or back[11] >" );
		num =input.nextInt();
		System.out.println("\nSorry you can use below option only >" );
			}while(num !=3 && num !=5 && num !=11);
			}else{
		if(find[5]==99 || find[5]==11){
		num=find[5]==99 ? 5:11;
		find[5]=0;
			}else{
		num=errorY(num,opt);
		find[0]=0;
			}
			}
//option 6 start>>>>>>>>>>>>							
		}else if(num==6){
		String id="";

			do{		
		clearConsole();
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println("|\t\t\t\tDelete Student\t\t\t\t           |");
		System.out.println("------------------------------------------------------------------------------------");
		System.out.print("\n\n\n\t\t\t\tEnter  Student ID   :");
		id=input.next();
		if(exists(student,id)){
		System.out.print("\t\t\t\tEnter  Student Name :");
		String name=input.next();
		for (int i = 0; i < student.length; i++){
		if(student[i][0].equals(id)){
		if(student[i][1].equals(name)){
		System.out.println(" Student Name :" + student[i][1]);
		student[i][0]="Deleted";
		student[i][1]="Deleted";
		marks[i][0]=0.0d;
		marks[i][1]=0.0d;
		System.out.println("\nStudent hs been deleted successfully\n");
		System.out.print("\tDo you want to delete another Student? (y/n) >");
		num=errorY(num,opt);
			}else{
		System.out.print("Sorry Wrong Name.. \n \t\t\tPlease Enter any [number] to tryagain back to [11] > ");
		num=input.nextInt();
		System.out.println();
			}
		}
	}
		}else{
		System.out.print("Sorry Wrong ID..\n \t\t\tPlease Enter any [number] to tryagain back to [11] > ");
		num=input.nextInt();
		System.out.println();
		}
			}while(num !=11);
//Print Student Details	>>>>>>>>>>>				
}else if(num==7){
clearConsole();
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println("|\t\t\t\tPrint Student Details\t\t\t\t   |");
		System.out.println("------------------------------------------------------------------------------------");
			do{
		System.out.print("\n\n\n\t\t\t\tEnter Student ID   :");
		String id=input.next();
		if(exists(student,id)){
		System.out.print("\t\t\t\tEnter Student Name :");
		String name=input.next();
		if(existsN(student,name)){
		double avg=0;
		for (int i = 0; i < student.length; i++){
		if(student[i][0].equals(id)){
		if(marks[i][0] <=0 || marks[i][1]<=0){
		System.out.println("  Marks not add yet.....");
			}else{
		String s []=new String[10];
		for (int k = 0; k< s.length; k++){
		s[k]="";
				}
		s[1]=marks[i][0]>=100 ? "\b":marks[i][0] <10 ? " ":"";
		s[2]=marks[i][1]>=100 ? "\b":marks[i][1] <10 ? " ":"";
		System.out.println("\t\t+----------------------------------+----------------+");
		System.out.print("\t\t| Programing Fundamentals Marks    |");
		System.out.println("\t\t  " +s[1]+(int)marks[i][0]+"|");
		System.out.print("\t\t| Database Management System Marks |");
		System.out.println("\t\t  "+s[2] +(int)marks[i][1]+"|");
		System.out.print("\t\t| Total Marks\t\t\t   |");
		double total=marks[i][0]+marks[i][1];
		s[3]=total >=100 ? "":total <10 ? "  ":" ";							 
		System.out.println("\t       "+s[3] +total+"|");
		avg=total/2;
		s[4]=avg >=100 ? "\b":avg <10 ? " ":"";							 
		System.out.print("\t\t| Avg Marks\t\t\t   |");
		System.out.println("\t\t" +s[4]+avg+"|");
		int rank=1;
		for (int j = 0; j < marks.length; j++){
		if(avg < ((marks[j][0]+marks[j][1]) / 2)){
		rank++;
			}
		}
s[5]=rank == 1 ? "1  (Frist)" : rank==2 ? "2 (Second)":rank ==3 ? "3  (Third)":"\t   "+rank;
		System.out.print("\t\t| Rank\t \t\t\t   |");
		System.out.println("\t  " +s[5]+"|");
		System.out.println("\t\t+----------------------------------+----------------+");
		}
			}
				}
		System.out.print("\n\tDo you want to search another student details ? (y/n) >");
		num=errorY(num,opt);
		break;
			}else{
		System.out.println("\t    Invalid Name Please try again\n");
			}
			}else{
		System.out.println("\t    Invalid ID Please try again");
		System.out.print("\t\tDo you want to try again (y/n) >");
		num=errorY(num,opt);
		break;
			}
		}while(true);
//Print Student rank
			}else if(num ==8){
clearConsole();
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println("|\t\t\t\tPrint Student Ranks\t\t\t\t   |");
		System.out.println("------------------------------------------------------------------------------------");	
		System.out.println();	
		System.out.println("\t+-------+-----------+-------------------+-------------+-----------+");
		System.out.println("\t| Rank  | ID        | Name\t        | Total Marks | Avg Marks |");
		System.out.println("\t+-------+-----------+-------------------+-------------+-----------+");
		double avg[]=new double[marks.length];
		for (int i = 0; i < marks.length; i++){
		avg[i]=(marks[i][0]+marks[i][1]) / 2;
			} //avg add to marks values
		int x=-1;
		for (int i = 0; i < marks.length; i++){
		int index=-1;
		double max =0;
		for (int j = 0; j< marks.length; j++){
		if(max <= avg[j] ){
		max=avg[j];
		index=j;
			}
		}	
		boolean b=student[index][0].equals("Deleted") ? false:true;
		b=avg[index]<=0 ? false:true;
		avg[index]=0;
		if(index !=-1 && x !=index && b){
		String st []=new String [4];
		String s=String.valueOf(marks[index][0]+marks[index][1]);
		String s1=String.valueOf((marks[index][0]+marks[index][1])/2);
		int t1=student[index][0].length()>=1 ? student[index][0].length()-1:0;
		int t2=student[index][1].length()>=1 ? student[index][1].length()-1:0;
		int t3=s.length() >=3 ? s.length()-3:0;
		int t4=s1.length()>=3 ? s1.length()-3:0;
		for (int w = 0; w < st.length; w++){
		st[w]="";
			}
		for (int w = 0; w < t1; w++){
		st[0]=st[0]+"\b";
			}
		for (int w = 0; w < t2; w++){
		st[1]=st[1]+"\b";
			}
		for (int w = 0; w < t3; w++){
		st[2]=st[2]+"\b";
			}
		for (int w = 0; w < t4; w++){
		st[3]=st[3]+"\b";
			}

		System.out.print("\t| " +(i+1) + "\t| " + student [index][0] +"         "+st[0]+ "| "+ student [index][1] +"                 " +st[1]+"| ");
		System.out.println(( marks[index][0]+marks[index][1]) + "         "+st[2]+"| "+ (( marks[index][0]+marks[index][1]) /2) +"       "+st[3]+"|");
		x=index;
			}		
		}
		System.out.println("\t+-------+-----------+-------------------+-------------+-----------+");
		System.out.print("   Do you want to go back to main menu? (n/y) >");
		num=errorY(num,opt);
		num=num==8 ? 11:num==11 ? 8:8;
			}else if(num ==9){
clearConsole();
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println("|\t\t\tBest In Programming Fundamentals\t\t\t   |");
		System.out.println("------------------------------------------------------------------------------------");	
		System.out.println("\t+-----------+---------------------+-------------+--------------+");
		System.out.println("\t| ID        |  Name \t          | PF Marks    | DBMS Marks   |");
		System.out.println("\t+-----------+---------------------+-------------+--------------+");
		double temp[][]=new double [marks.length][2];
		for (int i = 0; i < marks.length; i++){
		temp[i][0]=marks[i][0];
		temp[i][1]=marks[i][1];
			}
		int x=-1;
		for (int i = 0; i < marks.length; i++){
		double max=0;
		int index=-1;
		for (int j = 0; j < marks.length; j++){
		if(max  <= temp[j][0]){
		max=temp[j][0];
		index=j;
			}
				}
		boolean b=student[index][0].equals("Deleted") ? false:true;
		if(index != -1 && x!=index && b){
		String s=String.valueOf(marks[index][0]);
		String s1=String.valueOf(marks[index][1]);
		int t1=student[index][0].length();
		int t2=student[index][1].length();
		int t3=s.length();
		int t4=s1.length();
		String ts[]=new String [4];
		for(int w= 0; w < ts.length; w++){
		ts[w]="";
			}
		for(int w= 0; w < t1; w++){
		ts[0] +="\b";
			}
		for(int w= 0; w < t2; w++){
		ts[1] +="\b";
			}
		for(int w= 0; w < t3; w++){
		ts[2] +="\b";
			}
		for(int w= 0; w < t4; w++){
		ts[3] +="\b";
			}
		System.out.print("\t| " + student[index][0] +"          "+ts[0]+"| "+student[index][1]);
		System.out.println("                    "+ts[1]+"| "+ marks[index][0]+"            "+ts[2] +"| "+ marks[index][1] +"             "+ts[3]+"|");
		x=index;
		temp[index][0]=-1;
			}
				}
		System.out.println("\t+-----------+---------------------+-------------+--------------+");

		System.out.print("   Do you want to go back to main menu? (y/n) >");
		num=errorY(num,opt);
		num=num==9 ? 11:num==11 ? 9:9;
			}else if(num==10){
clearConsole();
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println("|\t\t\tBest In Databse Management System\t\t\t   |");
		System.out.println("------------------------------------------------------------------------------------");	
		System.out.println("\t+-----------+---------------------+-------------+--------------+");
		System.out.println("\t| ID        |  Name \t          |  DBMS Marks | PF Marks     |");
		System.out.println("\t+-----------+---------------------+-------------+--------------+");
		double temp[][]=new double [marks.length][2];
		for (int i = 0; i < marks.length; i++){
		temp[i][1]=marks[i][1]; 
		temp[i][1]=marks[i][1];
			}
		int x=-1;
		for (int i = 0; i < marks.length; i++){
		double max=0;
		int index=-1;
		for (int j = 0; j < marks.length; j++){
		if(max  <= temp[j][1]){
		max=temp[j][1];
		index=j;
		}
			}
		boolean b=student[index][0].equals("Deleted") ? false:true;
		if(index != -1 && x!=index && b){
		String s=String.valueOf(marks[index][0]);
		String s1=String.valueOf(marks[index][1]);
		int t1=student[index][0].length();
		int t2=student[index][1].length();
		int t3=s.length();
		int t4=s1.length();
		String ts[]=new String [4];
		for(int w= 0; w < ts.length; w++){
		ts[w]="";
			}
		for(int w= 0; w < t1; w++){
		ts[0] +="\b";
			}
		for(int w= 0; w < t2; w++){
		ts[1] +="\b";
			}
		for(int w= 0; w < t3; w++){
		ts[2] +="\b";
			}
		for(int w= 0; w < t4; w++){
		ts[3] +="\b";
			}
		System.out.print("\t| " + student[index][0] +"          "+ts[0]+"| "+student[index][1]);
		System.out.println("                    "+ts[1]+"| "+ marks[index][1]+"            "+ts[2] +"| "+ marks[index][0] +"             "+ts[3]+"|");
		x=index;
		temp[index][1]=-1;
			}
				}
		System.out.println("\t+-----------+---------------------+-------------+--------------+");
		System.out.print("   Do you want to go back to main menu? (y/n) >");
		num=errorY(num,opt);
		num=num==10 ? 11:num==11 ? 10:10;	
// Print Details			
			}else if(num ==-0){
clearConsole();
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println("|\t\t\t\tPrint Details\t\t\t\t           |");
		System.out.println("------------------------------------------------------------------------------------");
		for (int i = 0; i < student.length; i++){
		if(student[i][0].equals("Deleted")){
		System.out.print("Student " +(i+1) + " :");
		System.out.println("Deleted");
		System.out.println();
			}else{
		System.out.println("Student ID :"+ student[i][0]);
		System.out.println("Student Name :"+ student[i][1]);
		System.out.println("java :" + marks[i][0]);
		System.out.println("DBMS :" + marks[i][1]);
		System.out.println("total :" + (marks[i][1]+marks[i][0]));
		System.out.println();
		System.out.println();
			}
				}
		System.out.print("Menu :");
		num=input.nextInt();
// Exit >>>
		}else if(num == -1){ 
		clearConsole();
		System.out.print("\n\n\n\n\n\n\t\t\t\t\t  Thank you !!!");
		break;
			}
					} //while loop End >  >  >
					
					//<<<<<<<<<<<<<<<<< MAIN METHOD END >>>>>>>>>>>>>>>>>>>>>>>
		}public static double[][] addMarks(String[][] student,double marks[][]){ // MARKS ++
		double temp[][]=new double [student.length][2];
		for (int i = 0; i < marks.length; i++){
		temp[i]=marks[i];
			}
		marks=temp;
		return marks;
			}public static String[][] studentAr(String ar[][],int find[]){// ADD STUDENT >>>>>>>>
		Scanner input=new Scanner(System.in);
		int n=0;
		String id="";
		String name="";
		String opt="";
		String temp[][]=new String[ar.length+1][2];
		for (int i = 0; i <ar.length; i++){
		temp[i]=ar[i];
		}
		System.out.print("\n\n\n\n\t\t\t\tStudent ID  :");					
		id=input.next();	
		if(exists(id,ar)){
		System.out.print("\t\t\t\tStudent Name:");					
		name=input.next();
		temp[temp.length-1][0]=id;
		temp[temp.length-1][1]=name;
		find[1]=temp.length-1;
		System.out.print("\n\tStudent has been added successfully.");
			return temp;
			}else{
		System.out.println(">>>>Student already Exists try again >");
		System.out.println(">>>>Student Name :"+checkData(ar,id));
		System.out.print("\nSorry student has been already exists .");
		find[0]=2;	
			return ar;
				}	
		// add Marks >>>>>>>>>>>>>>						
			}public static double[][] marksAr(double marks[][],String student[][],int find[]){ // Marks Student Add
		Scanner input=new Scanner(System.in);
		boolean b=true;
		double num=0;
		double num2=0;
			do{
		System.out.print("\n\n\n\t\t\t\tEnter Student ID :");
		String id=input.next();
		if(exists(student,id)){
		System.out.println("\t\t\t\tStudent Name     :" +checkData(student,id));
		for (int i = 0; i < marks.length ; i++){
		if(student[i][0].equals(id)){
		if(marks[i][0]==0.0){
			do{
		System.out.print("\n\tProgramming Fundamentals Marks      :");
		num=input.nextDouble();
		if(existMarks(num)){
		marks[i][0]=num;
			break;
		}else{
		System.out.println("\tInvalid Numbers >");
			}
		}while(true);// end num-1
			do{
		System.out.print("\tData Base Management System Marks   :");
		num2=input.nextDouble();
		if(existMarks(num2)){
		marks[i][1]=num2;
		find[3]=1;
			return marks;
			}else{
		System.out.println("\tInvalid Numbers >");
				}
		}while(true);
			}else{
		System.out.println(" Marks Is already Exists");
		find[3]=2;
		find[4]=i;
			return marks;
			}
				}
					}
			}else{
		System.out.println("Invalid ID please Enter Valid ID >");
			do{
		System.out.print("\t  Back to [11] or Try again [5]>");
		find[5] =input.nextInt();
		System.out.println("\n\tSorry you can use below option only >" );
			}while(find[5] !=5 && find[5] !=11);	
			return marks;
				}
		}while(true);
		}public final static void clearConsole() {// Clear console >>>>>>>>>>>>>>>
			try {
		final String os = System.getProperty("os.name");
		if (os.contains("Windows")) {
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
		System.out.print("\033[H\033[2J");
		System.out.flush();
			}
			} catch (final Exception e) {
		e.printStackTrace();
			}
			}public static boolean exists(String id,String ar[][]){// Check Student Id Exist or Not	
			for (int i = 0; i < ar.length; i++){
			if(ar[i][0].equals(id)){
			return false;
			}
				}
			return true;		
		}public static boolean existMarks(double num){ // Marks Valid or Invalid >>>>>
			boolean b=num>100 ?  false:num<0 ?  false:true;
			return b;
		}public static boolean exists(String ar[][],String id){ // Student ID Check
		for (int i = 0; i < ar.length; i++){
		if(ar[i][0].equals(id)){
		return true;
		}
			}
		return false;
		}public static boolean existsN(String ar[][],String name){ //Student Name Check
		for (int i = 0; i < ar.length; i++){
		if(ar[i][1].equals(name)){
		return true;
		}
			}
			return false;
		}public static String[][] upStDe(String ar[][]){   // Update Student Details >>>>> 4
		Scanner input=new Scanner(System.in);
		System.out.print("\n\n\n\t\tEnter Student ID :");
		String id=input.next();
		if(exists(ar,id)){
		for (int i = 0; i < ar.length; i++){
		if(ar[i][0].equals(id)){
		System.out.println("\t\tStudent Name    :" +ar[i][1]);
		break;
			}
				}
		System.out.print("\t\t\tEnter Student New Name :");
		String name=input.next();
		for (int i = 0; i < ar.length; i++){
		if(ar[i][0].equals(id)){
		ar[i][1]=name;
		}
			}
		System.out.println("\tSuccessfully .");	
		System.out.print("\t\tDo you want to Update Student? (y/n) >");	
		}else{
		System.out.println("Sorry Student Doesn't Exists or Invalid ID ");
		System.out.print("\tDo you wan to Try to Update Student again ? (y/n) >");
			}
			return ar;
		}public static double [][] upMarks(String [][] ar,double marks[][],int find[]){ // Update Marks >>>>>>>>>> 5
		Scanner input=new Scanner(System.in);
		boolean b=true;
			do{
		double num=0.0d;
		double num2=0.0d;
		System.out.print("\n\n\n\t\tEnter Student ID    :");
		String id=input.next();
		if(exists(ar,id)){
		System.out.print("\t\tEnter Student Name  :");
		String name=input.next();
		if(idName(ar,id,name)){
		for (int i = 0; i < ar.length; i++){
		if(ar[i][0].equals(id) && ar[i][1].equals(name)){
		if(marks[i][1]<= 0 && marks[i][1]<=0){
		System.out.println("Its not add marks yet......" );
		find[0]=1;
		return marks;
		}else{
		System.out.println("\n\tProgramming Fundamentals Marks    :" + marks[i][0]);
		System.out.println("\tDatabase Management System Marks  :" + marks[i][1]);
			}
			do{	
		System.out.print("\n\tEnter New Fundamentals Marks:");
		num=input.nextDouble();
		if(existMarks(num)){
		marks[i][0]=num;
		break;
			}else{
		System.out.print("\tPlease Enter correct marks.. >");
			}
		}while(true);
			do{			
		System.out.print("\tEnter New DBMS Marks        :");
		num2=input.nextDouble();
		if(existMarks(num2)){
		marks[i][1]=num2;
		break;
			}else{
		System.out.println("\tPlease Enter correct marks.. >");
			}
		}while(true);	
		b=false;
				}
		}	
			}else{
		System.out.println("Sorry Name isn't exists please enter right Name");
			}
		}else{
		System.out.println("Sorry ID isn't exists please enter right ID");
			do{
		System.out.print("\t  Back to [11] or Try again [99]>");
		find[5] =input.nextInt();
		System.out.println("\n\tSorry you can use below option only >" );
		}while(find[5] !=99 && find[5] !=11);	
		return marks;
				}
		}while(b);	
System.out.print("Marks update Successfully . Do you want to another Student marks update? (y/n) >");
			return marks;
		}public static int errorY(int num,String opt){  // ERROR  Y N Repeat
		Scanner input=new Scanner(System.in);
		int n=num;
			do{
		opt=input.next();
		System.out.println();
		num=opt.equals("y") ? n:opt.equals("n") ? 11:-1;
		System.out.print(num ==-1 ? "Sorry you can only use 'y' or 'n' only >":"");
		}while(num ==-1);
			return num;
		}public static boolean idName(String [][] ar,String id, String name){ //ID and Name Equals check
		for (int i = 0; i < ar.length; i++){
		if(ar[i][0].equals(id) && ar[i][1].equals(name)){
			return true;
			}
				}	
		return false;
			}public static String checkData(String s [][],String id){ // check Deta id or name
		for (int i = 0; i < s.length; i++){
		if(s[i][0].equals(id)){
			return s[i][1];
			}
				}
			id="Invalid Name";
			return id;
				}
	} // End Project 	