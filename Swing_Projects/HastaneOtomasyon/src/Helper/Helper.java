package Helper;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Helper {
	
	public static void optionPaneChangeButton() {
		UIManager.put("OptionPane.cancelButtonText", "İptal");
		UIManager.put("OptionPane.noButtonText", "Hayır");
		UIManager.put("OptionPane.okButtonText", "Tamam");
		UIManager.put("OptionPane.yesButtonText", "Evet");
		
	}

	public static void showMsg(String str) {
		String msg;
		optionPaneChangeButton();
		switch(str) {
		case "fill":
			msg = "Tüm alanları doldurun.";
			break;
		case "success":
			msg = "İşlem başarılı !";
			break;
		case "broke":
			msg = "Someting gone wrong!";
			break;
		default : 
			msg = str;
		}
		
		
		JOptionPane.showMessageDialog(null, msg, "Mesaj", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static boolean confirm(String str) {
		optionPaneChangeButton();
		String msg;
		
		switch(str){
		case "sure":
			msg = "Bu işlemi gerçekleştirmek istiyor musun?";
			break;
		
		default:
			msg = str;
			break;
		}
		
		int result = JOptionPane.showConfirmDialog(null, msg,"DİKKAT !" , JOptionPane.YES_NO_OPTION);
		if(result== 0)
			return true;
		else
			return false;
	}
}
