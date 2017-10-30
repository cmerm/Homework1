package example;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/*

	Deficiency Needs  some improvement ;

        1- Timer register
        2- Closing with the moving of mouse or entering any key
        3- Showing pictures in fullsize

PS: I'm  in midterm week,i have 3 exams fot this week and 3 for next.
Also ,I'm taking object oriented class this semester because of my irregular 
situation but I am doing research and reading about this subject! This is not 
excuse ! I will do more research and improve myself .I'm looking both exams and
this homework . Thank You for this opportunity .
                Ahmet Cem Erim


*/

public class Main extends JFrame{
    JLabel photo;   //  showing photos on label
    Timer time;     //defining time for photo changing
    int x = 0;


    
    String[] photos = {                                         //photo array from computer 
                      "C:/Users/Cem/Desktop/Photos/1.jpg",//0
                      "C:/Users/Cem/Desktop/Photos/2.jpg",//1
                      "C:/Users/Cem/Desktop/Photos/3.jpg",//2

                    };
    
    public Main(){
        super("Java ScreenSaver");
        photo = new JLabel();
        photo.setBounds(30, 50,700, 300);                    //coordination of the photos



        //Call The Function SetImageSize
        SetImageSize(2);                                    // 0,1,2 total 3 photos on frame
        


        time = new Timer(3000,new ActionListener() {       //set a timer

            @Override
            public void actionPerformed(ActionEvent e) {
                SetImageSize(x);
                x += 1;
                if(x >= photos.length )                     //using array length for 
                    x = 0; 
            }
        });
        add(photo);
        time.start();
        setLayout(null);
        
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        pack();
        setSize(screenSize.width,screenSize.height);   //getting  screensize of computer
         //setSize(800, 400);
        getContentPane().setBackground(Color.decode("#bdb67b"));    //code of the color
        setLocationRelativeTo(null);                       //for open label on the middle
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);            // choosing close type 
        
        setVisible(true);
    }
    //create a function to resize the image 
    public void SetImageSize(int i){
        ImageIcon icon = new ImageIcon(photos[i]);
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(photo.getWidth(), photo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImc = new ImageIcon(newImg);
        photo.setIcon(newImc);
    }

    
    
    
public static void main(String[] args){ 
      
    
    
    new Main();
}
}