package Dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.lowagie.text.Font;
import javax.swing.DropMode;

//import util.FileConnect;

public class DialogConnectServer2 extends JDialog
{
  private final JPanel contentPanel = new JPanel();
  private JTextField txtHost;
  private JTextField txtPort;
  private JButton okButton;
  private JButton cancelButton;
  private JLabel lblLogin;
  private JTextField textField;
  private JTextField textField_1;
  private JTextField textField_2;
  //private JTextField txtPass;
  private JPasswordField txtPassword;
  
 /* public static void main(String[] args)
  {
    try
    {
      DialogConnectServer dialog = new DialogConnectServer();
      dialog.setDefaultCloseOperation(2);
      dialog.setVisible(true);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
  */
  public DialogConnectServer2()
  {
    setTitle("s'inscrire ");
    setIconImage(Toolkit.getDefaultToolkit().getImage(DialogConnectServer.class.getResource("/images/office_women_red.png")));
    setBounds(100, 100, 458, 483);
    getContentPane().setLayout(new BorderLayout());
    this.contentPanel.setBackground(new Color(224, 255, 255));
    this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(this.contentPanel, "Center");
    this.contentPanel.setLayout(null);
    
    this.okButton = new JButton("Connect");
    this.okButton.setBackground(new Color(173, 255, 47));
    this.okButton.setIcon(new ImageIcon(DialogConnectServer.class.getResource("/images/upload_database.png")));
    this.okButton.setForeground(new Color(255, 0, 0));
 //   this.okButton.setFont(new Font("Tahoma", 1, 14));
    this.okButton.setBounds(67, 382, 135, 52);
    this.contentPanel.add(this.okButton);
    this.okButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
    	  
    	  JOptionPane.showMessageDialog(null, "Successful connection");
          
       /* try
        {
        FileConnect connect = new FileConnect();
          connect.host = DialogConnectServer.this.txtHost.getText();
          connect.port = DialogConnectServer.this.txtPort.getText();
          connect.write();
          
          JOptionPane.showMessageDialog(null, "Successful connection");
          
          System.exit(0);
        }
        catch (Exception ex)
        {
          ex.printStackTrace();
        }
      } */}
    });
    this.okButton.setActionCommand("OK");
    getRootPane().setDefaultButton(this.okButton);
    

    this.cancelButton = new JButton("Cancel");
    this.cancelButton.setBackground(new Color(233, 150, 122));
    this.cancelButton.setIcon(new ImageIcon(DialogConnectServer.class.getResource("/images/delete.png")));
    this.cancelButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        System.exit(0);
      }
    });
    this.cancelButton.setForeground(new Color(255, 0, 0));
   // this.cancelButton.setFont(new Font("Tahoma", 1, 14));
    this.cancelButton.setBounds(257, 382, 135, 52);
    this.contentPanel.add(this.cancelButton);
    this.cancelButton.setActionCommand("Cancel");
    

    JLabel lblHost = new JLabel("Nom");
    lblHost.setForeground(new Color(0, 0, 255));
    //lblHost.setFont(new Font("Tahoma", 1, 14));
    lblHost.setBounds(22, 45, 63, 16);
    this.contentPanel.add(lblHost);
    
    
    JLabel lblDatabaes = new JLabel("Prenom");
    lblDatabaes.setForeground(new Color(0, 0, 255));
    //lblDatabaes.setFont(new Font("Tahoma", 1, 14));
    lblDatabaes.setBounds(22, 94, 83, 16);
    this.contentPanel.add(lblDatabaes);
    

    this.txtHost = new JTextField();
  //  this.txtHost.setText("127.0.0.1");
    this.txtHost.setBounds(146, 34, 246, 40);
    this.contentPanel.add(this.txtHost);
    this.txtHost.setColumns(10);
    

    this.txtPort = new JTextField();
  //  this.txtPort.setText("20000");
    this.txtPort.setColumns(10);
    this.txtPort.setBounds(146, 83, 246, 40);
    this.contentPanel.add(this.txtPort);
    
    lblLogin = new JLabel("email");
    lblLogin.setForeground(Color.BLUE);
    lblLogin.setBounds(22, 144, 83, 16);
    contentPanel.add(lblLogin);
    
    textField = new JTextField();
    textField.setColumns(10);
    textField.setBounds(146, 134, 246, 40);
    contentPanel.add(textField);
    
    JLabel lblAddresse = new JLabel("addresse\r\n");
    lblAddresse.setForeground(Color.BLUE);
    lblAddresse.setBounds(22, 203, 83, 16);
    contentPanel.add(lblAddresse);
    
    textField_1 = new JTextField();
    textField_1.setColumns(10);
    textField_1.setBounds(146, 185, 246, 40);
    contentPanel.add(textField_1);
    
    JLabel lblTel = new JLabel("TEL");
    lblTel.setForeground(Color.BLUE);
    lblTel.setBounds(22, 249, 83, 16);
    contentPanel.add(lblTel);
    
    textField_2 = new JTextField();
    textField_2.setColumns(10);
    textField_2.setBounds(146, 236, 246, 40);
    contentPanel.add(textField_2);
    
    JLabel lblMotDePasse = new JLabel("mot de passe");
    lblMotDePasse.setForeground(Color.BLUE);
    lblMotDePasse.setBounds(22, 311, 83, 16);
    contentPanel.add(lblMotDePasse);
    
    this.txtPassword = new JPasswordField();
    this.txtPassword.setBounds(146, 300, 246, 38);
    this.contentPanel.add(this.txtPassword);
  }
}
