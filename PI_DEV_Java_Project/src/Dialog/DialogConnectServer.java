package Dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

//import util.FileConnect;

public class DialogConnectServer extends JDialog
{
  private final JPanel contentPanel = new JPanel();
  private JTextField txtHost;
  private JTextField txtPort;
  private JButton okButton;
  private JButton cancelButton;
  
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
  public DialogConnectServer()
  {
    setTitle("se connecter ");
    setIconImage(Toolkit.getDefaultToolkit().getImage(DialogConnectServer.class.getResource("/images/office_women_red.png")));
    setBounds(100, 100, 450, 352);
    getContentPane().setLayout(new BorderLayout());
    this.contentPanel.setBackground(new Color(224, 255, 255));
    this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(this.contentPanel, "Center");
    this.contentPanel.setLayout(null);
    
    this.okButton = new JButton("Connect");
    this.okButton.setBackground(new Color(173, 255, 47));
    this.okButton.setIcon(new ImageIcon(DialogConnectServer.class.getResource("/images/upload_database.png")));
    this.okButton.setForeground(new Color(255, 0, 0));
    this.okButton.setFont(new Font("Tahoma", 1, 14));
    this.okButton.setBounds(67, 249, 133, 52);
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
    this.cancelButton.setFont(new Font("Tahoma", 1, 14));
    this.cancelButton.setBounds(264, 249, 133, 52);
    this.contentPanel.add(this.cancelButton);
    this.cancelButton.setActionCommand("Cancel");
    

    JLabel lblHost = new JLabel("Login");
    lblHost.setForeground(new Color(0, 0, 255));
    lblHost.setFont(new Font("Tahoma", 1, 14));
    lblHost.setBounds(22, 45, 63, 16);
    this.contentPanel.add(lblHost);
    
    
    JLabel lblDatabaes = new JLabel("Paswword");
    lblDatabaes.setForeground(new Color(0, 0, 255));
    lblDatabaes.setFont(new Font("Tahoma", 1, 14));
    lblDatabaes.setBounds(22, 94, 83, 16);
    this.contentPanel.add(lblDatabaes);
    

    this.txtHost = new JTextField();
  //  this.txtHost.setText("127.0.0.1");
    this.txtHost.setBounds(146, 34, 156, 40);
    this.contentPanel.add(this.txtHost);
    this.txtHost.setColumns(10);
    

    this.txtPort = new JTextField();
  //  this.txtPort.setText("20000");
    this.txtPort.setColumns(10);
    this.txtPort.setBounds(146, 83, 156, 40);
    this.contentPanel.add(this.txtPort);
  }
}
