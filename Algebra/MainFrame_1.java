package Algebra;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;

public class MainFrame_1 {

	protected Shell shlMode;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MainFrame_1 window = new MainFrame_1();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlMode.open();
		shlMode.layout();
		while (!shlMode.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlMode = new Shell();
		shlMode.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		shlMode.setSize(450, 300);
		shlMode.setText("Mode");
		
		Button btnNewButton = new Button(shlMode, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				new ArithFrame_1();
			}
		});
		btnNewButton.setBounds(59, 84, 134, 90);
		btnNewButton.setText("Arithmetics Mode");
		
		Button btnVariableMode = new Button(shlMode, SWT.NONE);
		btnVariableMode.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				new VariFrame_1();
			}
		});
		btnVariableMode.setText("Variable Mode");
		btnVariableMode.setBounds(248, 84, 134, 90);

	}

}
