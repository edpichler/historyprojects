package loto.activation;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class Sec {

	public static byte[] getMacAddress() throws SocketException,
			UnknownHostException {

		InetAddress address = InetAddress.getLocalHost();

		/*
		 * Get NetworkInterface for the current host and then read the hardware
		 * address.
		 */
		NetworkInterface ni = NetworkInterface.getByInetAddress(address);
		byte[] mac = ni.getHardwareAddress();
		return mac;

	}

	public static String getFormattedMacAddress() throws SocketException, UnknownHostException {
		byte[] macAddress = getMacAddress();
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < macAddress.length; i++) {
			buf.append(String.format ( "%1$02x", macAddress[i]).toUpperCase());
			if( i < macAddress.length-1){
				buf.append("-");
			}
		}
		return buf.toString();
	}

	public static long getActivationCode() throws Exception,
			UnknownHostException {
		byte[] macAddress = getMacAddress();
		StringBuffer buf = new StringBuffer();
		if (macAddress.length == 0) {
			throw new Exception(
					"Para poder utilizar o produto é necessário ter placa de rede instalada.");
		}
		for (int i = 0; i < macAddress.length; i++) {
			long num = macAddress[i];
			if (num < 0) {
				num = num * -3;
			}
			buf.append(num);
		}
		return Long.parseLong(buf.toString());
	}

	public static String getSerial(long activationCode) {
		long round = Math.round(activationCode * 1.14);
		StringBuffer temp = new StringBuffer("" + round);
		temp.replace(0, 3, String.valueOf(Math.round(round / 5.6)));
		return temp.toString();
	}

	public static boolean isValidSerial(String serial) throws Exception {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String serial2 = getSerial(getActivationCode());

		if (serial.equals(serial2)) {
			return true;
		}
		return false;
	}
}
