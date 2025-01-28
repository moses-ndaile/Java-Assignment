# Java-Assignment

 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moezon;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Moezon {
    private JFrame frame;
    private JTextField nameField, secondNameField, surNameField, ageField, phoneNumberField, emailField, regionField, postalAddressField, usernameField, passwordField;
    private JRadioButton maleButton, femaleButton;
    private JButton registerButton, loginButton, purchaseButton, signInButton;
    private JLabel nameLabel, secondNameLabel, surNameLabel, ageLabel, genderLabel, phoneNumberLabel, emailLabel, regionLabel, postalAddressLabel, usernameLabel, passwordLabel, productLabel, priceLabel, transportFeeLabel, totalPriceLabel;
    private JComboBox<String> productComboBox;
    private String[] products = {"iPhone X", "iPhone 11", "iPhone 12", "iPhone 13", "iPhone 14", "iPhone 15", "iPhone 16", "Phone Cover", "Phone Case", "Charger"};
    private double[] prices = {100000, 200000, 300000, 400000, 500000, 600000, 700000, 10000, 10000, 10000};
    private boolean isLoggedIn = false;

    public Moezon() {
        createGUI();
    }

    private void createGUI() {
        frame = new JFrame("Moezon");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        topPanel.add(new JLabel("<html><h2 style='color: orange; text-align: center; text-decoration: underline;'>MOEZON</h2></html>"));
        topPanel.add(new JLabel("<html><h2 style='color: orange; text-align: center;'>The Online Phone Store</h2></html>"));
        frame.add(topPanel, BorderLayout.NORTH);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Register", createRegisterPanel());
        tabbedPane.addTab("Login", createLoginPanel());
        tabbedPane.addTab("Purchase", createPurchasePanel());
        frame.add(tabbedPane, BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
    }

    private JPanel createRegisterPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(new GridLayout(10, 2));

        nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        tablePanel.add(nameLabel);
        tablePanel.add(nameField);

        secondNameLabel = new JLabel("Second Name:");
        secondNameField = new JTextField();
        tablePanel.add(secondNameLabel);
        tablePanel.add(secondNameField);

        surNameLabel = new JLabel("Sur Name:");
        surNameField = new JTextField();
        tablePanel.add(surNameLabel);
        tablePanel.add(surNameField);

        ageLabel = new JLabel("Age:");
        ageField = new JTextField();
        tablePanel.add(ageLabel);
        tablePanel.add(ageField);

        genderLabel = new JLabel("Gender:");
        maleButton = new JRadioButton("Male");
        femaleButton = new JRadioButton("Female");
        ButtonGroup group = new ButtonGroup();
        group.add(maleButton);
        group.add(femaleButton);
        JPanel genderPanel = new JPanel();
        genderPanel.add(genderLabel);
        genderPanel.add(maleButton);
        genderPanel.add(femaleButton);
        tablePanel.add(genderPanel);
        tablePanel.add(new JLabel());

        phoneNumberLabel = new JLabel("Phone Number (starting with country code):");
        phoneNumberField = new JTextField();
        tablePanel.add(phoneNumberLabel);
        tablePanel.add(phoneNumberField);

        emailLabel = new JLabel("Email or iCloud Address:");
        emailField = new JTextField();
        tablePanel.add(emailLabel);
        tablePanel.add(emailField);

        regionLabel = new JLabel("Region:");
        regionField = new JTextField();
        tablePanel.add(regionLabel);
        tablePanel.add(regionField);

        postalAddressLabel = new JLabel("Postal Address:");
        postalAddressField = new JTextField();
        tablePanel.add(postalAddressLabel);
        tablePanel.add(postalAddressField);

        passwordLabel = new JLabel("Password:");
        passwordField = new JTextField();
        tablePanel.add(passwordLabel);
        tablePanel.add(passwordField);

        panel.add(tablePanel, BorderLayout.CENTER);

        registerButton = new JButton("Register");
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Register logic here
                JOptionPane.showMessageDialog(frame, "Registration successful!");
                if (JOptionPane.showConfirmDialog(frame, "Do you want to login now?") == JOptionPane.YES_OPTION) {
                    login();
                }
            }
        });
        panel.add(registerButton, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createLoginPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        usernameLabel = new JLabel("Username or Email:");
        usernameField = new JTextField();
        panel.add(usernameLabel);
        panel.add(usernameField);

        passwordLabel = new JLabel("Password:");
        passwordField = new JTextField();
        panel.add(passwordLabel);
        panel.add(passwordField);

        loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });
        panel.add(new JLabel());
        panel.add(loginButton);

        return panel;
    }

    private void login() {
        // Login logic here
        isLoggedIn = true;
        JOptionPane.showMessageDialog(frame, "Login successful!");
        if (JOptionPane.showConfirmDialog(frame, "Do you want to proceed to purchase?") == JOptionPane.YES_OPTION) {
            JTabbedPane tabbedPane = (JTabbedPane) frame.getContentPane().getComponent(1);
            tabbedPane.setSelectedIndex(2);
        }
    }

    private JPanel createPurchasePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        productLabel = new JLabel("Product:");
        productComboBox = new JComboBox<>(products);
        topPanel.add(productLabel);
        topPanel.add(productComboBox);
        panel.add(topPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(3, 2));
        priceLabel = new JLabel("Price:");
        centerPanel.add(priceLabel);
        centerPanel.add(new JLabel());
        transportFeeLabel = new JLabel("Transport Fee:");
        centerPanel.add(transportFeeLabel);
        centerPanel.add(new JLabel());
        totalPriceLabel = new JLabel("Total Price:");
        centerPanel.add(totalPriceLabel);
        centerPanel.add(new JLabel());
        panel.add(centerPanel, BorderLayout.CENTER);

        purchaseButton = new JButton("Purchase");
        purchaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isLoggedIn) {
                    int result = JOptionPane.showConfirmDialog(frame, "You need to login to make a purchase. Do you want to login now?");
                    if (result == JOptionPane.YES_OPTION) {
                        JTabbedPane tabbedPane = (JTabbedPane) frame.getContentPane().getComponent(1);
                        tabbedPane.setSelectedIndex(1);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Please login to make a purchase.");
                    }
                    return;
                }
                int selectedIndex = productComboBox.getSelectedIndex();
                double price = prices[selectedIndex];
                double transportFee = price * 0.2;
                double totalPrice = price + transportFee;
                priceLabel.setText("Price:= " + price);
                transportFeeLabel.setText("Transport Fee:= " + transportFee);
                totalPriceLabel.setText("Total Price:= " + totalPrice);
                JOptionPane.showMessageDialog(frame, "Your parcel will be delivered within 2 weeks.");
            }
        });
        panel.add(purchaseButton, BorderLayout.SOUTH );

        signInButton = new JButton("Sign out");
        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTabbedPane tabbedPane = (JTabbedPane) frame.getContentPane().getComponent(1);
                tabbedPane.setSelectedIndex(1);
            }
        });
        panel.add(signInButton, BorderLayout.EAST );

        return panel;
    }

    public static void main(String[] args) {
        new Moezon();
    }
}
