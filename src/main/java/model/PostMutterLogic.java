//１３－７　つぶやきの投稿に関する処理を行うモデル　元10-13
//mutterインスタンスをmutterテーブルに追加するように（引数）変更

package model;

import dao.MutterDAO;

public class PostMutterLogic {
	public void execute(Mutter mutter) { // 引数を1つに変更
		MutterDAO dao = new MutterDAO();
		dao.create(mutter);
	}
}