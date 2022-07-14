package com.test.jsch.test;

import com.jcraft.jsch.*;
import com.test.jsch.Shell;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class JSchShellTest {
    private JPanel mainPannel;
    private JTextArea textArea1;
    private JTextField textField1;
    private JTextArea textArea3;
    private JTextField textField3;
    private JTextArea textArea2;
    private JTextField textField2;
    private JButton connectButton;
    private JButton channelCopy1Button;
    private JButton channelCopy2Button;

    Session session = null;

    Channel channel1;
    InputStream inputStream1;
    PrintStream outputStream1;

    Channel channel2;
    InputStream inputStream2;
    PrintStream outputStream2;

    Channel channel3;
    InputStream inputStream3;
    PrintStream outputStream3;

    public JSchShellTest() {
        inputStream1 = new ByteArrayInputStream(textField1.getText().getBytes(StandardCharsets.UTF_8));
        outputStream1 = new PrintStream(new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                textArea1.append("" + (char) (b & 0xFF));
            }
        });

        inputStream2 = new ByteArrayInputStream(textField2.getText().getBytes(StandardCharsets.UTF_8));
        outputStream2 = new PrintStream(new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                textArea2.append("" + (char) (b & 0xFF));
            }
        });

        inputStream3 = new ByteArrayInputStream(textField3.getText().getBytes(StandardCharsets.UTF_8));
        outputStream3 = new PrintStream(new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                textArea3.append("" + (char) (b & 0xFF));
            }
        });


        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                init();

                try {
                    channel1 = session.openChannel("shell");
                    //    channel1.setInputStream(inputStream1);
                       channel1.setOutputStream(outputStream1);

                    channel1.setInputStream(System.in);
                    //channel1.setOutputStream(System.out);

                    channel1.connect(3 * 1000);
                } catch (Exception ex) {
                    System.out.println("Channel copy1 error - " + ex.getMessage());
                }

            }
        });
        textField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    System.out.println("keyTyped: '" + e.getKeyChar() + "'");
                }
            }
        });

        channelCopy1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    channel2 = session.openChannel("shell");
                    //    channel2.setInputStream(inputStream2);
                    channel2.setOutputStream(outputStream2);

                    channel2.setInputStream(System.in);
                    //channel2.setOutputStream(System.out);

                    channel2.connect(3 * 1000);
                } catch (Exception ex) {
                    System.out.println("Channel copy2 error - " + ex.getMessage());
                }
            }
        });


        channelCopy2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    channel3 = session.openChannel("shell");
                    //    channel1.setInputStream(inputStream1);
                    channel3.setOutputStream(outputStream3);

                    channel3.setInputStream(System.in);
                    //channel3.setOutputStream(System.out);

                    channel3.connect(3 * 1000);
                } catch (Exception ex) {
                    System.out.println("Channel copy3 error - " + ex.getMessage());
                }
            }
        });

    }

    private void init() {
        try {
            JSch jsch = new JSch();

            String host = JOptionPane.showInputDialog(
                    "Enter username@hostname",
            //        System.getProperty("user.name") + "@localhost"
                    "root@ec2-3-36-73-36.ap-northeast-2.compute.amazonaws.com"
            );

            String user = host.substring(0, host.indexOf('@'));
            host = host.substring(host.indexOf('@') + 1);

            session = jsch.getSession(user, host, 22);

            String passwd = JOptionPane.showInputDialog("Enter password");
            //session.setPassword(passwd);
            session.setPassword("Netand141)");

            UserInfo ui = new Shell.MyUserInfo() {
                public void showMessage(String message) {
                    JOptionPane.showMessageDialog(null, message);
                }

                public boolean promptYesNo(String message) {
                    Object[] options = {"yes", "no"};
                    int foo = JOptionPane.showOptionDialog(null,
                            message,
                            "Warning",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.WARNING_MESSAGE,
                            null, options, options[0]);
                    return foo == 0;
                }
            };

            session.setUserInfo(ui);
            session.connect(30000);   // making a connection with timeout.

        } catch (Exception e) {
            System.out.println(e);
        }

    }


    public static void main(String args[]) {
        JSchShellTest jSchShellTest = new JSchShellTest();

        JFrame jFrame = new JFrame("JSchShell Frame");
        jFrame.setContentPane(jSchShellTest.mainPannel);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setPreferredSize(new Dimension(600, 600));
        jFrame.pack();
        jFrame.setVisible(true);
    }

    public void setData(ConnectButton data) {
    }

    public void getData(ConnectButton data) {
    }

    public boolean isModified(ConnectButton data) {
        return false;
    }


    public static abstract class MyUserInfo
            implements UserInfo, UIKeyboardInteractive {
        public String getPassword() {
            return null;
        }

        public boolean promptYesNo(String str) {
            return false;
        }

        public String getPassphrase() {
            return null;
        }

        public boolean promptPassphrase(String message) {
            return false;
        }

        public boolean promptPassword(String message) {
            return false;
        }

        public void showMessage(String message) {
        }

        public String[] promptKeyboardInteractive(String destination,
                                                  String name,
                                                  String instruction,
                                                  String[] prompt,
                                                  boolean[] echo) {
            return null;
        }
    }
}
