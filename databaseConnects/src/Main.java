import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        DBConnection db= new DBConnection();
        Connection conn=db.connectToDb("postgres","postgres","admin");

        Teacher t= new Teacher();
        Student s= new Student();

        Scanner input = new Scanner(System.in);
        System.out.println("Press 1 TO SignIn if you are Teacher\nPress 2 if you are Student\nPress 3 to SignUp");

        int num = Integer.parseInt(input.nextLine());

        if(num==1){
            System.out.println("Please Enter Your Name");
            String N=input.nextLine();
            System.out.println("Please Enter Your password");
            String P=(input.nextLine());
            String[] result = t.searchByName(conn,N);


            if(result[0].equals(N) && result[1].equals(P)){
                System.out.println("Welcome "+N);
                boolean loop = true;
                while(loop) {

                    System.out.println("Press 1 to enter record\n" +
                            "Press 2 See students Record\n" +
                            "Press 3 Exit\nPress 4 to add student");

                    int num1 = Integer.parseInt(input.nextLine());

                    if (num1 == 1) {
                        System.out.println("Enter Student rollNu ");
                        Scanner inputsp = new Scanner(System.in);
                        String student_id = inputsp.nextLine();

                        System.out.println("Student Existing Record");
                        s.searchById(conn,student_id);

                        System.out.println("Enter marks");
                        Scanner inputs = new Scanner(System.in);
                        String marks = inputs.nextLine();

                        System.out.println("Press 1 to enter oop marks\n" +
                                "Press 2 to enter itcp marks\n" +
                                "Press 3 to enter maths marks\n" +
                                "Press 4 to enter network marks\n");

                        Scanner inputsub = new Scanner(System.in);
                        String subject_id = inputsub.nextLine();

                        boolean goingGood = true;
                        String array[] = s.searchSubject(conn,student_id);

                        if(array!=null){

                            for(int i=0;i<array.length; i++){

                                if(subject_id == "1" && array[i]=="oop"){
                                    System.out.println("This subjecy marks alreadt exist ");
                                    goingGood = false;
                                    break;
                                } else if (subject_id.equals("2") && array[i].equals("itcp")) {
                                    System.out.println("This subject marks already exist ");
                                    goingGood = false;
                                    break;
                                }else if (subject_id == "3" && array[i]=="maths") {
                                    System.out.println("This subjecy marks alreadt exist ");
                                    goingGood = false;
                                    break;
                                }else if (subject_id == "4" && array[i]=="network") {
                                    System.out.println("This subject marks alread exist ");
                                    goingGood = false;
                                    break;
                                }
                            }
                        }

                        if(goingGood == true){
                            String teacher_id=result[2];
                            t.InsertStudentMarks(conn, marks,subject_id,student_id);
                        }

                    }
                    if (num1 == 2){
                        t.readData(conn);
                    }
                    if (num1 == 3){
                        loop=false;
                    }
                    if (num1 == 4){
                        System.out.println("Enter Student name");
                        Scanner inputname = new Scanner(System.in);
                        String student_name = inputname.nextLine();

                        System.out.println("Press 1 if From dep CS\n" +
                                "Press 2 if From dep SE\n" +
                                "Press 3 if From dep EE\n" +
                                "Press 4 if From dep BBA\n");
                        Scanner inputd = new Scanner(System.in);
                        String student_dep = inputd.nextLine();
                        s.addStudent(conn,student_name,student_dep);
                    }
                }
            }else{
                System.out.println("Wrong UserName Password");
            }
        }
        if (num==2){
            System.out.println("Enter your name to see your result");
            String N=input.nextLine();
            s.searchByName(conn,N);
        }
        if (num == 3){
            System.out.println("Enter Your name");
            Scanner inputname = new Scanner(System.in);
            String teacher_name = inputname.nextLine();

            System.out.println("Press 1 if From dep CS\nPress 2 if From dep SE\nPress 3 if From dep EE\nPress 4 if From dep BBA\n");
            Scanner inputd = new Scanner(System.in);
            String teacher_dep = inputd.nextLine();

            System.out.println("Enter Your Password");
            Scanner inputpass = new Scanner(System.in);
            String teacher_pass = inputpass.nextLine();

            t.addTeacher(conn,teacher_name,teacher_dep,teacher_pass);
        }
    }
}
