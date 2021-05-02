/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gameticket_package;


import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Calendar;
import java.io.IOException;
import java.util.Vector;

/**
 *
 * @author Nadeen
 */
public class Gameticket_package {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
      System.out.println("**************"+"WELCOM to the game ticket reversertion"+"**************"+"\n");
        
        /**initialize array of four different games*/
        Game g[]= new Game[4];
        Date date1=new Date(2020,3,3);
        Date date2=new Date(2020,3,4);
        Date date3=new Date(2020,3,5);
        Date date4=new Date(2020,3,6);
        
        
        g[0]= new nationalgame("cairo staduim",1000,date1);

        g[1]= new nationalgame(" allianz arena",2200,date2);
        g[2]= new internationalgame("wembley ",2000,date3);
        g[3]= new internationalgame("camp nou ",700,date4);
        //set teams
        g[0].setteams("Ahli","Zmalik");
        g[1].setteams("barcelona","real madrid");
        g[2].setteams("egypt","italy");
        g[3].setteams("spain","german");
        
        //set winner teams
        g[0].setwinner("Ahli");
        g[1].setwinner("barcelona");
        g[2].setwinner("egypt");
        g[3].setwinner("spain");
        
        for (int i = 0; i < 4; i++) {
            g[i].display();
            System.out.println("\n");
        }
  
        //thre categories
        seats s[]=new seats[3];
        s[0]=new seats("A");
        s[1]=new seats("B");
        s[2]=new seats("C");
        /*s[0].setprice("A");
        s[1].setprice("B");
        s[2].setprice("C");*/
        for (int i = 0; i < 3; i++) {
            s[i].display();
        }
        
        //fans
    
        fans fan[]=new fans[4];
        
        for(int i=0;i<4;i++)
        {
            fan[i]=new fans();
        }
        
        //first fan 
        fan[0].book(1,g[2],s[0]);
        fan[0].name="soou";
        fan[0].age=20;
        fan[0].phone="123";
        fan[0].displayINFO();
        fan[0].upgrade(s[2]);
        System.out.println("\n");
        System.out.println("---------------------------------");
        
        
        prize prize=new prize();
        //second fan
        fan[1].book(1, g[1], s[1]);
        fan[1].name="george";
        fan[1].age=34;
        fan[1].phone="3445";
        fan[1].setbet("barcelona");
        fan[1].displayINFO();
        if(fan[1].bet()){
        prize.showmessage();}
        System.out.println("\n");
        System.out.println("---------------------------------");
        //third fan
        msg m=new msg();
        fan[2].book(1, g[0], s[2]);
        fan[2].name="mark";
        fan[2].age=23;
        fan[2].phone="2342";
        fan[2].displayINFO();
        fan[2].cancel(2);
        m.showmessage();
        System.out.println("\n");
        
        
        System.out.println("---------------------------------");
        System.out.println("********USER INPUT*******"+"\n");
        System.out.println("Enter your name: ");
        Scanner scan=new Scanner(System.in);
        String name=scan.nextLine();
        fan[3].name=name;
        System.out.println("\n"+"Enter your age:  ");
        Scanner scan2=new Scanner(System.in);
        int age=scan2.nextInt();
        fan[3].age=age;
        
        System.out.println("\n"+"Enter your phone: ");
         Scanner scan3=new Scanner(System.in);
        String phone=scan3.nextLine();
        fan[3].phone=phone;
        System.out.println("You can buy ticket in category A"+"\n");
        System.out.println("You can buy ticket in category B"+"\n");
        System.out.println("You can buy ticket in category C"+"\n");
        int price1=s[0].getprice();
        int price2=s[1].getprice();
        int price3=s[2].getprice();
    
         System.out.println("the cost in first category:  "+price1+"\n");
         System.out.println("the cost in second category:  "+price2+"\n");
         System.out.println("the cost in second category:  "+price3+"\n");
         
         
         //the unique code of the game
          System.out.println("enter which game you want to press 1 or 2 or 3 or 4"+"\n");
          Scanner n=new Scanner(System.in);
        int pho=n.nextInt();
         //A OR B OR C
         System.out.println("enter the id of the category:  "+"\n");
         Scanner x=new Scanner(System.in);
        String category=x.nextLine();
        seats news=new seats(category);
        
        System.out.println("enter number of ticket you want"+"\n");
        Scanner number=new Scanner(System.in);
        int num=number.nextInt();
        
        fan[3].book(num, g[pho], news);
        
        System.out.println("if you want to cancel reservation press 1 , if you want to upgrade seat press 2"+"\n");
        Scanner choose=new Scanner(System.in);
        int ch=choose.nextInt();
        switch(ch){
            case 1:
                fan[3].cancel(news.seat_number);
                break;
            case 2:
                fan[3].upgrade(news);
                break;
            default:
                break;
        }
        
