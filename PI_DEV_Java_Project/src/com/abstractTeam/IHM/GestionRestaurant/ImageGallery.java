package com.abstractTeam.IHM.GestionRestaurant;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ImageGallery extends JFrame
{
//    private ImageIcon myImage1 = new ImageIcon ("img/plat.jpg");
//    private ImageIcon myImage2 = new ImageIcon ("img/Menubackground.jpg");
//    private ImageIcon myImage3 = new ImageIcon ("img/plat2.jpg");
//    private ImageIcon myImage4 = new ImageIcon ("img/plat2.png");
    JPanel ImageGallery = new JPanel();
    private List<ImageIcon> myImages = new ArrayList<ImageIcon>();
    private int curImageIndex=0;

    public ImageGallery (List<ImageIcon> myImages)
        {   
    	this.myImages=myImages;
            ImageGallery.add(new JLabel (myImages.get(0)));
//            myImages[0]=myImage1;
//            myImages[1]=myImage2;
//            myImages[2]=myImage3;
//            myImages[3]=myImage4;
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            getContentPane().add(ImageGallery, BorderLayout.NORTH);

            JButton PREVIOUS = new JButton ("Previous");
            JButton NEXT = new JButton ("Next");

            JPanel Menu = new JPanel();
            Menu.setLayout(new GridLayout(1,myImages.size()));
            Menu.add(PREVIOUS);
            Menu.add(NEXT);

            getContentPane().add(Menu, BorderLayout.SOUTH);

            //register listener
            PreviousButtonListener PreviousButton = new PreviousButtonListener ();
            NextButtonListener NextButton = new NextButtonListener ();

            //add listeners to corresponding componenets 
            PREVIOUS.addActionListener(PreviousButton);
            NEXT.addActionListener(NextButton);

        }

    



    class PreviousButtonListener implements ActionListener 
    {

        public void actionPerformed(ActionEvent e)
            {
                if(curImageIndex>0 && curImageIndex <= myImages.size()-1)
                    {   ImageGallery.remove(0);
                        curImageIndex=curImageIndex-1;
                        ImageIcon TheImage= myImages.get(curImageIndex);
                        ImageGallery.add(new JLabel (TheImage));
                        ImageGallery.validate();
                        ImageGallery.repaint(); 
                    }
                else 
                    {   
                        ImageGallery.remove(0);
                        ImageGallery.add(new JLabel (myImages.get(0)));
                        curImageIndex=0;
                        ImageGallery.validate();
                        ImageGallery.repaint();
                    }
            }
    }

    class NextButtonListener implements ActionListener 
    {


        public void actionPerformed(ActionEvent e)
        {

            if(curImageIndex>=0 && curImageIndex < myImages.size()-1)
                {   ImageGallery.remove(0);
                    curImageIndex = curImageIndex + 1;
                    ImageIcon TheImage= myImages.get(curImageIndex);
                    ImageGallery.add(new JLabel (TheImage));
                    ImageGallery.validate();
                    ImageGallery.repaint(); 
                }
            else 
                {   
                    ImageGallery.remove(0);
                    ImageGallery.add(new JLabel (myImages.get(myImages.size()-1)));
                    curImageIndex=3;
                    ImageGallery.validate();
                    ImageGallery.repaint();
                }

        }
    }
}