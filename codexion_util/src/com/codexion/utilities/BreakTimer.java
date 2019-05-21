package com.codexion.utilities;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.TimeZone;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import org.apache.log4j.Logger;

public class BreakTimer extends JFrame implements ActionListener, Runnable {
	/**
	 * BreakTimer.java - simple stopwatch that starts the timer as soon as it starts running
	 * <p>
	 * Version 1.1 adds logging with log4j
	 * <p>
	 * @author Lucas Vieites
	 * @version 1.1 
	 */
	private static final long serialVersionUID = -8681454681186736601L;
	private long startTime;
	private final static java.text.SimpleDateFormat timerFormat = new java.text.SimpleDateFormat("H:mm:ss.SSS");
	private final JButton btnStart = new JButton("Start");
	private final JLabel lblTime= new JLabel("0:00:00.000");
	private Thread updater;
	private boolean isRunning= false;
	final static Logger logger = Logger.getLogger(BreakTimer.class);


	private final Runnable displayUpdater= new Runnable() {
		public void run() {
		   displayElapsedTime(System.currentTimeMillis() - BreakTimer.this.startTime);
	    }
	};

	public void actionPerformed(ActionEvent ae) {
		if(isRunning) {
			long elapsed= System.currentTimeMillis() - startTime;
			isRunning= false;
			try {
				updater.join();
				// Wait for updater to finish
			}
			catch(InterruptedException ie) {}
			displayElapsedTime(elapsed);

			if(logger.isInfoEnabled()){
				logger.info("Counter stopped: " + timerFormat.format(new java.util.Date(elapsed)) +
					" => " + Long.toString(elapsed) + " msec");
			}
			btnStart.setText("Start");
			// Display the end result
		} else {
			startTime= System.currentTimeMillis();
			isRunning= true;
			updater= new Thread(this);
			updater.start();
			if(logger.isInfoEnabled()){
				logger.info("Counter started");
			}
			btnStart.setText("Stop");
		}
	}

	private void displayElapsedTime(long elapsedTime) {
		lblTime.setText(timerFormat.format(new java.util.Date(elapsedTime)));
	}

	public void run() {
		try {
			while(isRunning) {
				SwingUtilities.invokeAndWait(displayUpdater);
				Thread.sleep(50);
		   }
	    }
	    catch(java.lang.reflect.InvocationTargetException ite) {
			ite.printStackTrace(System.err);
			// Should never happen!
		}
		catch(InterruptedException ie) {}
		// Ignore and return!
	}

	public BreakTimer() {
		super();
		timerFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		btnStart.setFont(new Font("Arial", Font.BOLD, 32));
		btnStart.addActionListener(this);
		getContentPane().add(btnStart);
		
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblTime);
		
		lblTime.setFont(new Font("Arial", Font.BOLD, 32));
		
		this.setSize(300, 150);
		//this.setContentPane(getJContentPane());
		this.setTitle("StopWatch");
		// Center the window
		Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds((screenSize.width-300)/2, (screenSize.height-150)/2, 300, 150);
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setIconImage(Toolkit.getDefaultToolkit().getImage(ReglaDeTres.class.getResource("/com/codexion/utilities/resources/regladetres_16x16.png")));
		setVisible(true);
		// TODO: Uncomment before committing
		btnStart.doClick(); // Start the timer as soon as the button is rendered
	}

	public static void main(String[] arg) {
		new BreakTimer().addWindowListener(new WindowAdapter() {
		   public void windowClosing(WindowEvent e) {
			   logger.info("Stopwatch exited.");
			   System.exit(0);
		   }
	    });
	}
}