        fan[3].displayINFO();
        System.out.println("-----------------DISPLAY ALL FANS---------------");
        System.out.println("-----------------FAN ONE---------------");
        fan[0].displayINFO();
        System.out.println("-----------------FAN TWO---------------");
        fan[1].displayINFO();
        System.out.println("-----------------FAN THREE---------------");
        fan[2].displayINFO();
        System.out.println("-----------------FAN FOUR---------------");
        fan[3].displayINFO();
}
}
    /**abstract class that describe the game information*/
       public abstract class Game{
         /**ID of each game*/
        public int unique_code;
        public String Location;
        /**total number of seats in the stadium*/
        public int NumberOfSeats;
        //counter of games
        private static int NumberOfgames=1;
        public Date date=new Date();
        public String team1;
        public String team2;
        public String winner; //////
        Game()
        {
            
        }
        public Game(String loc,int total,Date d)
        {
            this.Location=loc;
            this.NumberOfSeats=total;
            this.date=d;
            this.unique_code=NumberOfgames;
            NumberOfgames++;
        }
        public int getsize()
        {
            return NumberOfSeats;
        }
        public void setdate(int x)
        {
            date.setDate(date.getDate()+x);
        }
        public void setteams(String t1,String t2)
        {
            this.team1=t1;
            this.team2=t2;
        }
        public void setwinner(String str)
        {
            this.winner=str;
        }
        public String getwinner()
        {
            return winner;
        }
        public int geday(Date d)
        {
            /**return a Calendar instance based on the current time in the default time zone with the default locale.*/
            //The Current Date is:Tue Aug 28 11:10:40 UTC 2018  
            Calendar c = Calendar.getInstance();
            //set Calendars time represented by this Calendar’s time value, with the given or passed date as a parameter.
             c.setTime(d);
             // The function returns int value of the day of the week, e.g, 1 for Monday, 2 for Tuesday and so on.
             int day = c.get(Calendar.DAY_OF_WEEK);
             return day;
        }
        public void display()
        {
            System.out.print("the unique code: "+this.unique_code);
            System.out.println("");
            System.out.print(this.Location);
            System.out.println("");
            System.out.print(this.NumberOfSeats);
            System.out.println("");
            System.out.print(this.date);
            System.out.println("");
            System.out.print(this.team1+"   VS   "+this.team2);
        }
    }
     //inheritance
     /**subclass extends from game*/
       public class nationalgame extends Game{ 
        /**national game subclass constructor
        *@param loc the stadium name
         * @param total the number of seats
         * @param d the date of the match
         */
        public nationalgame(String loc,int total,Date d)
        {
            super(loc,total,d);
        }
        //**overloading method with different number of parameters in argument list*/
        public void display(String str)
        {
            super.display();
         System.out.print("");
        }
    }
    /**subclass extends from game*/
      public class internationalgame extends Game{
        /**international game subclass constructor
        *@param loc the stadium name
         * @param total the number of seats
         * @param d the date of the match
         */
       public internationalgame(String loc,int total,Date d)
        {
            super(loc,total,d);
        }
       /**overriding with the same function name and different body*/
        public void display()   
        {
            super.display();
            System.out.print("");
        }
    } 
    /** sub class extends from exception*/
     public class exception extends Exception{
       public exception(String str)
       {
           super(str);
       }
   }
   /**the information about seats*/
      public class seats{
        /**each seat has a unique number*/
        final int seat_number;
        private static int noOfseats=1;
        private int seat_price;
        /**the category of seat*/
        public String category;
        /**involve the seats that are already booked*/
        public Vector<seats> booked=new Vector<seats>();
        /**
         * @param cate represents the category
         * the constructor of class seat*/
        public seats(String cate)
        {
            this.category=cate;
            this.seat_number=noOfseats;
            noOfseats++;
            setprice();
        }
        public int getnumber()
        {
            return seat_number;
        }
       
        /**@return return Return array of seats */
        public ArrayList<Integer> seatNumberCalculate()
	{
		// Variables to values for each block of seats
		int A = 0;
		int B = 0;
		int C  = 0;

		// ArrayList to hold the values
		ArrayList<Integer> s = new ArrayList<Integer>();

		// Add zero at the start of the array to act as a defauilt value for the cbs
		s.add(0);

		// Calculate the seatnumbers and add them into the array
		for (int i=0; i < 100; i++)
		{
			A = 101+i;
			s.add(A);
		}
		for (int i = 0; i < 100; i++)
		{
			B = 201+i;
			s.add(B);
		}
		for (int i = 0; i < 100; i++)
		{
			C = 301+i;
			s.add(C);
		}

		return s;
	}

    public int getprice()
    {
        if(category=="A")
            setprice();
        else if(category=="B")
            setprice();
        else
            setprice();
        
        return seat_price;
    }
    public String getcate()
    {
        if(seat_number==1)
        {return category="A";}
        if(seat_number==2)
        {
            return category="B";
        }
        else
            return category="C";
    }
  
    /**public method to set price with calculated members*/
    public void setprice()
    {
        if(category=="A")
            seat_price=200*2;
        else if(category=="B")
            seat_price=150*2;
        else
            seat_price=100*2;
    }
    /**display the information of fan's seat*/
    public void display()
    {
        System.out.print("Seat number: "+seat_number);
        System.out.println("\n");
        System.out.print("price:  "+seat_price);
        System.out.println("\n");
        System.out.print("category: "+category);
        System.out.println("\n");
        System.out.print(noOfseats);
    }
}
    
      /**class ticket to describe the information of the ticket*/
      public class tickets{
        private int price;
        public Date booking_date;
        public int numberoftickets;
        Game obj;
        seats seat;
        public int count=0;
        int number;
        /**@param g object from class game
         * @param s object from class seat
         * the constructor of class ticket*/
        public tickets(Game g,seats s)
        {
            this.obj=g;
            this.seat=s;
            numberoftickets++;
            count++;
            seat.booked.add(s);
            number=obj.getsize();
            booking_date=new Date(); 
        }
        public Date getbookingdate()
        {
            return booking_date;
                }
        public void setprice()
        {
            price=seat.getprice();
        }
        public int getprice()
        {
            return price;
        }
        public int get()
        {
            return number;
        }
        /**display all information about ticket*/
        public void display()
        {
            System.out.print(seat.seat_number);
            System.out.println("\n");
            System.out.print(obj.team1);
            System.out.println("");
            System.out.println(obj.team2);
            System.out.println("\n");
            System.out.println("total price:");
            System.out.print(price);
            System.out.println("\n");
            
        }
    }
    /**class fan which describe the information about fans*/
      public class fans{
        public int fan_ID;
        private static int NumberOfFans=1;
        //public seats seat;
        /**each fan has different number of tickets*/
        public ArrayList<tickets>ticket;
        public String name;
        public String phone;
        public int age;
        private int counter=0;
        private String prediction;
        public tickets tick;
        /**constructor of class fan*/
        public fans()
        {
           ticket=new ArrayList<tickets>();
           this.fan_ID=NumberOfFans;
           NumberOfFans++;
        }
        /**@return true if there is available seat
         *@param s object from class seat
         */
        public boolean check(seats s)
        {
            for (int i = 0; i < s.booked.size(); i++) {
                if(s.booked.get(i)==s)
                    return false;
                break;
            }
            return true;
        }
        /**@param num number of tickets
         *@param g object from game class
         * @param s object from class seat represent that each fan has seat
         */
        public void book(int num,Game g,seats s)
        {
        if(this.check(s)){
            tick=new tickets(g,s);
            ticket.add(tick);
          counter+=num;
          System.out.println("tickets booked");
      }
    else{
      System.out.println("tickets  unavailable");
    }
        }
        /**
         * @param s the new seat that the fan want to upgrade to*/
        public void upgrade(seats s)
        {
           tick.seat=s;
           ticket.add(tick);
           System.out.println("your seat has been upgraded"+"\n");
        
    }
        /**
         * @param num the ticket number
         * assign variable index to the ticket id
         * convert days to integers to make comparison
        */
        public void cancel(int num)
        {
            for (int i = 0; i < ticket.size(); i++) {
                int index=0;
                if(ticket.get(i).count==num)
                {
                    index=i;
                }
            }
            Date date=tick.booking_date;
             Calendar c = Calendar.getInstance();
             c.setTime(date);
             int day = c.get(Calendar.DAY_OF_WEEK);
             int dayofmatch=tick.obj.geday(tick.obj.date);
             if(day-dayofmatch>=3)
             {
                 ticket.remove(num);
                 System.out.println("your reservation has been canceled");
             }
            try{
                if(day-dayofmatch<3){
                 throw new exception("you can't cancel your reservation");
                }
            }
             catch(exception E){
                 System.out.println("INVALID"+" "+E.getMessage());
        }
                 }
        public void setbet(String str)
        {
            this.prediction=str;
        }
        public String getbet()
        {
            return prediction;
        }
        public boolean bet()
        {
            if(prediction==tick.obj.winner)
                return true;
            else
                return false;
            
        }
        public void displayINFO()
        {
          System.out.print("FAN ID: "+fan_ID);
          System.out.println("\n");
          System.out.print("fan name: "+name);
          System.out.println("\n");
          System.out.print("fan phone: "+phone);
          System.out.println("\n");
          System.out.print("fan age: "+age);
          System.out.println("\n");
          System.out.print("seat number of the fan:"+tick.seat.getnumber());
          System.out.println("\n");
          System.out.print("seat price:"+tick.seat.getprice());
          System.out.println("\n");
          System.out.print("seat category:"+tick.seat.getcate());
          System.out.println("\n");
          System.out.println("GAME INFPRMATION");
          System.out.print("the location"+tick.obj.Location);
          System.out.println("\n");
          System.out.print("Team 1: "+tick.obj.team1+"   VS   "+"Team 2: "+tick.obj.team2);
          System.out.println("\n");
          System.out.print("Date: "+tick.obj.date);
        }
    }
    /**interface class to describe two message*/
     interface message
    {
        public void showmessage();
    }
    /**child class describe the opinions of fans*/
     public class msg implements message{
        //override
        public void showmessage()
        {
            System.out.println("THANK YOU FOR USE THIS SYSTEM I HOPE YOU ENJOY THE MARCH.");
        }
    }
     public class prize implements message{
        //override
        public void showmessage()
        {
            System.out.println("\n"+"WOW, You won the bet!.here is your T-shirt ");
        }
    }