//１３－８　つぶやきの取得に関する処理を行うモデル（DAO利用）
//mutterDAOを使用しmutterテーブルの全レコードを取得し、それを返す

package model;

import java.util.List;

import dao.MutterDAO;

public class GetMutterListLogic {

	public List<Mutter> execute() {
		MutterDAO dao = new MutterDAO();
		List<Mutter> mutterList = dao.findAll();
		return mutterList;
	}
}