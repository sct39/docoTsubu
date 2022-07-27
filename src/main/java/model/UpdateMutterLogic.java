package model;

import dao.MutterDAO;

public class UpdateMutterLogic {

	public void execute(String strId, String text) {

		int id = Integer.parseInt(strId);
		MutterDAO dao = new MutterDAO();
		dao.update(id, text);
	}
}
