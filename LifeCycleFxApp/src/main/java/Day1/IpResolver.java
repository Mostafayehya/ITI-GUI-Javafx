package Day1;

import javax.swing.*;
import java.awt.*;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

public class IpResolver extends JFrame {

    public IpResolver() {
        this.setLayout(new FlowLayout());

        JTextField urlTextField = new JTextField(40);
        JLabel label = new JLabel("Enter URL", SwingConstants.CENTER);
        JScrollPane scrollPane = new JScrollPane(urlTextField);
        JButton findIpButton = new JButton("Find IP");

        JOptionPane resultOptionPane = new JOptionPane();

        findIpButton.addActionListener(actionEvent -> {
            String address = "";
            String url = urlTextField.getText();
            //     String hostName = url.replaceAll("(https|http|file):\\/\\/", "");
            try {
                URL fullURL = new URL(url);

                String hostName = fullURL.getHost();
                if (hostName.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Empty host name", "Error", JOptionPane.ERROR_MESSAGE);

                } else {
                    // address = InetAddress.getByName(url.getHost().replaceAll("[http][https]","")).getHostAddress();
                    address = InetAddress.getByName(hostName).getHostAddress();
                    JOptionPane.showMessageDialog(null, "URL: " + url + "\n" + "IP: " + address);
                }

            } catch (UnknownHostException unknownHostException) {
                JOptionPane.showMessageDialog(null, "Couldn't find Ip for the given hostname", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (MalformedURLException malformedURLException) {
                JOptionPane.showMessageDialog(null, "Malformed URL", "Error", JOptionPane.ERROR_MESSAGE);

            }
        });

        add(scrollPane, BorderLayout.CENTER);
        add(label, BorderLayout.CENTER);
        add(urlTextField, BorderLayout.CENTER);
        add(findIpButton, BorderLayout.CENTER);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        IpResolver ui = new IpResolver();
        ui.setSize(600, 400);
        ui.setTitle("IP finder");
        ui.setResizable(true);
        ui.setVisible(true);
        ui.setLocationRelativeTo(null);
    }
}
